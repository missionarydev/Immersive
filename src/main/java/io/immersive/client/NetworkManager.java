package io.immersive.client;

import com.google.common.collect.ImmutableSet;
import io.immersive.ImmersiveConfig;
import io.immersive.client.packet.PacketListener;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.net.SocketAddress;
import java.util.UUID;

public class NetworkManager extends SimpleChannelInboundHandler {
    @Getter private static final AttributeKey<Integer> protocolVersion = AttributeKey.newInstance("protocol_version");
    @Getter private static final ImmutableSet<Integer> SUPPORTED_VERSIONS = ImmutableSet.of(5);

    @Getter private SocketAddress socketAddress;
    @Getter private UUID spoofedIdentifier;
    @Getter private final boolean flag;
    @Getter @Setter private PacketListener packetListener;

    public NetworkManager(final boolean flag) {
        this.flag = flag;
    }

    public static int getVersion(@NonNull final Channel attr) {
        final Integer ver = attr.attr(protocolVersion).get();
        return (ver != null) ? ver : ImmersiveConfig.SERVER_VERSION.asI();
    }

    @Override
    protected void messageReceived(final ChannelHandlerContext channelHandlerContext, final Object o) throws Exception {

    }
}
