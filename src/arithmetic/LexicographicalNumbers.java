package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gezz on 2017/9/12.
 */
public class LexicographicalNumbers {

    public static void main(String args[]) {
        List<Integer> result = lexiOrder(130);
        System.out.println(result);
        System.out.println("length:" + result.size());
    }

    public static List<Integer> lexiOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            helper(i,n,result);
        }
        return result;
    }

    public static void helper( int cur, int n, List<Integer> result) {
        if (n < cur) {
            return;
        }
        result.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i <= n) {
                helper(cur * 10 + i, n, result);
            }
        }

    }
}
