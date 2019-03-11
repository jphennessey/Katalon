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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement


'search for an item'
not_run: WebUI.sendKeys(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'), 'hennessy black 750')

WebUI.waitForElementVisible(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'), GlobalVariable.G_smallTimeout)

not_run: WebUI.clearText(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'))

WebDriver driver = DriverFactory.getWebDriver()
not_run: WebElement element = WebUI.findWebElement(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'),30)
WebElement x = driver.findElement(By.xpath("//input[@id='at_searchProducts']"))
WebUI.executeJavaScript("arguments[0].value=''", Arrays.asList(x))

'search for an item'
WebUI.setText(findTestObject('MFE Testing Pages/Header/ProductSearch/input_productFinderSearch'), GlobalVariable.G_productSearch)

WebUI.click(findTestObject('MFE Testing Pages/Header/ProductSearch/button_productFinderSearch'))

'verify PLP results'
not_run: WebUI.verifyElementText(findTestObject('MFE Testing Pages/Page_PLP/text_searchResults'), 'Showing 1 results for \'hennessy black 750\'', 
    FailureHandling.STOP_ON_FAILURE)

'click the single result image'
not_run: WebUI.click(findTestObject('MFE Testing Pages/Page_PLP/img_firstResult'))

WebUI.setText(findTestObject('MFE Testing Pages/Page_PDP/text_quantity'), GlobalVariable.G_productCount)

'add the item to the cart from the PDP'
WebUI.click(findTestObject('Object Repository/MFE Testing Pages/Page_PDP/button_addToCart'))

if (GlobalVariable.G_viewCartAfterAdd) {
    WebUI.click(findTestObject('Object Repository/MFE Testing Pages/Page_PDP/button_viewCart'))
} else {
    WebUI.delay(GlobalVariable.G_smallTimeout)
}

