package simulation;

import java.nio.ByteBuffer;
import java.util.*;

import info.Variable;
import info.Type;
import info.Method2;

import classFile.ClassFile;

public class Stack {

    ClassFile classFile;
    int maxStackSize = 0;
    int maxLocalsSize = 0;
    int argsSize = 0;
    HashMap<String, Variable> locals;
    byte[] code;

    List<Short> impers;

    List<Integer> scopes;

    public java.util.Stack<Type> stackTypes;

    public Stack(String[] argNames, Method2 m){
        classFile = ClassFile.get();
        code = new byte[0];
        argsSize = argNames.length;
        locals = new HashMap<>();
        stackTypes = new java.util.Stack<>();
        scopes = new ArrayList<>();
        scopes.add(0);
        impers = new ArrayList<>();
        for(int i=0; i< argNames.length; i++){
            addVar(argNames[i], m.arguments.get(i));
        }
    }

    public void addCode(byte[] newCode){
        var byteLength = code.length + newCode.length;
        code = ByteBuffer.allocate(byteLength).put(code).put(newCode).array();
    }

    public void addVar(String s, Type type){
        if(classFile.fieldRefs().containsKey(s)){
            System.out.println("Variable with name: \"" + s + "\" already exists");
            return;
        }
        if(locals.containsKey(s)){
            System.out.println("Variable with name: \"" + s + "\" already exists");
            return;
        }
        locals.put(s, new Variable(locals.size(), type));
        maxLocalsSize = Math.max(maxLocalsSize, locals.size());
        scopes.add(scopes.removeLast() + 1);
    }

    public void addArr(String s, Type type){
        if(classFile.fieldRefs().containsKey(s)){
            System.out.println("Variable with name: \"" + s + "\" already exists");
            return;
        }
        if(locals.containsKey(s)){
            System.out.println("Variable with name: \"" + s + "\" already exists");
            return;
        }

        locals.put(s, new Variable(locals.size(), type));
        maxLocalsSize = Math.max(maxLocalsSize, locals.size());
        scopes.add(scopes.removeLast() + 1);

        byte atype = 10;
        switch (type.t()){
            case 2 -> atype = 6;
            case 3 -> atype = 8;
            case 4 -> atype = 5;
        }
        addCode(ByteBuffer.allocate(2).put((byte) 0xbc).put(atype).array());
        stackPopType();
        stackPushType(type);
        storeVar(s);
    }

    public void getVar(String s){
        if(classFile.fieldRefs().containsKey(s)){
            addCode(ByteBuffer.allocate(3).put((byte)0xb2).put(classFile.fieldRefs().get(s).index).array());
            stackPushType(classFile.fieldRefs().get(s).type);
            return;
        }
        if(locals.containsKey(s)){
            Variable v = locals.get(s);
            if(v.type.ar()){
                aload(v.index);
            }
            else {
                switch (v.type.t()) {
                    case 1, 3, 4 ->
                        iload(v.index);
                    case 2->
                        fload(v.index);
                }
            }
            stackPushType(v.type);
        }
    }

    void aload(byte[] index){
        addCode(ByteBuffer.allocate(2).put((byte)0x19).put(index).array());
    }

    void iload(byte[] index){
        addCode(ByteBuffer.allocate(2).put((byte)0x15).put(index).array());
    }

    void fload(byte[] index){
        addCode(ByteBuffer.allocate(2).put((byte)0x17).put(index).array());
    }

    public void storeVar(String s){
        if(classFile.fieldRefs().containsKey(s)){
            addCode(ByteBuffer.allocate(3).put((byte)0xb3).put(classFile.fieldRefs().get(s).index).array());
            if(!classFile.fieldRefs().get(s).type.eq(stackPopType()))
            {
                System.out.println("Saving one type to a variable of another type");
            }
            return;
        }
        if(locals.containsKey(s)){
            Variable v = locals.get(s);
            var x = stackPopType();
            if(!v.type.eq(x))
            {
                System.out.println("Saving one type to a variable of another type: " + s);
            }
            if(v.type.ar()){
                astore(v.index);
            }
            else {
                switch (v.type.t()) {
                    case 1, 3, 4 ->
                        istore(v.index);
                    case 2->
                        fstore(v.index);
                }
            }
        }
    }

    void astore(byte[] index){
        addCode(ByteBuffer.allocate(2).put((byte)0x3a).put(index).array());
    }

    void istore(byte[] index){
        addCode(ByteBuffer.allocate(2).put((byte)0x36).put(index).array());
    }

    void fstore(byte[] index){
        addCode(ByteBuffer.allocate(2).put((byte)0x38).put(index).array());
    }

    public void getArrEnter(String s){
        getVar(s);
    }

    public void getArrExit(){
        Type type = stackPeekType(1);
        if(type.ar2()){
            aaload();
        }
        else{
            switch (type.t()){
                case 1-> iaload();
                case 2-> faload();
                case 3-> baload();
                case 4-> caload();
            }
        }

        stackPopType();
        stackPopType();
        stackPushType(type.deAr());
    }

    void aaload(){
        addCode(ByteBuffer.allocate(1).put((byte)0x32).array());
    }

    void iaload(){
        addCode(ByteBuffer.allocate(1).put((byte)0x2e).array());
    }

    void faload(){
        addCode(ByteBuffer.allocate(1).put((byte)0x30).array());
    }

    void baload(){
        addCode(ByteBuffer.allocate(1).put((byte)0x33).array());
    }

    void caload(){
        addCode(ByteBuffer.allocate(1).put((byte)0x34).array());
    }

    public void storeArrEnter(String s){
        getVar(s);
    }

    public void storeArrExit(){
        Type type = stackPeekType(2);
        if(type.ar2()){
            aastore();
        }
        else {
            switch (type.t()) {
                case 1->
                    iastore();
                case 2->
                    fastore();
                case 3->
                    bastore();
                case 4->
                    castore();
            }
        }
        stackPopType();
        stackPopType();
        stackPopType();
    }

    void aastore(){
        addCode(ByteBuffer.allocate(1).put((byte)0x53).array());
    }

    void iastore(){
        addCode(ByteBuffer.allocate(1).put((byte)0x4f).array());
    }

    void fastore(){
        addCode(ByteBuffer.allocate(1).put((byte)0x51).array());
    }

    void bastore(){
        addCode(ByteBuffer.allocate(1).put((byte)0x54).array());
    }

    void castore(){
        addCode(ByteBuffer.allocate(1).put((byte)0x55).array());
    }


    public void intConversion(){
        Type type = stackPeekType(0);
        if (type.t() == 2) {
            f2i();
        }
        stackPopType();
        stackPushType(new Type(1,0));
    }

    public void floatConversion(){
        Type type = stackPeekType(0);
        if (type.t() == 1) {
            i2f();
        }
        stackPopType();
        stackPushType(new Type(2,0));
    }

    public void boolConversion(){
        Type type = stackPeekType(0);
        if (type.t() == 1) {
            i2b();
        }
        stackPopType();
        stackPushType(new Type(3,0));
    }

    public void charConversion(){
        Type type = stackPeekType(0);
        if (type.t() == 1) {
            i2c();
        }
        stackPopType();
        stackPushType(new Type(4,0));
    }

    void f2i(){
        addCode(ByteBuffer.allocate(1).put((byte)0x8b).array());
    }

    void i2f(){
        addCode(ByteBuffer.allocate(1).put((byte)0x86).array());
    }

    void i2b(){
        addCode(ByteBuffer.allocate(8).put((byte)0x99).putShort((short)(7)).put((byte)0x04).put((byte)0xa7)
                .putShort((short)(4)).put((byte)0x03).array());
    }

    void i2c(){
        addCode(ByteBuffer.allocate(1).put((byte)0x92).array());
    }

    public void getConstInt(String s){
        int val = Integer.parseInt(s);
        if(val < 128 && val >-129){
            addCode(ByteBuffer.allocate(2).put((byte)0x10).put((byte)val).array());
            stackPushType(new Type(1,0));
            return;
        }

        Variable v = new Variable(classFile.constantPoolInfo.addIntegerConstant(val), new Type(1, 0));
        addCode(ByteBuffer.allocate(3).put((byte)0x13).put(v.index).array());
        stackPushType(new Type(1,0));
    }

    public void getConstInt(int val){
        if(val < 128 && val >-129){
            addCode(ByteBuffer.allocate(2).put((byte)0x10).put((byte)val).array());
            stackPushType(new Type(1,0));
            return;
        }

        Variable v = new Variable(classFile.constantPoolInfo.addIntegerConstant(val), new Type(1, 0));
        addCode(ByteBuffer.allocate(3).put((byte)0x13).put(v.index).array());
        stackPushType(new Type(1,0));
    }

    public void getConstFloat(String s) {
        Variable v = new Variable(classFile.constantPoolInfo.addFloatConstant(Float.parseFloat(s)), new Type(1, 0));
        addCode(ByteBuffer.allocate(3).put((byte) 0x13).put(v.index).array());
        stackPushType(new Type(2,0));
    }

    public void getConstBool(String s){
        addCode(ByteBuffer.allocate(2).put((byte)0x10).put(s.equals("true") ? (byte)1 : (byte)0).array());
        stackPushType(new Type(3,0));
    }

    public void getConstChar(String s) {
        addCode(ByteBuffer.allocate(2).put((byte) 0x10).put((byte)s.charAt(0)).array());
        stackPushType(new Type(4,0));
    }

    public void enterScope(){
        scopes.add(0);
    }

    public void exitScope(){
        int c = scopes.removeLast();
        for(int i = 0; i<c; i++){
            locals.values().removeIf(v-> Arrays.equals(v.index, new byte[]{(byte) (locals.size() - 1)}));
        }
    }

    public void summation(){
        Type type = stackPeekType(0);
        if(!type.eq(stackPeekType(1))){
            System.out.println("Summation type mismatch");
        }
        if(type.t() == 2){
            fadd();
        }
        else{
            iadd();
        }
        stackPopType();
    }

    void iadd(){
        addCode(ByteBuffer.allocate(1).put((byte)0x60).array());
    }

    void isub(){
        addCode(ByteBuffer.allocate(1).put((byte)0x64).array());
    }

    void idiv(){
        addCode(ByteBuffer.allocate(1).put((byte)0x6c).array());
    }

    void imul(){
        addCode(ByteBuffer.allocate(1).put((byte)0x68).array());
    }

    void fadd(){
        addCode(ByteBuffer.allocate(1).put((byte)0x62).array());
    }

    void fsub(){
        addCode(ByteBuffer.allocate(1).put((byte)0x66).array());
    }

    void fdiv(){
        addCode(ByteBuffer.allocate(1).put((byte)0x6e).array());
    }

    void fmul(){
        addCode(ByteBuffer.allocate(1).put((byte)0x6a).array());
    }

    public void subtraction(){
        Type type = stackPeekType(0);
        if(!type.eq(stackPeekType(1))){
            System.out.println("Subtraction type mismatch");
        }
        if(type.t() == 2){
            fsub();
        }
        else{
            isub();
        }
        stackPopType();
    }

    public void division(){
        Type type = stackPeekType(0);
        if(!type.eq(stackPeekType(1))){
            System.out.println("Division type mismatch");
        }
        if(type.t() == 2){
            fdiv();
        }
        else{
            idiv();
        }
        stackPopType();
    }

    public void multiplication(){
        Type type = stackPeekType(0);
        if(!type.eq(stackPeekType(1))){
            System.out.println("Multiplication type mismatch");
        }
        if(type.t() == 2){
            fmul();
        }
        else{
            imul();
        }
        stackPopType();
    }

    public void minus(){
        Type type = stackPeekType(0);
        if(type.t() == 2){
            fneg();
        }
        else{
            ineg();
        }
    }

    void ineg(){
        addCode(ByteBuffer.allocate(1).put((byte)0x74).array());
    }

    void fneg(){
        addCode(ByteBuffer.allocate(1).put((byte)0x76).array());
    }

    public void orOp(){
        if(stackPeekType(0).t() != 3 || stackPeekType(1).t() != 3){
            System.out.println("Or operation type mismatch");
        }
        ior();
        stackPopType();
    }

    public void andOp(){
        if(stackPeekType(0).t() != 3 || stackPeekType(1).t() != 3){
            System.out.println("And operation type mismatch");
        }
        iand();
        stackPopType();
    }

    void ior(){
        addCode(ByteBuffer.allocate(1).put((byte)0x80).array());
    }

    void iand(){
        addCode(ByteBuffer.allocate(1).put((byte)0x7e).array());
    }

    public void notOp(){
        if(stackPeekType(0).t() != 3){
            System.out.println("Not operation type mismatch");
        }
        addCode(ByteBuffer.allocate(8).put((byte)0x99).putShort((short)(7)).put((byte)0x03).put((byte)0xa7)
                .putShort((short)(4)).put((byte)0x04).array());
    }

    public void lessEqOp(){ //TODO STACK Ślepoto
        Type t = stackPopType(), t2 = stackPopType();
        if(t.ar() || t2.ar()){
            System.out.println("Cant compare arrays");
        }

        if(t.t()!=t2.t() || t.t() < 1 || t.t() > 2){
            System.out.println("Compare operator type mismatch");
        }


        if(t.t() == 2){
            addCode(ByteBuffer.allocate(9).put((byte)0x96)
                    .put((byte)0x9d).putShort((short)(7))
                    .put((byte)0x04).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x03).array());
        }
        else{
            addCode(ByteBuffer.allocate(8)
                    .put((byte)0xa3).putShort((short)(7))
                    .put((byte)0x04).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x03).array());
        }
        stackPushType(new Type(3, 0));
    }

    public void greaterEqOp(){
        Type t = stackPopType(), t2 = stackPopType();
        if(t.ar() || t2.ar()){
            System.out.println("Cant compare arrays");
        }

        if(t.t()!=t2.t() || t.t() < 1 || t.t() > 2){
            System.out.println("Compare operator type mismatch");
        }

        if(t.t() == 2){
            addCode(ByteBuffer.allocate(9).put((byte)0x95)
                    .put((byte)0x9b).putShort((short)(7))
                    .put((byte)0x04).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x03).array());
        }
        else{
            addCode(ByteBuffer.allocate(8)
                    .put((byte)0xa1).putShort((short)(7))
                    .put((byte)0x04).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x03).array());
        }
        stackPushType(new Type(3, 0));
    }

    public void lessOp(){
        Type t = stackPopType(), t2 = stackPopType();
        if(t.ar() || t2.ar()){
            System.out.println("Cant compare arrays");
        }

        if(t.t()!=t2.t() || t.t() < 1 || t.t() > 2){
            System.out.println("Compare operator type mismatch");
        }

        if(t.t() == 2){
            addCode(ByteBuffer.allocate(9).put((byte)0x95)
                    .put((byte)0x9b).putShort((short)(7))
                    .put((byte)0x03).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x04).array());
        }
        else{
            addCode(ByteBuffer.allocate(8)
                    .put((byte)0xa1).putShort((short)(7))
                    .put((byte)0x03).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x04).array());
        }

        stackPushType(new Type(3, 0));
    }

    public void greaterOp(){
        Type t = stackPopType(), t2 = stackPopType();
        if(t.ar() || t2.ar()){
            System.out.println("Cant compare arrays");
        }

        if(t.t()!=t2.t() || t.t() < 1 || t.t() > 2){
            System.out.println("Compare operator type mismatch");
        }

        if(t.t() == 2){
            addCode(ByteBuffer.allocate(9).put((byte)0x96)
                    .put((byte)0x9d).putShort((short)(7))
                    .put((byte)0x03).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x04).array());
        }
        else{
            addCode(ByteBuffer.allocate(8)
                    .put((byte)0xa3).putShort((short)(7))
                    .put((byte)0x03).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x04).array());
        }
        stackPushType(new Type(3, 0));
    }

    public void eqOp(){
        Type t = stackPopType(), t2 = stackPopType();
        if(t.ar() || t2.ar()){
            System.out.println("Cant compare arrays");
        }

        if(t.t()!=t2.t() || t.t() < 1 || t.t() > 2){
            System.out.println("Compare operator type mismatch");
        }

        if(t.t() == 2){
            addCode(ByteBuffer.allocate(9).put((byte)0x95)
                    .put((byte)0x99).putShort((short)(7))
                    .put((byte)0x03).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x04).array());
        }
        else{
            addCode(ByteBuffer.allocate(8)
                    .put((byte)0x9f).putShort((short)(7))
                    .put((byte)0x03).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x04).array());
        }
        stackPushType(new Type(3, 0));
    }

    public void notEqOp(){
        Type t = stackPopType(), t2 = stackPopType();
        if(t.ar() || t2.ar()){
            System.out.println("Cant compare arrays");
        }

        if(t.t()!=t2.t() || t.t() < 1 || t.t() > 2){
            System.out.println("Compare operator type mismatch");
        }

        if(t.t() == 2){
            addCode(ByteBuffer.allocate(9).put((byte)0x95)
                    .put((byte)0x99).putShort((short)(7))
                    .put((byte)0x04).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x03).array());
        }
        else{
            addCode(ByteBuffer.allocate(8)
                    .put((byte)0x9f).putShort((short)(7))
                    .put((byte)0x04).put((byte)0xa7)
                    .putShort((short)(4)).put((byte)0x03).array());
        }
        stackPushType(new Type(3, 0));
    }

    void ixor(){
        addCode(ByteBuffer.allocate(1).put((byte)0x82).array());
    }

    public void call(String s, boolean popResult){ //TODO params typechecking, no i dont think i will
        if(!classFile.methodRefs().containsKey(s)){
            System.out.println("No method named :\"" + s +"\"");
        }
        byte[] index = classFile.methodRefs().get(s).a;
        for(int i = 0; i < classFile.methodRefs().get(s).b.arguments.size(); ++i){
            stackPopType();
        }
        invokestatic(index);
        if(popResult && classFile.methodRefs().get(s).b.returnType.t()>0){
            pop();
        }
        else if(classFile.methodRefs().get(s).b.returnType.t()>0){
            stackPushType(classFile.methodRefs().get(s).b.returnType);
        }
    }

    void invokestatic(byte[] index){
        addCode(ByteBuffer.allocate(3).put((byte)0xb8).put(index).array());
    }

    public void stackPop(){
        pop();
        stackPopType();
    }

    void pop(){
        addCode(ByteBuffer.allocate(1).put((byte)0x57).array());
    }

    public void returnVoid(){
        addCode(ByteBuffer.allocate(1).put((byte)0xb1).array());
    }

    public void returnNonVoid(){
        Type type = stackPopType();
        if(type.ar()){
            areturn();
        }
        else{
            if(type.t() ==2){
                freturn();
            }
            else {
                ireturn();
            }
        }
    }

    void areturn(){
        addCode(ByteBuffer.allocate(1).put((byte) 0xb0).array());
    }

    void ireturn(){
        addCode(ByteBuffer.allocate(1).put((byte) 0xac).array());
    }

    void freturn(){
        addCode(ByteBuffer.allocate(1).put((byte) 0xae).array());
    }

    public void enterIf(){
        impers.add((short) code.length);
        ifeq();
        stackPopType();
    }

    void ifeq(){
        addCode(ByteBuffer.allocate(3).put((byte) 0x99).putShort((short)0).array());
    }

    public void exitIf(){
        int index = impers.removeLast();
        byte[] data = ByteBuffer.allocate(2).putShort((short) (code.length - index)).array();
        code[index+1] = data[0];
        code[index+2] = data[1];
    }

    public void enterIfElse(){
        impers.add((short) code.length);
        ifeq();
        stackPopType();
    }

    public void midIfElse(){
        int helper = code.length;
        gotoI();
        int index = impers.removeLast();
        byte[] data = ByteBuffer.allocate(2).putShort((short)(code.length - index)).array();
        code[index+1] = data[0];
        code[index+2] = data[1];
        impers.add((short) helper);
    }

    void gotoI(){
        addCode(ByteBuffer.allocate(3).put((byte) 0xa7).putShort((short) 0).array());

    }

    void gotoI(short in){
        addCode(ByteBuffer.allocate(3).put((byte) 0xa7).putShort(in).array());

    }

    public void exitIfElse(){
        int index = impers.removeLast();
        byte[] data = ByteBuffer.allocate(2).putShort((short) (code.length - index)).array();
        code[index+1] = data[0];
        code[index+2] = data[1];
    }

    public void enterWhile(){
        impers.add((short) code.length);
    }

    public void midWhile(){
        impers.add((short) code.length);
        ifeq();
        stackPopType();
    }

    public void exitWhile(){
        short ifeq = impers.removeLast();
        gotoI((short)(impers.removeLast() - code.length));

        byte[] data = ByteBuffer.allocate(2).putShort((short) (code.length - ifeq)).array();
        code[ifeq+1] = data[0];
        code[ifeq+2] = data[1];
    }

    public void enterCondFor(){
        impers.add((short) code.length);
    }

    public void exitCondFor(){
        impers.add((short) code.length);
        ifeq();
        stackPopType();
        gotoI();
    }

    public void exitIncrFor() {
        impers.add((short) code.length);
        gotoI();
    }

    public void exitFor(){
        int co = impers.removeLast();
        int in = impers.removeLast();
        int bo = impers.removeLast();

        gotoI((short)(in + 6 - code.length));

        byte[] data = ByteBuffer.allocate(2).putShort((short)(co - in)).array();
        code[in+4] = data[0];
        code[in+5] = data[1];

        data = ByteBuffer.allocate(2).putShort((short)(code.length - in)).array();
        code[in + 1] = data[0];
        code[in + 2] = data[1];

        data = ByteBuffer.allocate(2).putShort((short)(bo - co)).array();
        code[co+1] = data[0];
        code[co+2] = data[1];



        /*short tot = (short) code.length;
        short cod = impers.removeLast();
        short inc = (short)(impers.removeLast() + 3);
        short isize = (short)(cod - inc);
        byte[] temp = new byte[isize];
        for(short s = 0; s < isize; s++){
            temp[s] = code[s + inc];
        }
        for(short s = 0; s < tot - cod; s++){
            code[inc + s] = code[s + cod];
        }
        for(short s = 0; s < isize; s++){
            code[cod + s] = temp[s];
        }

        short ifeq = (short) (inc - 3);
        gotoI((short)(impers.removeLast() - code.length));


        byte[] data = ByteBuffer.allocate(2).putShort((short) (code.length - ifeq)).array();
        code[ifeq+1] = data[0];
        code[ifeq+2] = data[1];*/
    }

    public void enterPrint(){
        classFile.addPrint();
        stackPushType(new Type(5, 0));
        addCode(ByteBuffer.allocate(3).put((byte) 0xb2).put(classFile.fieldRefs().get("print").index).array());
    }

    public void exitPrint(){
        Type t = stackPopType();
        if(t.t() == 2){
            addCode(ByteBuffer.allocate(3).put((byte) 0xb6).put(classFile.methodRefs().get("print\\F").a).array());

        }
        else if(t.t() == 3){
            addCode(ByteBuffer.allocate(3).put((byte) 0xb6).put(classFile.methodRefs().get("print\\B").a).array());

        }
        else if(t.t() == 4){
            if(t.ar()){
                addCode(ByteBuffer.allocate(3).put((byte) 0xb6).put(classFile.methodRefs().get("print\\[C").a).array());

            }
            else{
                addCode(ByteBuffer.allocate(3).put((byte) 0xb6).put(classFile.methodRefs().get("print\\C").a).array());

            }
        }
        else{
            addCode(ByteBuffer.allocate(3).put((byte) 0xb6).put(classFile.methodRefs().get("print\\I").a).array());
        }

        stackPopType();
    }

    public void eqBool(){
        addCode(ByteBuffer.allocate(8).put((byte)0xa0).putShort((short)(7)).put((byte)0x04).put((byte)0xa7)
                .putShort((short)(4)).put((byte)0x03).array());
    }

    public void notEqBool(){
        addCode(ByteBuffer.allocate(8).put((byte)0xa0).putShort((short)(7)).put((byte)0x03).put((byte)0xa7)
                .putShort((short)(4)).put((byte)0x04).array());
    }

    public void dup(){
        addCode(ByteBuffer.allocate(1).put((byte)0x59).array());
        stackPushType(stackPeekType(0));
    }
    public void dup2(){
        addCode(ByteBuffer.allocate(1).put((byte)0x5c).array());
        stackPushType(stackPeekType(1));
        stackPushType(stackPeekType(1));

    }

    public int getStackSize(){
        return maxStackSize;
    }

    public int getLocalsSize(){
        return maxLocalsSize;
    }

    public void stackPushType(Type type){
        stackTypes.push(type);
        maxStackSize = Math.max(maxStackSize, stackTypes.size());
    }

    public Type stackPopType(){
        return stackTypes.pop();
    }

    public Type stackPeekType(int i){
        return stackTypes.get(stackTypes.size() - 1 - i);
    }

    public byte[] getCode(){
        return code;
    }
}
