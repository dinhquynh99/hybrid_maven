package rockerfeller;

public class DavidRockerfeller extends JohnRockerfeller {
    public static void main(String[] args) {
        DavidRockerfeller david = new DavidRockerfeller();
        david.viewCompanyName();
        david.viewCompany();
        david.viewPolicy();
        david.viewFriendship();
        // david.viewKeyScret();
    }

    public void viewCompanyName() {
        viewCompany();
        viewFriendship();
    }

}
