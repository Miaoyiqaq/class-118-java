package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));

    }



}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();


    //    ret.add(new ArrayList<>());//ret的0号节点
        for (int i = 0; i < numRows; i++) {//从ret的1号节点开始
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(i == 0){

                ret.add(list);
                continue;
            }
            if(i ==1){

                list.add(1);
                ret.add(list);
                continue;
            }
            for (int j = 1; j < i ; j++) {//每行第一个节点不用设置:j=1.最以后一个节点为1:j<i-1

                list.add(j,ret.get(i -1).get(j -1) + ret.get(i -1).get(j));
            }
            list.add(1);
            ret.add(list);

        }
        return ret;
    }
}

