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
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver

WebUI.callTestCase(findTestCase('M05 -Edit Sosial Media/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('edit sosial media/a_Sosmed'))

WebUI.click(findTestObject('edit sosial media/Edit Sosial Media'))

WebUI.clearText(findTestObject('edit sosial media/input_Whatsapp_d'))

WebUI.setText(findTestObject('edit sosial media/input_Whatsapp_d'), Whatsapp)

WebUI.click(findTestObject('edit sosial media/center_Simpan Sosial Media'))

WebDriver webDriver = DriverFactory.getWebDriver()

//mengambil objek inputan wa terlebih dahulu
field_wa = webDriver.findElement(By.xpath('(.//*[normalize-space(text()) and normalize-space(.)="Whatsapp"])[1]/following::div[1]'))

error_message = ((webDriver) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', field_wa)

println(error_message)

assert error_message == 'Please input an valid phone number'

