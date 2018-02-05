# Immersive

Reworked Minecraft Server written with Java

### About

Immersive was created because of the amount of messy and unnecessary code with-in Bukkit/Spigot and due to a DCMA,
this caused the Source Code to be a pain to contribute to or just to evencompile it.
While writing Immersive we had a couple of goals, but the main one was to re-create the server with the neatest code
possible.  We choose to use libraries such as [Lombok](https://projectlombok.org/) just for this reason.

### Running

To run the Immersive Server you will first need to compile or download the Server Jar.  After downloading the
jar you will need to create a script to run it, here is our recommended script to get started.

```
java -Xms128M -Xmx1G -XX:+AlwaysPreTouch -XX:+DisableExplicitGC -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:MaxGCPauseMillis=45 -XX:TargetSurvivorRatio=90 -XX:G1NewSizePercent=50 -XX:G1MaxNewSizePercent=80 -XX:InitiatingHeapOccupancyPercent=10 -XX:G1MixedGCLiveThresholdPercent=50 -XX:+AggressiveOpts -jar Immersive.jar
```

### Contributing

If you would like to contribute to Immersive, feel free to do so.  We appreciate Pull Requests and any bug reports to
help improve Immersive.
