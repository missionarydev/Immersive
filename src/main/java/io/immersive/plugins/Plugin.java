package io.immersive.plugins;

import io.immersive.plugins.ex.PluginLoaderException;
import lombok.NonNull;

import java.util.logging.Logger;

public abstract class Plugin {
    private PluginManager manager;
    private ClassLoader classLoader;
    private boolean instated;
    private boolean enabled;
    private PluginInfo info;
    private PluginLogger logger;

    public Plugin() {
        this.manager = null;
        this.classLoader = null;
        this.instated = false;
        this.enabled = false;
        this.info = null;

        final ClassLoader loader = this.getClass().getClassLoader();

        if(!(loader instanceof PluginClassLoader))
            throw new PluginLoaderException(this.getClass().getName());

        ((PluginClassLoader) loader).instate(this);
    }

    public final PluginManager getManager() {
        return this.manager;
    }

    public final ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public final boolean isInstated() {
        return this.instated;
    }

    protected final void setInstated(@NonNull final boolean instated) {
        this.instated = instated;
    }

    public final boolean isEnabled() {
        return this.enabled;
    }

    public final void setEnabled(@NonNull final boolean enabled) {
        if(this.enabled == enabled)
            return;

        this.enabled = enabled;

        if(enabled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public final PluginInfo getInfo() {
        return this.info;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    protected final void instate(@NonNull final PluginManager loader, @NonNull final ClassLoader classLoader, @NonNull final PluginInfo info) {
        this.manager = manager;
        this.classLoader = classLoader;
        this.info = info;

        this.logger = new PluginLogger(this);
    }

    public abstract void onLoad();
    public abstract void onEnable();
    public abstract void onDisable();
}
