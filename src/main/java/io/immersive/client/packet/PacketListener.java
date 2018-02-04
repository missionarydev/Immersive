package io.immersive.client.packet;

public interface PacketListener {

    /**
     * Called when a Packet is sent to the server
     * @param packet Incoming Packet
     */
    void onPacketIn(final Packet packet);

    /**
     * Called when a Packet is sent to a client
     * @param packet Outgoing Packet
     */
    void onPacketOut(final Packet packet);

}
