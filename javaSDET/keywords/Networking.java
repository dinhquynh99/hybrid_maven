package keywords;

public class Networking {

    // Phạm vi truy cập = Access Modifier
    // Thể hiện tính chất đống gói

    // Sử dụng trong phạm vi class này
    private String switchProduct = "";

    // Cho phép sử dụng thông qua kế thừa
    protected String hubProduct = "";

    // Sử dụng trong cùng 1 package
    String firewall = ""; // default

    // Dùng trong toàn bộ hệ thống/ framewwork
    public String routerProduct = "";

    // Hàm khởi tạo
    public Networking(String productName){

    }
}
