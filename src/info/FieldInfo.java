package info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/*
    u2             fields_count;
    field_info{
        u2             access_flags;
        u2             name_index;
        u2             descriptor_index;
        u2             attributes_count;
        attribute_info attributes[attributes_count];
    }fields[fields_count];
*/

public class FieldInfo implements Info { //TODO
    List<Field> fieldList = new ArrayList<>();

    public Field addField(byte[] accessFlags, byte[] nameIndex, byte[] descriptorIndex) {
        var field = new Field(accessFlags,nameIndex,descriptorIndex,new AttributeInfo());
        fieldList.add(field);
        return field;
    }
    @Override
    public int getBytesLength() {
        int bytesLength = 0;
        for (var field : fieldList)
            bytesLength += field.getBytesLength();
        return 2 + bytesLength;
    }
    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(getBytesLength());
        buffer.putShort((short)(fieldList.size()));
        for (var field : fieldList) {
            buffer.put(field.getBytes());
        }
        return buffer.array();
    }
}
