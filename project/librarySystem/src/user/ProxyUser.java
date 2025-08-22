package user;

public class ProxyUser {
    private User realUser;

    public User getRealUser() {
        return realUser;
    }

    public ProxyUser(User user){
        realUser = user;
    }
    //其他操作
//调⽤菜单
    public int display() {
        return -1;
    }
    //添加书籍操作
    public void addBook() {
    }
    //更新书籍操作
    public void updateBook() {
    }
    //移除图书
    public void removeBook() {
    }
    //查看图书的借阅次数
    public void borrowCount( ) {
    }
    //查看最受欢迎的前K本书
    public void generateBook() {
    }
    //查看库存状态
    public void checkInventoryStatus() {

    }
    //按照类别 统计图书
    public void categorizeBooksByCategory() {
    }
    //按照作者 统计图书
    public void categorizeBooksByAuthor() {
    }
    //移除上架超过1年的书籍
    public void checkAndRemoveOldBooks() {
    }
//--------------------------------普通相关⽅法-----------------------------
    //借阅图书
    public void borrowBook() {
    }
    //归还图书
    public void returnBook() {
    }
    //查看个⼈借阅情况
    public void viewBorrowHistory() {
    }
}

