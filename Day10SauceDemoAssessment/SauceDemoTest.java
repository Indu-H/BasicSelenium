
package SauceDemoImplementation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.annotations.Test;

import BaseClassUtility.SauceDemoBaseClass;

import PomUtilities.SauceDemoCartPage;
import PomUtilities.SauceDemoCheckoutPage;
import PomUtilities.SauceDemoLoginPage;
import PomUtilities.SauceDemoProductsPage;


public class SauceDemoTest extends SauceDemoBaseClass {


    // LOGIN TEST

    @Test(priority = 1)

    public void loginTest() {

        // OPEN APPLICATION

        driver.get(
                properties.getProperty("url")
        );


        // READ LOGIN DATA FROM PROPERTIES

        String username =
                properties.getProperty("username");

        String password =
                properties.getProperty("password");


        // CREATE LOGIN PAGE OBJECT

        SauceDemoLoginPage loginPage =
                new SauceDemoLoginPage(driver);


        // ENTER USERNAME

        loginPage.enterUsername(username);


        // ENTER PASSWORD

        loginPage.enterPassword(password);


        // CLICK LOGIN

        loginPage.clickLogin();


        // CREATE PRODUCTS PAGE OBJECT

        SauceDemoProductsPage productsPage =
                new SauceDemoProductsPage(driver);


        // VERIFY PRODUCTS PAGE

        boolean productsDisplayed =
                productsPage.verifyProductsPage();


        if (productsDisplayed) {

            System.out.println(
                    "Login successful and Products page displayed."
            );

        } else {

            System.out.println(
                    "Products page is not displayed."
            );

        }

    }



    // ORDER PLACEMENT TEST

    @Test(
            priority = 2,
            dependsOnMethods = "loginTest"
    )

    public void orderPlacementTest()
            throws IOException, InterruptedException {


        // CREATE PRODUCTS PAGE OBJECT

        SauceDemoProductsPage productsPage =
                new SauceDemoProductsPage(driver);


        // ADD SAUCE LABS BACKPACK

        productsPage.addSauceLabsBackpack();

        System.out.println(
                "Sauce Labs Backpack added to cart."
        );


        // VERIFY CART CONTAINS 1 ITEM

        boolean cartCount =
                productsPage.verifyCartCount("1");


        if (cartCount) {

            System.out.println(
                    "Cart contains 1 item."
            );

        } else {

            System.out.println(
                    "Cart does not contain 1 item."
            );

            return;

        }


        // OPEN CART

        productsPage.clickCart();


        // CREATE CART PAGE OBJECT

        SauceDemoCartPage cartPage =
                new SauceDemoCartPage(driver);


        // VERIFY BACKPACK DISPLAYED

        boolean backpackDisplayed =
                cartPage.verifyBackpackDisplayed();


        if (backpackDisplayed) {

            System.out.println(
                    "Sauce Labs Backpack is displayed in cart."
            );

        } else {

            System.out.println(
                    "Sauce Labs Backpack is not displayed in cart."
            );

            return;

        }


        // CLICK CHECKOUT

        cartPage.clickCheckout();



        // READ CHECKOUT DATA FROM EXCEL

        String excelPath =
                "./src/test/resources/DDT/SauceDemo1.xlsx";


        FileInputStream excelFile =
                new FileInputStream(excelPath);


        Workbook workbook =
                WorkbookFactory.create(excelFile);


        Sheet sheet =
                workbook.getSheet("Sheet1");


        Row row =
                sheet.getRow(1);


        DataFormatter formatter =
                new DataFormatter();


        String firstName =
                formatter.formatCellValue(
                        row.getCell(0)
                ).trim();


        String lastName =
                formatter.formatCellValue(
                        row.getCell(1)
                ).trim();


        String postalCode =
                formatter.formatCellValue(
                        row.getCell(2)
                ).trim();



        // PRINT EXCEL DATA

        System.out.println(
                "Excel Sheet Name: "
                        + sheet.getSheetName()
        );


        System.out.println(
                "First Name from Excel: "
                        + firstName
        );


        System.out.println(
                "Last Name from Excel: "
                        + lastName
        );


        System.out.println(
                "Postal Code from Excel: "
                        + postalCode
        );



        // CLOSE EXCEL

        workbook.close();

        excelFile.close();



        // CHECK EXCEL DATA

        if (
                firstName.isEmpty()
                        || lastName.isEmpty()
                        || postalCode.isEmpty()
        ) {

            System.out.println(
                    "Excel data is empty. Please check the Excel file."
            );

            return;

        } else {

            System.out.println(
                    "Excel data read successfully."
            );

        }



        // CREATE CHECKOUT PAGE OBJECT

        SauceDemoCheckoutPage checkoutPage =
                new SauceDemoCheckoutPage(driver);



        // ENTER FIRST NAME

        checkoutPage.enterFirstName(firstName);



        // ENTER LAST NAME

        checkoutPage.enterLastName(lastName);



        // ENTER POSTAL CODE

        checkoutPage.enterPostalCode(postalCode);



        // CLICK CONTINUE

        checkoutPage.clickContinue();



        // VERIFY CHECKOUT OVERVIEW

        boolean overviewDisplayed =
                checkoutPage.verifyCheckoutOverview();


        if (overviewDisplayed) {

            System.out.println(
                    "Checkout: Overview page displayed."
            );

        } else {

            System.out.println(
                    "Checkout: Overview page is not displayed."
            );

            return;

        }



        // CLICK FINISH

        checkoutPage.clickFinish();



        // VERIFY THANK YOU MESSAGE

        boolean thankYouDisplayed =
                checkoutPage.verifyThankYouMessage();


        if (thankYouDisplayed) {

            System.out.println(
                    "Thank you for your order message displayed."
            );

        } else {

            System.out.println(
                    "Thank you for your order message is not displayed."
            );

        }

    }

}
