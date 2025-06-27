package data;

import model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MomFoodData {
    public static List<Menu>  getMomMenuList() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(1, "뚝불", 10000));
        menuList.add(new Menu(2, "뚝제육", 9000));
        menuList.add(new Menu(3, "육회비빔밥", 9000));
        menuList.add(new Menu(4, "부대찌개", 9500));
        menuList.add(new Menu(5, "김치찌개", 8000));
        menuList.add(new Menu(6, "김치즈밥", 8000));
        menuList.add(new Menu(7, "알밥", 7500));
        menuList.add(new Menu(8, "된장찌개", 7500));
        menuList.add(new Menu(9, "순두부찌개", 7500));
        menuList.add(new Menu(10, "음료수", 1500));
        menuList.add(new Menu(11, "주류", 4000));
        return menuList;
    }
}
