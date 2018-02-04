package io.immersive.utils;

public class PerformanceUtils {

    public static String getUsedMemory() {
        return ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024)) + "MB";
    }

    public static String getMaxMemory() {
        return (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + "MB";
    }
}
