package controller;

import model.Menu;

import java.util.List;
import java.util.Scanner;

public class SelectedController {
    public static void select(List menuList) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;

        String menus = "";
        int count = 0;

        while(check) {
            System.out.println("\n메뉴를 선택하세요. (선택 완료 시 0 입력)");
            int selectMenu = sc.nextInt();
            Menu selected = findMenuById(menuList, selectMenu);

            if(selectMenu == 0) {
                System.out.printf("%s\t%d개\n", menus, count);
                break;
            }

            System.out.println("\n수량을 입력하세요.");
            int selectNum = sc.nextInt();

            menus = selected.getName();
            count = selectNum;

            // 가장 마지막으로 추가한 아이템만 나오는 문제 발생
        }
    }
    private static Menu findMenuById(List<Menu> menuList, int id) {
        for(Menu menu : menuList) {
            if(id == menu.getId()) {
                return menu;
            }
        }
        return null;
    }
}
