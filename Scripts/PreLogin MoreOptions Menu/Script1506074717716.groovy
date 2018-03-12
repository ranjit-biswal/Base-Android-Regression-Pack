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
import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF as ElseExpressionBNF
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import io.appium.java_client.TouchAction as TouchAction

String messageText = null

Boolean bResult = false , bResult1=false

'Installing the Application on the Device'
Mobile.startApplication(GlobalVariable.sApplicationPath, false)

'Delay of 30 Sec'
Mobile.delay(30)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

'Verifying MoreOptionsMenu Icon is Displayed or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    bResult =true

    System.out.println('MoreOptionsMenu Icon is Displayed')
} else {
    System.out.println('MoreOptionsMenu Icon is not Displayed')
}

'Clicking on More Options Icon'
Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

'Delay of 5 Sec'
Mobile.delay(5)

'***********************************************'

'Verifying MoreOptionsMenu Heading is Displayed on Not'
if ( bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Heading'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    System.out.println('MoreOptionsMenu Heading is Displayed')
} else {
    System.out.println('MoreOptionsMenu Heading is not Displayed')
}

'Getting MoreOptionsMenu Heading in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Heading'), 'value', 
    5, FailureHandling.CONTINUE_ON_FAILURE)

'Checking MoreOptionsMenu Heading Text is matching with the Expeced Text or Not'
if (messageText.equals(GlobalVariable.sMoreOptionsMenuHeadingText)) {
    System.out.println('MoreOptionsMenu Heading is matching with the Expected Text')
} else {
    System.out.println((('MoreOptionsMenu Heading is not matching with the Expected Text, Expected Text is : ' + GlobalVariable.sMoreOptionsMenuHeadingText) + 
        'but Actual Text is ') + messageText)
}

'***********************************************'

'Verifying CopyRight is Displayed on Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application CopyRight Text'), 
    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
    System.out.println('Application CopyRight is Displayed')
} else {
    System.out.println('Application CopyRight is not Displayed')
}

'Getting CopyRight in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application CopyRight Text'), 
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
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application Version'), 
    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
    System.out.println('Application Version is Displayed')
} else {
    System.out.println('Application Version is not Displayed')
}

'Getting Application Version in the String Variable'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application Version'), 
    'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

'Checking Application Version is matching with the Expeced Text or Not'
if (messageText.equals(GlobalVariable.sApplicationVersion)) {
    System.out.println('Application Version is matching with the Expeced Text')
} else {
    System.out.println((('Application Version Text is not matching with the Expected Text, Expected Text is :' + GlobalVariable.sApplicationVersion) + 
        ' but Actual Text is ') + messageText)
}

'***********************************************'

'Verifying Company Logo is Displayed on Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Company Logo'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    System.out.println('Company Logo is Displayed')
} else {
    System.out.println('Company Logo is not Displayed')
}

'***********************************************'

'Verifying Language Tab is Displayed in MoreOptionsMenu or Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Language Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    System.out.println('MoreOptionsMenu Language Tab is Displayed')

    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Language Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay of 5 Sec'
    Mobile.delay(5)

    'Getting Languages in the List'
    ArrayList<MobileElement> lMoreMenuLanguages = driver.findElementsByClassName('XCUIElementTypeCell')

    if (lMoreMenuLanguages.size() > 0) {
        System.out.println('List of Available Languages are :')

        for (int index = 0; index < lMoreMenuLanguages.size(); index++) {
            System.out.println(lMoreMenuLanguages.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())
        }
    } else {
        System.out.println('Language Tab is available but list of languages are not available. Please check manually')
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(10)
} else {
    System.out.println('MoreOptionsMenu Language Tab is not Displayed')
}

'Again Clicking on More Options Icon'
Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

'Delay of 5 Sec'
Mobile.delay(5)

'***********************************************'

'Verifying Terms & Conditions Tab is Displayed in MoreOptionsMenu or Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Terms and Conditions Tab'), 
    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
    System.out.println('MoreOptionsMenu Terms and Conditions Tab is Displayed')

    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Terms and Conditions Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay of 25 Sec'
    Mobile.delay(25)

    'Getting Terms & Conditions Heading in the String Variable'
    messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu T and C Module Heading'), 
        'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

    if (messageText.equals(GlobalVariable.sTandCExpectedTitle)) {
        System.out.println('On Click on T&C Tab, user is routing to the T&C Tab and title of the tab is matching with the expected title')
    } else {
        System.out.println('T&C Tab is available but the title of the T&C module is not matching. Please check manually')
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(10)
} else {
    System.out.println('MoreOptionsMenu T&C Tab is not Displayed')
}

'Again Clicking on MoreOptions Menu Icon'
Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

'Delay of 5 Sec'
Mobile.delay(5)

'***********************************************'

'Verifying FAQs Tab is Displayed in MoreOptionsMenu or Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu FAQs Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
true) {
    System.out.println('MoreOptionsMenu FAQs Tab is Displayed')

    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu FAQs Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay of 25 Sec'
    Mobile.delay(25)

    'Getting FAQs Heading in the String Variable'
    messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu FAQs Module Heading'), 
        'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

    if (messageText.equals(GlobalVariable.sFAQsModuleExpectedTitle)) {
        System.out.println('On Click on FAQs Tab, user is routing to the FAQ Tab and title of the tab is matching with the expected title')
    } else {
        System.out.println('FAQs Tab is available but the title of the FAQs module is not matching. Please check manually')
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

    'Delay'
    Mobile.delay(10)
} else {
    System.out.println('MoreOptionsMenu FAQs Tab is not Displayed')
}

'Again Clicking on MoreOptions Menu Icon'
Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

'Delay of 10 Sec'
Mobile.delay(10)

'***********************************************'

'Verifying SCM Website Tab is Displayed in MoreOptionsMenu or Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu SCM Website Tab'), 3, 
    FailureHandling.CONTINUE_ON_FAILURE) == true) {
    System.out.println('MoreOptionsMenu SCM Website Tab is Displayed')

    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu SCM Website Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay of 25 Sec'
    Mobile.delay(25)

    'Getting MoreOptionsMenu SCM Website Tab URL in the String Variable'
    messageText = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]').getText()

    if (messageText.equals(GlobalVariable.sCompanyUrl)) {
        System.out.println('On Click on SCM Website, user is successfully routing to the url :' + GlobalVariable.sCompanyUrl)
    } else {
        System.out.println(('On Click on SCM Website, user might route to the Website or something issue with the Website Url. Expected Url is :' + 
            GlobalVariable.sCompanyUrl) + ' .Please check manually')
    }
    
    'Clicking the Press Back to Application'
    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Return to Application Button'), 15)

    'Delay'
    Mobile.delay(20)
} else {
    System.out.println('MoreOptionsMenu SCM Website Tab is not Displayed')
}

'Again Clicking on MoreOptions Menu Icon'
Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

'Delay of 5 Sec'
Mobile.delay(5)

'***********************************************'

'Verifying Login Help Tab is Displayed in MoreOptionsMenu or Not'
if (bResult ==true && Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
    System.out.println('MoreOptionsMenu SCM Website Tab is Displayed')

    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

    'Delay of 25 Sec'
    Mobile.delay(25)

    'Getting Login Help Tab Side Menu Elements in the List'
    ArrayList<MobileElement> lMoreMenuLoginHelpSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')

    if (lMoreMenuLoginHelpSideMenu.size() > 0) {
		
		
		'Getting Account Number from the DataBase'
		String sAccountNumberQuery = 'SELECT Top 1 UA.UtilityAccountNumber FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'

		String sAccountNumber = database.DataBaseUtil.executeSQLQuery(sAccountNumberQuery)

		System.out.println(sAccountNumber)

		'Getting Email from the DataBase'
		String sEmailQuery = 'SELECT Top 1 U.EmailID FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'

		String sEmail = database.DataBaseUtil.executeSQLQuery(sEmailQuery)

		System.out.println(sEmail)
		
		'Getting Password from the DataBase'
		String sPasswordQuery = 'SELECT Top 1 U.Password FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'

		String sCurrentPassword = database.DataBaseUtil.executeSQLQuery(sPasswordQuery)

		System.out.println(sCurrentPassword)
		
        for (int index = 0; index < lMoreMenuLoginHelpSideMenu.size(); index++) {
            lMoreMenuLoginHelpSideMenu.get(index).findElementByClassName('XCUIElementTypeButton').click()

            'Delay of 10 Sec'
            Mobile.delay(10)
			
			

            if (driver.findElementByClassName('XCUIElementTypeStaticText').getText().equals('Forgot Username')) {

				bResult1=true
				
                'Entering the Email Address'
                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Email Address TextBox'), 
                    sEmail, 4)

                'Entering the Account Number'
                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Account Number TextBox'), 
                    sAccountNumber, 4)

                'Clicking on the Keyboard Ok Button'
                Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 10)

                'Clicking on the Submit Button'
                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Submit Button'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE)

                'Delay of 10 Sec'
                Mobile.delay(10)

                'Getting the Forgot UserName Message Text in the String variable'
                messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Popup Message Text'), 
                    'value', 5, FailureHandling.CONTINUE_ON_FAILURE)

                'Checking Forgot UserName Message Text is matching with the Expeced Text or Not'
                if (messageText.equals(GlobalVariable.sForgotUserNameText)) {
                    System.out.println('Forgot Username Email sent to the registered email :' + sEmail)
                } else {
                    System.out.println('Something went wrong with the Forgot Username functionality message Text is ' + 
                        messageText)
                }
                
                'Clicking on the Ok Button'
                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Message Popup Ok Button'), 
                    5)

                'Delay of 5 Sec'
                Mobile.delay(5)

                'Again Clicking on MoreOptions Menu Icon'
                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

                'Delay of 5 Sec'
                Mobile.delay(5)

                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE)

                'Delay of 15 Sec'
                Mobile.delay(15)
            }
			else if (driver.findElementByClassName('XCUIElementTypeStaticText').getText().equals('Forgot Password')) {
				
				bResult1=true
				
								'Entering the Email Address'
								Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Email Address TextBox'),
									sEmail, 4)
				
								'Entering the Account Number'
								Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Account Number TextBox'),
									sAccountNumber, 4)
				
								'Clicking on the Keyboard Ok Button'
								Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 10)
				
								'Clicking on the Submit Button'
								Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Submit Button'),
									3, FailureHandling.CONTINUE_ON_FAILURE)
				
								'Delay of 10 Sec'
								Mobile.delay(10)
				
								'Getting the Forgot Password Message Text in the String variable'
								messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Popup Message Text'),
									'value', 5, FailureHandling.CONTINUE_ON_FAILURE)
				
								'Checking Forgot Password Message Text is matching with the Expeced Text or Not'
								if (messageText.equals(GlobalVariable.sForgotPasswordText)) {
									System.out.println('Password Reset Email sent to the registered email :' + sEmail)
								} else {
									System.out.println('Something went wrong with the Forgot Password functionality message Text is ' +
										messageText)
								}
								
								'Clicking on the Ok Button'
								Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Message Popup Ok Button'),
									5)
				
								'Delay of 5 Sec'
								Mobile.delay(5)
								
								'Getting New Password from the DataBase'
								String sNewPasswordQuery = 'SELECT Top 1 U.Password FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'
						
								String sNewPassword = database.DataBaseUtil.executeSQLQuery(sNewPasswordQuery)
						
								System.out.println(sNewPassword)
								
								if(!sNewPassword.equals(sCurrentPassword))
								{
									System.out.println("Forgot Password Functionality is working as expected. Password has been updated and sent to the customer through email")
								}
								else 
								{
									System.out.println("Forgot Password Functionality is not working correctly. Password is not updated. Please check manually")
									
								}
								
				
								'Again Clicking on MoreOptions Menu Icon'
								Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)
				
								'Delay of 5 Sec'
								Mobile.delay(5)
				
								Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'),
									3, FailureHandling.CONTINUE_ON_FAILURE)
				
								'Delay of 15 Sec'
								Mobile.delay(15)
							}
			else if (driver.findElementByClassName('XCUIElementTypeStaticText').getText().equals('Problems Signing In')) {
				
								bResult1=true
								
								'Entering the Email Address'
								Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Email Address TextBox'),
									sEmail, 4)
				
								'Entering the Comment'
								Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Comment TextBox'),
									'This is for Internal Testing', 4)
								
								'Clicking on the Keyboard Ok Button'
								Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 10)
				
								'Clicking on the Submit Button'
								Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Submit Button'),
									3, FailureHandling.CONTINUE_ON_FAILURE)
				
								
								'Getting the Problems Signing In Message Text in the String variable'
								messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Popup Message Text'),
									'value', 5, FailureHandling.CONTINUE_ON_FAILURE)
				
								'Checking Forgot UserName Message Text is matching with the Expeced Text or Not'
								if (messageText.equals(GlobalVariable.sProblemSignInText)) {
									System.out.println('Problems Sign In Popup Text is as expected. Text is : ' + messageText)
								} else {
									System.out.println('Something went wrong with the Problems Sign In Popup. Message Text is ' +
										messageText)
								}
								
								'Clicking on the Ok Button'
								Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Message Popup Ok Button'),
									5)
				
								'Delay of 5 Sec'
								Mobile.delay(5)
			}
			
			if(bResult1==false)
			{
				'Calling the Press Back Inbuilt funtion'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
	
	
				'Delay'
				Mobile.delay(10)
			}
        }
    } else {
        System.out.println('Login Help Tab is available but Login Help Tab Side Menu Elements are not available. Please check manually')
    }
} else {
    System.out.println('MoreOptionsMenu Login Help Tab is not Displayed')
}

'***********************************************'