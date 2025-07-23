package demo2;

public class MyArray {
    public void setArray(Object arr,int sub) {
        array[sub] = arr;
    }

    public Object[] array = new Object[3];

}class NewMyArray<T> {

    public void setNewArray(int sub,T arr) {
        newArray[sub] = arr;
    }

    public Object[] newArray = new Object[3];

}
