package controller;

public class DeliveryController {
    public static void deliver() {
        System.out.println("🏃‍♂️ 배달 기사님이 배정 중입니다...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("😥 현재 배정 가능한 기사님이 없어요");
        }
        System.out.println("👍 배달 기사님 배정 완료!");
    }
}
