package controller;

import data.MomFoodData;
import model.Menu;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OrderController {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("언제나 점심을 책임지는 \uD83C\uDF5D LAUNCHMATE 입니다.");
        System.out.println("원하시는 음식점을 선택해주세요.\n");
        System.out.println("1. 엄마의 밥상");
        System.out.println("2. 부리또리");
        System.out.println("3. 고향촌 칼국수\n");

        System.out.print("입력 : ");
        int num = sc.nextInt();

        String title;
        List<Menu> menuList = null;

        switch(num) {
            case 1 :
                title = "엄마의 밥상";
                menuList = MomFoodData.getMomMenuList();
                break;
            case 2:
                title = "부리또리";
                break;
            case 3:
                title = "고향촌 칼국수";
                break;
            default :
                System.out.println("잘못된 입력입니다.");
                return;
        }
        System.out.println(title + " 메뉴");
        for(Menu menu : Objects.requireNonNull(menuList)) {
            System.out.printf("%-3d %-15s %,6d원\n", menu.getId(), menu.getName(), menu.getPrice());
        }

        // 메뉴 선택
        SelectedController.select(menuList);
    }
}
