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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

//'Installing/Launching the Application on the Device'
//Mobile.startApplication('E:\\app-debug.apk', false)

//'Calling Login Page Test Case'
//Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay of 50 seconds'
Mobile.delay(50)


'Scrolling  the Screen Downwards till Enroll Button'
Mobile.swipe(800, 1615, 400, 1615, FailureHandling.STOP_ON_FAILURE)

'Checking CompareMenu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Compare Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
false) {
	System.out.println('Compare is not displayed in the Dashboard/Landing Page' //   Mobile.pressBack()
		//End of IF
		) //End of FOR
	// End of FOR
	//End of FOR
} else {
	'Clicking on Compare Menu from Dashboard/Landing Page'
	Mobile.tap(findTestObject('SCM Mobile/LandingPage/Compare Menu'), 5)

	'Delay'
	Mobile.delay(10)
	
	'Compare Side Menu'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	ArrayList<MobileElement> ls = driver.findElementsByClassName('XCUIElementTypeStaticText')

	println(ls.size())

	for (int index = 0; index < ls.size(); index++) {
		if (ls.get(index).getText().equals('Power')) {
			'Veryfing Compare - Power'

			'Clicking on Power from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Power/Power Menu'), 45)
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/kWh Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power kWh unit is displayed')
				
				'Clicking on kWh Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Power/kWh Unit'),45)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Power - kWh - HighChart is displayed')
				}
				else
				{
					println ('Compare - Power - kWh - HighChart is not displayed')
				}
			}
			else
			{
				println ('Power kWh unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Power/Dollar Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Power - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Compare - Power - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Power Dollar unit is not displayed')
			}
			'Delay'
			Mobile.delay(10)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)
		} else if (ls.get(index).getText().equals('Water')) {
			'Veryfing Compare - Water'

			'Clicking on Water from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Water/Water Menu'), 25)

			'Delay'
			Mobile.delay(10)

			   if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Gal Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water Gal unit is displayed')
				
				'Clicking on Gal Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Water/Gal Unit'),25)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Water - Gal - HighChart is displayed')
				}
				else
				{
					println ('Compare - Water - Gal - HighChart is not displayed')
				}
			}
			else
			{
				println ('Water Gal unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Water/Dollar Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Water - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Compare - Water - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Water Dollar unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/HCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water HCF unit is displayed')
				
				'Clicking on HCF Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Water/HCF Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Water - HCF - HighChart is displayed')
				}
				else
				{
					println ('Compare - Water - HCF - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Water HCF unit is not displayed')
			}
			'Delay'
			Mobile.delay(10)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)
			
		} else if (ls.get(index).getText().equals('Gas')) {
			'Veryfing Compare - Gas'

			'Clicking on Gas from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Gas/Gas Menu'), 78)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Dollar Unit'), 10, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Gas Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Gas/Dollar Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Gas - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Compare - Gas - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Gas Dollar unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/CCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Gas CCF unit is displayed')
				
				'Clicking on CCF Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Gas/CCF Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Gas - CCF - HighChart is displayed')
				}
				else
				{
					println ('Compare - Gas - CCF - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Gas CCF unit is not displayed')
			}

			'Delay'
			Mobile.delay(10)

			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)
		}
	}
	
	'Delay'
	Mobile.delay(10)

	'Calling the Press Back Inbuilt funtion'
	Mobile.pressBack()
}

