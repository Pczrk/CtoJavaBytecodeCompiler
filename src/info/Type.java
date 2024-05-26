package info;

import descriptor.FieldDescriptor;
import descriptor.ReturnDescriptor;

public class Type {
    int type = 0;
    int array = 0;
    public Type(int type, int array){
        this.type = type;
        this.array = array;
    }

    public Type(String type, int array){
        switch (type) {
            case "int" -> this.type = 1;
            case "float" -> this.type = 2;
            case "bool" -> this.type = 3;
            case "char" -> this.type = 4;
        }
        this.array = array;
    }

    public FieldDescriptor getDescriptor() throws Exception {
        var desc = new FieldDescriptor();
        for(int i =0; i< array; i++){
            desc.addArray();
        }
        switch (type){
            case 1 -> desc.addInt();
            case 2 -> desc.addFloat();
            case 3 -> desc.addBoolean();
            case 4 -> desc.addChar();
        }
        return desc;
    }

    public ReturnDescriptor getReturnDescriptor() throws Exception {
        var desc = new ReturnDescriptor();
        for(int i =0; i < array; i++){
            desc.addArray();
        }
        switch (type){
            case 0 -> desc.addVoid();
            case 1 -> desc.addInt();
            case 2 -> desc.addFloat();
            case 3 -> desc.addBoolean();
            case 4 -> desc.addChar();
        }
        return desc;
    }

    public boolean eq(Type t2){return this.type == t2.type && this.array == t2.array;}

    public boolean ar(){return array>0;}

    public boolean ar2(){return array>1;}

    public int t(){return type;}

    public Type deAr(){
        return new Type(type, array-1);
    }

    public Type enAr(){
        return new Type(type, array+1);
    }
}
