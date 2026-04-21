import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //扫描指定目录，并找到名称或者内容中包含指定字符的所有普通文件（不包含目录）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的目录:");
        File file = new File(scanner.nextLine());
        if(!file.isDirectory()) {
            System.out.println("目录不存在");
            return;
        }
        System.out.println("请输入要查找的字符:");
        String flag = scanner.nextLine();
        if(flag.isEmpty()) {
            System.out.println("字符不能为空");
            return;
        }
        ArrayList<File> list = new ArrayList<File>();
        ScannerFlag(file, list);
        int n = list.size();
        for (int i = 0; i < n; i++) {
            try(BufferedReader reader = new BufferedReader(new FileReader(list.get(i)))) {
                String line = reader.readLine();
                if(line.contains( flag)) {
                    System.out.println(list.get(i).getAbsoluteFile());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void ScannerFlag(File file, ArrayList<File> list) {
        File[] files = file.listFiles();
        for(File f : files) {
            if(f.isFile()) {
                list.add(f);
            }
            if(f.isDirectory()) {
                ScannerFlag(f,list);
            }
        }
    }

    //进行普通文件的复制
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件路径:");
        File Path = new File(scanner.nextLine());
        if(!Path.exists()) {
            System.out.println("文件不存在");
            return;
        }
        System.out.println("请输入要复制的文件路径:");
        File newPatch = new File(scanner.nextLine());
        if(newPatch.getParent() == null) {
            System.out.println("请输入正确的文件路径");
            return;
        }
        if(newPatch.getAbsoluteFile().exists()) {
            System.out.println("文件已存在,是否覆盖(Y/n)?");
            String input = scanner.next();
            if(input.equals("n")) {
                System.out.println("终止复制");
                return;
            }
        }
        try(InputStream inputStream = new FileInputStream(Path);
            OutputStream outputStream = new FileOutputStream(newPatch)) {
            while (true) {
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);
                if(n == -1) {
                    break;
                }
                outputStream.write(bytes,0,n);
            }
            System.out.println("复制成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录），并且后续询问用户是否要
    //删除该文件
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("要扫描的目录:");
        File file = new File(scanner.nextLine());
        System.out.println();
        System.out.print("要删除的文件名:");
        String flag = scanner.nextLine();

        if(!file.isDirectory()) {
            System.out.println("目录不存在");
            return;
        }
        if(flag.isEmpty()) {
            System.out.println("文件名不能为空");
            return;
        }
        ArrayList<File> list = new ArrayList<File>();
        ScannerFile(file, flag, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("是否删除(Y/n):" + list.get(i).getAbsoluteFile());
            String input = scanner.next();
            if(input.equals("Y") || input.equals("y")) {
                if(list.get(i).delete()) {
                    System.out.println("已删除" + list.get(i).getAbsoluteFile());
                }
            }
        }

    }

    private static void ScannerFile(File file, String flag, ArrayList<File> list) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().contains(flag)) {
                list.add(f);
            }

            if (f.isDirectory()) {
                ScannerFile(f, flag , list);
            }
        }
    }
}
