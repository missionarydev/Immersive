package io.immersive.plugins;

import io.immersive.Immersive;
import io.immersive.plugins.ex.InvalidPluginException;
import io.immersive.plugins.ex.PluginLoadException;
import lombok.Getter;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;

public class PluginClassLoader extends URLClassLoader {
    @Getter private final ConcurrentHashMap<String, Class<?>> classes;
    @Getter private PluginManager manager;
    @Getter private Plugin plugin;
    @Getter private PluginInfo info;

    static {
        try {
            final Method method = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable");

            if(method != null) {
                final boolean oldAccessible = method.isAccessible();

                method.setAccessible(true);
                method.invoke(null);
                method.setAccessible(oldAccessible);
                Immersive.getLogger().info("Successfully set PluginClassLoader as parallel capable");
            }
        } catch(Exception e) {
            Immersive.getLogger().log(Level.WARNING, "Error setting PluginClassLoader as parallel capable", e);
        }
    }

    public PluginClassLoader(@NonNull final ClassLoader parent, @NonNull final PluginManager manager, @NonNull final File file) throws InvalidPluginException, MalformedURLException {
        super(new URL[]{file.toURI().toURL()}, parent);

        this.classes = new ConcurrentHashMap<>();
        this.manager = manager;

        try {
            final JarFile jar = new JarFile(file);
            final Enumeration<JarEntry> entries = jar.entries();

            while(entries.hasMoreElements()) {
                final JarEntry entry = entries.nextElement();

                if(entry.isDirectory() || !entry.getName().endsWith(".class"))
                    continue;

                final String className = entry.getName().substring(0, entry.getName().length() - 6).replace('/', '.');
                final Class<?> clazz = Class.forName(className, true, this);

                if(!clazz.isAnnotationPresent(PluginInfo.class))
                    continue;

                this.info = clazz.getAnnotation(PluginInfo.class);

                final Class<? extends Plugin> main;

                try {
                    main = clazz.asSubclass(Plugin.class);
                } catch(ClassCastException e) {
                    e.printStackTrace();
                    break;
                }

                try {
                    this.plugin = main.newInstance();
                } catch(IllegalAccessException e) {
                    Immersive.getLogger().log(Level.SEVERE, "Module " + info.name() + " doesn't have a public constructor", e);
                } catch(InstantiationException e) {
                    Immersive.getLogger().log(Level.SEVERE, "Module " + info.name() + " is not a proper type.", e);
                }

                break;
            }

            if(this.info == null)
                throw new InvalidPluginException("Plugin " + file.getName() + " does not contain a PluginInfo annotation.");
        } catch(IOException e) {
            Immersive.getLogger().log(Level.SEVERE, "Failed to instate JarFile on File '" + file.getName() + "'", e);
        } catch(ClassNotFoundException e) {
            Immersive.getLogger().log(Level.SEVERE, "Failed to find class in file '" + file.getName() + "'", e);
        }
    }

    @Override
    public Class<?> findClass(@NonNull final String name) throws ClassNotFoundException {
        return this.findClass(name, true);
    }

    public Class<?> findClass(@NonNull final String name, @NonNull final boolean global) throws ClassNotFoundException {
        Class<?> result = this.classes.get(name);

        if(result == null) {
            if(global)
                result = this.getManager().getClassByName(name);

            if(result == null) {
                result = super.findClass(name);

                if(result != null)
                    this.getManager().setClass(name, result);
            }

            if(result == null)
                return null;

            this.getClasses().put(name, result);
        }

        return result;
    }

    public synchronized void instate(@NonNull final Plugin plugin) {
        if(plugin.getClass().getClassLoader() != this)
            throw new PluginLoadException(plugin.getInfo().name(), "Cannot initialize plugin outside of " + this.getClass().getName() + ".");

        if(plugin.isInstated())
            throw new IllegalArgumentException("[Plugin] Plugin " + plugin.getInfo().name() + " has already been instated.");

        plugin.instate(this, this.getInfo());
    }
}
