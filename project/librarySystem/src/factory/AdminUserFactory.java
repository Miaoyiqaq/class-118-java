package factory;

import user.AdminUser;
import user.User;

public class AdminUserFactory implements IUserFactory {//创建管理员
    @Override
    public User createUser(String name, int userID) {
        return new AdminUser(name,userID,"管理员");
    }
}
