package nonFactoryPattern;

public class EndUser {
    public static void main(String[] args) {
        // Đến địa điểm showroom xe Honda
        Honda honda = new Honda();
        honda.viewCar();
        honda.driverCar();
        honda.buyCar();

        // Đến địa điểm showroom xe Huyndai
        Huyndai huyndai = new Huyndai();
        huyndai.viewCar();
        huyndai.driverCar();
        huyndai.buyCar();

        Toyota toyota = new Toyota();
        toyota.viewCar();
        toyota.driverCar();
        toyota.buyCar();

        Vinfast vinf = new Vinfast();
        vinf.viewCar();
        vinf.driverCar();
        vinf.buyCar();
    }
}
