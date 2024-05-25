package info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/*
    u2             methods_count;
    method_info {
        u2             access_flags;
        u2             name_index;
        u2             descriptor_index;
        u2             attributes_count;
        attribute_info attributes[attributes_count];
    } methods[methods_count];
*/

public class MethodInfo implements Info {
    List<Method> methodList = new ArrayList<>();
    public Method addMethod(byte[] accessFlags, byte[] nameIndex, byte[] descriptorIndex, AttributeInfo attributeInfo) {
        var method = new Method(accessFlags, nameIndex, descriptorIndex, attributeInfo);
        methodList.add(method);
        return method;
    }
    @Override
    public int getBytesLength() {
        int bytesLength = 0;
        for (var method : methodList)
            bytesLength += method.getBytesLength();
        return 2 + bytesLength;
    }
    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(getBytesLength());
        buffer.putShort((short)(methodList.size()));
        for (var method : methodList) {
            var temp = method.getBytes();
            buffer.put(temp);
        }
        return buffer.array();
    }
}
