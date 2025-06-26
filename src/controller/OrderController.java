package controller;

import model.OrderItem;

import java.util.List;
import java.util.Scanner;

// 주문내역 확인 & 주문하기
public class OrderController {
    public static void order(List<OrderItem> orderList) {
        // 주문하기 선택
        int total = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== ✅ 다음과 같이 주문합니다. =====\n");
        for(OrderItem item : orderList) {
            System.out.printf("%-10s \t %2d 개 \t %,10d\n", item.getMenu().getName(), item.getCount(), item.totalPrice());
            total += item.totalPrice();
        }

        System.out.printf("\n총 금액 : %,d원\n", total);
        System.out.println("\n결제 하시겠습니까?");
        System.out.println("예(1) / 아니요(2)");
        System.out.print("\n입력 : ");

        int pay = 0;
        try {
            pay = sc.nextInt();
        } catch (Exception e) {
            System.out.println("⚠️ 숫자만 입력해주세요.");
            sc.nextLine();
        }

        switch(pay) {
            case 1:
                System.out.println("\n결제중 ...");
                // 5초 대기 - thread.sleep

                try {
                    // 5초 -> 3초
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("❌ 결제 처리 중 문제가 발생했습니다.");
                }
                System.out.println("\n🎉 결제가 완료되었습니다.\n");
                DeliveryController.deliver();
                break;
            case 2:
                System.out.println("❌ 결제를 취소합니다.");
                break;
        }

    }
}
