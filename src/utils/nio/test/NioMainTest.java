package utils.nio.test;

import org.junit.Test;
import utils.nio.NioReadFileUtils;
import utils.nio.TransformUtils;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * Created by gezz on 2017/8/12.
 */
public class NioMainTest {

    @Test
    public void testReadFile() {
        NioReadFileUtils.readFile("src/utils/SrcCoderLineCounter.java");
    }

    @Test
    public void copyFile() {
        TransformUtils.copyFile("src/files/from.text","src/files/to.text");
    }

    @Test
    public void copyAddFile() {
        TransformUtils.copyAddFile("src/files/from.text","src/files/to.text");
    }

    @Test
    public void testSelectorNotSingle() {
        try {
            Selector selector = Selector.open();
            Selector selector2 = Selector.open();
            System.out.println(selector.equals(selector2));//结果为false
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void multiSelectionKeys() {
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        System.out.println(interestSet);
    }

}
