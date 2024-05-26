package info;

import java.util.ArrayList;
import java.util.List;

public class Method2 {
    public Type returnType;
    public List<Type> arguments;

    public Method2(Type type){
        returnType = type;
        arguments = new ArrayList<>();
    }

    public Method2(Type type, List<Type> args){
        returnType = type;
        arguments = args;
    }
}
