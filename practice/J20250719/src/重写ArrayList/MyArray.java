package 重写ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray implements IList {
    public int[] elem;
    public int usedSize;

    public static final int DEFAULT_CAPACITY = 5;


    @Override    // 默认构造⽅法
    public void SeqList() {
        elem = new int[DEFAULT_CAPACITY];
        usedSize =0;
    }

    @Override    // 将顺序表的底层容量设置为initcapacity
    public void SeqList(int initcapacity) {
        if(initcapacity>=0){
        elem = new int[initcapacity];
        }else {
            System.out.println("请输入合法容量");
        }
    }

    @Override    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }elem[usedSize++] = data;
    }

    @Override    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }if(pos >= 0 && pos <= usedSize) {
            for (int i = usedSize; i > pos; i--) {
                elem[i] = elem[i -1];
            }
            elem[pos] = data;
            usedSize++;
        } else if (pos < 0) {
            System.out.println("请输入合法坐标:" + pos);
        }else {
            System.out.println("超过顺序表长度:" + pos + "顺序表长度为:" + elem.length);
        }
    }

    @Override    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if(elem[i] == toFind){
                return true;
            }
        }
        return false;
    }

    @Override    // 查找某个元素对应的位置
    public int[] indexOf(int toFind) {
        boolean flag = false;
        MyArray myArray = new MyArray();
        myArray.SeqList();
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                myArray.add(i);
                flag = true;
            }
        }if(flag){
                return myArray.elem;
            }

        return new int[]{-1};
    }

    @Override    // 获取 pos 位置的元素
    public int get(int pos) {
        if(pos>=0 && pos < usedSize){
            return elem[pos];
        }else {
            System.out.print("请输入合法坐标(返回的-1代表无效)");
        }
        return -1;
    }

    @Override    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        if(pos >= 0 && pos < usedSize){
            elem[pos] = value;
        }else {
            System.out.print("请输入合法坐标(返回的-1代表无效)");
        }
    }

    @Override    //删除第⼀次出现的关键字key
    public void remove(int toRemove) {
        boolean flag = false;
        int num = 0;
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toRemove) {
                num = i;
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("没有该元素");
        } else {
            for (int i = num; i < usedSize -1; i++) {
                elem[i] = elem[i +1];
            }usedSize--;
        }
    }


    @Override    // 获取顺序表⻓度
    public int size() {
        return elem.length;
    }

    @Override    // 清空顺序表
    public void clear() {
        for (int i = 0; i < usedSize; i++) {
            elem[i] = 0;
        }usedSize = 0;
    }

    @Override    // 打印顺序表，注意：该⽅法并不是顺序表中的⽅法，为了⽅便看测试结果给出的
    public void display() {
        System.out.println(Arrays.toString(elem));
    }

    @Override       //判断顺序表是否满
    public boolean isFull() {
        return usedSize == elem.length;
    }
}
