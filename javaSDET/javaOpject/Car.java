package javaOpject;

public abstract class Car {

    // Abstract method
    // Bắt buộc phải override
    public abstract void viewCar();

    // Non-abstract method
    // Cho lớp con (sub-class) sử dụng trực tiếp
    // Cũng cho phép override lại
    public void driverCar(){

    }
}
