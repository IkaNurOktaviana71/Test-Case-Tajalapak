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
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('konfirmasi pesanan/a_Shop'))

WebUI.click(findTestObject('konfirmasi pesanan/New Konfirmasi_Orders'))

WebUI.verifyElementPresent(findTestObject('konfirmasi pesanan/verifikasi masuk halaman konfirmasi pesanan'), 0)

WebUI.click(findTestObject('konfirmasi pesanan/button_Submit'))

WebDriver webDriver = DriverFactory.getWebDriver()

field_invoice = webDriver.findElement(By.xpath('(//input[@name="a"])[3]'))

error_message =((JavascriptExecutor) webDriver).executeScript("return arguments[0].validationMessage", field_invoice)
println error_message

//verifikasi apakah error message sesuai
assert error_message == "Please fill out this field."