package rockerfeller;

public class JohnRockerfeller {
    // Thuộc tính
    public String companyName = "Standard Oil Company";
    public String companyProduct = "E95 Oil";

    // chỉ thằng kế thừa ms xem dc thôi (cả ngoài package) trong package cũng ko xem dc
    protected String rockerFriendship = "Abraham Lincol President";

    private String keySecret = "ROCK-2025-***";

    // default - ko cho phép truy cập ngoài package
    String companyPolicy = "Rockerfeller Salary Tax Cash";


    // Phương thức
    public void viewCompany(){
        System.out.println(companyName);
        System.out.println(companyProduct);
    }

    void viewPolicy(){
        System.out.println(companyPolicy);
    }

    protected void viewFriendship(){
        System.out.println(rockerFriendship);
    }

    private void viewKeySecret(){
        System.out.println(keySecret);
    }

    public static void main(String[] args) {
        JohnRockerfeller john = new JohnRockerfeller();
        john.viewCompany();
        john.viewPolicy();
        john.viewFriendship();
        john.viewKeySecret();
    }
}
