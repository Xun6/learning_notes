package ai;

import java.util.Scanner;

public class aiAppMain {
    public static void main(String[] args){
        AI ai = new AI();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.next();
            if("exit".equals(input)){
                System.out.println("再见！");
                break;
            }
            System.out.println(ai.answer(input));
        }
    }
}
