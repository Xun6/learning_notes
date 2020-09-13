package StringBuild;

public class stringBuild {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();

        int val = 123455;
        stringBuilder.append(true).append("abc").append(val);

        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.reverse().toString());
        System.out.println(stringBuilder.delete(0,4).toString());
        System.out.println(stringBuilder.insert(3,"llllll").toString());
    }
}
