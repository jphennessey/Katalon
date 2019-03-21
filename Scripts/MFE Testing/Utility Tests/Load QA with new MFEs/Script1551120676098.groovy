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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://qa.totalwine.com')

WebUI.click(findTestObject('MFE Testing Pages/AgeGate/button_Yes'), FailureHandling.OPTIONAL)

Cookie ck1 = new Cookie('2018Q2_OCHEADER', 'enabled')

Cookie ck2 = new Cookie('2018Q3_CART', 'enabled')

Cookie ck3 = new Cookie('2018Q2_PDP', 'enabled')

Cookie ck4 = new Cookie('2018Q4_CHECKOUT', 'enabled')

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck1)

driver.manage().addCookie(ck2)

driver.manage().addCookie(ck3)

driver.manage().addCookie(ck4)

WebUI.refresh()

WebUI.click(findTestObject('MFE Testing Pages/AgeGate/button_Yes'), FailureHandling.OPTIONAL)

WebUI.waitForPageLoad(GlobalVariable.G_smallTimeout)

