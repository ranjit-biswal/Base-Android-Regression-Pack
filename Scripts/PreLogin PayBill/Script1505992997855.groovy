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

String messageText = null

String transactionId = null

'Installing the Application on the Device'
Mobile.startApplication(GlobalVariable.sApplicationPath, false, FailureHandling.STOP_ON_FAILURE)

'Delay of 30 Sec'
Mobile.delay(30)

'One Time Payment'

'Clicking on Pay Bill Menu'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/PayBillMenu'), 5)

'Delay of 5 seconds'
Mobile.delay(5)
 
'Entering Customer Account Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Customer Account Number TextBox'), GlobalVariable.sUtilityAccountNumber, 3)

'Delay of 5 seconds'
Mobile.delay(5)
	
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Delay of 2 seconds'
Mobile.delay(2)

 'Entering Customer Mobile Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Customer Mobile Number TextBox'), GlobalVariable.sCustomerMobileNumber, 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Delay of 2 seconds'
Mobile.delay(2)
 
'Selecting the Agree CheckBox'
Mobile.checkElement(findTestObject('SCM Mobile/PreLogin PayBill/Agree CheckBox'), 3)

'Delay of 2 seconds'
Mobile.delay(2)
  
'Clicking on Next Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Next Button'), 3)
 
'Delay of 5 seconds'
Mobile.delay(5)
 
'Clicking on Make Payment Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Make Payment Button'), 3)
 
'Delay of 5 seconds'
Mobile.delay(5)
 
'Entering Bill Amount'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Enter Amount TextBox'), '1', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Entering Card Holder Name'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Name On Credit Card TextBox'), 'Test Card Holder', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Entering Card Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Number'), '5454545454545454', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Clicking on Card Expiry Date Calendar'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Expiry Calendar'), 3)
 
'Clicking Card Expiry Year Ok Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Calendar Done Button'), 3)
 
'Entering Credit Card Security Code'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Security Code TextBox'), '123', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()
 
'Clicking on PayBill Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/PayBill Button'), 10)
 
'Delay of 40 Sec'
Mobile.delay(40)
 
'Getting Payment Successful Text'
messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin PayBill/Payment Successful Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
 
'Getting Payment Transaction Id'
transactionId = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin PayBill/Transaction Id Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
 
'Verifying One Time Payment is Successfully Done or Not'
if (messageText.equals(null)) {
	System.out.println('Something went wrong with One Time Payment, Please check manually')
} else {
	if (messageText.equals('Payment Successful!')) {
		System.out.println('One Time Payment Successful, Transaction Id is : ' + transactionId)
	} else {
		System.out.println((('One Time Payment Successful, Transaction Id is : ' + transactionId) + 'Expected Text, Expected Text is : "Payment Successful!" but Actual Text is ') +
			messageText)
	}
}
 
'Clicking on Ok'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Ok Button'), 5)