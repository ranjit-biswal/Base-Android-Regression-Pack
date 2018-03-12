
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction as TouchAction

String messageText = null
int x=0,y=0

//'Calling Login Page Test Case'
//Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//
'Delay of 50 seconds'
Mobile.delay(50)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)

//x = UsageMenu.getLocation().getX()
//y = UsageMenu.getLocation().getY()
TouchAction action = new TouchAction(driver)
//action.press(x, y).moveTo(x -290, y).release().perform()


//'Scrolling the Dashboard Screen'
//Mobile.swipe(220, 674, 235, 674, FailureHandling.CONTINUE_ON_FAILURE)


  'Checking Notifications Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
false) {
	System.out.println('Notifications is not displayed in the Dashboard/Landing Page' //   Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		//End of IF
		) //End of FOR
} else {
	'Clicking on Notifications Menu from Dashboard/Landing Page'
	Mobile.tap(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 15)

	'Delay'
	Mobile.delay(10)
	
	'Clicking on Notifications Menu'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 15)
	
	
	'Clicking on All Mail Menu'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 55)
	
	'Delay'
	Mobile.delay(10)
	
	'Deleting a Notification'
	'***********************************************************************************'
	
	'All Mails Count & List'

	ArrayList<MobileElement> lAllMailMessages = driver.findElementsByClassName('XCUIElementTypeCell')
	
	'Delay'
	Mobile.delay(10)
	
	println(lAllMailMessages.size())
	
	if(lAllMailMessages.size()>0)
	{

	'Clicking on First Notification'
	for (int index = 0; index < 1; index++) {
	
		lAllMailMessages.get(index).click()
		
		'Delay'
		Mobile.delay(30)
		
		}
	
	'Getting the Message Text in the String variable'
	String sFirstMessageText = Mobile.getAttribute(findTestObject('SCM Mobile/Notifications/First Message Text in All Tabs'),	'value', 15, FailureHandling.CONTINUE_ON_FAILURE)

	
	'Clicking on Trash Icon'
	
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Trash Icon'), 5)
	
	'Clicking on Yes Button to provide the confirmation on Deletion'
	
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Yes Button'), 10)
	
	'Delay'
	Mobile.delay(25)
	
	
	'Getting the Message Text in the String variable'
	String sMessageDeletionText = Mobile.getAttribute(findTestObject('SCM Mobile/Notifications/Message Deletion Text'),	'value', 15, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Message Sent Text is matching with the Expeced Text or Not'
	if (sMessageDeletionText.equals('Your message(s) has been deleted successfully.')) {
		System.out.println('Your message(s) has been deleted successfully.')
	} else {
		System.out.println('Message Deletion Text is not matching with the Expected Text, Expected Text is : Your message(s) has been deleted successfully. but Actual Text is ' +
			sMessageDeletionText)
	}
	
	'Clicking on the Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Ok Button'), 5)
	
	'Delay'
	Mobile.delay(25)
	
	
	'Clicking on Notifications Hamburger Menu'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 15)
	
	WebElement AllMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 20)
	
	x = UsageMenu.getLocation().getX()
	y = UsageMenu.getLocation().getY()
	action.press(x, y).moveTo(x, y-100).release().perform()
	
	
	'Clicking on Trash Tab'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Trash Tab'), 15)
	
	'Delay'
	Mobile.delay(40)
	
	'Trash Mails Count & List'
	ArrayList<MobileElement> lDeleteItems = driver.findElementsByClassName('XCUIElementTypeCell')
	
	'Delay'
	Mobile.delay(10)
	
	println(lDeleteItems.size())

	'Clicking on First Notification'
	for (int index = 0; index < 1; index++) {
	
		lDeleteItems.get(index).click()
		
		'Delay'
		Mobile.delay(20)
		
		}
	
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Notifications/First Message Text in All Tabs'),	'value', 15, FailureHandling.CONTINUE_ON_FAILURE)
	
	if(sFirstMessageText.equals(messageText))
	{
		println ('Message Deleted from the All Email found in the Trash Tab')
	}
	else
	{
		println('Message Deleted from the All Email not found in the Trash Tab')
	}
	
	
	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		
	'Delay'
	Mobile.delay(20)

	'Replying a Notification'
	'***********************************************************************************'
	
	'Clicking on Notifications Menu'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 15)
	
	'Clicking on All Mail Menu'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 55)
	
	'Delay'
	Mobile.delay(10)
	
	'Clicking on First Notification'
	for (int index = 0; index < 1; index++) {
	
		lAllMailMessages.get(index).click()
		
		'Delay'
		Mobile.delay(10)
		
		}
	
	'Clicking on Reply Icon'
	
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Reply Icon'), 25)
	
	'Entering Message Text '
	Mobile.setText(findTestObject('SCM Mobile/Notifications/Email Message Text'), 'This is for Internal Testing', 3)
	
	
	'Clicking on the Keyboard Ok Button'
     Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

	
	'Clicking on Send Button'
	
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Send Button'), 75)
	
	
	'Getting the Message Sent Text in the String variable'
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Notifications/Message Sent Text'),		'value', 15, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Message Sent Text is matching with the Expeced Text or Not'
	if (messageText.equals('Message sent successfully.')) {
		System.out.println('Message Sent Text is matching with the Expeced Text')
	} else {
		System.out.println('Message Sent Text is not matching with the Expected Text, Expected Text is : Message sent successfully. but Actual Text is ' +
			messageText)
	}
	
	'Clicking on the Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Ok Button'), 5)
	
	'Delay'
	Mobile.delay(25)
	
	
	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

	
	'Delay'
	Mobile.delay(25)
	
	'Clicking on Notifications Menu'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 15)
	
	
	'Clicking on Sent Mail Tab'
	Mobile.tap(findTestObject('SCM Mobile/Notifications/Sent Tab'), 15)
	
	'Delay'
	Mobile.delay(40)
	
	'Sent Mails Count & List'
	ArrayList<MobileElement> lSentItems = driver.findElementsByClassName('XCUIElementTypeCell')
	
	'Delay'
	Mobile.delay(10)
	
	println(lSentItems.size())

	'Clicking on First Notification'
	for (int index = 0; index < 1; index++) {
	
		lSentItems.get(index).click()
		
		'Delay'
		Mobile.delay(20)
		
		}
	
	String sMessageText = Mobile.getAttribute(findTestObject('SCM Mobile/Notifications/Message Text in Sent Message Tab'),
		'value', 15, FailureHandling.CONTINUE_ON_FAILURE)

	if(sMessageText.equals('This is for Internal Testing'))
	{
		println ('Message sent from the All Email found in the Sent Items')
	}
	else
	{
		println('Message sent from the All Email not found in the Sent Items')
	}
}
	else
	{
		println('There is no messages in the All Email to Reply/Delete')
	}
	
	
	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

	
	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

}


