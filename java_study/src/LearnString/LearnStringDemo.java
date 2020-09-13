package LearnString;

public class LearnStringDemo {
    public static void main(String[] args){
        String content = "apple_orange_banana";
        //其实是生成一个新的String对象
        System.out.println(content.toUpperCase());

        //输出第1个字符串
        System.out.println(content.charAt(0));

        //截取
        System.out.println(content.substring(5));
        System.out.println(content.substring(1,6));

        //使用分割方法分割字符串
        String[] strings = content.split("_");
        for(int i = 0; i < strings.length; i++){
            System.out.print(strings[i]);
        }
        System.out.println();

        //使用字符串拆分方法
        char[] chars = content.toCharArray();
        for(int i =0; i < chars.length; i++){
            System.out.print(chars[i]);
        }

        //匹配"_"第一次出现的索引
        int indexof = content.indexOf("_");
        System.out.println("\n" + indexof);

        //匹配"_"最后一个出现的索引
        int lastindexof = content.lastIndexOf("_");
        System.out.println(lastindexof);

        //是否包含某值
        System.out.println(content.contains("apple"));
        System.out.println(content.contains("-"));


        //去空格方法
        String str = "  adb ";
        System.out.println(str);
        System.out.println(str.trim());
    }
}
