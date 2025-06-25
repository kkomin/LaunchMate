package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("언제나 점심을 책임지는 \uD83C\uDF5D LAUNCHMATE 입니다.");
        System.out.println("원하시는 음식점을 선택해주세요.\n");
        System.out.println("1. 엄마의 밥상");
        System.out.println("2. 부리또리");
        System.out.println("3. 고향촌 칼국수\n");

        System.out.print("입력 : ");
        int num = sc.nextInt();
        System.out.println(num);
    }
}
