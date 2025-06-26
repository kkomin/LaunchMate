package login;

import controller.MainController;
import data.UserData;
import model.CurrentUser;
import model.User;

import java.util.Scanner;

// 탈퇴하기
public class Delete {
    public static void delete() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("\n이름 : ");
            String name = sc.nextLine();

            System.out.print("아이디 : ");
            String id = sc.nextLine();

            User foundUser = null;
            for(User user : UserData.userList) {
                if(user.getName().equals(name) && user.getId().equals(id)) {
                    foundUser = user;
                    break;
                }
            }

            if(foundUser == null) {
                System.out.println("\n❌ 해당 정보를 가진 사용자는 존재하지 않습니다.\n");
                continue;
            }


            System.out.printf("\n%s 님의 정보를 삭제하시겠습니까?", name);
            System.out.println("예(1) / 아니요(2)\n");
            System.out.print("입력 : ");
            int input;

            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못 입력하셨습니다.");
                sc.nextLine();
                continue;
            }

            switch(input) {
                case 1 :
                    UserData.userList.remove(foundUser);
                    System.out.println("😂 성공적으로 삭제되었습니다.\n");
                    UserData.userList.remove(CurrentUser.getUser());  // 리스트에서 제거
                    MainController.start();
                    break;
                case 2:
                    System.out.println("\n메인 화면으로 돌아갑니다.");
                    MainController.start();
                    break;
                default :
                    System.out.println("⚠\uFE0F 1 또는 2를 입력해주세요.");
                    break;
            }
            break;
        }
    }
}
