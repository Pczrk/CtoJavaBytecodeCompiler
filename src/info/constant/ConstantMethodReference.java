package info.constant;

public class ConstantMethodReference extends ConstantReference implements Constant{
    public ConstantMethodReference(byte[] classIndex, byte[] nameAndTypeIndex){
        super(classIndex,nameAndTypeIndex);
    }
    @Override
    public byte getTag() {
        return (byte) 0x0a;
    }
}
