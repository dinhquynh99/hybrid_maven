package Keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GlobalVariable {
    // Biến non-static
    String addressName = "Ho Chi Minh City";

    // Biến tĩnh: static
    static String fullName = "Automation fc";

    // Biến final
    final String firstName = "John";

    // Biến static final
    static final String BROWSER_NAME = "FireFox";

    static void main(){
        // new : khởi tạo một class lên = tạo rs 1 đối tượng/instance
        // 1 class có thể tạo ra n đối tượng
        GlobalVariable globalVariable = new GlobalVariable();

        // kiếm tra xem biến đó có thuộc kiểu dữ liệu nào đó ko
        System.out.println(globalVariable instanceof GlobalVariable);

        // Interface  dùng qua cách implement chứ ko new

        // Biến non-static: dùng thông qua 1 instance/ đối tượng đại diện chp class
        System.out.println(globalVariable.addressName);

        globalVariable.addressName = "Ha Noi City";

        // Biến tĩnh: static: trực tiếp từ class
        System.out.println(fullName);

        // Biến final: ko cho phép ghi đè
        // globalVariable.firstName = "Ha Noi City";

        // Biến static final: Thuộc phạm vi class + ko dc ghi đè

    }

    // Gọi hàm tuần tự ko dc phép truy cập cùng thời điểm
public synchronized WebDriver getBrowserDriver(){
        WebDriver driver = new FirefoxDriver();
        return driver;
}

}
