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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.JavascriptExecutor

WebUI.openBrowser(GlobalVariable.urlWeb)

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('verifikasi halaman tajalapak sebelum daftar'), 0)

WebUI.click(findTestObject('Pendaftaran/button Register'))

WebUI.verifyElementPresent(findTestObject('Pendaftaran/verifikasi masuk helamaan daftar'), 0)

WebUI.setText(findTestObject('Pendaftaran/input username'), username)

WebUI.setText(findTestObject('Pendaftaran/input email'), email)

WebUI.setText(findTestObject('Pendaftaran/input Nomor Telephon'), noHP)

//memilih untuk jenis kelamin apakah laki-laki atau wanita
if(jk.toString().equalsIgnoreCase('Perempuan')) {
	WebUI.check(findTestObject('Pendaftaran/pilihan Wanita_jenis_kelamin'))
}else if(jk.toString().equalsIgnoreCase('Laki-laki')) {
	WebUI.check(findTestObject('Object Repository/Pendaftaran/pilihan Pria'))
}

WebUI.setEncryptedText(findTestObject('Pendaftaran/input password'), '8MbLm3cRDkc/jsWL6sX6LA==')

WebUI.setEncryptedText(findTestObject('Pendaftaran/input konfirmasi password'), '8MbLm3cRDkc/jsWL6sX6LA==')

WebDriver webDriver = DriverFactory.getWebDriver()

field_username = webDriver.findElement(By.xpath('//input[@name="username"]'))

validationMessage = WebUI.executeJavaScript("return arguments[0].validationMessage", Arrays.asList(field_username))

WebUI.click(findTestObject('Pendaftaran/button_Daftar'))

assert validationMessage =="character length must not exceed 50 characters"
