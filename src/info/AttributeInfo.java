package info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/*
    u2             attributes_count;
    attribute_info {
        u2 attribute_name_index;
        u4 attribute_length;
        u1 info[attribute_length];
    } attributes[attributes_count]
 */

public class AttributeInfo implements Info {
    List<Attribute> attributeList = new ArrayList<>();
    public void addAttribute(byte[] attributeName) {
        attributeList.add(new Attribute(attributeName));
    }
    public CodeAttribute addCodeAttribute(byte[] attributeName) {
        var code = new CodeAttribute(attributeName);
        attributeList.add(code);
        return code;
    }

    @Override
    public int getBytesLength() {
        int bytesLength = 0;
        for (var attribute : attributeList)
            bytesLength += attribute.getBytesLength();
        return 2 + bytesLength;
    }
    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(getBytesLength());
        buffer.putShort((short)(attributeList.size()));
        for (var attribute : attributeList) {
            buffer.put(attribute.getBytes());
        }
        return buffer.array();
    }
}
