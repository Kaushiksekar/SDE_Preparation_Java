package trees;

public abstract class InvokeAbstractClassWithMain {

    // this same shit works with interface also

    public static void hello(){
        System.out.println("hello");
    }

    public static void main(String[] args) throws Exception {
        hello();
        throw new Exception();
    }

}

interface A{
    public static void main(String args[]){
        System.out.println("Inside interface");
    }
}