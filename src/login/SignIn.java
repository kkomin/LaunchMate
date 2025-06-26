package login;

import controller.MainController;
import controller.RestaurantController;
import data.UserData;
import model.CurrentUser;
import model.User;

import java.util.Objects;
import java.util.Scanner;

public class SignIn {
    public static void login() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n이전으로는 0 입력");

            System.out.print("아이디(ID) : ");
            String id = sc.nextLine();

            User foundUser = null;
            for(User user : UserData.userList) {
                if(user.getId().equals(id)) {
                    foundUser = user;
                }
            }

            // 0 입력 시 메인으로 이동
            if(!id.equals("0")) {
                if(foundUser == null) {
                    System.out.println("❗ 아이디가 존재하지 않습니다.\n");
                    continue;
                }

                System.out.print("비밀번호(PW) : ");
                String pw = sc.nextLine();

                if(!Objects.requireNonNull(foundUser).getPw().equals(pw)) {
                    System.out.println("❌ 비밀번호가 일치하지 않습니다.\n");
                    continue;
                }

                CurrentUser.setUser(foundUser);
                RestaurantController.restaurant();
                break;
            }
            else {
                System.out.println("==========================");
                System.out.println("홈으로 돌아갑니다.\n");
                System.out.println("==========================");
                MainController.start();
            }

            break;
        }
    }
}
