package utils.jvm;

/**
 * Created by gezz on 2017/9/15.
 */
public class ClassInitialize {
    static {
        System.out.println("ClassInitialize initialized !");
    }

    public static class SuperClass {
        public static final int value = 1;
        static {
            System.out.println("SuperClass initialized !");
        }
    }

    public static class SubClass extends SuperClass {
        static {
            System.out.println("SubClass initialized !");
        }
    }

    public static void main(String[] args) {
//        System.out.println(SubClass.value);//仅仅引用了类的静态变量不会触发static代码块的执行，类未初始化
//        new SuperClass();
        SuperClass[] superClasses = new SuperClass[10];//不会触发static代码块，类未初始化
    }
}
