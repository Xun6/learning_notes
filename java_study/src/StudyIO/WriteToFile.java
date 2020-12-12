package StudyIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 向文件中写入数据
 */
public class WriteToFile {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File targetFile = createFile();  // 创建文件

        writeToFile(targetFile);  // 往文件中写入数据

        System.out.println("程序运行结束。");

    }

    /**
     * 向文件中写入数据
     * @param targetFile  创建出来的文件
     */
    private static void writeToFile(File targetFile) {
        //  TODO try with resource,帮我们搞定 close
        try(
                // TODO 创建一个outputStream，建立一个从程序到文件的byte数据传输流
                FileOutputStream fil = new FileOutputStream(targetFile);
                // TODO 创建一个writer，并指定字符集，可以写入字符了
                OutputStreamWriter out = new OutputStreamWriter(fil, StandardCharsets.UTF_8);
                // TODO 使用 printWriter,可以方便写入一行字符
                PrintWriter printWriter = new PrintWriter(out);
                ) {
            System.out.println("输入的内容会实时写入到文件中，若输入空行则结束！！！");
            while(true){
                String write = sc.nextLine().trim(); // 输入字符串
                if(write.trim().isBlank()){
                    System.out.println("输入结束。");
                    break;
                }else {
                    printWriter.println(write);
//                    printWriter.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // 创建一个文件
    private static File createFile() throws IOException {
        System.out.println("请输入一个文件名：");
        String fileName = sc.nextLine().trim();  // 输入文件名字符串
        // new一个文件
        File file = new File("." + File.separator + fileName + ".txt");
        // 判断是否已存在，存在就删除
        if(file.isFile()){
            System.out.println("文件已存在，删除：" + file.delete());
        }
        System.out.println(file.createNewFile());  // 标注是否创建成功
        return file;
    }
}
