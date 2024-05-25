package simulation;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stack {
    int stackSize = 0;
    int argsSize = 0;
    HashMap<String, Integer> locals;
    byte[] code;

    List<Integer> scopes;

    public Stack(String[] argNames){
        code = new byte[0];
        argsSize = argNames.length;
        locals = new HashMap<>();
        scopes = new ArrayList<>();
        for(String s : argNames){
            locals.put(s, locals.size());
        }
    }

    public void addCode(byte[] newCode){
        var byteLength = code.length + newCode.length;
        code = ByteBuffer.allocate(byteLength).put(code).put(newCode).array();
    }
    public int getVar(String s){
        if(!locals.containsKey(s)){
            locals.put(s, locals.size());
        }
        return argsSize + locals.get(s);
    }
    public boolean hasVar(String s){
        return locals.containsKey(s);
    }

    public void setStackSize(int newSize){
        if(newSize > stackSize){
            stackSize = newSize;
        }
    }

    public int getStackSize(){
        return stackSize;
    }

    public int getLocalsSize(){
        return locals.size();
    }

    public byte[] getCode(){
        return code;
    }
}
