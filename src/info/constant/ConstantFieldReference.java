package info.constant;

public class ConstantFieldReference extends ConstantReference implements Constant{
    public ConstantFieldReference(byte[] classIndex, byte[] nameAndTypeIndex){
        super(classIndex,nameAndTypeIndex);
    }
    @Override
    public byte getTag() {
        return (byte) 0x09;
    }
}
