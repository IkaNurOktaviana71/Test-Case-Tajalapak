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
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('challange/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('modul berita/halaman modul berita'))

WebUI.click(findTestObject('modul berita/masuk menu berita admin'))

WebUI.selectOptionByValue(findTestObject('modul berita/select_102550100'), '25', false)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> pagination = driver.findElements(By.xpath('//div[@id="example1_paginate"]/ul/li/a'))

for(int i=0; i<pagination.size();i++) {
	
	List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/modul berita/FIXX BANYAKNYA TABEL DI DAHSBORD BERITA'), 10)
	
	println dataList.size()
	
	assert dataList.size() <= 25
	
	WebUI.click(findTestObject('Object Repository/modul berita/a_Next PAGINATION'))
}



