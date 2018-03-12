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

'Calling Login Page Test Case'
Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Delay of 50 seconds'
Mobile.delay(50)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

//WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)
//
//x = UsageMenu.getLocation().getX()
//y = UsageMenu.getLocation().getY()
//TouchAction action = new TouchAction(driver)
//action.press(x, y).moveTo(x -590, y).release().perform()

'Checking Efficiency Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Efficiency Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Efficiency is not displayed in the Dashboard/Landing Page')
} else {
    'Clicking on Efficiency Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/Efficiency Menu'), 10)

	'Delay of 20 seconds'
	Mobile.delay(20)
	


	ArrayList<MobileElement> lEfficiencySideMenu = driver.findElementsByClassName('XCUIElementTypeCell')

    println('Size of Billing Side Menu :' + lEfficiencySideMenu.size())

    'Printing Billing Side Menu List'
    println('Billing Side Menu List Contains :')

    for (int index = 0; index < lEfficiencySideMenu.size(); index++) {
        println(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())

        'Delay of 1 seconds'
        Mobile.delay(1)
    }
    
    for (int index = 0; index < lEfficiencySideMenu.size(); index++) {
        if (lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Rebates1')) {
     	
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
			
			println("Rebates Tip Count " + lTipsCount.size())
			
			for(int index1=0;index1<1;index1++)
			{
				lTipsCount.get(index1).click()
				
				'Delay of 20 seconds'
				Mobile.delay(20)
				
				String sViewCountBeforeClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountBeforeClick)
				
				String sLikeCountBeforeCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountBeforeCLick)
				
				String[] s2 = sViewCountBeforeClick.split("\\s")
				println (s2)
				
				String s3 =s2[1]
				
				int iViewCountBeforeClick =Integer.parseInt(s3)
				int iLikeCountBeforeCLick =Integer.parseInt(sLikeCountBeforeCLick)
				
				
				'Clicking on Like Button'
				Mobile.tap(findTestObject('SCM Mobile/Efficiency/Rebates/Like Icon'), 10)

				'Delay of 10 seconds'
				Mobile.delay(10)
			
				String sLikeCountAfterCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountAfterCLick)
				
				
				int iLikeCountAfterCLick =Integer.parseInt(sLikeCountAfterCLick)
				
				'Calling the Press Back Inbuilt funtion'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

	
				'Delay'
				Mobile.delay(10)
				
				lTipsCount.get(index1).click()
				
				'Delay of 20 seconds'
				Mobile.delay(20)
					
				String sViewCountAfterClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountAfterClick)
			
				String[] s4 = sViewCountAfterClick.split("\\s")
				println (s4)
				
				String s5 =s4[1]
				int iViewCountAfterClick =Integer.parseInt(s5)
				
				if(iViewCountAfterClick ==iViewCountBeforeClick +1 )
				{
					println ("On Click on the Tip, Count Increased by 1 ")
				}
				else
				{
					println ("On Click on the Tip, Count mismatched please check manually ")
				}
				
				if(iLikeCountAfterCLick >  iLikeCountBeforeCLick)
				{
					println ("Like Button Clicked and Verified ")
				}
				else if(iLikeCountAfterCLick <  iLikeCountBeforeCLick)
				{
					println ("UnLike Button Clicked and Verified ")
				}
				else
				{
					println ("On Click on the Like/UnLike, Count mismatched please check manually")
				}

			}
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

        }
		else if(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Programs')) {
			
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
			
			println("Programs Tip Count " + lTipsCount.size())
			
			for(int index1=0;index1<1;index1++)
			{
				lTipsCount.get(index1).click()
				
				'Delay of 30 seconds'
				Mobile.delay(30)
				
				String sViewCountBeforeClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountBeforeClick)
				
				String sLikeCountBeforeCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountBeforeCLick)
				
				String[] s2 = sViewCountBeforeClick.split("\\s")
				println (s2)
				
				String s3 =s2[1]
				
				int iViewCountBeforeClick =Integer.parseInt(s3)
				int iLikeCountBeforeCLick =Integer.parseInt(sLikeCountBeforeCLick)
				
				
				'Clicking on Like Button'
				Mobile.tap(findTestObject('SCM Mobile/Efficiency/Rebates/Like Icon'), 10)

				'Delay of 10 seconds'
				Mobile.delay(10)
			
				String sLikeCountAfterCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountAfterCLick)
				
				
				int iLikeCountAfterCLick =Integer.parseInt(sLikeCountAfterCLick)
				
				'Calling the Press Back Inbuilt funtion'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

	
				'Delay'
				Mobile.delay(10)
				
				lTipsCount.get(index1).click()
				
				'Delay of 20 seconds'
				Mobile.delay(20)
					
				String sViewCountAfterClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountAfterClick)
			
				String[] s4 = sViewCountAfterClick.split("\\s")
				println (s4)
				
				String s5 =s4[1]
				int iViewCountAfterClick =Integer.parseInt(s5)
				
				if(iViewCountAfterClick ==iViewCountBeforeClick +1 )
				{
					println ("On Click on the Tip, Count Increased by 1 ")
				}
				else
				{
					println ("On Click on the Tip, Count mismatched please check manually ")
				}
				
				if(iLikeCountAfterCLick >  iLikeCountBeforeCLick)
				{
					println ("Like Button Clicked and Verified ")
				}
				else if(iLikeCountAfterCLick <  iLikeCountBeforeCLick)
				{
					println ("UnLike Button Clicked and Verified ")
				}
				else
				{
					println ("On Click on the Like/UnLike, Count mismatched please check manually")
				}

			}
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

        }
		else if(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Saving Tips')) {
			
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
			
			println("Savings Tip Count " + lTipsCount.size())
			
			for(int index1=0;index1<1;index1++)
			{
				lTipsCount.get(index1).click()
				
				'Delay of 40 seconds'
				Mobile.delay(40)
				
				String sViewCountBeforeClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountBeforeClick)
				
				String sLikeCountBeforeCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountBeforeCLick)
				
				String[] s2 = sViewCountBeforeClick.split("\\s")
				println (s2)
				
				String s3 =s2[1]
				
				int iViewCountBeforeClick =Integer.parseInt(s3)
				int iLikeCountBeforeCLick =Integer.parseInt(sLikeCountBeforeCLick)
				
				
				'Clicking on Like Button'
				Mobile.tap(findTestObject('SCM Mobile/Efficiency/Rebates/Like Icon'), 10)

				'Delay of 10 seconds'
				Mobile.delay(10)
			
				String sLikeCountAfterCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountAfterCLick)
				
				
				int iLikeCountAfterCLick =Integer.parseInt(sLikeCountAfterCLick)
				
				'Calling the Press Back Inbuilt funtion'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

	
				'Delay'
				Mobile.delay(10)
				
				lTipsCount.get(index1).click()
				
				'Delay of 20 seconds'
				Mobile.delay(20)
					
				String sViewCountAfterClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountAfterClick)
			
				String[] s4 = sViewCountAfterClick.split("\\s")
				println (s4)
				
				String s5 =s4[1]
				int iViewCountAfterClick =Integer.parseInt(s5)
				
				if(iViewCountAfterClick ==iViewCountBeforeClick +1 )
				{
					println ("On Click on the Tip, Count Increased by 1 ")
				}
				else
				{
					println ("On Click on the Tip, Count mismatched please check manually ")
				}
				
				if(iLikeCountAfterCLick >  iLikeCountBeforeCLick)
				{
					println ("Like Button Clicked and Verified ")
				}
				else if(iLikeCountAfterCLick <  iLikeCountBeforeCLick)
				{
					println ("UnLike Button Clicked and Verified ")
				}
				else
				{
					println ("On Click on the Like/UnLike, Count mismatched please check manually")
				}

			}
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
		else if(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Educational Tips')) {
			
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
			
			println("Educational Tip Count " + lTipsCount.size())
			
			for(int index1=0;index1<1;index1++)
			{
				lTipsCount.get(index1).click()
				
				'Delay of 40 seconds'
				Mobile.delay(40)
				
				String sViewCountBeforeClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountBeforeClick)
				
				String sLikeCountBeforeCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountBeforeCLick)
				
				String[] s2 = sViewCountBeforeClick.split("\\s")
				println (s2)
				
				String s3 =s2[1]
				
				int iViewCountBeforeClick =Integer.parseInt(s3)
				int iLikeCountBeforeCLick =Integer.parseInt(sLikeCountBeforeCLick)
				
				
				'Clicking on Like Button'
				Mobile.tap(findTestObject('SCM Mobile/Efficiency/Rebates/Like Icon'), 10)

				'Delay of 10 seconds'
				Mobile.delay(10)
			
				String sLikeCountAfterCLick =driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]").getText()
				println (sLikeCountAfterCLick)
				
				
				int iLikeCountAfterCLick =Integer.parseInt(sLikeCountAfterCLick)
				
				'Calling the Press Back Inbuilt funtion'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

	
				'Delay'
				Mobile.delay(10)
				
				lTipsCount.get(index1).click()
				
				'Delay of 20 seconds'
				Mobile.delay(20)
					
				String sViewCountAfterClick = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]").getText()
				println (sViewCountAfterClick)
			
				String[] s4 = sViewCountAfterClick.split("\\s")
				println (s4)
				
				String s5 =s4[1]
				int iViewCountAfterClick =Integer.parseInt(s5)
				
				if(iViewCountAfterClick ==iViewCountBeforeClick +1 )
				{
					println ("On Click on the Tip, Count Increased by 1 ")
				}
				else
				{
					println ("On Click on the Tip, Count mismatched please check manually ")
				}
				
				if(iLikeCountAfterCLick >  iLikeCountBeforeCLick)
				{
					println ("Like Button Clicked and Verified ")
				}
				else if(iLikeCountAfterCLick <  iLikeCountBeforeCLick)
				{
					println ("UnLike Button Clicked and Verified ")
				}
				else
				{
					println ("On Click on the Like/UnLike, Count mismatched please check manually")
				}

			}
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
		else if(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Enrollment Status')) {
			
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
		else if(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Goal/Rank')) {
			
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
		else if(lEfficiencySideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Energy Assistance')) {
			
			lEfficiencySideMenu.get(index).click()
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
    }
}