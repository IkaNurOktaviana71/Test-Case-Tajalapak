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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-KS-004'), [('transfer') : '1'
        , ('name') : 'runarun', ('date') : '2023-09-12'], FailureHandling.STOP_ON_FAILURE)

noPesanan = data.get('invoice')

name = data.get('namaPengirim')

count = data.get('totalBayar')

WebUI.setText(findTestObject('konfirmasi pesanan/input_No Pesanan_a di shop'), noPesanan)

WebUI.setText(findTestObject('konfirmasi pesanan/input_Alamat E-mail_form-control'), 'email')

WebUI.click(findTestObject('konfirmasi pesanan/button_Submit'))

WebUI.verifyElementText(findTestObject('konfirmasi pesanan/verifikasi sudah verifikasi order sekali dari menu shop'), 'PENTING - Pesanan ini sudah dikonfirmasi Sebelumnya sebanyak 1 kali,..')

