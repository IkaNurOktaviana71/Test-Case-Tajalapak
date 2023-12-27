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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver

WebUI.callTestCase(findTestCase('M05 -Edit Sosial Media/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('edit sosial media/a_Sosmed'))

WebUI.click(findTestObject('edit sosial media/Edit Sosial Media'))

WebUI.click(findTestObject('edit sosial media/input_Facebook_a'))

WebUI.setText(findTestObject('edit sosial media/input_Facebook_a'), facebook, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForAlert(5, FailureHandling.OPTIONAL)

WebDriver webDriver = DriverFactory.getWebDriver()

//mengambil text dari allert
String AlertText = webDriver.switchTo().alert().getText()

//verifikasi apakah yang muncul sesuai dengan yang di ekspetasikan
WebUI.verifyEqual(AlertText, 'Maaf, Tidak Boleh Menggunakan Spasi,..')

