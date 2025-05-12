public class Java {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 100)
        {
            if(i % 3 == 0 && i % 4 ==0)
            {
                System.out.print(i + " ");
            } 
            i++;
        }
    }
}
