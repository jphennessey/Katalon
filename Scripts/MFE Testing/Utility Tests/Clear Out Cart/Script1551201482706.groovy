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

cartNotEmpty = WebUI.verifyElementInViewport(findTestObject('Object Repository/MFE Testing Pages/Account Home/Cart Merge Modal/button_Discard'), 
    GlobalVariable.G_longTimeout, FailureHandling.OPTIONAL)

if (cartNotEmpty) {
    WebUI.click(findTestObject('Object Repository/MFE Testing Pages/Account Home/Cart Merge Modal/button_Discard'))

    WebUI.delay(GlobalVariable.G_smallTimeout)
} else {
    not_run: cartNotEmpty = WebUI.verifyElementVisible(findTestObject('MFE Testing Pages/Header/span_cartItemCount'), FailureHandling.OPTIONAL)

    not_run: if (cartNotEmpty) {
        not_run: WebUI.click(findTestObject('MFE Testing Pages/Header/span_cartItemCount'))

        not_run: WebUI.click(findTestObject('MFE Testing Pages/Cart/a_DeleteItem'))

        not_run: WebUI.click(findTestObject('MFE Testing Pages/Cart/button_confirmDelete'))
    }
}

