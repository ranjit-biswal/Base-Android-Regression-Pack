import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By.ByClassName as ByClassName
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
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
import io.appium.java_client.TouchAction as TouchAction

String messageText = null

String sModuleName = null

String sHamburgerMenuModuleName = null

Boolean bHamburgerMenu = false

Boolean bHamburgerSubMenu1 = false

'Calling Login Page Test Case'
Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Delay of 30 seconds'
Mobile.delay(30)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

TouchAction action = new TouchAction(driver)

'Checking HamBurger Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Hamburger Menu is not displayed on the Dashboard/Landing Page')
} else {
    bHamburgerMenu = true

    System.out.println('Hamburger Menu is displayed on the Dashboard/Landing Page')
}

'Clicking on Hamburger Menu from Dashboard/Landing Page'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

'Delay'
Mobile.delay(10)

'********************************************************'

'Verifying CopyRight is Displayed on Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Hamburger Menu Application CopyRight Text'), 3, 
    FailureHandling.CONTINUE_ON_FAILURE) == true) {
    System.out.println('Application CopyRight is Displayed')
} else {
    System.out.println('Application CopyRight is not Displayed')
}

'Getting CopyRight in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Hamburger Menu Application CopyRight Text'), 
    'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

'Checking CopyRight is matching with the Expeced Text or Not'
if (messageText.equals(GlobalVariable.sCopyRight)) {
    System.out.println('Copyright © Text is matching with the Expected Text')
} else {
    System.out.println((('Copyright © Text is not matching with the Expected Text, Expected Text is : ' + GlobalVariable.sCopyRight) + 
        'but Actual Text is ') + messageText)
}

'***********************************************'

'Verifying Application Version is Displayed on Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Hamburger Menu Application Version'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    System.out.println('Application Version is Displayed')
} else {
    System.out.println('Application Version is not Displayed')
}

'Getting Application Version in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Hamburger Menu Application Version'), 'value', 
    5, FailureHandling.CONTINUE_ON_FAILURE)

'Checking Application Version is matching with the Expeced Text or Not'
if (messageText.equals(GlobalVariable.sApplicationVersion)) {
    System.out.println('Application Version is matching with the Expeced Text')
} else {
    System.out.println((('Application Version Text is not matching with the Expected Text, Expected Text is :' + GlobalVariable.sApplicationVersion) + 
        ' but Actual Text is ') + messageText)
}

'***********************************************'

'Verifying Company Logo is Displayed on Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Hamburger Menu Company Logo'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    System.out.println('Company Logo is Displayed')
} else {
    System.out.println('Company Logo is not Displayed')
}

'***********************************************'

'Verifying Hamburger Sub Menu 1 Heading is Displayed on Not'
if ((bHamburgerMenu == true) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu1 Heading'), 
    3, FailureHandling.CONTINUE_ON_FAILURE) == true)) {
    bHamburgerSubMenu1 = true

    System.out.println('Hamburger Sub Menu 1 Heading is Displayed')
} else {
    System.out.println('Hamburger Sub Menu 1 Heading is not Displayed')
}

'Getting Hamburger Sub Menu 1 Heading in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu1 Heading'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
if (messageText.equals(GlobalVariable.sHamburgerSubMenu1HeadingText)) {
    System.out.println('Hamburger Menu Heading is matching with the Expected Text')
} else {
    System.out.println((('Hamburger Menu Heading is not matching with the Expected Text, Expected Text is : ' + GlobalVariable.sHamburgerSubMenu1HeadingText) + 
        'but Actual Text is ') + messageText)
}

'***********************************************'

'Verifying Hamburger Sub Menu 2 Heading is Displayed on Not'
if ((bHamburgerMenu == true) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu2 Heading'), 
    3, FailureHandling.CONTINUE_ON_FAILURE) == true)) {
    bHamburgerSubMenu1 = true

    System.out.println('Hamburger Sub Menu 2 Heading is Displayed')
} else {
    System.out.println('Hamburger Sub Menu 2 Heading is not Displayed')
}

'Getting Hamburger Sub Menu 2 Heading in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu2 Heading'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
if (messageText.equals(GlobalVariable.sHamburgerSubMenu2HeadingText)) {
    System.out.println('Hamburger Menu Heading is matching with the Expected Text')
} else {
    System.out.println((('Hamburger Menu Heading is not matching with the Expected Text, Expected Text is : ' + GlobalVariable.sHamburgerSubMenu2HeadingText) + 
        'but Actual Text is ') + messageText)
}

'***********************************************'

'Clicking on Sub Menu Heading to Expand the Menu'
Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu1 Heading'), 2, FailureHandling.CONTINUE_ON_FAILURE)

'Delay'
Mobile.delay(10)

ArrayList<MobileElement> lHamburgerSubMenu = driver.findElementsByClassName('XCUIElementTypeCell')

println('Size of Hamburger SubMenu :' + lHamburgerSubMenu.size())

'Printing Hamburger Menu List'
println('Hamburger Menu List Contains :')

for (int index = 26; index < lHamburgerSubMenu.size(); index++) {
    println(lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())

    'Delay of 1 seconds'
    Mobile.delay(1)
}

for (int index = 17; index < lHamburgerSubMenu.size(); index++) {
    println(lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())

    if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('View My Usage1')) {
        'Verifying View My Usage'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on View My Usage from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Usage')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('View and Pay My Bill1')) {
        'Verifying View and Pay My Bill'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on View and Pay My Bill from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Billing')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('View Planned and Current Outages1')) {
        'Verifying View Planned and Current Outages'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on View Planned and Current Outages from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Outages')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('View My Messages1')) {
        'Verifying View My Messages'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on View My Messages from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Inbox')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Compare My Spending With Others')) {
        'Verifying Compare My Spendings With Others'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Compare My Spendings With Others from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Compare')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Contact My Utility Company')) {
        'Verifying Connect My Utility Company'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Connect My Utility Company from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Connect Me')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Make a Service Request')) {
        'Verifying Make a Service Request'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Make a Service Request from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Services')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('View and Enroll in Rebate Programs')) {
        'Verifying View and Enroll in Rebate Programs'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on View and Enroll in Rebate Programs from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Efficiency')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Keep An Eye on Your Smart Appliance1')) {
        'Verifying Keep An Eye on Your Smart Appliance'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Keep An Eye on Your Smart Appliance from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Smart Home')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('FootPrint')) {
        'Verifying FootPrint'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on FootPrint from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Footprint')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Settings1')) {
        'Verifying Settings'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Settings from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Settings')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Notification Preferences')) {
        'Verifying Notification Preferences'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Notification Preferences from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Notification Preferences')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
        
        fNotificationPreferences(driver)
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Change Password')) {
        'Verifying Change Password'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Change Password from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Change Password')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
        
        fChangePassword(driver)

        '** Reverting the Changes**********'

        'Clicking on Hamburger Menu from Dashboard/Landing Page'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

        'Delay'
        Mobile.delay(10)

        'Clicking on Change Password from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        fRevertingChangePassword(driver)

        '** Setting the same password again*****'

        'Clicking on Hamburger Menu from Dashboard/Landing Page'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

        'Delay'
        Mobile.delay(10)

        'Clicking on Change Password from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        fSettingSamePassword(driver)
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Change Username')) {
        'Verifying Change Username'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Change Username from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Change Username')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
    } else if (lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Payment Locations')) {
        'Verifying Payment Locations'
        sHamburgerMenuModuleName = lHamburgerSubMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Payment Locations from Hamburger Menu'
        lHamburgerSubMenu.get(index).click()

        'Delay of 30 seconds'
        Mobile.delay(30)

        'Getting Hamburger Sub Menu 2 Heading in the String Variable'
        sModuleName = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Module Name'), 'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Hamburger Menu Heading is matching with the Expeced Text or Not'
        if (sModuleName.equals('Payment Locations')) {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is working as expected')
        } else {
            System.out.println(((('Verified that on click on ' + sHamburgerMenuModuleName) + ' user is routing to ') + sModuleName) + 
                '. So navigation is not working as expected. Please check manually.')
        }
        
        fPaymentLocations(driver)
    }
    
    'Clicking on the Back Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(10)

    'Clicking on Hamburger Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

    'Delay'
    Mobile.delay(10)

    'Clicking on Sub Menu Heading to Expand the Menu'
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu1 Heading'), 2, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay'
    Mobile.delay(10)
}

static void fNotificationPreferences(WebDriver driver) {
    AppiumDriver<?> driver1 = MobileDriverFactory.getDriver()

    ArrayList<MobileElement> lNotificationPreferences = driver1.findElementsByClassName('XCUIElementTypeCell')

    'Getting Random Number'
    int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, lNotificationPreferences.size() - 1)

    for (int index1 = randomnumber; index1 < lNotificationPreferences.size(); ) {
        String sNotificationPrefModuleName = lNotificationPreferences.get(index1).findElementByClassName('XCUIElementTypeStaticText').getText()

        'Clicking on Notification Preferences Side Menu'
        lNotificationPreferences.get(index1).click()

        'Delay of 1 seconds'
        Mobile.delay(1)

        ArrayList<MobileElement> lNotificationMedium = driver1.findElementsByClassName('XCUIElementTypeCell')

        'Getting Random Number'
        int randomnumber1 = utility.RandomRange.nextRandomIntegerInRange(1, lNotificationMedium.size())

        for (int index2 = randomnumber1; index2 < lNotificationMedium.size(); ) {
            if (lNotificationMedium.get(index2).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Text')) {
                println('Updating the Notification Medium Text')

                if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Text Field TextBox'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                    println('Notification Text Medium is already selected, so we are unselecting this medium')

                    'Clicking on Text Field Text Box'
                    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Text Field TextBox'), 
                        3, FailureHandling.CONTINUE_ON_FAILURE)
                } else {
                    println('Notification Text Medium is already selected, so we are unselecting this medium')

                    'Clicking on Text Field Text Box'
                    lNotificationMedium.get(index2).click()

                    'Clearing the Text Field'
                    Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Text Field TextBox'), 
                        0, FailureHandling.CONTINUE_ON_FAILURE)

                    'Entering the Phone Number in Text Field'
                    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Text Field TextBox'), 
                        GlobalVariable.sAlternateNumber, 4)
                }
            } else if (lNotificationMedium.get(index2).findElementByClassName('XCUIElementTypeStaticText').getText().equals(
                'Push Notification')) {
                'Clicking on Push Notification'
                Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Push Notification Text'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE)
            } else if (lNotificationMedium.get(index2).findElementByClassName('XCUIElementTypeStaticText').getText().equals(
                'Email Address')) {
                println('Updating the Notification Medium Email')

                if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Email Address TextBox'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                    println('Notification Email Address Medium is already selected, so we are unselecting this medium')

                    'Clicking on Email Address Field Text Box'
                    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Email Address TextBox'), 
                        3, FailureHandling.CONTINUE_ON_FAILURE)
                } else {
                    println('Notification Email Address Medium is already selected, so we are unselecting this medium')

                    'Clicking on Email Address Field Text Box'
                    lNotificationMedium.get(index2).click()

                    'Clearing Email Address Text Field'
                    Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Email Address TextBox'), 
                        0, FailureHandling.CONTINUE_ON_FAILURE)

                    'Entering the Email Address in Text Field'
                    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Email Address TextBox'), 
                        GlobalVariable.sEmailAddress, 4)
                }
            } else if (lNotificationMedium.get(index2).findElementByClassName('XCUIElementTypeStaticText').getText().equals(
                'IVR')) {
                println('Updating the Notification Medium IVR')

                if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/IVR TextBox'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                    println('Notification IVR Medium is already selected, so we are unselecting this medium')

                    'Clicking on IVR Field Text Box'
                    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/IVR TextBox'), 3, FailureHandling.CONTINUE_ON_FAILURE)
                } else {
                    println('Notification IVR Medium is already selected, so we are unselecting this medium')

                    'Clicking on IVR Field Text Box'
                    lNotificationMedium.get(index2).click()

                    'Clearing the IVR Field'
                    Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/IVR TextBox'), 0, 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    'Entering the Phone Number in IVR Field'
                    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/IVR TextBox'), GlobalVariable.sAlternateNumber, 
                        4)
                }
            }
            
            break
        }
        
        'Clicking on Save/Submit Button'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Submit Button'), 5)

        'Clicking on Submit Button'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Submit Button'), 5)

        'Getting configuration update text in the String Variable'
        String messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value', 
            5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Configuration Updation Message Text is matching with the Expeced Text or Not'
        if (messageText.equals(GlobalVariable.sNotificationPreferencesUpdationMessageText)) {
            System.out.println('Notification Preferences Updated Successfully')
        } else {
            System.out.println((('Notification Preferences Updated Text is not matching with the Expected Text, Expected Text is : ' + 
                GlobalVariable.sNotificationPreferencesUpdationMessageText) + ' but Actual Text is ') + messageText)
        }
        
        'Clicking on the PopUp Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

        'Delay of 5 seconds'
        Mobile.delay(5)

        break
    }
    
    'Clicking on the Back Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(10)

    'Clicking on Hamburger Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

    'Delay'
    Mobile.delay(10)

    'Clicking on Sub Menu Heading to Expand the Menu'
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu1 Heading'), 2, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay'
    Mobile.delay(10)
}

static void fChangePassword(WebDriver driver) {
    'Entering the Existing Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), GlobalVariable.sPassword, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Entering the New Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sNewPassword, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Entering the Confirm Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), GlobalVariable.sNewPassword, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Clicking on the Keyboard Done Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 4)

    'Clicking on Submit Button'
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

    'Delay of 4 sec'
    Mobile.delay(4)

    String messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value', 5, 
        FailureHandling.CONTINUE_ON_FAILURE)

    'Checking Password Updation Message Text is matching with the Expeced Text or Not'
    if (messageText.equals(GlobalVariable.sPasswordUpdationMessageText)) {
        System.out.println('Password Updated Successfully')
    } else {
        System.out.println((('Password Updated Text is not matching with the Expected Text, Expected Text is : ' + GlobalVariable.sPasswordUpdationMessageText) + 
            ' but Actual Text is ') + messageText)
    }
    
    'Clicking on the PopUp Ok Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

    'Delay of 5 seconds'
    Mobile.delay(5)
}

static void fRevertingChangePassword(WebDriver driver) {
    'Entering the Existing Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), GlobalVariable.sNewPassword, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Entering the New Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sNewPassword1, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Entering the Confirm Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), GlobalVariable.sNewPassword1, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Clicking on the Keyboard Done Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 4)

    'Clicking on Submit Button'
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

    'Delay of 4 sec'
    Mobile.delay(4)

    'Clicking on the PopUp Ok Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

    'Delay of 5 seconds'
    Mobile.delay(5)
}

static void fSettingSamePassword(WebDriver driver) {
    'Entering the Existing Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), GlobalVariable.sNewPassword1, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Entering the New Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sPassword, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Entering the Confirm Password'
    Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), GlobalVariable.sPassword, 
        4)

    'Delay of 1 sec'
    Mobile.delay(1)

    'Clicking on the Keyboard Done Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 4)

    'Clicking on Submit Button'
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

    'Delay of 4 sec'
    Mobile.delay(4)

    'Clicking on the PopUp Ok Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

    'Delay of 5 seconds'
    Mobile.delay(5)
}

static void fPaymentLocations(WebDriver driver) {
    AppiumDriver<?> driver1 = MobileDriverFactory.getDriver()

    ArrayList<MobileElement> lPaymentLocations = driver1.findElementsByClassName('XCUIElementTypeCell')

    if (lPaymentLocations.size() > 0) {
        for (int index2 = 0; index2 < 1; ) {
            String sPaymentLocationTitle = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Payment Locations/Payment Location Title'), 
                'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Clicking on the first Payment Location'
            lPaymentLocations.get(index2).click()   

            'Delay of 2 sec'
            Mobile.delay(2)

            String sPaymentLocationTitleOnMap = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Payment Locations/Payment Location Map Title'), 
                'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Configuration Updation Message Text is matching with the Expeced Text or Not'
            if (sPaymentLocationTitle.equals(sPaymentLocationTitleOnMap)) {
                System.out.println('On click on the Payment Location title is matching with Payment Location title on Map')
            } else {
                System.out.println((('On click on the Payment Location title is not matching with Payment Location title on Map, Expected Text is : ' + 
                    sPaymentLocationTitle) + ' but Actual Text is ') + sPaymentLocationTitleOnMap)
            }
            
break
        }
    } else {
        println('There is no payment location available')
    }
    
    'Clicking on the Back Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(10)

    'Clicking on Hamburger Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

    'Delay'
    Mobile.delay(10)

    'Clicking on Sub Menu Heading to Expand the Menu'
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Hamburger SubMenu1 Heading'), 2, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay'
    Mobile.delay(10)
}