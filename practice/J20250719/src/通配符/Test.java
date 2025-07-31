package 通配符;
class Food{

}

class Fruit extends Food{

}

class Apple extends Fruit{

}

class Banana extends Fruit{

}
class Plate<T> {
    private T date;

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
class Test2 {
    static void fun (Plate<? extends Fruit> pa){//如果将?替换为Banana或Apple.最后两个fun方法将无法通过编译
        System.out.println(pa.getDate());
    }
    static void fun1 (Plate<? super Fruit> pa){
        System.out.println(pa.getDate());
    }
}
public class Test {
    public static void main(String[] args) {
        Plate<Banana> plate = new Plate<>();
        plate.setDate(new Banana());
        Plate<Apple> plate1 = new Plate<>();
        plate1.setDate(new Apple());
        Test2.fun(plate);
        Test2.fun(plate1);
        
    }
}
