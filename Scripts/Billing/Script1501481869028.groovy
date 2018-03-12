import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null

import org.openqa.selenium.Dimension

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

'Calling Login Page Test Case'
Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(50)

'Checking Billing Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Billing is not displayed in the Dashboard/Landing Page' //   Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
        //			driver.scrollToExact(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay Enrollment Button'))
        //			
        //			Mobile.checkElement(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay I Agree CheckBox '), 5)
        //			
        //			'Scrolling  the Screen Downwards till Enroll Button'
        ) //			Mobile.scrollToText("Enroll", FailureHandling.CONTINUE_ON_FAILURE)
    //
    //			'Delay'
    //			Mobile.delay(10)
    //			
    //			'Selecting the T&C CheckBox'
    //	Mobile.tap
    //	 MobileElement cCheckBox = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeButton[1]")	
    //	 cCheckBox.click()
    //	Mobile.checkElement(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay T and C CheckBox'), 5)
    //			TouchAction action = new TouchAction(driver)
    //			action.pre
    //			Mobile.scrollToText(findTestObject('XCUIElementTypeStaticText - I Agree To'))
    //			
} else {
    'Clicking on Billing Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 5)

    'Delay'
    Mobile.delay(10)

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    ArrayList<MobileElement> lBillingSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')

    println('Size of Billing Side Menu :' + lBillingSideMenu.size())

    'Printing Billing Side Menu List'
    println('Billing Side Menu List Contains :')

    for (int index = 0; index < lBillingSideMenu.size(); index++) {
        println(lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())

        'Delay of 1 seconds'
        Mobile.delay(1)
    }
    
    for (int index = 0; index < lBillingSideMenu.size(); index++) {
        if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Utility Bill11')) {
            'Veryfing Billing - Utility Bill'

            'Clicking on Utility Bill from Billing Menu'
            lBillingSideMenu.get(index).click()

            'Delay of 50 seconds'
            Mobile.delay(50)

            'Clicking on Pay Now Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Pay Now Button'), 15)

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Entering the Bill Amount'
            Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Bill Amount TextBox'), '2', 4)

            'Hiding the Keyboard'
            Mobile.hideKeyboard()

            'Clicking on Next Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Next Button'), 15)

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Entering the CVV Number'
            Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/CVV Code TextBox'), '123', 4)

            'Hiding the Keyboard'
            Mobile.hideKeyboard()

            'Clicking on the Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Submit Button'), 35)

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Getting Payment Successful Text'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Utility Bill/Payment Successful Text'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Getting Payment Transaction Id'
            transactionId = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Utility Bill/Transaction Id Text'), 'text', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Verifying Bill Payment is Successfully Done or Not'
            if (messageText.equals(null)) {
                System.out.println('Something went wrong with Bill Payment, Please check manually')
            } else {
                if (messageText.equals('Payment Successful!')) {
                    System.out.println('Bill Payment Successful, Transaction Id is : ' + transactionId)
                } else {
                    System.out.println((('Bill Time Payment Successful, Transaction Id is : ' + transactionId) + 'Expected Text, Expected Text is : "Payment Successful!" but Actual Text is ') + 
                        messageText)
                }
            }
            
            'Clicking on the Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Ok Button'), 75)

            'Delay of 45 seconds'
            Mobile.delay(45)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(30)
        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('History1')) {
            'Veryfing Billing - History'

            'Clicking on History from Billing Menu'
            lBillingSideMenu.get(index).click()

            'Delay of 50 seconds'
            Mobile.delay(50)

            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History/Bill Statement Tab'), 10, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('Bill Statement Tab is not displayed in the Billing History')
            } else {
                System.out.println('Bill Statement Tab is displayed in the Billing History Menu')

                'Clicking on Bill Statement Tab'
                Mobile.tap(findTestObject('SCM Mobile/Billing/History/Bill Statement Tab'), 15)

                'Delay of 35 seconds'
                Mobile.delay(35)

                ArrayList<MobileElement> lHistoryRow = driver.findElementsByClassName('XCUIElementTypeCell')

                println('History Row Count :' + lHistoryRow.size())

                if (lHistoryRow.size() > 0) {
                    System.out.println('Bill Statement Tab have history rows count : ' + lHistoryRow.size())
                } else {
                    System.out.println('Bill Statement Tab dont have history')
                }
            }
            
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History/Payments Tab'), 10, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('Payments Tab is not displayed in the Billing History')
            } else {
                System.out.println('Payments Tab is displayed in the Billing History Menu')

                'Clicking on Bill Payments Tab'
                Mobile.tap(findTestObject('SCM Mobile/Billing/History/Payments Tab'), 15)

                'Delay of 35 seconds'
                Mobile.delay(35)

                ArrayList<MobileElement> lHistoryRow = driver.findElementsByClassName('XCUIElementTypeCell')

                println('History Row Count :' + lHistoryRow.size())

                if (lHistoryRow.size() > 0) {
                    System.out.println('Payments Tab have history rows count : ' + lHistoryRow.size())
                } else {
                    System.out.println('Payments Tab dont have history')
                }
            }
            
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History/Bill Filter Button'), 10, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('Bill Filter Button is not displayed in the Billing History')
            } else {
                System.out.println('Bill Filter Button is displayed in the Billing History Menu')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Budget My Bill1')) {
            'Veryfing Billing - Budget My Bill'

            'Clicking on Budget My Bill from Billing Menu'
            lBillingSideMenu.get(index).click()

            'Delay of 50 seconds'
            Mobile.delay(50)

            'Updating the Budget My Bill'

            'Clicking on Monthly Budget TextBox'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Budget My Bill/Monthly Budget TextBox'), 5)

            'Entering the Monthly Budget'
            Mobile.setText(findTestObject('SCM Mobile/Billing/Budget My Bill/Monthly Budget TextBox'), GlobalVariable.sMonthlyBudget, 
                4)

            'Clicking on the Keyboard Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

            'Clicking on Set Budget Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Budget My Bill/Set Budget Button'), 5)

            'Delay of 15 sec'
            Mobile.delay(15)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Budget My Bill Updation Message Text is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sBudgetMyBillMessageText)) {
                System.out.println('Budget My Bill Updated Successfully')
            } else {
                System.out.println((('Budget My Bill Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sBudgetMyBillMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'Delay of 5 seconds'
            Mobile.delay(5)

            'Checking Notify Over Budget Switch'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Budget My Bill/Notify Over Budget Switch'), 
                10, FailureHandling.CONTINUE_ON_FAILURE) == false) {
                System.out.println('Notify Over Budget Switch is not displayed in the Budget My Bill')
            } else {
                System.out.println('Notify Over Budget Switch is displayed in the Budget My Bill Menu')

                String sSwitchSelection = driver.findElementByClassName('XCUIElementTypeSwitch').getAttribute('value').toString()

                println(sSwitchSelection)

                if (sSwitchSelection.equals('true')) {
                    System.out.println('Notify Over Budget Switch is enabled')
                } else {
                    System.out.println('Notify Over Budget Switch is disabled')
                }
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Auto Pay')) {
            'Veryfing Billing - Auto Pay'

            'Clicking on Auto Pay from Billing Menu'
            lBillingSideMenu.get(index).click()

            'Delay of 20 seconds'
            Mobile.delay(20)

            'Clicking on Select Credit Card'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Select Credit Card from DropDown'), 18)

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Clicking on Select Credit Card'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Select the Credit Card'), 18)

            'Delay of 25 seconds'
            Mobile.delay(25)

            MobileElement bCalendar = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeButton[1]')

            bCalendar.click()

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Selecting the AutoPay Date'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Calendar Select Button'), 5)

            'Delay of 10 seconds'
            Mobile.delay(10)
			
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 1;
			int scrollStart = screenHeightStart.intValue();
			System.out.println("s="+scrollStart);
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0,scrollEnd,0,scrollStart,4000);
			sleep(1000);
			
			driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeButton[1]").click()
			

//            'Selecting the I Agree Checkbox'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/I Agree CheckBox'), 5)

            'Delay of 10 seconds'
            Mobile.delay(10)

            'Clicking on Enroll Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay Enrollment Button'), 18)

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Getting AutoPay Enrollment Text'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay Enrollment Text'), 'text', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Verifying AutoPay Enrollment is Successfully Done or Not'
            if (messageText.equals(null)) {
                System.out.println('Something went wrong with AutoPay Enrollment, Please check manually')
            } else {
                if (messageText.equals('Your Auto Pay details have been saved successfully.')) {
                    System.out.println('Your Auto Pay details have been saved successfully.')
                } else {
                    System.out.println('AutoPay Enrollment Successful, Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' + 
                        messageText)
                }
            }
            
            'Clicking on the Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Ok Button'), 25)

            'Delay of 15 seconds'
            Mobile.delay(15)

            'Unerolling From AutoPay'
            Mobile.tapAndHold(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay Enrolled Account Selection'), 6, 8)

            'Clicking on the Delete Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Delete Button'), 6)

            'Getting AutoPay Enrollment Text'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay Unerollment Text'), 'text', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Verifying AutoPay UnEnrollment is Successfully Done or Not'
            if (messageText.equals(null)) {
                System.out.println('Something went wrong with AutoPay UnEnrollment, Please check manually')
            } else {
                if (messageText.equals('You have been successfully unenrolled from Auto Pay.')) {
                    System.out.println('You have been successfully unenrolled from Auto Pay.')
                } else {
                    System.out.println('AutoPay UnEnrollment Successful, Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' + 
                        messageText)
                }
            }
            
            'Clicking on the Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Ok Button'), 25)

            'Delay of 45 seconds'
            Mobile.delay(45)

            'Delay'
            Mobile.delay(10)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(20)
        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Rate Analysis')) {
            'Veryfing Billing - Rate Analysis'

            'Clicking on Rate Analysis from Billing Menu'
            lBillingSideMenu.get(index).click()

            'Delay of 50 seconds'
            Mobile.delay(50)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Level Pay')) {
            'Veryfing Billing - Level Pay'

            'Clicking on Level Pay from Billing Menu'
            lBillingSideMenu.get(index).click()

            'Delay of 20 seconds'
            Mobile.delay(20)

            'Enrolling in the Level Pay'

            'Selecting the Agree CheckBox'
            Mobile.checkElement(findTestObject('SCM Mobile/Billing/Level Pay/I Agree CheckBox'), 3)

            'Delay of 2 seconds'
            Mobile.delay(2)

            'Clicking on Enroll Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Level Pay/Enroll Button'), 3)

            'Delay of 8 seconds'
            Mobile.delay(8)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Level Pay Enrollment Text is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sLevelEnrollmentMessageText)) {
                System.out.println('User Sucessfully Enrolled for Level Pay')
            } else {
                System.out.println((('Level Pay Enrollment Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sLevelEnrollmentMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'Delay of 5 seconds'
            Mobile.delay(5)

            'DisEnrolling from Level Pay'

            'Clicking on DisEnroll Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Level Pay/DisEnroll Button'), 3)

            'Delay of 6 seconds'
            Mobile.delay(6)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value', 
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Level Pay Enrollment Text is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sLevelDisEnrollmentMessageText)) {
                System.out.println('User Sucessfully DisEnrolled for Level Pay')
            } else {
                System.out.println((('Level Pay DisEnrollment Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sLevelDisEnrollmentMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'Delay of 5 seconds'
            Mobile.delay(5)

            'Calling the Press Back Inbuilt funtion'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        }
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(20)
}