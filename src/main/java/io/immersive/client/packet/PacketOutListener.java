package io.immersive.client.packet;

public interface PacketOutListener {

    /**
     * Called when a Packet is sent to a client
     * @param packet Outgoing Packet
     */
    void onPacketOut(final Packet packet);

}
