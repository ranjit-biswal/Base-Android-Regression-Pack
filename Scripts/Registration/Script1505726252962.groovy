import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null
import java.util.logging.Logger as Logger
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
//

'Installing the Application on the Device'
Mobile.startApplication('//Users//sus//Desktop//SCM iOS Build//SCM_DEV_Sept5.ipa', false)

'Delay of 30 Sec'
Mobile.delay(30)


'Delay of 20sec'
Mobile.delay(20)

'Clicking on Register Now Button'
Mobile.tap(findTestObject('SCM Mobile/Registration/Register Now Button'), 10)

'Delay of 10 sec'
Mobile.delay(10)

'Getting Account Type from the DataBase'
String sCustomerTypeQuery = ";WITH UnRegisteredCustomer AS (SELECT c.CustomerID, U.MobilePhone,(CASE WHEN CA.AddressType = 1 THEN 'Residential' ELSE 'Commercial' END) AS AddressType, MAX(CA.UtilityAccountNumber) AS UtilityAccountNumber FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID = ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID = a.AddressID JOIN UserAccount UA(NOLOCK) ON a.UtilityAccountNumber = UA.UtilityAccountNumber JOIN [User] U(NOLOCK) ON UA.UserID = U.UserID WHERE a.STATUS = 3 AND c.CustomerID NOT IN (1,- 1) GROUP BY c.CustomerID, U.MobilePhone,(CASE WHEN CA.AddressType = 1	THEN 'Residential' ELSE 'Commercial' END)) SELECT TOP 1 R.AddressType FROM CustomerAddress CA(NOLOCK) JOIN UnRegisteredCustomer R(NOLOCK) ON CA.UtilityAccountNumber = R.UtilityAccountNumber AND CA.CustomerID = R.CustomerID"

String sCustomerType = database.DataBaseUtil.executeSQLQuery(sCustomerTypeQuery)

System.out.println(sCustomerType)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

ArrayList<MobileElement> lRadioButtons = driver.findElementsByClassName('XCUIElementTypeStaticText')

println(lRadioButtons.size())

'Delay of 20 seconds'
Mobile.delay(20)

for (int index = 0; index < lRadioButtons.size(); index++) {
    if (lRadioButtons.get(index).getText().equals(sCustomerType)) {
        lRadioButtons.get(index).click()

        'Delay of 20 seconds'
        Mobile.delay(20)

        'Clicking on Next Button'
        Mobile.tap(findTestObject('SCM Mobile/Registration/Next Button'), 10)

        'Delay of 20 seconds'
        Mobile.delay(20)

        break
    } 
}//End of FOR

'Getting Account Number from the DataBase'
String sAccountNumberQuery = "WITH UnRegisteredCustomer AS (SELECT c.CustomerID, U.MobilePhone,(CASE WHEN CA.AddressType = 1 THEN 'Residential' ELSE 'Commercial' END) AS AddressType, MAX(CA.UtilityAccountNumber) AS UtilityAccountNumber FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID = ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID = a.AddressID JOIN UserAccount UA(NOLOCK) ON a.UtilityAccountNumber = UA.UtilityAccountNumber JOIN [User] U(NOLOCK) ON UA.UserID = U.UserID WHERE a.STATUS = 3 AND c.CustomerID NOT IN (1,- 1)	GROUP BY c.CustomerID, U.MobilePhone,(CASE 	WHEN CA.AddressType = 1	THEN 'Residential' ELSE 'Commercial' END)) SELECT TOP 1 CA.UtilityAccountNumber FROM CustomerAddress CA(NOLOCK) JOIN UnRegisteredCustomer R(NOLOCK) ON CA.UtilityAccountNumber = R.UtilityAccountNumber AND CA.CustomerID = R.CustomerID"

String sNewAccountNumber = database.DataBaseUtil.executeSQLQuery(sAccountNumberQuery)
System.out.println(sNewAccountNumber);


'Entering the Account Number'
Mobile.setText(findTestObject('SCM Mobile/Registration/Account Number TextBox'), sNewAccountNumber, 4)

'Delay of 5 seconds'
Mobile.delay(5)

'Getting Random Number'
int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, 50000);

'Entering the Email Address'
Mobile.setText(findTestObject('SCM Mobile/Registration/Email Address TextBox'), "sahil.dheer" + randomnumber + "@smartusys.com", 4)
String sUserEmail = "sahil.dheer" + randomnumber + "@smartusys.com";

'Delay of 5 seconds'
Mobile.delay(5)

'Entering the UserName'
Mobile.setText(findTestObject('SCM Mobile/Registration/UserName TextBox'), "sahil.dheer" + randomnumber, 4)
String sUserName = "sahil.dheer" + randomnumber;

'Delay of 5 seconds'
Mobile.delay(5)

'Clicking on the Keyboard Ok Button'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

'Entering the Password'
Mobile.setText(findTestObject('SCM Mobile/Registration/Password TextBox'), "Demo@123" , 4)

'Delay of 5 seconds'
Mobile.delay(5)

'Clicking on the Keyboard Ok Button'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)


'Delay of 3 seconds'
Mobile.delay(3)

'Entering the Confirm Password'
Mobile.setText(findTestObject('SCM Mobile/Registration/Confirm Password TextBox'), "Demo@123" , 4)

'Delay of 5 seconds'
Mobile.delay(5)

'Clicking on the Keyboard Ok Button'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

'Delay of 3 seconds'
Mobile.delay(3)

'Getting ZipCode from the DataBase'
String sAccountZipCodeQuery = "WITH UnRegisteredCustomer AS (SELECT c.CustomerID, U.MobilePhone,(CASE WHEN CA.AddressType = 1 THEN 'Residential' ELSE 'Commercial' END) AS AddressType, MAX(CA.UtilityAccountNumber) AS UtilityAccountNumber FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID = ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID = a.AddressID JOIN UserAccount UA(NOLOCK) ON a.UtilityAccountNumber = UA.UtilityAccountNumber JOIN [User] U(NOLOCK) ON UA.UserID = U.UserID WHERE a.STATUS = 3 AND c.CustomerID NOT IN (1,- 1)	GROUP BY c.CustomerID, U.MobilePhone,(CASE 	WHEN CA.AddressType = 1	THEN 'Residential' ELSE 'Commercial' END)) SELECT TOP 1 CA.ZipCode FROM CustomerAddress CA(NOLOCK) JOIN UnRegisteredCustomer R(NOLOCK) ON CA.UtilityAccountNumber = R.UtilityAccountNumber AND CA.CustomerID = R.CustomerID"

String sAccountZipCode = database.DataBaseUtil.executeSQLQuery(sAccountZipCodeQuery);
System.out.println(sAccountZipCode);

'Entering the ZipCode'
Mobile.setText(findTestObject('SCM Mobile/Registration/ZipCode TextBox'), sAccountZipCode , 4)

'Delay of 5 seconds'
Mobile.delay(5)

'Clicking on the Keyboard Ok Button'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

'Delay of 3 seconds'
Mobile.delay(3)

'Clicking on Security Question1 DropDown'
Mobile.tap(findTestObject('SCM Mobile/Registration/DropDown SecurityQuestion1'), 10)

'Delay of 2 seconds'
Mobile.delay(2)


ArrayList<MobileElement> lQuestionList = driver.findElementsByClassName('XCUIElementTypeStaticText')

println(lQuestionList.size())

'Delay of 20 seconds'
Mobile.delay(20)

for (int index1 = 1; index1 < 2; index1++) {
	
		lQuestionList.get(index1).click()
		
		'Delay of 5 seconds'
		Mobile.delay(5)


	}//End of FOR


'Entering the Security Answer1'
Mobile.setText(findTestObject('SCM Mobile/Registration/SecurityAnswer1 TextBox'), "1234" , 4)

'Clicking on the Keyboard Ok Button'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

'Delay of 2 seconds'
Mobile.delay(2)

'Clicking on Security Question2 DropDown'
Mobile.tap(findTestObject('SCM Mobile/Registration/DropDown SecurityQuestion2'), 10)

'Delay of 2 seconds'
Mobile.delay(2)

for (int index1 = 2; index1 < 3; index1++) {
	
		lQuestionList.get(index1).click()
		
		'Delay of 5 seconds'
		Mobile.delay(5)

	}//End of FOR

'Entering the Security Answer2'
Mobile.setText(findTestObject('SCM Mobile/Registration/SecurityAnswer2 TextBox'), "1234" , 4)

'Delay of 2 seconds'
Mobile.delay(2)

'Clicking on the Keyboard Ok Button'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)


'Clicking on I Agree Checkbox'
Mobile.checkElement(findTestObject('SCM Mobile/Registration/I Agree CheckBox'), 10)

'Delay of 2 seconds'
Mobile.delay(2)

'Getting the Customer ID'
String sCustomerIdQuery = "WITH UnRegisteredCustomer AS (SELECT c.CustomerID, U.MobilePhone,(CASE WHEN CA.AddressType = 1 THEN 'Residential' ELSE 'Commercial' END) AS AddressType, MAX(CA.UtilityAccountNumber) AS UtilityAccountNumber FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID = ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID = a.AddressID JOIN UserAccount UA(NOLOCK) ON a.UtilityAccountNumber = UA.UtilityAccountNumber JOIN [User] U(NOLOCK) ON UA.UserID = U.UserID WHERE a.STATUS = 3 AND c.CustomerID NOT IN (1,- 1)	GROUP BY c.CustomerID, U.MobilePhone,(CASE 	WHEN CA.AddressType = 1	THEN 'Residential' ELSE 'Commercial' END)) SELECT TOP 1 CA.CustomerID FROM CustomerAddress CA(NOLOCK) JOIN UnRegisteredCustomer R(NOLOCK) ON CA.UtilityAccountNumber = R.UtilityAccountNumber AND CA.CustomerID = R.CustomerID"
String sCustomerId = database.DataBaseUtil.executeSQLQuery(sCustomerIdQuery);
System.out.println(sCustomerId);

'Clicking on Register Button'
Mobile.tap(findTestObject('SCM Mobile/Registration/Register Button'), 10)

'Delay of 40 seconds'
Mobile.delay(40)

//if (driver.switchTo().alert().getText().equalsIgnoreCase(
//"A link with instructions on how to complete registration has been sent to the customer’s registered Email Address.")) {
//bResult = true;
//Log.info("Customer Account Created, Customer Email Id is : " + sUserEmail + ". "
//	+ "Customer account password is : " + CSRWorkBenchAdmin.getProperty("customerpassword"));
//sComment = "Customer Account Created, Customer Email Id is : " + sUserEmail + ". "
//	+ "Customer account password is : " + CSRWorkBenchAdmin.getProperty("customerpassword");
//ResultUpdate.updateResult(sCurrURL, sModule, sSection, bResult, sComment, iPriority);
//
//} else {
//bResult = false;
//Log.info("Customer account has been created successfully.");
//sComment = "Customer Account Created, Customer Email Id is : " + sUserEmail + ". "
//	+ "Customer account password is : " + CSRWorkBenchAdmin.getProperty("customerpassword")
//	+ " but alert text mismatched, alert text is : " + driver.switchTo().alert().getText();
//ResultUpdate.updateResult(sCurrURL, sModule, sSection, bResult, sComment, iPriority);
//}
//
//driver.switchTo().alert().accept();
//Thread.sleep(2000);
//
//// Activating Customer
//int iCustomerId = Integer.parseInt(sCustomerId);
//int s1 = DataBaseUtil.callStoredProcedure("QA", iCustomerId);
//System.out.println(s1);
//
////	bResult2 = true;
////fCustomerPasswordChange(driver);
////	Thread.sleep(2000);
//
//sSection = sSection1 + " - " + " New Customer Tries to Login on Customer Portal  ";
//iPriority = 2;
//bResult = true;
//
//driver.get(CSRWorkBenchAdmin.getProperty("CustomerPortalURL"));
//Thread.sleep(1500);
//
//// CommonFunctions.highLightElement(driver,
//// SCMBase.fMyAccount(driver));
//// SCMBase.fMyAccount(driver).click();
//Thread.sleep(3000);
//Log.info("****New User Tries to Login***");
//
//CommonFunctions.highLightElement(driver, SCMBase.fUserId(driver));
//SCMBase.fUserId(driver).sendKeys(sUserName);
//Thread.sleep(2000);
//
//CommonFunctions.highLightElement(driver, SCMBase.fPassword(driver));
//SCMBase.fPassword(driver).sendKeys(CSRWorkBenchAdmin.getProperty("customerpassword"));
//Thread.sleep(2000);
//
//CommonFunctions.highLightElement(driver, SCMBase.fSignIn(driver));
//SCMBase.fSignIn(driver).click();
//Thread.sleep(6000);
//
//try {
//if (SCMBase.fAboutMyHomeTitle(driver).getText().equals("About My Home")) {
//bResult = true;
//driver.switchTo().activeElement();
//driver.findElement(By.cssSelector(".modal-lg .modal-header .close")).click();
//Thread.sleep(2000);
//Log.info("Customer added by Admin, able to login on the Customer Portal");
//sComment = "Customer added by Admin, able to to login on the Customer Portal";
//ResultUpdate.updateResult(sCurrURL, sModule, sSection, bResult, sComment, iPriority);
//
//// CommonFunctions.highLightElement(driver,
//// CSR_WORKBENCH.fCustomerSignOutDropDown(driver));
//// CSR_WORKBENCH.fCustomerSignOutDropDown(driver).click();
//// Thread.sleep(2000);
//
//CommonFunctions.highLightElement(driver, CSR_WORKBENCH.fCustomerSignOut(driver));
//CSR_WORKBENCH.fCustomerSignOut(driver).click();
//Thread.sleep(2000);
//Log.info("Customer Sign Out from the Utility");
//}
//
//else if (SCMBase.fAboutMyBusinessTitle(driver).getText().equals("About My Business")) {
//bResult = true;
//driver.switchTo().activeElement();
//driver.findElement(By.cssSelector(".modal-lg .modal-header .close")).click();
//Thread.sleep(2000);
//Log.info("Customer added by Admin, able to login on the Customer Portal");
//sComment = "Customer added by Admin, able to to login on the Customer Portal";
//ResultUpdate.updateResult(sCurrURL, sModule, sSection, bResult, sComment, iPriority);
////
////					CommonFunctions.highLightElement(driver, CSR_WORKBENCH.fCustomerSignOutDropDown(driver));
////					CSR_WORKBENCH.fCustomerSignOutDropDown(driver).click();
////					Thread.sleep(2000);
//
//CommonFunctions.highLightElement(driver, CSR_WORKBENCH.fCustomerSignOut(driver));
//CSR_WORKBENCH.fCustomerSignOut(driver).click();
//Thread.sleep(2000);
//Log.info("Customer Sign Out from the Utility");
//}
//
//else {
//bResult = false;
//Log.info("Something went wrong during New Customer Login on customer portal");
//Thread.sleep(2000);
//sComment = "Something went wrong during New Customer Login on customer portal";
//ResultUpdate.updateResult(sCurrURL, sModule, sSection, bResult, sComment, iPriority);
//}
//
//} catch (Exception e) {
//e.printStackTrace();
//Assert.fail(e.getMessage());
//bResult = false;
//sComment = e.getMessage();
//ResultUpdate.updateResult(sCurrURL, sModule, sSection, bResult, sComment, iPriority);
//}
