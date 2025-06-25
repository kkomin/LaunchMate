package controller;

import data.MomFoodData;
import model.Menu;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainController {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("언제나 점심을 책임지는 \uD83C\uDF5D LAUNCHMATE 입니다.");
            System.out.println("원하시는 음식점을 선택해주세요.\n");
            System.out.println("1. 엄마의 밥상");
            System.out.println("2. 부리또리");
            System.out.println("3. 고향촌 칼국수\n");

            System.out.print("입력 : ");
            int num = 0;

            // 숫자 이외의 경우 예외처리
            try {
                num = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\n[❗ ERROR ❗] 숫자를 입력하세요\n");
                sc.nextLine();
                continue;
            }

            String title = "";
            List<Menu> menuList = null;

            switch(num) {
                case 1 :
                    title = "엄마의 밥상";
                    menuList = MomFoodData.getMomMenuList();
                    break;
                case 2:
                    title = "부리또리";
                    // BurittoMenu 구현
                    break;
                case 3:
                    title = "고향촌 칼국수";
                    // KalguksuMenu 구현
                    break;
                default :
                    System.out.println("\n[💢WARNING💢] 1 ~ 3 사이의 숫자 입력\n");
                    continue;
            }

            // 메뉴 데이터가 없는 경우
            if (menuList.isEmpty()) {
                System.out.println("\n💦 메뉴 준비중 ... \n");
                continue;
            }

            System.out.println("\n[" + title + "] 메뉴\n");
            for(Menu menu : Objects.requireNonNull(menuList)) {
                System.out.printf("%-3d %-15s %,6d원\n", menu.getId(), menu.getName(), menu.getPrice());
            }

            // 메뉴 선택
            SelectedController.select(menuList);
            break;
        }
    }
}
