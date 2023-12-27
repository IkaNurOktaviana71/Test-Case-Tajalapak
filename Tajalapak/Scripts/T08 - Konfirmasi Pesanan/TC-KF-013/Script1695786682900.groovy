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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-OS-001'), [('Roda') : '2'
        , ('MetodePembayaran') : 'transfer'], FailureHandling.STOP_ON_FAILURE)

noInvoice = data.get('invoice')

nmPengirim = data.get('namaPengirim')

ttlBayar = data.get('totalBayar')

WebUI.click(findTestObject('konfirmasi pesanan/a_Akun 0'))

WebUI.click(findTestObject('konfirmasi order konsumen/pembelian dari akun'))

WebUI.click(findTestObject('konfirmasi pesanan/new konfirmasi bayar'))

WebUI.verifyElementPresent(findTestObject('konfirmasi pesanan/verifikasi user masuk halaman konfirmasi bayar dari akun profil'), 
    0)

WebUI.clearText(findTestObject('konfirmasi pesanan/input_Total TagihanTransfer_b'))

WebUI.setText(findTestObject('konfirmasi pesanan/input_Total TagihanTransfer_b'), ttlBayar)

WebUI.selectOptionByValue(findTestObject('konfirmasi pesanan/select dropdown trasfer'), transfer, false)

WebUI.uploadFile(findTestObject('konfirmasi pesanan/input_Upload Bukti Transfer_f'), 'F:\\bootcamp\\Miniproject\\Transfer.rar')

name = WebUI.getAttribute(findTestObject('Object Repository/konfirmasi pesanan/input_Nama Pengirim_d'), 'value')

assert name == nmPengirim

assert name.toString().trim().equalsIgnoreCase(nama.trim())

WebUI.click(findTestObject('konfirmasi pesanan/button_Konfirmasi Pembayaran'))

WebUI.verifyTextPresent('Please upload an valid file!', false)

