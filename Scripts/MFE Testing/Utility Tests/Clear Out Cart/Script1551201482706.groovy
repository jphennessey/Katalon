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

boolean mergeCartModalPresent = WebUI.verifyElementVisible(findTestObject('MFE Testing Pages/Account Home/Cart Merge Modal/div_Dont forget those other it'), 
    FailureHandling.CONTINUE_ON_FAILURE)

if (mergeCartModalPresent) {
    WebUI.click(findTestObject('MFE Testing Pages/Account Home/Cart Merge Modal/button_Discard') //    cartEmpty = WebUI.verifyElementVisible(findTestObject('MFE Testing Pages/Cart/text_emptyCartMessage'), FailureHandling.CONTINUE_ON_FAILURE)
        )
} else {
    WebUI.click(findTestObject('MFE Testing Pages/Header/icon_shoppingCart'))

    cartNotEmpty = WebUI.verifyElementVisible(findTestObject('MFE Testing Pages/Cart/a_DeleteItem'), FailureHandling.CONTINUE_ON_FAILURE)

    if (cartNotEmpty) {
        WebUI.click(findTestObject('MFE Testing Pages/Cart/a_DeleteItem'))

        WebUI.click(findTestObject('MFE Testing Pages/Cart/button_confirmDelete'))
    }
}

