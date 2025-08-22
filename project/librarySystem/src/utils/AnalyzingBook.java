package utils;

import book.Book;
import com.bit.utils.FileUtils;

import java.io.IOException;
import java.time.LocalDate;

public class AnalyzingBook {
    //
    public void storeObject(Book[] books, String filename) {
        int bookSum = 0;//真实的书本数量
        for (Book book : books) {
            if (book != null) {
                bookSum++;
            }
        }

        StringBuilder jsonArray = new StringBuilder();
        for (int i = 0; i < bookSum; i++) {
            if(books[i] != null){
                jsonArray.append(books[i].toJSON());
                if(i != bookSum-1){
                    //一行代表一个书籍,用/n换行来表示一本书的结尾
                    jsonArray.append("\n");
                }
            }

        }
        FileUtils.writeFile(jsonArray.toString(),filename);//将数据写入文件中
    }
    public Book[] loadObject(String filename) {
//从⽂件读取数据
        String content = FileUtils.readFile(filename);
        if (content == null || content.isEmpty()) {
            System.out.println("未找到该文件:" + filename);
            return null;
        }
        //将一行数据分为多行,分开后一行的数据即为一本书的数据
        String[] bookJosn = content.split("\n");
        Book[] bookList = new Book[bookJosn.length];
        for (int i = 0; i < bookJosn.length; i++) {
           Book book = parseBookJson(bookJosn[i]);
           bookList[i] = book;
        }
        return bookList;
    }

    private Book parseBookJson(String json) {
        if(json.isEmpty()){
            return null;
        }
        //提取每一个属性
        String[] pairs = json.split(",");
        int bookId = Integer.parseInt(pairs[0]);
        String title = pairs[1];
        String author = pairs[2];
        String category = pairs[3];
        int publishYear = Integer.parseInt(pairs[4]);
        boolean isBorrowed = Boolean.parseBoolean(pairs[5]);
        int borrowCount = Integer.parseInt(pairs[6]);
        LocalDate shelfDate = LocalDate.parse(pairs[7]);
        //构造书籍对象
        Book book = new Book(title,author,category,publishYear,shelfDate);
        book.setBorrowed(isBorrowed);
        book.setBorrowCount(borrowCount);
        book.setBookId(bookId);
        return book;

    }

}
