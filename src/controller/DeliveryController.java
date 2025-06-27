package controller;

public class DeliveryController {
    public static void deliver() {
        System.out.println("🏃‍♂️ 배달 기사님이 배정 중입니다...");
        try {
            // 5초 -> 3초
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("😥 현재 배정 가능한 기사님이 없어요");
        }
        System.out.println("👍 배달 기사님 배정 완료!\n");

        System.out.println("======================================");
        System.out.println("📦 배달을 시작합니다.");

        // 10초 ~ 2분 사이로 걸리는 시간 (deliveryTime), 거리(distance)
        int deliveryTime = getRandomDelivery();
        int distance = getRandomDistance();    // 1.3km

        // 거리
        System.out.printf("총 거리 : %.1f km\n", distance / 1000.0);

        // 예상 시간
        System.out.printf("예상 시간 : %d 초\n",deliveryTime / 1000);
        System.out.println("======================================");

        // 배달 시간이 30초 이상일 경우
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("😅 배달 기사님이 배정을 취소하셨습니다.");
        }

        if(deliveryTime >= 30000) {
            System.out.println("\n\uD83C\uDF27\uFE0F 현재 폭우로 인해 기사님이 안전운전 중이에요!\n");
        }
        // 배달 시간이 30초 미만일 경우
        else {
            System.out.println("\n🛵 기사님이 열심히 달려가고 있어요!\n");
        }

        // 단계 수 설정 ( 배달 시간이 길면 5단계, 짧으면 10단계)
        int step = (deliveryTime < 30000) ? 5 : 10;
        int interval = deliveryTime / step;

        // 배달 시물레이션
        for(int i = 0; i <= step; i++) {
            // 시간 설정
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println("⚠️ 배달 중 문제가 발생했습니다.");
            }

            int percent = i * 100 / step;
            double remainDistance = (distance - (distance * i / (double)step)) / 1000.0;

            String arrow = "➡\uFE0F".repeat(i);
            String space = "-".repeat(step - i);

            System.out.printf("[%-" + step + "s] %d%% (%.1fkm 남음)\n",
                    arrow + space, percent, remainDistance);
        }
        // 배달 완료 메세지
        System.out.println("\n\uD83C\uDF5D LAUNCHMATE");
        System.out.println("🏠 배달이 완료되었습니다. 맛있게 드세요!");
    }
    // 배달 시간 랜덤 설정 (10초 ~ 60초 사이의 값 랜덤 출력)
    private static int getRandomDelivery() {
        // random() * (최댓값 - 최솟값 + 1)) + 최솟값
        return (int) (Math.random() * (60000 - 10000 + 1) + 10000);
    }

    // 배달 거리 랜덤 설정 (800m ~ 1.5km 사이의 값 랜덤 출력)
    private static int getRandomDistance() {
        return (int) (Math.random() * (1500 - 800 + 1) + 800);
    }
}
