import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.SimpleDateFormat

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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

WebUI.openBrowser('https://10.9.2.63/ecommerce/administrator/')

WebUI.setText(findTestObject('halaman admin/input_ADMIN_a'), 'admin')

WebUI.setEncryptedText(findTestObject('halaman admin/input_ADMIN_password'), '374mkdZ/lqyNS21oH+MJZQ==')

WebUI.delay(10)

WebUI.click(findTestObject('halaman admin/input_login admin'))

WebUI.verifyElementPresent(findTestObject('halaman admin/VERIFIKASI MASUK DASHBORD ADMIN'), 0)

WebUI.click(findTestObject('halaman admin/a_Transaksi Market'))

WebUI.click(findTestObject('konfirmasi order konsumen/MENU Konf. Order Konsumen'))

WebUI.click(findTestObject('Object Repository/halaman admin/KLIK SORTING TANGGAL'))

//ambil semua element dari tanggal
List<WebElement> dateList = WebUI.findWebElements(findTestObject('Object Repository/halaman admin/SORTING TANGGAL'), 5)

//deklarasi array
String[] arrDateListOri = new String[dateList.size()]

String[] arrDateListSort = new String[dateList.size()]

//isi array yang ori dan sort
for(int i=0; i<dateList.size(); i++) {
	textt = dateList.get(i).text
	
	Locale loc = new Locale("id", "ID")
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", loc)
	applyDate = sdf.parse(textt)
	applyDate = applyDate.getTime()
	
	arrDateListOri[i] = applyDate
	arrDateListSort[i] = applyDate
}

//sort array
Arrays.sort(arrDateListSort)

assert arrDateListOri == arrDateListSort



