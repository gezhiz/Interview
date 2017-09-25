package utils.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *-Xms	初始堆大小
 * -Xmx	最大堆大小
 * -Xmn 堆中新生代的大小
 *
 * Created by gezz on 2017/9/12.
 */
public class HeapOOM {
    public static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
