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
import org.openqa.selenium.WebElement as WebElement

HashMap<String,Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-KS-001'), [:], FailureHandling.STOP_ON_FAILURE)

noInvoice = data.get('invoice')

nmPengirim = data.get('namaPengirim')

ttlBayar = data.get('totalBayar')

ttlOngkir = data.get('totalOngkir')


String invoice = String.valueOf(noInvoice);

WebUI.navigateToUrl('https://10.9.2.63/ecommerce/administrator/')

WebUI.setText(findTestObject('halaman admin/input_ADMIN_a'), 'admin')

WebUI.setEncryptedText(findTestObject('halaman admin/input_ADMIN_password'), '374mkdZ/lqyNS21oH+MJZQ==')

WebUI.delay(10)

WebUI.click(findTestObject('halaman admin/input_login admin'))

WebUI.verifyElementPresent(findTestObject('halaman admin/VERIFIKASI MASUK DASHBORD ADMIN'), 0)

WebUI.click(findTestObject('halaman admin/a_Transaksi Market'))

WebUI.click(findTestObject('halaman admin/a_Penjualan ke Konsumen'))

WebUI.verifyElementPresent(findTestObject('halaman admin/VERIFIKASI MASUK KE penjual ke konsumen'), 0)

//MENCARI NOMOR INVOICE DENGAN MENGGUNAKAN LIST
List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/halaman admin/LIST KODE TRANSAKSI'), 10)

String pesanan = ""
for(int i=0; i<dataList.size() ; i++) {
	text = dataList.get(i).text
	//mengubah tipe char ke string
	String List = String.valueOf(text)
	if(invoice.toString().contains(List)) {
		pesanan = List
	}else {
		continue
	}
}
println pesanan

// mengambil status
status = WebUI.getText(findTestObject('Object Repository/halaman admin/td_Pending'))
println status

//mengambil total ongkir
totalOng = WebUI.getText(findTestObject('Object Repository/halaman admin/td_Rp 15,246 (1 Produk)'))
println totalOng

harga = totalOng.substring(3,9).trim().replace(',','')
Hargaa = Integer.parseInt(harga)
println Hargaa

//mengambil nama konsumen
konsumen = WebUI.getText(findTestObject('Object Repository/halaman admin/KONSUMEN DI PENJUAL KE KONSUMEN'))
println konsumen

assert status =="Konfirmasi"
assert ttlOngkir == Hargaa
assert konsumen == nmPengirim 
