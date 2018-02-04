# Immersive

Reworked Minecraft Server written with Java

### About

Immersive was created because of all the issues with Bukkit/Spigot.  Due to all the DCMA's and issues with rights
to the source code it caused an issue with all the repos containing source code to the project.
This made it painfully hard to get a working version of the source code due to maven repositories
for Bukkit being offline, but also because the sourcewas all in patch files meaning whenever you edited the source,
you don't commit the changes you have done, but instead you create a patch and commit that instead.

Immersive was created with quality and ease of use in mind.  We wanted to make the source code as neat as possible, 
follow modern conventions, and use new libraries such as lombok.  We also wanted it to be close to Bukkit regarding
it's features and how some methods are accessed.  Unlike other servers such as Glowstone, we did not want to support the
Bukkit API because it would force us to code the server almost exactly like Bukkit's in order to function.
With Immersive there is no need for you to use reflection and or NMS to access variables, methods, and or classes.

### Running the Server

The Immersive Server was coded with Java 8 and will not support any lower versions.
The server operates as a normal Java program, you will download a compiled jar (or compile it yourself),
and run it from a command line or script.

Currently as the server is in Alpha and no Minecraft support is added the server functions only as a command terminal.

When running the server we recommend at least 512MB of ram.
If you would like the most performance out of Immersive,
we have a start script that was created to work well with Immersive. 

