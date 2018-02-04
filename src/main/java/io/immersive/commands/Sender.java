package io.immersive.commands;

import java.util.List;

public interface Sender {

    /**
     * Gets the name of the sender.
     * @return Sender's Name
     * @see io.immersive.server.Console
     * @see io.immersive.entity.Player
     */
    String getName();

    /**
     * Sends a message to the sender.
     * @param message Message to send.
     */
    void sendMessage(final String message);

    /**
     * Sends multiple messages to the sender.
     * @param messages {@code List<String>} of messages to send.
     */
    void sendMessage(final List<String> messages);

    /**
     * Checks if the sender has a permission via it's node.
     * @param node Permission Node
     * @return {@code true} or {@code false}
     * @see io.immersive.permissions.Permission
     * @see io.immersive.permissions.Permissible
     */
    boolean hasPermission(final String node);

    /**
     * Checks if the sender has a permission.
     * @param permission Permission Object
     * @return {@code true} or {@code false}
     * @see io.immersive.permissions.Permission
     * @see io.immersive.permissions.Permissible
     */
    boolean hasPermission(final io.immersive.permissions.Permission permission);

}
