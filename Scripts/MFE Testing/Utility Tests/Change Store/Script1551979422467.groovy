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

storeName = WebUI.getText(findTestObject('MFE Testing Pages/Header/ChangeStore/text_myStore'))

'change to Sacramento if not already selected'
if (storeName != GlobalVariable.G_storeDisplayed) {
    WebUI.waitForElementClickable(findTestObject('MFE Testing Pages/Header/ChangeStore/div_expandStoreSearch'), GlobalVariable.G_smallTimeout)

    WebUI.click(findTestObject('MFE Testing Pages/Header/ChangeStore/div_expandStoreSearch'))

    WebUI.waitForElementVisible(findTestObject('MFE Testing Pages/Header/ChangeStore/button_findOtherStores'), GlobalVariable.G_smallTimeout)

    WebUI.click(findTestObject('MFE Testing Pages/Header/ChangeStore/button_findOtherStores'))

    WebUI.setText(findTestObject('MFE Testing Pages/Header/ChangeStore/input_storeFinderSearch'), GlobalVariable.G_storeSearch)

    WebUI.click(findTestObject('MFE Testing Pages/Header/ChangeStore/button_storeFinderSearch'))

    WebUI.delay(GlobalVariable.G_smallTimeout)

    WebUI.click(findTestObject('MFE Testing Pages/Header/ChangeStore/button_selectFirstStoreInList'))

    WebUI.delay(GlobalVariable.G_mediumTimeout)

    WebUI.verifyElementText(findTestObject('MFE Testing Pages/Header/ChangeStore/text_myStore'), GlobalVariable.G_storeDisplayed)
}

