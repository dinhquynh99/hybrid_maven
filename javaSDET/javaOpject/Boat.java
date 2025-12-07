package javaOpject;

public interface Boat {
    // Nếu ko define từ khoá abstract thì trình biên dịch vẫn tự hiểu tất cả đều là abstract method

    public void clickToElement();
    public abstract void moveToElement();
}
