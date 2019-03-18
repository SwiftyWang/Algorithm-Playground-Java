package base_java_test;

public class TestClassLoader {
    static class Father {

        //Why reference to a static final field will not trigger class loading? What will JVM do(bytecode) when it meets this code?
        //
        //The JLS says
        //
        //A class or interface type T will be initialized immediately before the first occurrence of any one of the following:
        //
        //[...]
        //A static field declared by T is used and the field is not a constant variable (§4.12.4).
        //A constant variable is defined as
        //
        //A constant variable is a *final variable of primitive type or type  String* that is initialized with a constant expression (§15.28).
        //
        //So your field is such a constant variable and accessing it won't cause the type to be initialized.
        public static final String TAG = "Father";

        static {
            System.out.println("static Father");
        }

        {
            System.out.println("unStatic Father");
        }

        public Father() {
            System.out.println("construct Father");
            method();
        }

        public void method() {
            System.out.println("method Father");
        }

        @Override
        public String toString() {
            return "toString Father";
        }
    }

    static class Son extends Father {
        public static Son instance = new Son();

        {
            System.out.println("unStatic Son");
        }

        static {
            System.out.println("static Son");
        }


        public Son() {
            System.out.println("construct Son");
            method();
        }

        public void method() {
            System.out.println("method Son");
        }

        @Override
        public String toString() {
            return "toString Son";
        }
    }

    public static void main(String[] args) {
        System.out.println("1.---------------------");
        System.out.println(Son.TAG);

        Son[] sons = new Son[10];
        System.out.println(sons);
        System.out.println("2.---------------------");
        System.out.println(Son.instance);
        System.out.println("3.---------------------");
        Son son = new Son();
        Father father = son;
        father.method();
        System.out.println(son);


//        1.---------------------
//        Father
//        [Lcom.m800.TestClassLoader$Son;@7adf9f5f
//        2.---------------------
//        static Father
//        unStatic Father
//        constract Father
//        method Son
//        unStatic Son
//        constract Son
//        method Son
//        static Son
//        toString Son
//        3.---------------------
//        unStatic Father
//        constract Father
//        method Son
//        unStatic Son
//        constract Son
//        method Son
//        method Son
//        toString Son
    }
}