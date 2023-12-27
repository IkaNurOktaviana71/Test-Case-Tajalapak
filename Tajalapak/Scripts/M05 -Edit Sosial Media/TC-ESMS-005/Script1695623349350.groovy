import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('M05 -Edit Sosial Media/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('edit sosial media/verifikasi masuk halaman biodata diri'), 0)

WebUI.click(findTestObject('edit sosial media/a_Sosmed'))

instagram = WebUI.getText(findTestObject('Object Repository/hasil sosmed/hasil Instagram_c'))

println instagram

WebUI.click(findTestObject('edit sosial media/Edit Sosial Media'))

WebUI.clearText(findTestObject('edit sosial media/input_Instagram_c'))

WebUI.setText(findTestObject('edit sosial media/input_Instagram_c'), insta)

WebUI.click(findTestObject('edit sosial media/li_Profile'))

WebUI.click(findTestObject('edit sosial media/a_Sosmed'))

instag = WebUI.getText(findTestObject('Object Repository/hasil sosmed/hasil Instagram_c'))
println instag

assert instagram == instag

