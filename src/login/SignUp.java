package login;

import controller.MainController;
import data.UserData;
import model.User;

import java.util.Scanner;

public class SignUp {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("이름 : ");
            String name = sc.nextLine();

            System.out.print("아이디 : ");
            String id = sc.nextLine();

            // 중복 검사 -> 이름 및 아이디 중복일 경우
            boolean isDuplicate = false;
            for(User user : UserData.userList) {
                if(user.getName().equals(name) && user.getId().equals(id)) {
                    System.out.println("🙅‍♀️ 이미 존재하는 사용자 입니다.");
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate) {
                continue;
            }

            System.out.print("비밀번호 : ");
            String pw = sc.nextLine();

            System.out.println("✅ 회원가입이 완료되었습니다!");
            break;
        }
        MainController.start();
    }
}
