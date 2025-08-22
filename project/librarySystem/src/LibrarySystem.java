import book.Book;
import com.bit.utils.FileUtils;
import constant.Constant;
import factory.AdminUserFactory;
import factory.IUserFactory;
import factory.NormalUserFactory;
import user.User;
import utils.AnalyzingBook;

import javax.management.MBeanAttributeInfo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class LibrarySystem {
    public static void main(String[] args) throws IOException {
        IUserFactory adminUserFactory = new AdminUserFactory();
        IUserFactory normalUserFactory = new NormalUserFactory();
        User adminUser = adminUserFactory.createUser("老大",1);
        User normalUser1 = normalUserFactory.createUser("老二",2);
        User normalUser2 = normalUserFactory.createUser("老三",3);
        Book[] books = new Book[4];
        books[0] = new Book("java", "gaobo", "编程", 1994, LocalDate.of(2023, 9, 24));
        books[1] = new Book("mysql", "lisi", "编程", 1999, LocalDate.of(2024, 2, 10));
        books[2] = new Book("php", "gaobo", "编程", 2020, LocalDate.of(2023, 9, 23));
        books[3] = new Book("西游记", "吴承恩", "⼩说", 2024, LocalDate.of(2023, 9, 23));
        AnalyzingBook analyzingBook = new AnalyzingBook();
        analyzingBook.storeObject(books,Constant.ALL_BOOKS_FILE_NAME);
        Book[] loadeBooks = analyzingBook.loadObject(Constant.ALL_BOOKS_FILE_NAME);

        Arrays.toString(loadeBooks);
    }
}
