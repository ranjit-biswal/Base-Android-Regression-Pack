import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null
import java.util.logging.Logger as Logger
import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF as ElseExpressionBNF
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

Boolean bResult = false

Boolean bResult1 = false

'Calling Login Page Test Case'
Mobile.callTestCase(findTestCase('LogIn'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Delay'
Mobile.delay(50)

'Checking My Account Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('My Account is not displayed in the Dashboard/Landing Page')
} else {
    'Clicking on My Account Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 10)

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    ArrayList<MobileElement> lMyAccountSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')

    println('Size of My Account Side Menu :' + lMyAccountSideMenu.size())

    'Printing My Account Side Menu List'
    println('My Account Side Menu List Contains :')

    for (int index = 0; index < lMyAccountSideMenu.size(); index++) {
        println(lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())

        'Delay of 1 seconds'
        Mobile.delay(1)
    }
    
    for (int index = 0; index < lMyAccountSideMenu.size(); index++) {
        if (lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Profile1')) {
            'Veryfing My Account - Profile'

            'Clicking on Profile from My Account Menu'
            lMyAccountSideMenu.get(index).click()

            'Delay of 50 seconds'
            Mobile.delay(50)

            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile - Alternate Number Text Box'), 
                3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                'Clearing the Alternate Number Text Box'
                Mobile.clearText(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile - Alternate Number Text Box'), 
                    5)

                'Entering the Alternate Number'
                Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile - Alternate Number Text Box'), 
                    GlobalVariable.sAlternateNumber, 4)

                'Clicking on the Keyboard Ok Button'
                Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

                'Delay of 15 seconds'
                Mobile.delay(15)
            }
            
            'Clicking on the Save Button'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile - Save Button'), 15)

            'Delay of 20 seconds'
            Mobile.delay(20)

            'Getting the Account Update Message Text in the String variable'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile - Profile Updation Message Text'), 
                'value', 15, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Account Update Message Text is matching with the Expeced Text or Not'
            if (messageText.equals('Your Profile has been updated successfully.')) {
                System.out.println('Account Update Message Text is matching with the Expeced Text')
            } else {
                System.out.println('Account Update Message Text is not matching with the Expected Text, Expected Text is : Your Profile has been updated successfully. but Actual Text is ' + 
                    messageText)
            }
            
            'Clicking on the Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile - Ok Button'), 25)

            'Delay'
            Mobile.delay(25)

            'Clicking on the Back Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Payment Information')) {
            'Veryfing My Account - Payment Information'

            'Clicking on Payment Information from My Account Menu'
            lMyAccountSideMenu.get(index).click()

            'Delay of 20 seconds'
            Mobile.delay(20)

            '******Deleting Payment Method ***********'

            'Getting Accounts in the List'
            ArrayList<MobileElement> lAccountsList = driver.findElementsByClassName('XCUIElementTypeCell')

            println('Number of Accounts :' + lAccountsList.size())

			if(lAccountsList.size()>0)
			{
			'Getting User Id from the DataBase'
			String sUserIdQuery = "Select UserId from [User] Where UserName = " + "'"  + GlobalVariable.sUserName +"'"
			String sUserId = database.DataBaseUtil.executeSQLQuery(sUserIdQuery);
			System.out.println(sUserId);
			
			
			'Getting Account Id from the DataBase'
			String sAccountNumberQuery = "Select AccountNumber from Account Where UtilityAccountNumber = " + "'"  + GlobalVariable.sUtilityAccountNumber +"'"
			String sAccountNumber = database.DataBaseUtil.executeSQLQuery(sAccountNumberQuery);
			System.out.println(sAccountNumber);
			
			
			'Deleting Row from Table Default Payment'
			'Selecting Row Count from the table'
			
			String sDefaultPaymentMethodGetRowQuery = "Select COUNT(*) from DefaultPayment Where UserId = " + "'"  + sUserId +"'" + " and AccountNumber = " + "'"  + sAccountNumber +"'" 
			String sDefaultPaymentMethodGetRow = database.DataBaseUtil.executeSQLQuery(sDefaultPaymentMethodGetRowQuery);
			
			if(sDefaultPaymentMethodGetRow>0)
			{
				String sDefaultPaymentMethodDeleteRowQuery = "Delete from DefaultPayment Where UserId = " + "'"  + sUserId +"'" + " and AccountNumber = " + "'"  + sAccountNumber +"'" 
				String sDefaultPaymentMethodDeleteRow = database.DataBaseUtil.executeUpdateandDeleteSQLQuery(sDefaultPaymentMethodDeleteRowQuery);
				
				if(sDefaultPaymentMethodGetRow ==1)
				{
					println ('Default Payment Method Deleted Sucessfully')
				}	
				else
				{
					println ('Default Payment Method is not get Deleted, Please check manually')
				}
			}
			else
			{
				println ('There is no Default Payment Method linked with this account')
			}
			
			'Deleting Row from Table CreditCard'
			'Selecting Row Count from the table'
			
			String sCreditCardGetRowQuery = "Select COUNT(*) from CreditCard Where UserId = " + "'"  + sUserId +"'" 
			String sCreditCardGetRow = database.DataBaseUtil.executeSQLQuery(sDefaultPaymentMethodGetRowQuery);
			
			if(sCreditCardGetRow>0)
			{
				String sCreditCardDeleteRowQuery = "Delete from CreditCard Where UserId = " + "'"  + sUserId +"'" 
				String sCreditCardDeleteRow = database.DataBaseUtil.executeUpdateandDeleteSQLQuery(sCreditCardDeleteRowQuery);
				
				if(sCreditCardGetRow ==1)
				{
					println ('CreditCard Deleted Sucessfully')
				}
				else
				{
					println ('CreditCard is not get Deleted, Please check manually')
				}
			}
			else
			{
				println ('There is no CreditCard Payment Method linked with this account')
			}
			
			'Deleting Row from Table BankAccount'
			'Selecting Row Count from the table'
			
			String sBankAccountGetRowQuery = "Select COUNT(*) from BankAccount Where UserId = " + "'"  + sUserId +"'"
			String sBankAccountGetRow = database.DataBaseUtil.executeSQLQuery(sDefaultPaymentMethodGetRowQuery);
			
			if(sBankAccountGetRow>0)
			{
				String sBankAccountDeleteRowQuery = "Delete from BankAccount Where UserId = " + "'"  + sUserId +"'"
				String sBankAccountDeleteRow = database.DataBaseUtil.executeUpdateandDeleteSQLQuery(sBankAccountDeleteRowQuery);
				
				if(sBankAccountGetRow ==1)
				{
					println ('BankAccount Deleted Sucessfully')
				}
				else
				{
					println ('BankAccount is not get Deleted, Please check manually')
				}
			}
			else
			{
				println ('There is no BankAccount Payment Method linked with this account')
			}
        }
		else
		{
			println ('There is no Payment Method linked with this account')
		}
			
            '*********Adding Payment Method*******'

            'Clicking on Add Payment Method from Payment Information'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Add Payment Method Button'), 5)

            'Entering the Card Holder Name'
            Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Card Holder Name'), GlobalVariable.sCardHolderName, 
                4)

            'Clicking on the Keyboard Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

            'Entering the Card Number'
            Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card Number'), GlobalVariable.sCardNumber, 
                4)

            'Clicking on the Keyboard Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

            'Clicking on Calendar Icon'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Calendar Icon'), 4)

            'Clicking on Calendar Done Button'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Calendar Done Button'), 5)

            'Entering the Card CVV Number'
            Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Card Security Code'), '123', 4)

            'Clicking on the Keyboard Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

            'Clicking on Calendar Add Card Button'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Add Card Button'), 5)

            'Delay'
            Mobile.delay(30)

            'Getting the Payment Card Message Text in the String variable'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Payment Method Add Text'), 
                'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Payment Method Add Message Text is matching with the Expeced Text or Not'
            if (messageText.equals('Your credit card details have been added successfully and will be validated once you choose to make a payment.')) {
                System.out.println('Payment Method Added Successfuly')
            } else {
                System.out.println('Payment Method Add Message Text is not matching with the Expected Text, Expected Text is : Your credit card details have been added successfully and will be validated once you choose to make a payment. but Actual Text is ' + 
                    messageText)
            }
            
            'Clicking on the Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Add Payment Method Message Popup Ok Button'), 
                15)

            'Delay'
            Mobile.delay(60)

            'Clicking on the Back Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Marketing Preferences')) {
            'Veryfing My Account - Marketing Preferences'

            'Clicking on Marketing Preferences from My Account Menu'
            lMyAccountSideMenu.get(index).click()

            'Delay'
            Mobile.delay(10)

            'Getting Marketing Preferences in the List'
            ArrayList<MobileElement> lMarketingPreferencesList = driver.findElementsByClassName('XCUIElementTypeCell')

            println(('Number of Marketing Preferences :' + lMarketingPreferencesList.size()) - 1)

            'Printing Marketing Preferences List'
            println('Marketing Preferences List Contains :')

            if (lMarketingPreferencesList.size() > 1) {
                for (int index1 = 1; index1 < lMarketingPreferencesList.size(); index1++) {
                    println(lMarketingPreferencesList.get(index1).findElementByClassName('XCUIElementTypeStaticText').getText())

                    'Delay of 1 seconds'
                    Mobile.delay(1)
                }
                
                'Getting Random Number'
                int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, lMarketingPreferencesList.size())

                for (int index1 = randomnumber; index1 < lMarketingPreferencesList.size(); ) {
                    String sSwitchSelection = lMarketingPreferencesList.get(index1).findElementByClassName('XCUIElementTypeSwitch').getAttribute(
                        'value').toString()

                    println(sSwitchSelection)

                    if (sSwitchSelection.equals('true')) {
                        bResult = true

                        println(lMarketingPreferencesList.get(index1).findElementByClassName('XCUIElementTypeStaticText').getText() + 
                            ' is already checked')

                        'UnSelecting the Marketing Preferences'
                        lMarketingPreferencesList.get(index1).findElementByClassName('XCUIElementTypeSwitch').click()

                        'Delay of 1 seconds'
                        Mobile.delay(1)

                        println('UnSelecting Marketing Prefereces for  ' + lMarketingPreferencesList.get(index1).findElementByClassName(
                                'XCUIElementTypeStaticText').getText())
                    } else {
                        bResult1 = true

                        println(lMarketingPreferencesList.get(index1).findElementByClassName('XCUIElementTypeStaticText').getText() + 
                            ' is not checked')

                        'Selecting the Marketing Preferences'
                        lMarketingPreferencesList.get(index1).findElementByClassName('XCUIElementTypeSwitch').click()

                        'Delay of 1 seconds'
                        Mobile.delay(1)

                        println('Selecting Marketing Prefereces for  ' + lMarketingPreferencesList.get(index1).findElementByClassName(
                                'XCUIElementTypeStaticText').getText())
                    }
                }
                
                'Clicking on Save Button'
                Mobile.tap(findTestObject('SCM Mobile/My Account/Marketing Preferences/Save Button'), 5)

                'Delay of 8 seconds'
                Mobile.delay(8)

                messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value', 
                    5, FailureHandling.CONTINUE_ON_FAILURE)

                'Checking Marketing Preferences Updation Message Text is matching with the Expeced Text or Not'
                if (messageText.equals(GlobalVariable.sMarketingPreferencesMessageText)) {
                    System.out.println('Marketing Preferences Updated Successfully')
                } else {
                    System.out.println((('Marketing Preferences Updated Text is not matching with the Expected Text, Expected Text is : ' + 
                        GlobalVariable.sMarketingPreferencesMessageText) + ' but Actual Text is ') + messageText)
                }
                
                'Clicking on the PopUp Ok Button'
                Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

                'Delay of 5 seconds'
                Mobile.delay(5)

                'Clicking on the Back Button'
                Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

                'Delay'
                Mobile.delay(10)
            } else {
                println('Marketing Preferences List is Empty')
            }
            
            'Clicking on the Back Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(10)
        } else if (lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('About My Home')) {
            'Veryfing My Account - About My Home'

            'Clicking on About My Home from My Account Menu'
            lMyAccountSideMenu.get(index).click()

            'Delay'
            Mobile.delay(40)

            'Clicking on the Back Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(40)
        } else if (lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Guest User1')) {
            'Veryfing My Account - Guest User'

            'Clicking on Guest User from My Account Menu'
            lMyAccountSideMenu.get(index).click()

            'Delay'
            Mobile.delay(10)

            'Clicking on the Back Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(30)
        } else if (lMyAccountSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('About My Business')) {
            'Veryfing My Account - About My Business'

            'Clicking on About My Business from My Account Menu'
            lMyAccountSideMenu.get(index).click()

            'Delay'
            Mobile.delay(40)

            'Clicking on the Back Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

            'Delay'
            Mobile.delay(40)
        }
    }
    
    'Clicking on the Back Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(30)
}