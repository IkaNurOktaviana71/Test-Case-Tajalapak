import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.geom.Arc2D.Double

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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-OS-001'), [('Roda') : '2'
        , ('MetodePembayaran') : 'transfer'], FailureHandling.STOP_ON_FAILURE)

noInvoice = data.get('invoice')

nmPengirim = data.get('namaPengirim')

ttlBayar = data.get('totalBayar')

WebUI.navigateToUrl('https://10.9.2.63/ecommerce/administrator/')

WebUI.setText(findTestObject('halaman admin/input_ADMIN_a'), 'admin')

WebUI.setEncryptedText(findTestObject('halaman admin/input_ADMIN_password'), '374mkdZ/lqyNS21oH+MJZQ==')

WebUI.delay(10)

WebUI.click(findTestObject('halaman admin/input_login admin'))

WebUI.verifyElementPresent(findTestObject('halaman admin/VERIFIKASI MASUK DASHBORD ADMIN'), 0)

WebUI.click(findTestObject('halaman admin/a_Transaksi Market'))

WebUI.click(findTestObject('halaman admin/a_Penjualan ke Konsumen'))

WebUI.verifyElementPresent(findTestObject('halaman admin/VERIFIKASI MASUK KE penjual ke konsumen'), 0)

WebUI.click(findTestObject('halaman admin/search di penjual ke konsumen'))

WebUI.setText(findTestObject('halaman admin/search di penjual ke konsumen'), noInvoice)

status = WebUI.getText(findTestObject('Object Repository/halaman admin/td_Pending'))
println status

totalOng = WebUI.getText(findTestObject('Object Repository/halaman admin/td_Rp 15,246 (1 Produk)'))
println totalOng

harga = totalOng.substring(3,9)
println harga

assert status =="Pending"

//String[] totalOngkir = totalOng.split(" ")
//
//for(int i=0; i<3 ; i++) {
//	text = totalOngkir[i].text
//	
//}


