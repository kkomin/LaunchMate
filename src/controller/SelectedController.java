package controller;

import model.Menu;
import model.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectedController {
    public static void select(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);

        // 선택한 아이템들 저장
        List<OrderItem> orderList = new ArrayList<>();

        while(true) {
            System.out.println("\n메뉴를 선택하세요. (선택 완료 시 0 입력)");
            int selectMenu;

            try {
                selectMenu = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\n❗ 숫자를 입력하세요\n");
                sc.nextLine();
                continue;
            }

            if(selectMenu == 0) {
                if(orderList.isEmpty()) {
                    System.out.println("아직 선택한 메뉴가 없습니다.");
                    continue;
                } else {
                    System.out.println("========== [주문 내역] ==========\n");
                    for(OrderItem item : orderList) {
                        System.out.printf("%-15s \t %2d 개\n", item.getMenu().getName(), item.getCount());
                    }
                    System.out.println("\n===============================\n");
                    System.out.println("\n이대로 주문 하시겠습니까?");
                    System.out.println("\n예(1) / 아니요 (2) / 주문취소 (3)");
                    System.out.print("입력 : ");
                    int goOrder;

                    try {
                        goOrder = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("\n⚠️ 숫자를 입력하세요\n");
                        continue;
                    }

                    switch(goOrder) {
                        case 1 :
                        // 주문하기
                        OrderController.order(orderList);
                        break;
                        case 2 :
                            continue;
                        case 3:
                            RestaurantController.restaurant();
                        default :
                            System.out.println("⚠️ 잘못 입력하셨습니다.");
                            continue;
                    }
                }
                break;
            }

            Menu selected = findMenuById(menuList, selectMenu);
            if(selected == null) {
                System.out.println("❓ 메뉴가 존재하지 않습니다.\n");
                continue;
            }

            System.out.println("\n수량을 입력하세요.");
            int selectNum = sc.nextInt();
            if(selectNum <= 0) {
                System.out.println("⚠️ 1개 이상이어야 합니다.\n");
                continue;
            }

            // 이미 선택한 메뉴일 경우
            boolean found = false;
            for(OrderItem item : orderList) {
                // 입력한 id와 리스트에 있는 id 비교
                if(item.getMenu().getId() == selected.getId()) {
                    // 수량만 추가
                    item.setCount(item.getCount() + selectNum);
                    found = true;
                    break;
                }
            }

            if(!found) {
                orderList.add(new OrderItem(selected, selectNum));
            }
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
