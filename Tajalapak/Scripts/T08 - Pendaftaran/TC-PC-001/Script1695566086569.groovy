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

//WAJIB MENJALANKAN TC-PS-001 TERLEBIH DAHULU
WebUI.openBrowser('https://10.9.2.63/ecommerce/administrator/')

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('halaman admin/verifikasi masuk masuk website admin'), 0)

WebUI.setText(findTestObject('halaman admin/input_ADMIN_a'), 'admin')

WebUI.setEncryptedText(findTestObject('halaman admin/input_ADMIN_password'), '374mkdZ/lqyNS21oH+MJZQ==')

WebUI.delay(10)

WebUI.click(findTestObject('halaman admin/input_login admin'))

WebUI.click(findTestObject('konsumen/span_Master Market'))

WebUI.click(findTestObject('konsumen/Konsumen master market'))

WebUI.click(findTestObject('konsumen/search di konsumen'))

WebUI.setText(findTestObject('konsumen/search di konsumen'), noHP)

WebUI.click(findTestObject('konsumen/edit data konsumen'))

//mengambil data
user = WebUI.getAttribute(findTestObject('Object Repository/konsumen/input_Username_bb'), 'value')

println(user)

mail = WebUI.getAttribute(findTestObject('Object Repository/konsumen/input_Alamat Email_c'), 'value')

number = WebUI.getAttribute(findTestObject('Object Repository/konsumen/input_No Hp_k'), 'value')

//melakukan chek data apakah sudah sesuai atau belum
assert user.toString().trim().equalsIgnoreCase(username.trim())

assert mail.toString().trim().equalsIgnoreCase(email.trim())

assert number.toString().trim().equalsIgnoreCase(noHP.trim())

if (jk.toString().equalsIgnoreCase('Perempuan')) {
    WebUI.verifyElementChecked(findTestObject('Object Repository/konsumen/JK FIX PEREMPUAN'), 2)
} else if (jk.toString().equalsIgnoreCase('Laki-laki')) {
    WebUI.verifyElementChecked(findTestObject('Object Repository/konsumen/jk laki-laki'), 2)
}

