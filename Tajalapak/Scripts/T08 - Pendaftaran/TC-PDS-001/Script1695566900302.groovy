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

WebUI.openBrowser('https://10.9.2.63/ecommerce/administrator/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('delete akun/input usn admin'), 'admin')

WebUI.setEncryptedText(findTestObject('delete akun/input password admin'), '374mkdZ/lqyNS21oH+MJZQ==')

WebUI.delay(10)

WebUI.click(findTestObject('delete akun/button signin di web admin'))

WebUI.click(findTestObject('delete akun/a_Konsumen'))

WebUI.setText(findTestObject('delete akun/input search nama konsumen'), noHp)

WebUI.click(findTestObject('delete akun/untuk delete akun'), FailureHandling.OPTIONAL)

WebUI.waitForAlert(5)

WebUI.acceptAlert()

