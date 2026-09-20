
package TestScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomUtilities.OrangeHRMHomePage;
import PomUtilities.OrangeHRMLoginPage;
import PomUtilities.OrangeHRMMyInfoPage;
import PomUtilities.OrangeHRMVacanciesPage;

public class OrangeHRMTest
        extends BaseClassUtility.OrangeHRMBaseClass {

    // ============================================================
    // TEST CASE 1 - ADD VACANCY
    // ============================================================

    @Test(
            dataProvider = "vacancyData",
            priority = 1
    )
    public void addVacancyTest(
            String vacancyName,
            String jobTitle,
            String description,
            String hiringManager,
            String numberOfPositions
    ) {

        System.out.println(
                "========== ADD VACANCY TEST STARTED =========="
        );

        // HOME PAGE

        OrangeHRMHomePage homePage =
                new OrangeHRMHomePage(driver);

        // CLICK RECRUITMENT

        homePage.clickRecruitment();

        // VACANCIES PAGE

        OrangeHRMVacanciesPage vacanciesPage =
                new OrangeHRMVacanciesPage(driver);

        // CLICK VACANCIES TAB

        vacanciesPage.clickVacanciesTab();

        // CLICK ADD BUTTON

        vacanciesPage.clickAddButton();

        // ENTER VACANCY NAME

        vacanciesPage.enterVacancyName(vacancyName);

        // SELECT JOB TITLE

        vacanciesPage.selectJobTitle(jobTitle);

        // ENTER DESCRIPTION

        vacanciesPage.enterDescription(description);

        // SELECT HIRING MANAGER

        vacanciesPage.selectHiringManager(hiringManager);

        // ENTER NUMBER OF POSITIONS

        vacanciesPage.enterNumberOfPositions(
                numberOfPositions
        );

        // CLICK SAVE BUTTON

        vacanciesPage.clickSaveButton();

        // VERIFY VACANCY SAVED

        boolean result =
                vacanciesPage.verifyVacancySaved();

        Assert.assertTrue(
                result,
                "Vacancy was not saved successfully."
        );

        System.out.println(
                "Vacancy saved successfully."
        );

        // LOGOUT

        homePage.logout();

        System.out.println(
                "========== ADD VACANCY TEST COMPLETED =========="
        );
    }

    // ============================================================
    // TEST CASE 2 - EDIT MY INFO
    // ============================================================

    @Test(
            dataProvider = "myInfoData",
            priority = 2
    )
    public void editMyInfoTest(
            String expectedFirstName,
            String expectedLastName,
            String expectedEmployeeId
    ) {

        System.out.println(
                "========== EDIT MY INFO TEST STARTED =========="
        );

        // HOME PAGE

        OrangeHRMHomePage homePage =
                new OrangeHRMHomePage(driver);

        // CLICK MY INFO

        homePage.clickMyInfo();

        // MY INFO PAGE

        OrangeHRMMyInfoPage myInfoPage =
                new OrangeHRMMyInfoPage(driver);

        // ENTER FIRST NAME

        myInfoPage.enterFirstName(
                expectedFirstName
        );

        // CLEAR MIDDLE NAME

        myInfoPage.clearMiddleName();

        // ENTER LAST NAME

        myInfoPage.enterLastName(
                expectedLastName
        );

        // ENTER EMPLOYEE ID

        myInfoPage.enterEmployeeId(
                expectedEmployeeId
        );

        // SAVE PERSONAL DETAILS

        myInfoPage.clickPersonalDetailsSave();

        System.out.println(
                "Personal details saved."
        );

        // LOGOUT

        homePage.logout();

        // LOGIN AGAIN

        OrangeHRMLoginPage loginPage =
                new OrangeHRMLoginPage(driver);

        loginPage.enterUsername(
                properties.getProperty("username")
        );

        loginPage.enterPassword(
                properties.getProperty("password")
        );

        loginPage.clickLogin();

        System.out.println(
                "Login again completed."
        );

        // OPEN MY INFO AGAIN

        homePage.clickMyInfo();

        // VERIFY UPDATED DETAILS

        boolean result =
                myInfoPage.verifyUpdatedDetails(
                        expectedFirstName,
                        expectedLastName,
                        expectedEmployeeId
                );

        Assert.assertTrue(
                result,
                "Edited employee details were not updated correctly."
        );

        System.out.println(
                "Edited employee details verified successfully."
        );

        // LOGOUT

        homePage.logout();

        System.out.println(
                "========== EDIT MY INFO TEST COMPLETED =========="
        );
    }

    // ============================================================
    // DATA PROVIDER - VACANCY DATA
    // ============================================================

    @DataProvider(name = "vacancyData")
    public Object[][] vacancyData() throws IOException {

        String excelPath =
                "./src/test/resources/DDT/Day12VacancyDataOfOrangeHRM.xlsx";

        FileInputStream excelFile =
                new FileInputStream(excelPath);

        Workbook workbook =
                WorkbookFactory.create(excelFile);

        Sheet sheet =
                workbook.getSheetAt(0);

        Row row =
                sheet.getRow(1);

        DataFormatter formatter =
                new DataFormatter();

        String vacancyName =
                formatter.formatCellValue(
                        row.getCell(0)
                ).trim();

        String jobTitle =
                formatter.formatCellValue(
                        row.getCell(1)
                ).trim();

        String description =
                formatter.formatCellValue(
                        row.getCell(2)
                ).trim();

        String hiringManager =
                formatter.formatCellValue(
                        row.getCell(3)
                ).trim();

        String numberOfPositions =
                formatter.formatCellValue(
                        row.getCell(4)
                ).trim();

        workbook.close();

        excelFile.close();

        return new Object[][] {

                {
                        vacancyName,
                        jobTitle,
                        description,
                        hiringManager,
                        numberOfPositions
                }

        };
    }

    // ============================================================
    // DATA PROVIDER - MY INFO DATA
    // ============================================================

    @DataProvider(name = "myInfoData")
    public Object[][] myInfoData() throws IOException {

        String excelPath =
                "./src/test/resources/DDT/Day12MyInfoOrangeHRM.xlsx";

        FileInputStream excelFile =
                new FileInputStream(excelPath);

        Workbook workbook =
                WorkbookFactory.create(excelFile);

        Sheet sheet =
                workbook.getSheetAt(0);

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

        String employeeId =
                formatter.formatCellValue(
                        row.getCell(2)
                ).trim();

        workbook.close();

        excelFile.close();

        return new Object[][] {

                {
                        firstName,
                        lastName,
                        employeeId
                }

        };
    }
}
