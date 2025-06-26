package login;

import controller.MainController;
import data.UserData;
import model.User;

import java.util.Scanner;

public class SignUp {
    public static void signup() {
        Scanner sc = new Scanner(System.in);

        String name;
        while(true) {
            System.out.print("\n이름 : ");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("이름을 입력해주세요.");
                continue;
            }

            // 중복 검사 -> 이름 중복일 경우
            boolean isDuplicate = false;
            for (User user : UserData.userList) {
                if (user.getName().equals(name)) {
                    System.out.println("\n🙅‍♀️ 이미 존재하는 사용자 입니다.\n");
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                break;
            }
        }

        String id;
        while(true) {
            System.out.print("아이디 : ");
            id = sc.nextLine().trim();

            if (id.isEmpty()) {
                System.out.println("아이디를 입력해주세요.");
                continue;
            }

            if (id.equals("0")) {
                System.out.println("❌ 아이디로 0은 사용 불가합니다.\n");
                continue;
            }
            break;
        }

        String pw;
        while(true) {
            System.out.print("비밀번호 : ");
            pw = sc.nextLine().trim();

            if (pw.isEmpty()) {
                System.out.println("비밀번호를 입력해주세요.");
                continue;
            }
            break;
        }

        // 사용자 추가
        User newUser = new User(name, id, pw);
        UserData.userList.add(newUser);

        System.out.println("\n✅ 회원가입이 완료되었습니다!\n");
        MainController.start();
    }
}
