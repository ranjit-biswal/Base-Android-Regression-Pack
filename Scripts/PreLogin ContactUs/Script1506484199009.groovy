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

'Installing the Application on the Device'
Mobile.startApplication(GlobalVariable.sApplicationPath, false, FailureHandling.STOP_ON_FAILURE)

'Delay of 30 Sec'
Mobile.delay(30)

'Clicking on PreLogin ContactUs'
Mobile.tap(findTestObject('SCM Mobile/PreLogin ContactUs/PreLogin ContactUs Menu'), 5)

'Delay of 5 seconds'
Mobile.delay(5)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

ArrayList<MobileElement> lContactUsSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')

println(lContactUsSideMenu.size())

'Delay of 20 seconds'
Mobile.delay(20)

for (int index = 0; index < lContactUsSideMenu.size(); index++) {
    if (lContactUsSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Contact Us')) {
        lContactUsSideMenu.get(index).click()

        'Delay of 20 Sec'
        Mobile.delay(20)

        System.out.println('Connect Me Tab displayed')

        'Calling the Press Back Inbuilt funtion'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

        'Delay'
        Mobile.delay(10) 
		
    } else if (lContactUsSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Service Turn On/Off')) {
        lContactUsSideMenu.get(index).click()

        'Delay of 20 Sec'
        Mobile.delay(20)

        System.out.println('Services Tab displayed')

        'Calling the Press Back Inbuilt funtion'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

        'Delay'
        Mobile.delay(10)
    } else if (lContactUsSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Report Water Waste')) {
        lContactUsSideMenu.get(index).click()

        'Delay of 20 Sec'
        Mobile.delay(20)

        'Getting Message Text of the Module'
        messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin ContactUs/Report Water Waste Module Heading'), 
            'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Verifying Report Water Waste Module Name'
        if (messageText.equals(null)) {
            System.out.println('Something went wrong with Report Water Waste Link')
        } else {
            if (messageText.equals('Connect Me')) {
                System.out.println('On Click on the Report Water Waste Link user is routing to the Connect Me Page')

                'Verifying Connect Me Page Topic Name'
                String sTopicName = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin ContactUs/Report Water Waste Module Heading'), 
                    'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

                if (sTopicName.equals('Report Water Waste')) {
                    System.out.println('Connect Me page default topic is Report Water Waste')
                } else {
                    System.out.println('Connect Me page default topic is not Report Water Waste. Actual Title is : ' + sTopicName)
                }
            } else {
                System.out.println('On Click on the Report Water Waste Link user is routing to the Connect Me Page. Expected Text is : "Connect Me" but Actual Text is ' + 
                    messageText)
            }
        }
        
        'Calling the Press Back Inbuilt funtion'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

        'Delay'
        Mobile.delay(10)
    } else if (lContactUsSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Payment Locations')) {
        lContactUsSideMenu.get(index).click()

        'Delay of 20 Sec'
        Mobile.delay(20)

        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin ContactUs/Payment Location Popup - If payment location is not available'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        true) {
            System.out.println('There is no poyment location for the zipcode selected')
			
			'Clicking on the Popup Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
	
			'Delay'
			Mobile.delay(10)
        }
		
		
        
        'Calling the Press Back Inbuilt funtion'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

        'Delay'
        Mobile.delay(10)
    }
}

'Calling the Press Back Inbuilt funtion'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

'Delay'
Mobile.delay(10)