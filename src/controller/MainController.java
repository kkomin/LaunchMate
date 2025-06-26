package controller;

import login.SignIn;
import login.SignUp;

import java.util.Scanner;

public class MainController {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("언제나 점심을 책임지는 \uD83C\uDF5D LAUNCHMATE 입니다.");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 탈퇴하기");
            System.out.println("\n4. 프로그램 종료");

            System.out.print("\n입력 : ");
            int input = 0;

            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요.\n");
            }

            switch(input) {
                case 1 :
                    // 로그인
                    SignIn.login();
                    break;
                case 2 :
                    // 회원가입
                    SignUp.signup();
                    break;
                case 3 :
                    // 탈퇴하기
                    break;
                case 4 :
                    break;
                default:
                    System.out.println("다시 입력하세요.");
                    continue;
            }
            break;
        }
    }
}
