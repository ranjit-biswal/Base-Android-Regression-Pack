import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import io.appium.java_client.TouchAction as TouchAction

String messageText = null

Boolean bResult = false

Boolean bResult1 = true

Integer iBeforeCarCount = 0

Integer iAfterCarCount = 0

String sCar = null

//'Calling Login Page Test Case'
//Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(50)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)

x = UsageMenu.getLocation().getX()

y = UsageMenu.getLocation().getY()

TouchAction action = new TouchAction(driver)

action.press(x, y).moveTo(x - 450, y).release().perform()

action.press(x, y).moveTo(x - 500, y).release().perform()

Mobile.delay(30)

'Checking EV Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/EV Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('EV is not displayed in the Dashboard/Landing Page')
} else {
    'Clicking on Billing Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/EV Menu'), 5)

    'Delay'
    Mobile.delay(10)

    ArrayList<MobileElement> ls = driver.findElementsByClassName('XCUIElementTypeStaticText')

    for (int index = 1; index < ls.size(); index++) {
        if (ls.get(index).getText().equals('Electric Vehicle')) {
            'Clicking on Electric Vehicle Side Menu'
            ls.get(index).click()

            'Delay'
            Mobile.delay(10)

			'Click on Select Car Link'
            ArrayList<MobileElement> lSelectCarBeforeEVUpdate = driver.findElementsByClassName('XCUIElementTypeCell')

            for (int index1 = 0; index1 < 1; index1++) {
                lSelectCarBeforeEVUpdate.get(index1).findElementByClassName('XCUIElementTypeStaticText').click()
            }
            
			'Car List Before EV Update'
			ArrayList<MobileElement> lCarListBeforeEVUpdate = driver.findElementsByClassName('XCUIElementTypeCell')
			
			'Car Count Before EV Update'
			iBeforeCarCount = lCarListBeforeEVUpdate.size()
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Clicking on Add Button'
            Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/Add Button'), 6)

            'Selecting/Unselecting the Car from the Car List'
            ArrayList<MobileElement> lCarList = driver.findElementsByClassName('XCUIElementTypeCell')

            println(lCarList.size())

            for (int index2 = 0; index2 < 1; index2++) {
      
                sCar = lCarList.get(index2).findElementByClassName('XCUIElementTypeStaticText').getText()
                lCarList.get(index2).click()
            }
            
            'Clicking on Save Button'
            Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/Save Button'), 6)

            'Delay'
            Mobile.delay(20)

            'Getting Message Text after click on Save'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Electric Vehicle/EV/EV Setting Save Text'), 'value', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Verifying EV Setting is Successfully Saved or Not'
            if (messageText.equals(null)) {
                System.out.println('Something went wrong with EV page Updation, Please check manually')
            } else {
                if (messageText.equals('Your settings have been saved successfully.')) {
                    System.out.println('Your EV settings have been saved successfully.')
                } else {
                    System.out.println('Your EV settings have been saved successfully. Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' + 
                        messageText)
                }
            }
            
            'Clicking on the Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/EV Setting Save Popup Ok Button'), 30)

			'Delay'
			Mobile.delay(20)
			
            'Checking Selected/UnSelected Car in the Car List DropDown'

            'Clicking on Electric Vehicle Side Menu'
            Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/EV Side Menu'), 30)

            'Delay'
            Mobile.delay(20)

			'Click on Select Car Link'
            ArrayList<MobileElement> lSelectCarAfterEVUpdate = driver.findElementsByClassName('XCUIElementTypeCell')

            for (int index3 = 0; index3 < 1; index3++) {
                lSelectCarAfterEVUpdate.get(index3).findElementByClassName('XCUIElementTypeStaticText').click()
            }
            
			'Car List After EV Update'
			ArrayList<MobileElement> lCarListAfterEVUpdate = driver.findElementsByClassName('XCUIElementTypeCell')
			
			'Car Count After EV Update'
			iAfterCarCount = lCarListAfterEVUpdate.size()
			
			if(iBeforeCarCount > iAfterCarCount)
			{
				for (int index4 = 0; index4 < lCarListAfterEVUpdate.size(); index4++) {
					if (lCarListAfterEVUpdate.get(index4).findElementByClassName('XCUIElementTypeStaticText').getText().equals(sCar)) {
						bResult1 = false
						}
					else
					{
						bResult1 = true
					}
				}
			}
			else if(iBeforeCarCount < iAfterCarCount)
			{
				for (int index4 = 0; index4 < lCarListAfterEVUpdate.size(); index4++) {
					if (lCarListAfterEVUpdate.get(index4).findElementByClassName('XCUIElementTypeStaticText').getText().equals(sCar)) {
						bResult1 = true
						break
					}
				}
			}
			else
			{
				println('SomeThing is wrong, Please check EV car Add functionality manually')
				
			}
       
            if (bResult1 == true) {
                println('Car Selected from the Add Menu is displayed in the Car List DropDown OR Car UnSelected from the Add Menu is not displayed in the Car List DropDown')
            } else {
                println('SomeThing is wrong, Please check EV car Add functionality manually')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (ls.get(index).getText().equals('Charging Stationq')) {
            'Veryfing EV - Electric Vehicle'
            ls.get(index).click()

            'Delay'
            Mobile.delay(10)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        }
    }
    
    'Delay'
    Mobile.delay(10)

    'Calling the Press Back Inbuilt funtion'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
}


'Installing the Application on the Device'
Mobile.closeApplication()
