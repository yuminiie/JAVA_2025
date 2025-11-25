package Homework;
import java.util.Scanner;
import java.util.Random;

public class UpDownGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int ranNumber = r.nextInt(99) + 1;
        System.out.print("📍 숫자를 입력하세요 📍: ");
        int answer = sc.nextInt();
        while(true){
            if(answer < ranNumber){
                System.out.println("👽 up! 👽");
                System.out.print("📍 숫자를 입력하세요 📍: ");
                answer = sc.nextInt();
            }
            else if(answer > ranNumber){
                System.out.println("🤡 down! 🤡");
                System.out.print("📍 숫자를 입력하세요 📍: ");
                answer = sc.nextInt();
            }
            else {
                System.out.println("🎉 정답입니다! 🎉");
                break;
            }
        }
    }
}
