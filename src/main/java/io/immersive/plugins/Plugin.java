package io.immersive.plugins;

import io.immersive.plugins.ex.PluginLoaderException;
import lombok.NonNull;

import java.util.logging.Logger;

public abstract class Plugin {
    private boolean instated;
    private boolean enabled;
    private ClassLoader classLoader;
    private PluginInfo info;
    private PluginLogger logger;

    public Plugin() {
        this.instated = false;
        this.enabled = false;
        this.classLoader = null;
        this.info = null;

        final ClassLoader loader = this.getClass().getClassLoader();

        if(!(loader instanceof PluginClassLoader))
            throw new PluginLoaderException(this.getClass().getName());

        ((PluginClassLoader) loader).instate(this);
    }

    public final ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public final boolean isInstated() {
        return this.instated;
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

    protected final void instate(@NonNull final ClassLoader classLoader, @NonNull final PluginInfo info) {
        this.instated = true;
        this.classLoader = classLoader;
        this.info = info;
        this.logger = new PluginLogger(this);
    }

    public abstract void onLoad();
    public abstract void onEnable();
    public abstract void onDisable();
}
