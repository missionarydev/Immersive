package io.immersive.client.packet;

public interface PacketInListener {

    /**
     * Called when a Packet is sent to the server
     * @param packet Incoming Packet
     */
    void onPacketIn(final Packet packet);

}
