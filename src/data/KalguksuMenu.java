package data;

import model.Menu;

import java.util.ArrayList;
import java.util.List;

public class KalguksuMenu {
    public static List<Menu> getKalguksuMenu() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(1, "얼큰이 칼국수", 8500));
        menuList.add(new Menu(2, "얼큰이 칼국수", 9000));
        menuList.add(new Menu(3, "얼음 메밀국수", 8500));
        menuList.add(new Menu(4, "비빔 막국수", 8500));
        menuList.add(new Menu(5, "검정 콩국수", 1000));
        menuList.add(new Menu(6, "바지락 칼국수", 8500));
        menuList.add(new Menu(7, "감자전", 8000));
        menuList.add(new Menu(8, "공기밥", 1000));
        menuList.add(new Menu(9, "막걸리", 3000));
        menuList.add(new Menu(10, "음료수", 1500));
        return menuList;
    }
}
