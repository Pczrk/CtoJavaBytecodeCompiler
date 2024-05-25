package info;

import java.nio.ByteBuffer;

public class Attribute implements Info{
    byte[] attributeNameIndex; // 2 bytes
    // pointless byte[] attributeLength; // 4 bytes
    byte[] info = new byte[0]; //TODO MOZE SIE UDA BEZ, JAK NARAZIE NIE POTRZEBOWALEM ZADNEGO INNEGO ATRYBUTU POZA CODE

    public Attribute(byte[] attributeNameIndex){
        this.attributeNameIndex = attributeNameIndex;
    }
    @Override
    public int getBytesLength() {
        return 6 + info.length;
    }

    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(getBytesLength());
        return buffer.put(attributeNameIndex).putInt(info.length).put(info).array();
    }
}
