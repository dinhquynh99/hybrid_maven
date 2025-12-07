package keywords;

public class Dell extends Networking implements IComputor {
    // Class kế thừa class => dùng extends
    // cùng data type dùng extend (kế thừa nhau dc)

    // Class kế thừa interface => dùng implements
    // khác data type dùng implements
    // ko có TH interface kế thừa class

    String ssd = "Samsung 998"; // Biến Global

    public Dell(String ssd) { // Biến Local
        // Trong hàm khởi tạo của lớp con phải gọi qua hàm khởi tạo của lớp cha = super
        super("Router");

        // Trong trường hợp biến trùng tên thì ưu tiên lấy biến loacl
        System.out.println(ssd);
        // Muốn dùng biến global thì phải gọi qua hàm this
        System.out.println(this.ssd);

}
}
