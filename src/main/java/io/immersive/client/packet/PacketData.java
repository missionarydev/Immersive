package io.immersive.client.packet;

import io.immersive.ImmersiveConfig;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import lombok.Getter;
import lombok.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public class PacketData extends ByteBuf {
    @Getter private final ByteBuf buffer;
    @Getter private final int version;

    public PacketData(@NonNull final ByteBuf buffer, final int version) {
        this.buffer = buffer;
        this.version = version;
    }

    public PacketData(@NonNull final ByteBuf buffer) {
        this(buffer, ImmersiveConfig.SERVER_VERSION.asI());
    }

    @Override
    public int capacity() {
        return this.getBuffer().capacity();
    }

    @Override
    public ByteBuf capacity(final int i) {
        return this.getBuffer().capacity(i);
    }

    @Override
    public int maxCapacity() {
        return this.getBuffer().maxCapacity();
    }

    @Override
    public ByteBufAllocator alloc() {
        return this.getBuffer().alloc();
    }

    @Override
    public ByteOrder order() {
        return this.getBuffer().order();
    }

    @Override
    public ByteBuf order(final ByteOrder byteOrder) {
        return this.getBuffer().order(byteOrder);
    }

    @Override
    public ByteBuf unwrap() {
        return this.getBuffer().unwrap();
    }

    @Override
    public boolean isDirect() {
        return this.getBuffer().isDirect();
    }

    @Override
    public int readerIndex() {
        return this.getBuffer().readerIndex();
    }

    @Override
    public ByteBuf readerIndex(final int i) {
        return this.getBuffer().readerIndex(i);
    }

    @Override
    public int writerIndex() {
        return this.getBuffer().writerIndex();
    }

    @Override
    public ByteBuf writerIndex(final int i) {
        return this.getBuffer().writerIndex(i);
    }

    @Override
    public ByteBuf setIndex(final int i, final int value) {
        return this.getBuffer().setIndex(i, value);
    }

    @Override
    public int readableBytes() {
        return this.getBuffer().readableBytes();
    }

    @Override
    public int writableBytes() {
        return this.getBuffer().writableBytes();
    }

    @Override
    public int maxWritableBytes() {
        return this.getBuffer().maxWritableBytes();
    }

    @Override
    public boolean isReadable() {
        return this.getBuffer().isReadable();
    }

    @Override
    public boolean isReadable(final int i) {
        return this.getBuffer().isReadable(i);
    }

    @Override
    public boolean isWritable() {
        return this.getBuffer().isWritable();
    }

    @Override
    public boolean isWritable(final int i) {
        return this.getBuffer().isWritable(i);
    }

    @Override
    public ByteBuf clear() {
        return this.getBuffer().clear();
    }

    @Override
    public ByteBuf markReaderIndex() {
        return this.getBuffer().markReaderIndex();
    }

    @Override
    public ByteBuf resetReaderIndex() {
        return this.getBuffer().resetReaderIndex();
    }

    @Override
    public ByteBuf markWriterIndex() {
        return this.getBuffer().markWriterIndex();
    }

    @Override
    public ByteBuf resetWriterIndex() {
        return this.getBuffer().resetWriterIndex();
    }

    @Override
    public ByteBuf discardReadBytes() {
        return this.getBuffer().discardReadBytes();
    }

    @Override
    public ByteBuf discardSomeReadBytes() {
        return this.getBuffer().discardSomeReadBytes();
    }

    @Override
    public ByteBuf ensureWritable(final int i) {
        return this.getBuffer().ensureWritable(i);
    }

    @Override
    public int ensureWritable(final int i, final boolean b) {
        return this.getBuffer().ensureWritable(i, b);
    }

    @Override
    public boolean getBoolean(final int i) {
        return this.getBuffer().getBoolean(i);
    }

    @Override
    public byte getByte(final int i) {
        return this.getBuffer().getByte(i);
    }

    @Override
    public short getUnsignedByte(final int i) {
        return this.getBuffer().getUnsignedByte(i);
    }

    @Override
    public short getShort(final int i) {
        return this.getBuffer().getShort(i);
    }

    @Override
    public int getUnsignedShort(final int i) {
        return this.getBuffer().getUnsignedShort(i);
    }

    @Override
    public int getMedium(final int i) {
        return this.getBuffer().getMedium(i);
    }

    @Override
    public int getUnsignedMedium(final int i) {
        return this.getBuffer().getUnsignedMedium(i);
    }

    @Override
    public int getInt(final int i) {
        return this.getBuffer().getInt(i);
    }

    @Override
    public long getUnsignedInt(final int i) {
        return this.getBuffer().getUnsignedInt(i);
    }

    @Override
    public long getLong(final int i) {
        return this.getBuffer().getLong(i);
    }

    @Override
    public char getChar(final int i) {
        return this.getBuffer().getChar(i);
    }

    @Override
    public float getFloat(final int i) {
        return this.getBuffer().getFloat(i);
    }

    @Override
    public double getDouble(final int i) {
        return this.getBuffer().getDouble(i);
    }

    @Override
    public ByteBuf getBytes(final int i, final ByteBuf bytebuf) {
        return this.getBuffer().getBytes(i, bytebuf);
    }

    @Override
    public ByteBuf getBytes(final int i, final ByteBuf bytebuf, final int j) {
        return this.getBuffer().getBytes(i, bytebuf, j);
    }

    @Override
    public ByteBuf getBytes(final int i, final ByteBuf bytebuf, final int j, final int k) {
        return this.getBuffer().getBytes(i, bytebuf, j, k);
    }

    @Override
    public ByteBuf getBytes(final int i, final byte[] abyte) {
        return this.getBuffer().getBytes(i, abyte);
    }

    @Override
    public ByteBuf getBytes(final int i, final byte[] abyte, final int j, final int k) {
        return this.getBuffer().getBytes(i, abyte, j, k);
    }

    @Override
    public ByteBuf getBytes(final int i, final ByteBuffer bytebuffer) {
        return this.getBuffer().getBytes(i, bytebuffer);
    }

    @Override
    public ByteBuf getBytes(final int i, final OutputStream outputstream, final int j) throws IOException { // CraftBukkit - throws IOException
        return this.getBuffer().getBytes(i, outputstream, j);
    }

    @Override
    public int getBytes(final int i, GatheringByteChannel gatheringbytechannel, final int j) throws IOException { // CraftBukkit - throws IOException
        return this.getBuffer().getBytes(i, gatheringbytechannel, j);
    }

    @Override
    public ByteBuf setBoolean(final int i, boolean flag) {
        return this.getBuffer().setBoolean(i, flag);
    }

    @Override
    public ByteBuf setByte(final int i, final int j) {
        return this.getBuffer().setByte(i, j);
    }

    @Override
    public ByteBuf setShort(final int i, final int j) {
        return this.getBuffer().setShort(i, j);
    }

    @Override
    public ByteBuf setMedium(final int i, final int j) {
        return this.getBuffer().setMedium(i, j);
    }

    @Override
    public ByteBuf setInt(final int i, final int j) {
        return this.getBuffer().setInt(i, j);
    }

    @Override
    public ByteBuf setLong(final int i, long j) {
        return this.getBuffer().setLong(i, j);
    }

    @Override
    public ByteBuf setChar(final int i, final int j) {
        return this.getBuffer().setChar(i, j);
    }

    @Override
    public ByteBuf setFloat(final int i, float f) {
        return this.getBuffer().setFloat(i, f);
    }

    @Override
    public ByteBuf setDouble(final int i, double d0) {
        return this.getBuffer().setDouble(i, d0);
    }

    @Override
    public ByteBuf setBytes(final int i, final ByteBuf bytebuf) {
        return this.getBuffer().setBytes(i, bytebuf);
    }

    @Override
    public ByteBuf setBytes(final int i, final ByteBuf bytebuf, final int j) {
        return this.getBuffer().setBytes(i, bytebuf, j);
    }

    @Override
    public ByteBuf setBytes(final int i, final ByteBuf bytebuf, final int j, final int k) {
        return this.getBuffer().setBytes(i, bytebuf, j, k);
    }

    @Override
    public ByteBuf setBytes(final int i, final byte[] abyte) {
        return this.getBuffer().setBytes(i, abyte);
    }

    @Override
    public ByteBuf setBytes(final int i, final byte[] abyte, final int j, final int k) {
        return this.getBuffer().setBytes(i, abyte, j, k);
    }

    @Override
    public ByteBuf setBytes(final int i, final ByteBuffer bytebuffer) {
        return this.getBuffer().setBytes(i, bytebuffer);
    }

    @Override
    public int setBytes(final int i, InputStream inputstream, final int j) throws IOException { // CraftBukkit - throws IOException
        return this.getBuffer().setBytes(i, inputstream, j);
    }

    @Override
    public int setBytes(final int i, ScatteringByteChannel scatteringbytechannel, final int j) throws IOException { // CraftBukkit - throws IOException
        return this.getBuffer().setBytes(i, scatteringbytechannel, j);
    }

    @Override
    public ByteBuf setZero(final int i, final int j) {
        return this.getBuffer().setZero(i, j);
    }

    @Override
    public boolean readBoolean() {
        return this.getBuffer().readBoolean();
    }

    @Override
    public byte readByte() {
        return this.getBuffer().readByte();
    }

    @Override
    public short readUnsignedByte() {
        return this.getBuffer().readUnsignedByte();
    }

    @Override
    public short readShort() {
        return this.getBuffer().readShort();
    }

    @Override
    public int readUnsignedShort() {
        return this.getBuffer().readUnsignedShort();
    }

    @Override
    public int readMedium() {
        return this.getBuffer().readMedium();
    }

    @Override
    public int readUnsignedMedium() {
        return this.getBuffer().readUnsignedMedium();
    }

    @Override
    public int readInt() {
        return this.getBuffer().readInt();
    }

    @Override
    public long readUnsignedInt() {
        return this.getBuffer().readUnsignedInt();
    }

    @Override
    public long readLong() {
        return this.getBuffer().readLong();
    }

    @Override
    public char readChar() {
        return this.getBuffer().readChar();
    }

    @Override
    public float readFloat() {
        return this.getBuffer().readFloat();
    }

    @Override
    public double readDouble() {
        return this.getBuffer().readDouble();
    }

    @Override
    public ByteBuf readBytes(final int i) {
        return this.getBuffer().readBytes(i);
    }

    @Override
    public ByteBuf readSlice(final int i) {
        return this.getBuffer().readSlice(i);
    }

    @Override
    public ByteBuf readBytes(ByteBuf bytebuf) {
        return this.getBuffer().readBytes(bytebuf);
    }

    @Override
    public ByteBuf readBytes(ByteBuf bytebuf, final int i) {
        return this.getBuffer().readBytes(bytebuf, i);
    }

    @Override
    public ByteBuf readBytes(ByteBuf bytebuf, final int i, final int j) {
        return this.getBuffer().readBytes(bytebuf, i, j);
    }

    @Override
    public ByteBuf readBytes(byte[] abyte) {
        return this.getBuffer().readBytes(abyte);
    }

    @Override
    public ByteBuf readBytes(final byte[] abyte, final int i, final int j) {
        return this.getBuffer().readBytes(abyte, i, j);
    }

    @Override
    public ByteBuf readBytes(ByteBuffer bytebuffer) {
        return this.getBuffer().readBytes(bytebuffer);
    }

    @Override
    public ByteBuf readBytes(final OutputStream outputstream, final int i) throws IOException {
        return this.getBuffer().readBytes(outputstream, i);
    }

    @Override
    public int readBytes(final GatheringByteChannel gatheringbytechannel, final int i) throws IOException {
        return this.getBuffer().readBytes(gatheringbytechannel, i);
    }

    @Override
    public ByteBuf skipBytes(final int i) {
        return this.getBuffer().skipBytes(i);
    }

    @Override
    public ByteBuf writeBoolean(final boolean flag) {
        return this.getBuffer().writeBoolean(flag);
    }

    @Override
    public ByteBuf writeByte(final int i) {
        return this.getBuffer().writeByte(i);
    }

    @Override
    public ByteBuf writeShort(final int i) {
        return this.getBuffer().writeShort(i);
    }

    @Override
    public ByteBuf writeMedium(final int i) {
        return this.getBuffer().writeMedium(i);
    }

    @Override
    public ByteBuf writeInt(final int i) {
        return this.getBuffer().writeInt(i);
    }

    @Override
    public ByteBuf writeLong(final long i) {
        return this.getBuffer().writeLong(i);
    }

    @Override
    public ByteBuf writeChar(final int i) {
        return this.getBuffer().writeChar(i);
    }

    @Override
    public ByteBuf writeFloat(final float f) {
        return this.getBuffer().writeFloat(f);
    }

    @Override
    public ByteBuf writeDouble(final double d0) {
        return this.getBuffer().writeDouble(d0);
    }

    @Override
    public ByteBuf writeBytes(final ByteBuf bytebuf) {
        return this.getBuffer().writeBytes(bytebuf);
    }

    @Override
    public ByteBuf writeBytes(final ByteBuf bytebuf, final int i) {
        return this.getBuffer().writeBytes(bytebuf, i);
    }

    @Override
    public ByteBuf writeBytes(final ByteBuf bytebuf, final int i, final int j) {
        return this.getBuffer().writeBytes(bytebuf, i, j);
    }

    @Override
    public ByteBuf writeBytes(final byte[] abyte) {
        return this.getBuffer().writeBytes(abyte);
    }

    @Override
    public ByteBuf writeBytes(final byte[] abyte, final int i, final int j) {
        return this.getBuffer().writeBytes(abyte, i, j);
    }

    @Override
    public ByteBuf writeBytes(final ByteBuffer bytebuffer) {
        return this.getBuffer().writeBytes(bytebuffer);
    }

    @Override
    public int writeBytes(final InputStream inputstream, final int i) throws IOException {
        return this.getBuffer().writeBytes(inputstream, i);
    }

    @Override
    public int writeBytes(final ScatteringByteChannel scatteringbytechannel, final int i) throws IOException {
        return this.getBuffer().writeBytes(scatteringbytechannel, i);
    }

    @Override
    public ByteBuf writeZero(final int i) {
        return this.getBuffer().writeZero(i);
    }

    @Override
    public int indexOf(final int i, final int j, final byte b0) {
        return this.getBuffer().indexOf(i, j, b0);
    }

    @Override
    public int bytesBefore(final byte b0) {
        return this.getBuffer().bytesBefore(b0);
    }

    @Override
    public int bytesBefore(final int i, final byte b0) {
        return this.getBuffer().bytesBefore(i, b0);
    }

    @Override
    public int bytesBefore(final int i, final int j, final byte b0) {
        return this.getBuffer().bytesBefore(i, j, b0);
    }

    @Override
    public int forEachByte(final ByteBufProcessor bytebufprocessor) {
        return this.getBuffer().forEachByte(bytebufprocessor);
    }

    @Override
    public int forEachByte(final int i, final int j, final ByteBufProcessor bytebufprocessor) {
        return this.getBuffer().forEachByte(i, j, bytebufprocessor);
    }

    @Override
    public int forEachByteDesc(final ByteBufProcessor bytebufprocessor) {
        return this.getBuffer().forEachByteDesc(bytebufprocessor);
    }

    @Override
    public int forEachByteDesc(final int i, final int j, final ByteBufProcessor bytebufprocessor) {
        return this.getBuffer().forEachByteDesc(i, j, bytebufprocessor);
    }

    @Override
    public ByteBuf copy() {
        return this.getBuffer().copy();
    }

    @Override
    public ByteBuf copy(final int i, final int j) {
        return this.getBuffer().copy(i, j);
    }

    @Override
    public ByteBuf slice() {
        return this.getBuffer().slice();
    }

    @Override
    public ByteBuf slice(final int i, final int j) {
        return this.getBuffer().slice(i, j);
    }

    @Override
    public ByteBuf duplicate() {
        return this.getBuffer().duplicate();
    }

    @Override
    public int nioBufferCount() {
        return this.getBuffer().nioBufferCount();
    }

    @Override
    public ByteBuffer nioBuffer() {
        return this.getBuffer().nioBuffer();
    }

    @Override
    public ByteBuffer nioBuffer(final int i, final int j) {
        return this.getBuffer().nioBuffer(i, j);
    }

    @Override
    public ByteBuffer internalNioBuffer(final int i, final int j) {
        return this.getBuffer().internalNioBuffer(i, j);
    }

    @Override
    public ByteBuffer[] nioBuffers() {
        return this.getBuffer().nioBuffers();
    }

    @Override
    public ByteBuffer[] nioBuffers(final int i, final int j) {
        return this.getBuffer().nioBuffers(i, j);
    }

    @Override
    public boolean hasArray() {
        return this.getBuffer().hasArray();
    }

    @Override
    public byte[] array() {
        return this.getBuffer().array();
    }

    @Override
    public int arrayOffset() {
        return this.getBuffer().arrayOffset();
    }

    @Override
    public boolean hasMemoryAddress() {
        return this.getBuffer().hasMemoryAddress();
    }

    @Override
    public long memoryAddress() {
        return this.getBuffer().memoryAddress();
    }

    @Override
    public String toString(Charset charset) {
        return this.getBuffer().toString(charset);
    }

    @Override
    public String toString(final int i, final int j, final Charset charset) {
        return this.getBuffer().toString(i, j, charset);
    }

    @Override
    public int hashCode() {
        return this.getBuffer().hashCode();
    }

    @Override
    public boolean equals(final Object object) {
        return this.getBuffer().equals(object);
    }

    @Override
    public int compareTo(final ByteBuf bytebuf) {
        return this.getBuffer().compareTo(bytebuf);
    }

    @Override
    public String toString() {
        return this.getBuffer().toString();
    }

    @Override
    public ByteBuf retain(final int i) {
        return this.getBuffer().retain(i);
    }

    @Override
    public ByteBuf retain() {
        return this.getBuffer().retain();
    }

    @Override
    public ByteBuf touch() {
        return this.getBuffer().touch();
    }

    @Override
    public ByteBuf touch(final Object o) {
        return this.getBuffer().touch(o);
    }

    @Override
    public int refCnt() {
        return this.getBuffer().refCnt();
    }

    @Override
    public boolean release() {
        return this.getBuffer().release();
    }

    @Override
    public boolean release(final int i) {
        return this.getBuffer().release(i);
    }
}
