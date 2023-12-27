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

WebUI.openBrowser(GlobalVariable.urlWeb)

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('verifikasi masuk website tajalapk'), 0)

WebUI.click(findTestObject('sedekah online/a_Donasi (di halaman utama)'))

WebUI.click(findTestObject('sedekah online/a_Sedekah Online'))

WebUI.verifyElementPresent(findTestObject('sedekah online/verifikasi halaman sedekah Online'), 0)

WebUI.setText(findTestObject('sedekah online/input_Sedekah'), NominalSedekah)

WebUI.setText(findTestObject('sedekah online/input_No Handphone (di sedekah online)'), noHp)

WebUI.setText(findTestObject('sedekah online/input_Alamat Email (di sedekah online)'), email)

//untuk dropdown metode pembayaran
WebUI.selectOptionByValue(findTestObject('Object Repository/sedekah online/dropdown metode pembayaraan'), pembayaran, false)

// untuk dropdown sedekah ditunjukan untuk siapa
WebUI.selectOptionByValue(findTestObject('Object Repository/sedekah online/sedekah ditunjukan untuk keluarga'), sedekahUntuk, 
    false)

WebUI.setText(findTestObject('sedekah online/input isi doa terbaik anda'), doa)

WebUI.setText(findTestObject('sedekah online/input 2 digit terakhir nomor hp'), digitAkhir)

WebUI.click(findTestObject('sedekah online/button_Sedekah Sekarang'))

// membuat object web driver
WebDriver webDriber = DriverFactory.getWebDriver()

// mengambil object inputan dari nama lengkap terlebih dahulu
field_nmLengkap = webDriber.findElement(By.xpath('//input[@name="nama_lengkap"]'))

//mengambil error message
error_message = ((webDriber) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', field_nmLengkap)

println(error_message)

//verivikasi apakah error message sesuai
assert error_message == 'Please fill out this field.'

