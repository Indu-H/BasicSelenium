package PomImplementation;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import PomUtilities.OrangeHRMCandidatesPage;
import PomUtilities.OrangeHRMHomePage;
import PomUtilities.OrangeHRMLoginPage;
import PomUtilities.OrangeHRMRecruitmentPage;

public class OrangeHRMPomImplementation {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		
		        // PROPERTY FILE
		        

		        FileInputStream propFis =
		                new FileInputStream("src/test/resources/DDT/Day7OrangeHRM.properties");

		        Properties prop = new Properties();

		        prop.load(propFis);


		        // =====================================================
		        // COMMON DATA FROM PROPERTY FILE
		        // =====================================================

		        String url = prop.getProperty("url");

		        String browser = prop.getProperty("browser");

		        String loginUsername = prop.getProperty("username");

		        String loginPassword = prop.getProperty("password");

		        String resumePath = prop.getProperty("resumePath");


		        // =====================================================
		        // EXCEL FILE
		        // =====================================================

		        FileInputStream excelFis =
		                new FileInputStream("src/test/resources/DDT/OrangeHRMRecruitment.xlsx");

		        Workbook wb = WorkbookFactory.create(excelFis);

		        Sheet sh = wb.getSheet("Sheet1");

		        Row row = sh.getRow(1);

		        DataFormatter formatter = new DataFormatter();


		        // =====================================================
		        // TEST DATA FROM EXCEL
		        // =====================================================

		        String firstName =
		                formatter.formatCellValue(row.getCell(1));

		        String middleName =
		                formatter.formatCellValue(row.getCell(2));

		        String lastName =
		                formatter.formatCellValue(row.getCell(3));

		        String vacancy =
		                formatter.formatCellValue(row.getCell(4));

		        String email =
		                formatter.formatCellValue(row.getCell(5));

		        String contactNumber =
		                formatter.formatCellValue(row.getCell(6));

		        String dateOfApplication =
		                formatter.formatCellValue(row.getCell(7));

		        String jobTitle =
		                formatter.formatCellValue(row.getCell(8));

		        String searchVacancy =
		                formatter.formatCellValue(row.getCell(9));

		        String hiringManager =
		                formatter.formatCellValue(row.getCell(10));

		        String status =
		                formatter.formatCellValue(row.getCell(11));

		        String candidateName =
		                formatter.formatCellValue(row.getCell(12));

		        String applicationDate =
		                formatter.formatCellValue(row.getCell(13));


		        // =====================================================
		        // LAUNCH BROWSER
		        // =====================================================

		        WebDriver driver;

		        if (browser.equalsIgnoreCase("chrome")) {

		            driver = new ChromeDriver();

		        } else {

		            driver = new ChromeDriver();
		        }


		        driver.manage().window().maximize();

		        driver.manage()
		                .timeouts()
		                .implicitlyWait(Duration.ofSeconds(10));


		        WebDriverWait wait =
		                new WebDriverWait(
		                        driver,
		                        Duration.ofSeconds(20)
		                );


		        // =====================================================
		        // OPEN ORANGEHRM
		        // =====================================================

		        driver.get(url);


		        // =====================================================
		        // LOGIN PAGE OBJECT
		        // =====================================================

		        OrangeHRMLoginPage loginPage =
		                new OrangeHRMLoginPage(driver);


		        loginPage.getUsername(loginUsername);

		        loginPage.getPassword(loginPassword);

		        loginPage.getLoginButton();


		        // =====================================================
		        // HOME PAGE OBJECT
		        // =====================================================

		        OrangeHRMHomePage homePage =
		                new OrangeHRMHomePage(driver);


		        homePage.getRecruitment();


		        // =====================================================
		        // RECRUITMENT PAGE OBJECT
		        // =====================================================

		        OrangeHRMRecruitmentPage recruitmentPage =
		                new OrangeHRMRecruitmentPage(driver);


		        // Click Add
		        recruitmentPage.getAddButton();


		        // Enter First Name
		        recruitmentPage.getFirstName(firstName);


		        // Enter Middle Name
		        recruitmentPage.getMiddleName(middleName);


		        // Enter Last Name
		        recruitmentPage.getLastName(lastName);


		        // Select Vacancy
		        recruitmentPage.getVacancy(vacancy);


		        // Enter Email
		        recruitmentPage.getEmail(email);


		        // Enter Contact Number
		        recruitmentPage.getContactNumber(contactNumber);


		        // Upload Resume
		        recruitmentPage.getResume(resumePath);


		        // Date of Application
		        recruitmentPage.getDateOfApplication(dateOfApplication);


		        // Save
		        recruitmentPage.getSaveButton();


		        Thread.sleep(3000);


		        // =====================================================
		        // CANDIDATES PAGE
		        // =====================================================

		        recruitmentPage.getCandidates();


		        Thread.sleep(2000);


		        OrangeHRMCandidatesPage candidatesPage =
		                new OrangeHRMCandidatesPage(driver);


		        // Select Job Title
		        candidatesPage.getJobTitle(jobTitle);


		        // Select Vacancy
		        candidatesPage.getVacancy(searchVacancy);


		        // Select Hiring Manager
		        candidatesPage.getHiringManager(hiringManager);


		        // Select Status
		        candidatesPage.getStatus(status);


		        // Enter Candidate Name
		        candidatesPage.getCandidateName(candidateName);


		        // Select Application Date
		        candidatesPage.getApplicationDate(applicationDate);


		        // Click Search
		        candidatesPage.getSearchButton();


		        Thread.sleep(3000);


		        // =====================================================
		        // VERIFY RECORDS FOUND
		        // =====================================================

		        boolean result =
		                candidatesPage.verifyCandidate(candidateName);


		        if (result) {

		            System.out.println(
		                    "Candidate is added successfully and found in Records Found section."
		            );

		        } else {

		            System.out.println(
		                    "Candidate is NOT found in Records Found section."
		            );
		        }


		        
		        // LOGOUT
		        

		        homePage.getUserDropdown();

		        homePage.getLogout();


		        
		        // CLOSE
		       

		        wb.close();

		        excelFis.close();

		        propFis.close();

		        //driver.quit();
		        System.out.println("OrangeHRM Recruitment POM test completed.");
		    }
		

	}


