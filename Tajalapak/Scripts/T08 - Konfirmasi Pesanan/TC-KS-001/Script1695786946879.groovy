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
import org.openqa.selenium.support.ui.Select as Select
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-OS-001'), [('Roda') : '2'
        , ('MetodePembayaran') : 'transfer'], FailureHandling.STOP_ON_FAILURE)

noInvoice = data.get('invoice')

nmPengirim = data.get('namaPengirim')

ttlBayar = data.get('totalBayar')

WebUI.click(findTestObject('konfirmasi pesanan/a_Akun 0'))

WebUI.click(findTestObject('konfirmasi pesanan/a_Profile'))

WebUI.click(findTestObject('konfirmasi pesanan/a_Pembelian'))

WebUI.click(findTestObject('konfirmasi pesanan/new konfirmasi bayar'))

WebUI.verifyElementPresent(findTestObject('konfirmasi pesanan/verifikasi user masuk halaman konfirmasi bayar dari akun profil'), 
    0)

WebUI.uploadFile(findTestObject('konfirmasi pesanan/input_Upload Bukti Transfer_f'), 'F:\\bootcamp\\Miniproject\\transfer.jpg')

totalBayar = WebUI.getAttribute(findTestObject('Object Repository/konfirmasi pesanan/input_Total TagihanTransfer_b'), 'value')

WebUI.selectOptionByValue(findTestObject('konfirmasi pesanan/select dropdown trasfer'), transfe, false)

naamaPengirim = WebUI.getAttribute(findTestObject('Object Repository/konfirmasi pesanan/input_Nama Pengirim_d'), 'value')

println(naamaPengirim)

tanggal = WebUI.getAttribute(findTestObject('Object Repository/konfirmasi pesanan/input_Tanggal Transfer_e'), 'value')

println(tanggal)

Select select = new Select(DriverFactory.getWebDriver().findElement(By.xpath('//select[@name="c"]')))

String transfer = select.getFirstSelectedOption().getText()

//println transfer
String[] trans = transfer.split('-')

String transf = ''

for (int i = 0; i < trans.length; i++) {
    tf = (trans[0]).trim()

    transf = tf
}

println(transf)

assert totalBayar.toString().trim().equalsIgnoreCase(ttlBayar.trim())

assert naamaPengirim.toString().trim().equalsIgnoreCase(nmPengirim.trim())

WebUI.click(findTestObject('konfirmasi pesanan/button_Konfirmasi Pembayaran'))

WebUI.verifyElementText(findTestObject('konfirmasi pesanan/verifikasi sukses melakukan pembayaran pesanan'), 'Sukses Melakukan Konfirmasi Pembayaran Pesanan!')

data.put('namaHasilInput', naamaPengirim)

data.put('date', tanggal)

data.put('noRekening', transf)

data.put('inputJmlTf', totalBayar)

return data

