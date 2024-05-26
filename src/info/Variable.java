package info;

public class Variable {
    public byte[] index;
    public Type type;

    /*public Variable(int index, String type, int array){
        this.type = new Type(type, array);
        this.index = new byte[1];
        this.index[0] = (byte) index;
    }

    public Variable(int index, String type){
        this.type = new Type(type, 0);
        this.index = new byte[1];
        this.index[0] = (byte) index;
    }

    public Variable(byte[] index, String type, boolean array){
        this.type = new Type(type, array ? 1 : 0);
        this.index = index;
    }*/

    public Variable(byte[] index, String type){
        this.type = new Type(type, 0);
        this.index = index;
    }

    public Variable(int index, Type type){
        this.type = type;
        this.index = new byte[1];
        this.index[0] = (byte) index;
    }

    public Variable(byte[] index, Type type){
        this.type = type;
        this.index = index;
    }
}