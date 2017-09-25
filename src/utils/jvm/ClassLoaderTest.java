package utils.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gezz on 2017/9/19.
 */
public class ClassLoaderTest {

    public static final void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null) {
                    return super.loadClass(name);//如果不在同一个包下，则交给父类加载器加载
                }
                try {
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);//按照类限定名查找
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }

            }
        };
        Object object = classLoader.loadClass("utils.jvm.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof utils.jvm.ClassLoaderTest);
    }

}
