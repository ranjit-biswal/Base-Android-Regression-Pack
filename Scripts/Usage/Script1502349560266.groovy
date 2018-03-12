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

String messageText = null

'Calling Login Page Test Case'
Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(50)

'Checking Usage Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Usage is not displayed in the Dashboard/Landing Page' //   Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

        //End of IF
        ) //End of FOR
} else {
    'Clicking on Usage Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 5)

    'Delay'
    Mobile.delay(10)

	'Usage Side Menu'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    ArrayList<MobileElement> lUsageSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')

    println('Size of Usage Side Menu :' + lUsageSideMenu.size())

    'Printing Usage Side Menu List'
    println('Usage Side Menu List Contains :')

    for (int index = 0; index < lUsageSideMenu.size(); index++) {
        println(lUsageSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())

        'Delay of 1 seconds'
        Mobile.delay(1)
    }
    
    for (int index = 0; index < lUsageSideMenu.size(); index++) {

        if (lUsageSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Power')) {
            'Veryfing Usage - Power'

            'Clicking on Power from Usage Menu'
           lUsageSideMenu.get(index).click()
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Power/kWh Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power kWh unit is displayed')
				
				'Clicking on kWh Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Power/kWh Unit'),15)
				
//				'Clicking on DataDivision DropDown'
//				Mobile.tap(findTestObject('SCM Mobile/Usage/Common/DataDivisionDropDown'),5)
//				
//				'Delay'
//				Mobile.delay(2)
//							
//				'Getting DataDivision in a List'
//				ArrayList<MobileElement> lDataDivision = driver.findElementsByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTable[1]/XCUIElementTypeCell')
//				
//				println (lDataDivision.size())
//				
//				if(lDataDivision.size()>0)
//				{
//					for(int index1=0;index1<lDataDivision.size();index1++)
//					{
//						if(lDataDivision.get(index1).findElementByXPath('XCUIElementTypeStaticText[1]').getText().equals("Monthly"))
//						{
//							lDataDivision.get(index1).click()
//							
//							Mobile.delay(10)
//						}
//					}
//				}
//				else
//				{
//					
//				}
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Power/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Power - kWh - HighChart is displayed')
				}
				else
				{
					println ('Usage - Power - kWh - HighChart is not displayed')
				}
			}
			else
			{
				println ('Power kWh unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Power/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Power/Dollar Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Power/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Power - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Usage - Power - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Power Dollar unit is not displayed')
			}
			'Delay'
			Mobile.delay(10)
			
            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


            'Delay'
            Mobile.delay(30)
        } else if (lUsageSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Water')) {
            'Veryfing Usage - Water'

            'Clicking on Water from Usage Menu'
            lUsageSideMenu.get(index).click()
			
            'Delay'
            Mobile.delay(10)

           	if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Gal Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water Gal unit is displayed')
				
				'Clicking on Gal Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Water/Gal Unit'),25)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Water - Gal - HighChart is displayed')
				}
				else
				{
					println ('Usage - Water - Gal - HighChart is not displayed')
				}
			}
			else
			{
				println ('Water Gal unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Water/Dollar Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Water - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Usage - Water - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Water Dollar unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/HCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water HCF unit is displayed')
				
				'Clicking on HCF Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Water/HCF Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Water - HCF - HighChart is displayed')
				}
				else
				{
					println ('Usage - Water - HCF - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Water HCF unit is not displayed')
			}
			'Delay'
			Mobile.delay(10)
			
            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


            'Delay'
            Mobile.delay(30)
			
        } else if (lUsageSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Solar')) {
            'Veryfing Usage - Solar'

            'Clicking on Solar from Usage Menu'
            lUsageSideMenu.get(index).click()
		   
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Solar/Dollar Unit'), 15, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Solar Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Solar/Dollar Unit'),23)
				
				'Delay'
				Mobile.delay(30)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Solar/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Solar - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Usage - Solar - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Solar Dollar unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Solar/kWh Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Solar kWh unit is displayed')
				
				'Clicking on kWh Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Solar/kWh Unit'),23)
				
				'Delay'
				Mobile.delay(30)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Solar/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Solar - kWh - HighChart is displayed')
				}
				else
				{
					println ('Usage - Solar - kWh - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Solar kWh unit is not displayed')
			}
            'Delay'
            Mobile.delay(10)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


            'Delay'
            Mobile.delay(30)
        } else if (lUsageSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Gas')) {
            'Veryfing Usage - Gas'

            'Clicking on Gas from Usage Menu'
            lUsageSideMenu.get(index).click()
						
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Gas/Dollar Unit'), 10, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Gas Dollar unit is displayed')
				
				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Gas/Dollar Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Gas/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Gas - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Usage - Gas - Dollar - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Gas Dollar unit is not displayed')
			}
			
			'Delay'
			Mobile.delay(10)
			
			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Gas/CCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Gas CCF unit is displayed')
				
				'Clicking on CCF Unit'
				Mobile.tap(findTestObject('SCM Mobile/Usage/Gas/CCF Unit'),23)
				
				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Gas/Usage HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Usage - Gas - CCF - HighChart is displayed')
				}
				else
				{
					println ('Usage - Gas - CCF - HighChart is not displayed')
				}
				
			}
			else
			{
				println ('Gas CCF unit is not displayed')
			}

            'Delay'
            Mobile.delay(10)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


            'Delay'
            Mobile.delay(30)
        }
    }
    
    'Delay'
    Mobile.delay(10)

    'Calling the Press Back Inbuilt funtion'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

}