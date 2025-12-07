package dungQuatOil;

import rockerfeller.JohnRockerfeller;

public class NelsonRockerfeller extends JohnRockerfeller {
    public static void main(String[] args) {
        NelsonRockerfeller nelson = new NelsonRockerfeller();
        nelson.viewCompanyName();
        // nelson.viewPolicy();
        nelson.viewFriendship();
        // nelson.viewKeyScret();
    }

    public void viewCompanyName(){
        viewCompany();
    }
}
