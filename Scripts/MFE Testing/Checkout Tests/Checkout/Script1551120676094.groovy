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

WebUI.click(findTestObject('MFE Testing Pages/Header/link_signInOrCreateAccount'))

WebUI.verifyElementPresent(findTestObject('MFE Testing Pages/Page_Login/iframe_signIn'), 0)

WebUI.sendKeys(findTestObject('MFE Testing Pages/Page_Login/input_username'), 'jphtest@yopmail.com')

WebUI.sendKeys(findTestObject('MFE Testing Pages/Page_Login/input_password'), 'test123')

WebUI.click(findTestObject('MFE Testing Pages/Page_Login/button_signIn'))

WebUI.verifyElementVisibleInViewport(findTestObject('MFE Testing Pages/Page_AccountHome/h2_welcomeBackUser'), 5)

WebUI.sendKeys(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'), 'hennessy black 750')

WebUI.click(findTestObject('MFE Testing Pages/Header/ProductSearch/button_productFinderSearch'))

WebUI.verifyElementText(findTestObject('MFE Testing Pages/Page_PLP/text_searchResults'), 'Showing 1 results for \'hennessy black 750\'')

WebUI.click(findTestObject('MFE Testing Pages/Page_PLP/img_firstResult'))

WebUI.closeBrowser()

