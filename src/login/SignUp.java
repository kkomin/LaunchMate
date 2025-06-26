package login;

import controller.MainController;

import java.util.Scanner;

public class SignUp {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("이름 : ");
            String name = sc.nextLine();

            System.out.print("아이디 : ");
            String id = sc.nextLine();

            System.out.print("비밀번호 : ");
            String pw = sc.nextLine();

            break;
        }

        System.out.println("✅ 회원가입이 완료되었습니다!");
        MainController.start();
    }
}
