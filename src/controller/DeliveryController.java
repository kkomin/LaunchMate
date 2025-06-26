package controller;

public class DeliveryController {
    public static void deliver() {
        System.out.println("🏃‍♂️ 배달 기사님이 배정 중입니다...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("😥 현재 배정 가능한 기사님이 없어요");
        }
        System.out.println("👍 배달 기사님 배정 완료!\n");

        System.out.println("📦 배달을 시작합니다.");

        // 10초 ~ 2분 사이로 걸리는 시간 (deliveryTime), 거리(distance)
        int deliveryTime = getRnadomDelivery();
        int distance = 1300;    // 1.3km

        System.out.println(deliveryTime / 1000 + "초");
        // 배달 시간이 30초 이상일 경우
        if(deliveryTime >= 30000) {
            System.out.println("\uD83C\uDF27\uFE0F 현재 폭우로 인해 기사님이 안전운전 중이에요!");
        }
        // 배달 시간이 30초 미만일 경우
        else {
            System.out.println("🛵 기사님이 열심히 달려가고 있어요!");
        }
    }
    // 배달 시간 랜덤 설정
    private static int getRnadomDelivery() {
        // random() * (최댓값 - 최솟값 + 1)) + 최솟값
        return (int) (Math.random() * (60000 - 10000 + 1) + 10000);
    }
}
