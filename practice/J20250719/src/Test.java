class FandMax<T extends Comparable<T>>{//泛型类
    T fandMax(T[] arr){
        T max = arr[0];//类型应使用compareable接口的类型才能正常调用compareto方法
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        return max;
    }
}

class FandMax1{//泛型方法
    static<T extends Comparable<T>> T fandMax(T[] arr){
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }return max;
    }
}

public class Test {
    public static void main(String[] args) {



        Integer[] array = {2,4,7,9,10,1};
        
        //FandMax<Integer> fandMax = new FandMax<>();
        //Integer tmp = fandMax.fandMax(array);
        //FandMax1 fandMax1 = new FandMax1();
        Integer tmp = FandMax1.fandMax(array);
        System.out.println(tmp);
    }
}
