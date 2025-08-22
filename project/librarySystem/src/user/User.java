package user;

public abstract class User{
    protected String name;
    protected int userID;
    protected String role;


    public User(String name, int userID, String role) {
        this.name = name;
        this.userID = userID;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }

    public abstract int display();//菜单方法

}