package com.zyx.singleton;

public class InnerClass {
    private InnerClass(){

    }
    private static class TempClass{
        private static final InnerClass innerClass = new InnerClass();
    }

    public static InnerClass getInnerClass(){
        return TempClass.innerClass;
    }
}
