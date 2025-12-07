package javaOpject;

public class Honda extends Car{
    String hondaCivic;

    public static void main(String[] args) {
        Honda honda = new Honda();
        honda.driverCar();

        Honda city = new Honda();
    }

    public void viewHondaCivic(){
        driverCar();
    }

    //  Non-Abstract Class không chứa 1 abstract method
    // Abstract method - hàm ko có phần thân
    // sử dụng để cho các lớp kế thừa phải implement lại
    // Thể hiện cho tính chất trừu tượng (Astraction)
    // public abstract void driverHondaCivic();

    public void driveHondaCivic(){

    }

    @Override
    public void viewCar() {

    }
}
