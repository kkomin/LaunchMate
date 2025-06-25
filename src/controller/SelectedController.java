package controller;

import model.Menu;
import model.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectedController {
    public static List<OrderItem> select(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);

        // 선택한 아이템들 저장
        List<OrderItem> orderList = new ArrayList<>();

        while(true) {
            System.out.println("\n메뉴를 선택하세요. (선택 완료 시 0 입력)");
            int selectMenu;

            try {
                selectMenu = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\n[❗ ERROR ❗] 숫자를 입력하세요\n");
                continue;
            }

            if(selectMenu == 0) {
                if(orderList.isEmpty()) {
                    System.out.println("아직 선택한 메뉴가 없습니다.");
                    continue;
                } else {
                    System.out.println("\n[주문 내역]");
                    for(OrderItem item : orderList) {
                        System.out.printf("%-15s \t %2d 개\n", item.getMenu().getName(), item.getCount());
                    }
                    System.out.println("이대로 주문 하시겠습니까?");
                    System.out.println("예(1) / 아니요 (2) / 주문취소 (3)");
                    System.out.print("입력 : ");
                    int goOrder;

                    try {
                        goOrder = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("\n[❗ ERROR ❗] 숫자를 입력하세요\n");
                        continue;
                    }

                    switch(goOrder) {
                        case 1 :
                        // 주문하기
                        OrderController.order();
                        break;
                        case 2 :
                            continue;
                        case 3:
                            MainController.start();
                        default :
                            System.out.println("잘못 입력하셨습니다.");
                            continue;
                    }
                }
                break;
            }

            Menu selected = findMenuById(menuList, selectMenu);
            if(selected == null) {
                System.out.println("메뉴가 존재하지 않습니다.\n");
                continue;
            }

            System.out.println("\n수량을 입력하세요.");
            int selectNum = sc.nextInt();
            if(selectNum <= 0) {
                System.out.println("1개 이상이어야 합니다.\n");
                continue;
            }
            orderList.add(new OrderItem(selected, selectNum));
        }
        return orderList;
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
