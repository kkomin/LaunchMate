package login;

import controller.MainController;
import data.UserData;
import model.User;

import java.util.Scanner;

public class SignUp {
    public static void signup() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("\n이름 : ");
            String name = sc.nextLine();

            // 중복 검사 -> 이름 중복일 경우
            boolean isDuplicate = false;
            for(User user : UserData.userList) {
                if(user.getName().equals(name)) {
                    System.out.println("\n🙅‍♀️ 이미 존재하는 사용자 입니다.\n");
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate) {
                continue;
            }
            System.out.print("아이디 : ");
            String id = sc.nextLine();


            System.out.print("비밀번호 : ");
            String pw = sc.nextLine();

            // 사용자 추가
            User newUser = new User(name, id, pw);
            UserData.userList.add(newUser);

            System.out.println("\n✅ 회원가입이 완료되었습니다!\n");
            break;
        }
        MainController.start();
    }
}
