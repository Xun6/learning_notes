package StudyHowToCreateDirFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 学习如何使用 File 类创建文件目录
 */
public class StudyHowToCreateFile {

    // 定义一个静态路径，"."表示当路径
    private static final String ROOT = "." + File.separator;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //================文件分隔符（不同操作系统不一样）===================
        System.out.println("文件路径分隔符：" + File.separator);
        System.out.println("环境变量分隔符：" + File.pathSeparator);


        // TODO 使用 File类，依次创建多层文件夹，修改文件夹名称，在指定文件夹创建文件，删除文件，删除文件夹
        File dir = createDirs();  // 创建文件目录

        File newDir = renameDir(dir);  // 修改文件目录名称

        String file = createFiles(newDir); // 目录下创建文件

        String newFile = renameFiles(newDir,file);  // 修改文件名称

        deleteFiles(newDir,newFile); // 删除文件

        deleteFile(newDir); // 删除文件夹



    }

    // 删除文件夹
    private static void deleteFile(File newDir) {
        System.out.println("是否删除文件夹？ ture/fales");
        boolean isdel = scanner.nextBoolean();
        // TODO 前提是文件夹需要是空的，否则删除失败
        if(isdel){
            System.out.println("删除文件夹：" + newDir.delete());
        }
    }

    // 删除文件
    private static void deleteFiles(File dir,String fileName) {
        System.out.println("是否要删除文件呢？ true/fales");

        boolean deleteFile = scanner.nextBoolean();
        if(deleteFile) {
            for (int i = 0; i < 20; i++) {
                File fn = new File(dir, fileName + i + ".txt");
                System.out.println("删除文件" + fn.delete());
            }
        }
    }

    // 修改文件名
    private static String renameFiles(File newDir,String fileName) {
        System.out.println("请输入新的文件名前缀：");
        String newFileName = scanner.nextLine().trim();

        for(int i=0; i < 20; i++){
            File f = new File(newDir,fileName + i + ".txt");
            File fn = new File(newDir,newFileName + i + ".txt");
            System.out.println("修改文件" + f.getName() + ": " + f.renameTo(fn));
        }
        return newFileName;
    }

    // 创建多级文件
    private static String createFiles(File newDir) throws IOException {
        System.out.println("请输入文件名前缀：");
        String fileName = scanner.nextLine().trim();

        for(int i=0; i < 20; i++){
            File f = new File(newDir,fileName + i + ".txt");
            System.out.println("创建文件" + f.getName() + ": " + f.createNewFile());
        }
        return fileName;
    }

    // 修改目录
    private static File renameDir(File dir) {
        System.out.println("请输入新的文件夹名称：");
        String newDirName = scanner.nextLine().trim();

        // 创建新目录
        File newDir = new File(dir.getParentFile(),newDirName);
        boolean success = dir.renameTo(newDir); // 修改
        if(success){
            System.out.println("目录修改成功！");
        } else {
            System.out.println("修改失败！！！");
            return null;
        }
        return newDir;
    }


    // 创建文件目录路径
    private static File createDirs() {
        List<String> pathList = new ArrayList<>();
        while(true){
            System.out.println("请输入路径名称，为空这结束：");
            String path = scanner.nextLine();  // 输入路径名
            // 判断是否输入为空
            if(path.isBlank()){
                break;
            }
            pathList.add(path);  // 加入元素
        }
        return createDir(pathList.toArray(new String[0]));  // 保证传递的是String 类型的数组
    }

    // 创建文件目录
    private static File createDir(String... restPaths) {
        String rest = joinRestDir(restPaths);
        System.out.println("将在" + ROOT + "下创建" + rest);
        File dir = new File(ROOT,rest);
        // 判断文件是否已存在
        if(dir.exists() && dir.isDirectory()){
            System.out.println("文件已存在" + dir.toString());
            return dir;
        } else {
            // 创建多级文件
            boolean createSuccess = dir.mkdirs();
            if(createSuccess){
                return dir;
            } else {
                throw new IllegalArgumentException("无法创建文件！！！");
            }
        }
    }

    // 拼接路径
    private static String joinRestDir(String[] restPaths) {
        return Arrays.stream(restPaths).map(String::trim).collect(Collectors.joining(File.separator));
    }
}
