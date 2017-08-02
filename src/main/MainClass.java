package main;

import org.junit.Test;
import utils.SrcCoderLineCounter;

import java.io.*;

/**
 * Created by gezz on 2017/8/1.
 */
public class MainClass {
    /**gasgseg**/
    @Test

    public void countSourceCode() {
        //File file = new File("src");
        try {
            SrcCoderLineCounter counter = new SrcCoderLineCounter();
            counter.readFiles("src");
            System.out.println(counter.getCounter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
