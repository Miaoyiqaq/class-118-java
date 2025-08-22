package factory;

import user.User;

public interface IUserFactory {//用户工厂,用来更高级的创建用户
    User createUser(String name, int userID);
}
