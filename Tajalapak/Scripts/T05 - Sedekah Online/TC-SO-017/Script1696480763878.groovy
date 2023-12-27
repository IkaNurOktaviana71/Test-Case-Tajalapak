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

WebUI.callTestCase(findTestCase('T05 - Sedekah Online/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('sedekah online/a_Donasi (di halaman utama)'))

WebUI.verifyElementClickable(findTestObject('sedekah online/a_Sedekah Online'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('sedekah online/a_Sedekah Online'))

WebUI.verifyElementPresent(findTestObject('sedekah online/verifikasi halaman sedekah Online'), 0)

WebUI.setText(findTestObject('sedekah online/input_Sedekah'), NominalSedekah)

WebUI.setText(findTestObject('sedekah online/input_Nama lengkap (di sedekah online)'), namaLengkap)

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

WebUI.verifyTextPresent('Sukses Proses Bersedekah, kami akan segera menghubungi anda! Terima kasih', false)

