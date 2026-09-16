package PomImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PomUtilities.OrangeHRMCandidatesPage;
import PomUtilities.OrangeHRMHomePage;
import PomUtilities.OrangeHRMLoginPage;
import PomUtilities.OrangeHRMRecruitmentPage;

public class OrangeHRMPomImplementation {

    public static void main(String[] args) throws IOException, InterruptedException {


        // ============================================================
        // PROPERTY FILE
        // ============================================================

        FileInputStream propertyFile = new FileInputStream(

                "./src/test/resources/DDT/Day7OrangeHRM.properties"
        );


        java.util.Properties properties = new java.util.Properties();

        properties.load(propertyFile);


        String url = properties.getProperty("url");

        String username = properties.getProperty("username");

        String password = properties.getProperty("password");

        String resumePath = properties.getProperty("resumePath");


        propertyFile.close();



        // ============================================================
        // EXCEL FILE
        // ============================================================

        FileInputStream excelFile = new FileInputStream(

                "./src/test/resources/DDT/OrangeHRMRecruitment.xlsx"
        );


        Workbook workbook = WorkbookFactory.create(excelFile);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(1);

        DataFormatter formatter = new DataFormatter();



        // ============================================================
        // READ EXCEL DATA
        // ============================================================

        String firstName = formatter.formatCellValue(
                row.getCell(1)
        );


        String middleName = formatter.formatCellValue(
                row.getCell(2)
        );


        String lastName = formatter.formatCellValue(
                row.getCell(3)
        );


        String vacancy = formatter.formatCellValue(
                row.getCell(4)
        );


        String email = formatter.formatCellValue(
                row.getCell(5)
        );


        String contactNumber = formatter.formatCellValue(
                row.getCell(6)
        );


        String jobTitle = formatter.formatCellValue(
                row.getCell(7)
        );


        String searchVacancy = formatter.formatCellValue(
                row.getCell(8)
        );


        String hiringManager = formatter.formatCellValue(
                row.getCell(9)
        );


        String status = formatter.formatCellValue(
                row.getCell(10)
        );


        String candidateName = formatter.formatCellValue(
                row.getCell(11)
        );



        // ============================================================
        // CHROME SETTINGS
        // ============================================================

        ChromeOptions settings = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();


        prefs.put(
                "profile.password_manager_leak_detection",
                false
        );


        settings.setExperimentalOption(
                "prefs",
                prefs
        );



        // ============================================================
        // LAUNCH BROWSER
        // ============================================================

        WebDriver driver = new ChromeDriver(settings);

        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(

                Duration.ofSeconds(10)
        );



        // ============================================================
        // OPEN ORANGEHRM
        // ============================================================

        driver.get(url);



        // ============================================================
        // LOGIN PAGE
        // ============================================================

        OrangeHRMLoginPage loginPage =

                new OrangeHRMLoginPage(driver);


        loginPage.getUsername(username);

        loginPage.getPassword(password);

        loginPage.getLoginButton();



        // ============================================================
        // HOME PAGE
        // ============================================================

        OrangeHRMHomePage homePage =

                new OrangeHRMHomePage(driver);


        homePage.getRecruitment();



        // ============================================================
        // RECRUITMENT PAGE
        // ============================================================

        OrangeHRMRecruitmentPage recruitmentPage =

                new OrangeHRMRecruitmentPage(driver);



        // ============================================================
        // ADD CANDIDATE
        // ============================================================

        recruitmentPage.clickAdd();


        recruitmentPage.enterFirstName(firstName);


        recruitmentPage.enterMiddleName(middleName);


        recruitmentPage.enterLastName(lastName);


        recruitmentPage.selectVacancy(vacancy);


        recruitmentPage.enterEmail(email);


        recruitmentPage.enterContactNumber(contactNumber);


        recruitmentPage.getResume(resumePath);



        // ============================================================
        // SAVE CANDIDATE
        // ============================================================

        recruitmentPage.getSaveButton();


        Thread.sleep(3000);



        // ============================================================
        // CANDIDATES PAGE
        // ============================================================

        recruitmentPage.clickCandidates();


        Thread.sleep(2000);



        // ============================================================
        // SEARCH CANDIDATE
        // ============================================================

        OrangeHRMCandidatesPage candidatesPage =

                new OrangeHRMCandidatesPage(driver);


        candidatesPage.getJobTitle(jobTitle);


        candidatesPage.getVacancy(searchVacancy);


        candidatesPage.getHiringManager(hiringManager);


        candidatesPage.getStatus(status);


        candidatesPage.getCandidateName(candidateName);


        candidatesPage.getSearchButton();


        Thread.sleep(3000);



        // ============================================================
        // VERIFY
        // ============================================================

        boolean result =

                candidatesPage.verifyCandidate(candidateName);


        if (result) {

            System.out.println(

                    "Candidate is found in Records Found section."
            );

        } else {

            System.out.println(

                    "Candidate is NOT found in Records Found section."
            );
        }



        // ============================================================
        // LOGOUT
        // ============================================================

        homePage.getUserDropdown();


        homePage.getLogout();



        // ============================================================
        // CLOSE
        // ============================================================

        workbook.close();

        excelFile.close();

        //driver.quit();



        System.out.println(

                "OrangeHRM Recruitment POM test completed."
        );

    }

}
