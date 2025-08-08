import java.util.Scanner;

public class Test {
    private  String  userName = "xiaoming";
    private  String  userPassword = "123";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Test test = new Test();
        System.out.print("输入用户名和密码(空格隔开)");
        String userName = scanner.next();
        String userPassword = scanner.next();
        if(!test.getUserName().equals(userName)){
            throw new UserNameEexception("用户名错误");
        }if(!test.getUserPassword().equals(userPassword)){
            throw new UserPasswordException("密码错误");
        }
    }
}
