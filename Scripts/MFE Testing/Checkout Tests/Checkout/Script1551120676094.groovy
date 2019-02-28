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
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('MFE Testing/Utility Tests/Load QA with new MFEs'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('MFE Testing Pages/Header/link_signInOrCreateAccount'))

WebUI.verifyElementPresent(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/iframe_signInOrCreateAccount'), 0)

WebUI.sendKeys(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/input_username'), 'jphmfe@yopmail.com')

WebUI.sendKeys(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/input_password'), 'test123')

WebUI.click(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/button_signIn'))

not_run: WebUI.callTestCase(findTestCase('MFE Testing/Utility Tests/Create Random Account'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('MFE Testing/Utility Tests/Clear Out Cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'), 'hennessy black 750')

WebUI.click(findTestObject('MFE Testing Pages/Header/ProductSearch/button_productFinderSearch'))

WebUI.verifyElementText(findTestObject('MFE Testing Pages/Page_PLP/text_searchResults'), 'Showing 1 results for \'hennessy black 750\'')

WebUI.click(findTestObject('MFE Testing Pages/Page_PLP/img_firstResult'))

WebUI.click(findTestObject('Object Repository/MFE Testing Pages/Page_PDP/button_addToCart'))

WebUI.click(findTestObject('MFE Testing Pages/Page_PDP/button_viewCart'))

WebUI.click(findTestObject('MFE Testing Pages/Cart/button_SecureCheckout'))

WebUI.click(findTestObject('MFE Testing Pages/Page_Checkout/button_SaveAndContinue'))

WebUI.delay(1)

WebUI.click(findTestObject('MFE Testing Pages/Page_Checkout/button_SaveAndContinue'))

WebUI.waitForElementClickable(findTestObject('MFE Testing Pages/Page_Checkout/3-ReviewAndSubmit/button_PlaceOrder'), 1)

WebUI.click(findTestObject('MFE Testing Pages/Page_Checkout/3-ReviewAndSubmit/label_IamAtLeast21yearsOldCheckbox'))

WebUI.click(findTestObject('MFE Testing Pages/Page_Checkout/3-ReviewAndSubmit/button_PlaceOrder'))

WebUI.closeBrowser()

