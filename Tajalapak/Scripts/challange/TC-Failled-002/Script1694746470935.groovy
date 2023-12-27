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

WebUI.callTestCase(findTestCase('challange/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('modul berita/halaman modul berita'))

WebUI.click(findTestObject('modul berita/masuk menu berita admin'))

WebUI.click(findTestObject('modul berita/a_Tambahkan Data'))

WebUI.setText(findTestObject('modul berita/input_Judul_b'), 'wah! sepak bola indonesi semangkin meningkat')

WebUI.selectOptionByValue(findTestObject('modul berita/pilih kategori'), kategori, false)

WebUI.click(findTestObject('modul berita/input_YaTidak_e headline'))

WebUI.click(findTestObject('modul berita/input_YaTidak_f pilihan'))

WebUI.click(findTestObject('modul berita/input_YaTidak_g berita utama'))

WebUI.setText(findTestObject('modul berita/input isi berita'), 'wah sepak bola di  indonesi semangkin meningkat')


WebDriver webDriver = DriverFactory.getWebDriver()

field_isi = webDriver.findElement(By.xpath('(.//*[normalize-space(text()) and normalize-space(.)="Select"])[2]/following::p[1]'))

validationMessage = WebUI.executeJavaScript("return arguments[0].validationMessage", Arrays.asList(field_isi))

assert validationMessage == "character length must more than 100 character"


WebUI.click(findTestObject('modul berita/button_Tambahkan'))