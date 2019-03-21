import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('MFE Testing Pages/Header/link_signInOrCreateAccount'))

WebUI.verifyElementPresent(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/iframe_signInOrCreateAccount'), GlobalVariable.G_longTimeout)

WebUI.click(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/link_createAccountStartHere'))

WebUI.verifyElementPresent(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/button_Register'), 
    GlobalVariable.G_smallTimeout)

WebUI.setText(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/input__firstName'), 
    'Joe')

WebUI.setText(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/input__lastName'), 
    'Hennessey')

String randomEmail = CustomKeywords.'com.totalwine.utils.GenerateRandom.randomEmail'()

WebUI.setText(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/input__email'), 
    randomEmail)

WebUI.setText(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/input_password'), 
    'test123')

WebUI.setText(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/input__phone'), 
    '8005551212')

WebUI.click(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/label_IamAtLeast21yearsOld'))

WebUI.click(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/label_IagreeToTerms'))

WebUI.click(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/CreateAccount/Page_newAccountForm/button_Register'))

