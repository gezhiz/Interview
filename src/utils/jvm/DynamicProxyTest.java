package utils.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * JDK 动态代理：仅支持对接口的代理
 * Created by gezz on 2017/9/21.
 */
public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }
    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello!");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originObj;

        Object bind(Object originObj) {
            this.originObj = originObj;
            //通过bind方法返回的对象，拿到了originObj的类型信息,重新生成一个字节码，然后重新组建一个类
            return Proxy.newProxyInstance(getClass().getClassLoader(),originObj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originObj,args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
