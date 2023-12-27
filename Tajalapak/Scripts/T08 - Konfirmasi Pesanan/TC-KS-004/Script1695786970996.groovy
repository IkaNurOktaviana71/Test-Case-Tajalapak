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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-KS-003'), [('noInvoice') : ' \tTRX91.20230911105711'
        , ('email') : 'runarun@gmail.com'], FailureHandling.STOP_ON_FAILURE)

noPesanan = data.get('invoice')

name = data.get('namaPengirim')

count = data.get('totalBayar')

WebUI.clearText(findTestObject('konfirmasi pesanan/input_Total TagihanTransfer_b'))

WebUI.setText(findTestObject('konfirmasi pesanan/input_Total TagihanTransfer_b'), count)

WebUI.selectOptionByValue(findTestObject('konfirmasi pesanan/select dropdown trasfer'), transfer, false)

WebUI.clearText(findTestObject('konfirmasi pesanan/input_Nama Pengirim_d'))

WebUI.setText(findTestObject('konfirmasi pesanan/input_Nama Pengirim_d'), name)

WebUI.uploadFile(findTestObject('konfirmasi pesanan/input_Upload Bukti Transfer_f'), 'F:\\bootcamp\\Miniproject\\transfer.jpg')

WebUI.click(findTestObject('konfirmasi pesanan/button_Konfirmasi Pembayaran'))

WebUI.verifyElementText(findTestObject('konfirmasi pesanan/verifikasi sukses melakukan pembayaran dari menu shop'), 'Sukses Melakukan Konfirmasi Pembayaran Pesanan!')

return data