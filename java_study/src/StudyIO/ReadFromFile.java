package StudyIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadFromFile {

    private static final String FILE_NAME = "我的目录.txt";

    public static void main(String[] args){
        // 初始化文件地址
        File sourceFile = new File("." + File.separator + FILE_NAME);

        // TODO System.in可以读取标准输入里的byte，而Scanner可以将这个byte读取出来，转换成String，
        //  进而转换成不同的数据类型，比如int、boolean
        Scanner in = new Scanner(System.in);

        classicWay(sourceFile);  // 使用经典的方法 （方法一）

        otherWay(sourceFile);  // 使用lambda的方法 （方法二）
    }

    // 输入流获取文件数据（方法二）
    private static void otherWay(File sourceFile) {
        System.out.println("---------------使用lambda的方法---------------------");
        try(
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                ){

            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 输入流获取文件数据 （方法一）
    private static void classicWay(File sourceFile) {
        System.out.println("--------------使用经典处理方式-------------------");
        try(
                // TODO 建立从文件到程序的数据输入流
                FileInputStream fil = new FileInputStream(sourceFile);
                // TODO 装饰一下，指定字符编码，将读出的byte转为字符
                InputStreamReader reader = new InputStreamReader(fil, StandardCharsets.UTF_8);
                // TODO 缓存功能，输入输出效率更高，并且可以一次读取一行
                BufferedReader bufferedReader = new BufferedReader(reader);
                ){
            System.out.println("以下是从文件输入到程序的内容：");
            String line = null;  // 判断文件是否读取完成
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line.trim().toUpperCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
