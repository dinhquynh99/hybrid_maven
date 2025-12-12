package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static BasePage getBasePage(){
        return new BasePage();
    }

    // Global variable
    // private WebDriver driver;

    // Web Browser
    // 1- Phạm vi truy cập
    // 1.1 private => khi hàm này chỉ sử dụng trong chính lớp BasePage - 1 hàm khác có gọi qua để sử dụng
    // 2.2 protected => khi hàm này chỉ sử dụng cho các lớp con kế thừa BasePage (cùng package và khác package)
    // 2.3 public (gần như ko dùng) => khi hàm này muốn cho tất cả các class gọi qua sủ dụng dc

    // 2- Kiểu dữ liệu cảu hàm
    // gồm: void/ int/ String/ boolean/ WebbElement/ List<WebElement>/...
    // nó liên quan đến chức năng mk viết trong hàm
    // chỉ có void là ko cần return còn khác void đều phải return kiểu giữ liệu trả về

    // 3- Tên hàm

    // 4- Tham số
    // có tham số hay không tuỳ vào chức năng cần viết

    // 5- Kiểu dữ liệu trả về

    // Local variable: chỉ sử dụng dc trong phạm vi hàm void này ngoài phạm vi hàm này thì ko dùng dc
    public void clickToElement(String locator) {

    }

    public void senkeyElement() {
        String locator;
    }

    public void selectElement() {
        String locator;

        // biến i chỉ dc dùng trong vòng lặp for thôi trên và dưới vòng lặp đêù ko dùng dc
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                String name = "";
            }

        }

        String browserName;
    }

    // chỉ truyền tham số mang tính chất đại diện, ko truyền cứng
    public void openPageURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void fowardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }


    private Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelToAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public void sendkeyToAlert(WebDriver driver, String keyToSend) {
        waitAlertPresence(driver).sendKeys(keyToSend);
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }


    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    private WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    private List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void senkeyToElement(WebDriver driver, String locator, String valueToSend) {
        getElement(driver, locator).sendKeys(valueToSend);
    }

    // nếu biến dc dùng từ 2 lần trở lên thì khai báo sau đó lấy ra dùng
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        Select select = new Select(getElement(driver, locator));
        select.selectByVisibleText(textItem);
    }

    // nếu biến dùng 1 lần thì ko cần khai báo new lên và dùng luôn
    public String getSelectedItemDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemEnableDropdown(WebDriver driver, String editableXPath, String childXPath, String expectedTextItem) {
        getElement(driver, editableXPath).clear();
        getElement(driver, editableXPath).sendKeys(expectedTextItem);
        sleepInSecond(1);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(childXPath)));
        for (WebElement temp : allItems) {
            if (temp.getText().equals(expectedTextItem)) {
                temp.click();
                sleepInSecond(1);
                break;
            }

        }

    }

    public void selectItemInSelectableDropdown(WebDriver driver, String parentXPath, String childXPath, String expectedTextItem) {
        getElement(driver, parentXPath).click();
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(childXPath)));
        for (WebElement temp : allItems) {
            if (temp.getText().equals(expectedTextItem)) {
                temp.click();
                sleepInSecond(1);
                break;
            }

        }

    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementDomAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getDomAttribute(attributeName);
    }

    public String getElementDomProperty(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getDomProperty(propertyName);
    }

    public String getElementCss(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getDomProperty(propertyName);
    }

    public String getElementHexaColor(WebDriver driver, String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public boolean isElementDisplay(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementEnable(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)) {
            clickToElement(driver, locator);
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)) {
            clickToElement(driver, locator);
        }
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void leftClickToElement(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void dragAndDropToElement(WebDriver driver, String sourcelocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourcelocator),
                getElement(driver, targetLocator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("argument[0].setAttribute('style', argument[1]", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("argument[0].setAttribute('style', argument[1])", element, originalStyle);

    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].click();", getElement(driver, locator));
        sleepInSecond(2);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("argument[0].validationMessage;", getElement(driver, locator));
    }

    public WebElement waitElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(getByXPath(locator)));
    }

    public List<WebElement> waitListElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXPath(locator)));
    }

    public boolean waitElementInVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(locator)));
    }

    public boolean waitListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
    }

    public WebElement waitElementPresence(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfElementLocated(getByXPath(locator)));
    }

    public List<WebElement> waitListElementPresence(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXPath(locator)));
    }

    public boolean waitElementSelected(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeSelected(getByXPath(locator)));
    }

    public WebElement waitElementClickable(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeClickable(getByXPath(locator)));
    }

    public boolean isloadingIconDisappear(WebDriver driver){
        return waitListElementInvisible(driver, "//div[contains(@class,'oxd-loading-spinner')]");
    }

    private Duration shortTimeout = Duration.ofSeconds(10);
    private Duration longTimeout = Duration.ofSeconds(30);

    public By getByXPath(String locator) {
        return By.xpath(locator);
    }

}
