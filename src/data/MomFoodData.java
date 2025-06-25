package data;

import model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MomFoodData {
    public static List<Menu>  getMomMenuList() {
        List<Menu> menuList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            menuList.add(new Menu(i, "뚝불", 10000));
            menuList.add(new Menu(i, "뚝제육", 9000));
            menuList.add(new Menu(i, "육회비빔밥", 9000));
            menuList.add(new Menu(i, "부대찌개", 9500));
            menuList.add(new Menu(i, "김치찌개", 8000));
            menuList.add(new Menu(i, "김치즈밥", 8000));
            menuList.add(new Menu(i, "알밥", 7500));
            menuList.add(new Menu(i, "된장찌개", 7500));
            menuList.add(new Menu(i, "순두부찌개", 7500));
            menuList.add(new Menu(i, "음료수", 1500));
            menuList.add(new Menu(i, "주류", 4000));
        }
        return menuList;
    }
}
