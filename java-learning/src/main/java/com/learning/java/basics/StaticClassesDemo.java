package com.learning.java.basics;

public class StaticClassesDemo {

    public static void main(String[] args) {

        DataObject.InnerClass.accessOuterClass();
        // cannot access below method call without creating an object
        DataObject.InnerClass in = new DataObject.InnerClass();
        in.accessOuterClassNonStatic();

    }

}

class DataObject{

    public Integer nonStaticVar;
    public static Integer staticVar;    //static variable

    static {
        staticVar = 40;
        //nonStaticVar = 20;    //Not possible to access non-static members
    }

    {
        nonStaticVar = 20;
    }

    public static Integer getStaticVar(){
        return staticVar;
    }

    public Integer getNonStaticVar(){
        return nonStaticVar;
    }


    public static class InnerClass{
        public static void accessOuterClass()
        {
            System.out.println(staticVar);       //static variable of outer class
            System.out.println(getStaticVar());  //static method of outer class
        }

        public void accessOuterClassNonStatic(){
            // cannot access outer class non static member without creating object
            DataObject dataObject = new DataObject();
            System.out.println(dataObject.getNonStaticVar());
        }

    }

}
