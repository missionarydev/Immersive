package io.immersive.plugins;

import io.immersive.Immersive;
import io.immersive.utils.Directories;
import lombok.Getter;
import lombok.NonNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginManager {
    @Getter private final List<Plugin> plugins;
    @Getter private final Pattern pattern;
    @Getter private final ConcurrentHashMap<String, Class<?>> classes;
    @Getter private final Map<String, PluginClassLoader> loaders;

    public PluginManager() {
        this.plugins = new ArrayList<>();
        this.pattern = Pattern.compile("\\.jar$");
        this.classes = new ConcurrentHashMap<>();
        this.loaders = new LinkedHashMap<>();

        this.loadPlugins();
        this.enablePlugins();
    }

    public void enablePlugins() {
        this.getPlugins().forEach(this::enablePlugin);
    }

    public void disablePlugins() {
        this.getPlugins().forEach(this::disablePlugin);
    }

    private void loadPlugins() {
        final File directory = Directories.getPluginsDirectory();

        if(!directory.isDirectory())
            throw new IllegalStateException("Plugins directory doesn't exist.");

        Arrays.stream(Objects.requireNonNull(directory.listFiles())).forEach(file -> {
            try {
                this.loadPlugin(file);
            } catch(Exception e) {
                Immersive.getLogger().log(Level.SEVERE, "Failed not load \"" + file.getPath() + "\".", e);
            }
        });
    }

    private void loadPlugin(@NonNull final File file) throws Exception {
        final String name = file.getName();
        final Matcher match = this.pattern.matcher(name);
        final Plugin plugin;

        if(match.find()) {
            if(!file.exists())
                throw new FileNotFoundException(file.getPath() + " does not exist");

            final PluginClassLoader loader = new PluginClassLoader(this.getClass().getClassLoader(), this, file);
            this.getLoaders().put(loader.getInfo().name(), loader);
            plugin = loader.getPlugin();
        } else {
            plugin = null;
        }

        if(plugin != null) {
            this.getPlugins().add(plugin);
            Immersive.getLogger().info("[" + plugin.getInfo().name() + "] Loading " + plugin.getInfo().name() + " (" + plugin.getInfo().version() + ")");
            plugin.onLoad();
        }
    }

    public void enablePlugin(@NonNull final Plugin plugin) {
        if(plugin.isEnabled())
            return;

        Immersive.getLogger().info("[" + plugin.getInfo().name() + "] Enabling " + plugin.getInfo().name() + " (" + plugin.getInfo().version() + ")");

        if(!this.getLoaders().containsKey(plugin.getInfo().name()))
            this.getLoaders().put(plugin.getInfo().name(), (PluginClassLoader) plugin.getClassLoader());

        try {
            plugin.setEnabled(true);
        } catch(Throwable e) {
            Immersive.getLogger().log(Level.SEVERE, "Error occurred while enabling " + plugin.getInfo().name(), e);
        }
    }

    public void disablePlugin(@NonNull final Plugin plugin) {
        if(!plugin.isEnabled())
            return;

        Immersive.getLogger().info("[" + plugin.getInfo().name() + "] Disabling " + plugin.getInfo().name() + " (" + plugin.getInfo().version() + ")");

        try {
            plugin.setEnabled(false);
        } catch(Throwable e) {
            Immersive.getLogger().log(Level.SEVERE, "Error occurred while disabling " + plugin.getInfo().name(), e);
        }

        this.getLoaders().remove(plugin.getInfo().name());

        if(!(plugin.getClassLoader() instanceof PluginClassLoader))
            return;

        ((PluginClassLoader) plugin.getClassLoader()).getClasses().keySet().forEach(getClasses()::remove);
    }

    public Plugin getPlugin(@NonNull final String name) {
        return this.getPlugins().stream().filter(plugin -> plugin.getInfo().name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    protected Class<?> getClassByName(@NonNull final String name) {
        Class<?> cachedClass = this.classes.get(name);

        if(cachedClass != null)
            return cachedClass;

        for(String current : this.loaders.keySet()) {
            final PluginClassLoader loader = this.loaders.get(current);

            try {
                cachedClass = loader.findClass(name, false);
            } catch(ClassNotFoundException ignored) {
                continue;
            }

            if(cachedClass != null)
                return cachedClass;
        }

        return null;
    }

    protected void setClass(@NonNull final String name, @NonNull final Class<?> clazz) {
        if(!this.classes.containsKey(name))
            this.classes.put(name, clazz);
    }
}
