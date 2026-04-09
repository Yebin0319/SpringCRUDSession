package likelion;

public class Juice extends Beverage {

    private int VitaminC; // EnergyDrink만의 추가 필드

    public Juice(String name, int price,
                       int stock, int VitaminC) {
        super(name, price, stock);
        this.VitaminC = VitaminC;
    }

    @Override
    public void displayInfo() {
        System.out.println("이름: "   + getName());    // getter 사용
        System.out.println("가격: "   + getPrice() + "원");
        System.out.println("재고: "   + getStock() + "개");
        System.out.println("비타민: " + VitaminC + "mg");
    }
}