package model;

// 주문하기 위해 선택한 아이템들
// 주문 시 결재까지의 계산도 포함
public class OrderItem {
    // id, name, price -> Menu에 이미 존재함
    private final Menu menu;
    private int count;

    public OrderItem(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int totalPrice() {
        return menu.getPrice() * count;
    }
}
