import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.SimpleDateFormat as SimpleDateFormat
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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-KS-001'), [('transfe') : '2'], 
    FailureHandling.STOP_ON_FAILURE)

nopesanan = data.get('invoice')

println(nopesanan)

count = data.get('totalBayar')

namaInput = data.get('namaHasilInput')

date = data.get('date')

tujuanTf = data.get('noRekening')

jmlTF = data.get('inputJmlTf')

WebUI.navigateToUrl('https://10.9.2.63/ecommerce/administrator/')

WebUI.verifyElementPresent(findTestObject('halaman admin/verifikasi masuk masuk website admin'), 0)

WebUI.setText(findTestObject('halaman admin/input_ADMIN_a'), 'admin')

WebUI.setEncryptedText(findTestObject('halaman admin/input_ADMIN_password'), '374mkdZ/lqyNS21oH+MJZQ==')

WebUI.delay(10)

WebUI.click(findTestObject('halaman admin/input_login admin'))

WebUI.verifyElementPresent(findTestObject('halaman admin/VERIFIKASI MASUK DASHBORD ADMIN'), 0)

WebUI.click(findTestObject('halaman admin/a_Transaksi Market'))

WebUI.click(findTestObject('konfirmasi order konsumen/MENU Konf. Order Konsumen'))

WebUI.verifyElementPresent(findTestObject('konfirmasi order konsumen/HALAMAN Data Konfirmasi Pembayaran Konsumen'), 0)

WebUI.click(findTestObject('konfirmasi order konsumen/input_Search_ DI KON PEMBAYARAN'))

WebUI.setText(findTestObject('konfirmasi order konsumen/input_Search_ DI KON PEMBAYARAN'), nopesanan)

Uangtf = WebUI.getText(findTestObject('Object Repository/konfirmasi order konsumen/UANG YANG di transfer'))

name = WebUI.getText(findTestObject('Object Repository/konfirmasi order konsumen/nama yang tf'))

rekening = WebUI.getText(findTestObject('Object Repository/konfirmasi order konsumen/ke rekening'))

waktu = WebUI.getText(findTestObject('Object Repository/konfirmasi order konsumen/tanggal transfer'))

WebUI.click(findTestObject('halaman admin/new bukti tf di halaman order konsumen'))

WebUI.delay(10)

Locale loc = new Locale('id', 'ID')

SimpleDateFormat sdf = new SimpleDateFormat('dd MMM yyyy', loc)

Date parseDate = null

String SentDate = waktu

parseDate = sdf.parse(SentDate)

SimpleDateFormat print = new SimpleDateFormat('yyyy-MM-dd', loc)

String tanggal = print.format(parseDate)

println(tanggal)

status = WebUI.getText(findTestObject('Object Repository/konfirmasi order konsumen/keterangan lunas apa pending'))

berkas1 = WebUI.getAttribute(findTestObject('Object Repository/halaman admin/new bukti tf di halaman order konsumen'), 'href').split(
    '/')

println(berkas1)

berkasUrl = (berkas1[(berkas1.size() - 1)])

println(berkasUrl)

File downloadFolder = new File('C:\\Users\\USER\\Downloads')

List namesOfFiles = Arrays.asList(downloadFolder.list())

assert namesOfFiles.contains(berkasUrl)

assert count == Uangtf

assert namaInput == name

assert tujuanTf == rekening

assert date == tanggal

assert status == 'Lunas'

