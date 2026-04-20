import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("E:/code/file/1.txt");
            Writer writer = new FileWriter("E:/code/file/1.txt")) {
            String str = "你好世界";
            writer.write(str);
            //使用flush()方法,否则无输出
            writer.flush();
            char[] data = new char[1024];
            int n = reader.read(data);
            for (int i = 0; i < n; i++) {
                System.out.print(data[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main13(String[] args) {
        try(Reader reader = new FileReader("E:/code/file/1.txt");
            Writer writer = new FileWriter("E:/code/file/1.txt")) {
            char[] c = {'你','好','世','界'};
            writer.write(c);
            //使用flush()方法,否则无输出
            writer.flush();
            char[] data = new char[1024];
            int n = reader.read(data);
            for (int i = 0; i < n; i++) {
                System.out.print(data[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main12(String[] args) {
        try(Reader reader = new FileReader("E:/code/file/1.txt");
            Writer writer = new FileWriter("E:/code/file/1.txt")) {
            writer.write('你');
            writer.write('好');
            writer.write('世');
            writer.write('界');
            //使用flush()方法,否则无输出
            writer.flush();
            char[] data = new char[1024];
            int n = reader.read(data);
            for (int i = 0; i < n; i++) {
                System.out.print(data[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main11(String[] args) {//// 提前在该目录下创建对应的文件 , 内容填写为 你好世界
        try(Reader reader = new FileReader("E:/code/file/1.txt")) {
            while(true) {
                char[] data = new char[1024];
                int n = reader.read(data);
                if(n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main10(String[] args) {//// 提前在该目录下创建对应的文件 , 内容填写为 你好世界
        try(Reader reader = new FileReader("E:/code/file/1.txt")) {
            while(true) {
                int data = reader.read();
                if(data == -1) {
                    break;
                }
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main9(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("E:/code/file/1.txt",true);
            InputStream inputStream = new FileInputStream("E:/code/file/1.txt")){
            //写入文件内容
            byte[] bytes = {97,98,99};
            outputStream.write(bytes);
            //写入后读取
            while(true) {
                int data = inputStream.read();
                if(data == -1) {
                    break;
                }
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main8(String[] args) {
        //提前在该目录下创建对应的文件,内容填写为abc
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("E:/code/file/1.txt");
            while (true) {
                int data = inputStream.read();
                if(data == -1) {
                    break;
                }
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main6(String[] args) {
        //提前在该目录下创建对应的文件,内容填写为abc
        try(InputStream inputStream = new FileInputStream("E:/code/file/1.txt")) {
            byte[] data = new byte[1024];
            //去掉while循环
            int n = inputStream.read(data,0,1);
            for (int i = 0; i < n; i++) {
                System.out.println((char)data[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main5(String[] args) {
        //提前在该目录下创建对应的文件,内容填写为abc
        try(InputStream inputStream = new FileInputStream("E:/code/file/1.txt")) {
            while(true) {
                //data的长度可以自定义
                byte[] data = new byte[1024];
                int  n = inputStream.read(data);
                if(n == -1) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    //不能直接打印内容,得转换为char
                    //System.out.print(data[i]);
                    //正确的打印方法
                    System.out.print((char)data[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main4(String[] args) {
        //提前在该目录下创建对应的文件,内容填写为abc
        try(InputStream inputStream = new FileInputStream("E:/code/file/1.txt");) {
            while(true) {
                int data = inputStream.read();
                if(data == -1) {
                    break;
                }
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main3(String[] args) throws IOException {
        //创建旧文件对象
        File oldFile = new File("E:/code/file/1.txt");
        //创建新文件对象
        File newFile = new File("E:/code/file/1/1.txt");
        //创建文件目录
        new File(newFile.getParent()).mkdirs();
        //创建旧文件
        oldFile.createNewFile();
        //移动前的文件
        System.out.println("移动前:");
        System.out.print("旧的的文件是否存在:");
        System.out.println(oldFile.exists());
        System.out.print("新的文件是否存在");
        System.out.println(newFile.exists());
        //移动1.txt到1/1.txt
        oldFile.renameTo(newFile);
        //移动后的文件
        System.out.println("移动后:");
        System.out.print("旧的的文件是否存在:");
        System.out.println(oldFile.exists());
        System.out.print("新的文件是否存在");
        System.out.println(newFile.exists());
        //运行完毕后删除文件
        newFile.deleteOnExit();
    }public static void main7(String[] args) throws IOException {
        //创建父目录对象
        File parentFile = new File("E:/code/file");
        //创建旧文件对象
        File oldFile = new File("E:/code/file/old.txt");
        //创建新文件对象
        File newFile = new File("E:/code/file/new.txt");
        //创建父目录
        parentFile.mkdirs();
        //创建旧文件
        oldFile.createNewFile();
        //列出重命名前父目录下的所有文件
        System.out.print("重命名前的目录文件");
        System.out.println(Arrays.toString(new File("E:/code/file/").list()));
        //重命名old.txt为new.txt
        oldFile.renameTo(newFile);
        //列出重命名后父目录下的所有文件
        System.out.print("重命名后的目录文件");
        System.out.println(Arrays.toString(new File("E:/code/file/").list()));
        //运行完毕后删除文件
        newFile.deleteOnExit();
    }
    public static void main2(String[] args) throws IOException {
        File file = new File("./code/file");
        //获取当前文件路径
        System.out.println(file.getPath());
        //获取当前文件绝对路径
        System.out.println(file.getAbsolutePath());
        //获取当前文件整理后的绝对路径
        System.out.println(file.getCanonicalPath());
    }
    public static void main1(String[] args) throws IOException {
        File file = new File("E:/code/file/");
        //获取文件当前位置
        System.out.println(file.getParent());
        //获取文件名
        System.out.println(file.getName());
        //获取当前文件路径
        System.out.println(file.getPath());
        //获取当前文件绝对路径
        System.out.println(file.getAbsolutePath());
        //获取当前文件整理后的绝对路径
        System.out.println(file.getCanonicalPath());
        //判断当前文件是否存在
        System.out.println(file.exists());
        //判断该文件是否是普通文件
        System.out.println(file.isFile());
        //判断该文件是否是目录
        System.out.println(file.isDirectory());
        //创建空白的普通文件
        System.out.println(file.createNewFile());
        //列出目录中的文件内容
        System.out.println(Arrays.toString(file.list()));
        //删除当前文件
        //System.out.println(file.delete());
        //当前进程结束后删除
        //file.deleteOnExit();
    }
}
