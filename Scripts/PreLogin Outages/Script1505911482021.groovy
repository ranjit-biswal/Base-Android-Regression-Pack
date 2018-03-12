import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By.ByClassName as ByClassName
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

String sOutageTitleOnListOutagesPage = null

String sOutageTitleOnOutagesDetailsPage = null

boolean bResult = false

String messageText = null

'Installing the Application on the Device'
Mobile.startApplication(GlobalVariable.sApplicationPath, false, FailureHandling.STOP_ON_FAILURE)

'Delay of 30 Sec'
Mobile.delay(30)

'Clicking on PreLogin Outages'
Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/PreLogin Outages Menu'), 5)

'Delay of 5 Sec'
Mobile.delay(5)

if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/Current Outages Tab'), 10, FailureHandling.CONTINUE_ON_FAILURE) == 
    false) {
        System.out.println('Current Outages Tab is not displayed in the Outages')
    } else {
        System.out.println('Current Outages Tab is displayed in the Outages Menu')

        'Clicking on Current Outages Tab'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Current Outages Tab'), 15)

        'Delay of 10 seconds'
        Mobile.delay(10)

        'Clicking on Outages List View'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Outages List View'), 15)

        sOutageTitleOnListOutagesPage = null

        sOutageTitleOnOutagesDetailsPage = null

        sOutageTitleOnListOutagesPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on the Outage List View Page'), 
            'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Clicking on the first Outages in the List View'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/First Outage in the Outage List View Page'), 5)

        'Delay'
        Mobile.delay(5)

        sOutageTitleOnOutagesDetailsPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on Outage Details Page_Map'), 
            'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

        if (sOutageTitleOnListOutagesPage.equals(sOutageTitleOnOutagesDetailsPage)) {
            System.out.println('Outage Title mentioned in List View is matching with the Outage Details Title')
        } else {
            System.out.println((('Outage Title mentioned in List View is not matching with the Outage Details Title Expected Outage Title is ' + 
                sOutageTitleOnListOutagesPage) + ' but Actual Outage Ttile is ') + sOutageTitleOnOutagesDetailsPage)
        }
        
        'Calling the Press Back Inbuilt funtion'
        Mobile.pressBack()

        'Delay'
        Mobile.delay(10)

        'Calling the Press Back Inbuilt funtion'
        Mobile.pressBack()

        'Delay'
        Mobile.delay(10)
    }
} else {
    System.out.println('Current Outages count is 0')

    'Clicking on Ok Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PopUp Ok Button'), 10)

    'Delay'
    Mobile.delay(5)
}

if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/Planned Outages Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Planned Outages Tab is not displayed in the Outages')
} else {
    System.out.println('Planned Outages Tab is displayed in the Outages Menu')

    'Clicking on Planned Outages Tab'
    Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Planned Outages Tab'), 15)

    'Delay of 15 seconds'
    Mobile.delay(15)

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    true) {
        System.out.println('Planned Outages count is 0')

        'Clicking on Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

        'Delay'
        Mobile.delay(5)
    } else {
        'Clicking on Outages List View'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Outages List View'), 35)

        'Delay'
        Mobile.delay(5)

        sOutageTitleOnListOutagesPage = null

        sOutageTitleOnOutagesDetailsPage = null

        sOutageTitleOnListOutagesPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on the Outage List View Page'), 
            'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Clicking on the first Outages in the List View'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/First Outage in the Outage List View Page'), 5)

        'Delay'
        Mobile.delay(10)

        sOutageTitleOnOutagesDetailsPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on Outage Details Page_Map'), 
            'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

        if (sOutageTitleOnListOutagesPage.equals(sOutageTitleOnOutagesDetailsPage)) {
            System.out.println('Outage Title mentioned in List View is matching with the Outage Details Title')
        } else {
            System.out.println(((' Outage Title mentioned in List View is not matching with the Outage Details Title Expected Outage Title is ' + 
                sOutageTitleOnListOutagesPage) + ' but Actual Outage Ttile is ') + sOutageTitleOnOutagesDetailsPage)
        }
        
        'Calling the Press Back Inbuilt funtion'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

        'Delay'
        Mobile.delay(10)
    }
}

if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/Report Outages Link'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Report Outages Link is not displayed in the Outages')
} else {
    System.out.println('Report Outage Link is displayed in the Outages Menu')

    'Clicking on Report Outage Link'
    Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Report Outages Link'), 25)

    'Delay of 15 seconds'
    Mobile.delay(15)

    'Getting Message Text of the Module'
    messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

    'Verifying Report Outage Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Report Outage Link')
    } else {
        if (messageText.equals('Connect Me')) {
            System.out.println('On Click on the Report Outage Link user is routing to the Connect Me Page')
        } else {
            System.out.println('On Click on the Report Outage Link user is routing to the Connect Me Page. Expected Text is : "Connect Me" but Actual Text is ' + 
                messageText)
        }
    }
}

'PressBack'
Mobile.pressBack()

'Delay'
Mobile.delay(10)

'PressBack'
Mobile.pressBack()

'Delay'
Mobile.delay(10)