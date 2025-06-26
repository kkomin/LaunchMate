package login;

import java.util.Scanner;

public class SignUp {
    public static void signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.println("이름 : ");
        String name = sc.nextLine();

        System.out.print("아이디 : ");
        String id = sc.nextLine();

        System.out.print("비밀번호 : ");
        String pw = sc.nextLine();
    }
}
