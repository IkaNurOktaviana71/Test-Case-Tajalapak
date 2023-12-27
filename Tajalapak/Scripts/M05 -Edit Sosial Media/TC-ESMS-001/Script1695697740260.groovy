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

WebUI.callTestCase(findTestCase('M05 -Edit Sosial Media/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('edit sosial media/verifikasi masuk halaman biodata diri'), 0)

WebUI.click(findTestObject('edit sosial media/a_Sosmed'))

WebUI.click(findTestObject('edit sosial media/Edit Sosial Media'))

WebUI.clearText(findTestObject('edit sosial media/input_Facebook_a'))

WebUI.setText(findTestObject('edit sosial media/input_Facebook_a'), Facebook)

WebUI.clearText(findTestObject('edit sosial media/input_Twitter_b'))

WebUI.setText(findTestObject('edit sosial media/input_Twitter_b'), Twitter)

WebUI.clearText(findTestObject('edit sosial media/input_Instagram_c'))

WebUI.setText(findTestObject('edit sosial media/input_Instagram_c'), Instagram)

WebUI.clearText(findTestObject('edit sosial media/input_Whatsapp_d'))

WebUI.setText(findTestObject('edit sosial media/input_Whatsapp_d'), Whatsapp)

WebUI.clearText(findTestObject('edit sosial media/input_Telegram_e'))

WebUI.setText(findTestObject('edit sosial media/input_Telegram_e'), Telegram)

WebUI.clearText(findTestObject('edit sosial media/input_Youtube_f'))

WebUI.setText(findTestObject('edit sosial media/input_Youtube_f'), Youtube)

WebUI.clearText(findTestObject('edit sosial media/input_LinkedIn_g'))

WebUI.setText(findTestObject('edit sosial media/input_LinkedIn_g'), LinkedIn)

WebUI.clearText(findTestObject('edit sosial media/input_Google_h'))

WebUI.setText(findTestObject('edit sosial media/input_Google_h'), Google)

WebUI.click(findTestObject('edit sosial media/center_Simpan Sosial Media'))

face = WebUI.getText(findTestObject('hasil sosmed/hasil facebook_a'))

Twit = WebUI.getText(findTestObject('hasil sosmed/hasil twitter_b'))

insta = WebUI.getText(findTestObject('hasil sosmed/hasil Instagram_c'))

wa = WebUI.getText(findTestObject('hasil sosmed/hasil whatsapp d'))

tele = WebUI.getText(findTestObject('hasil sosmed/hasil Telegram e'))

yout = WebUI.getText(findTestObject('hasil sosmed/hasil youtube f'))

lin = WebUI.getText(findTestObject('hasil sosmed/hasil linkedin g'))

goo = WebUI.getText(findTestObject('hasil sosmed/hasil google h'))

assert face.toString().trim().equalsIgnoreCase(Facebook.trim())

assert Twit.toString().trim().equalsIgnoreCase(Twitter.trim())

assert insta.toString().trim().equalsIgnoreCase(Instagram.trim())

assert wa.toString().trim().equalsIgnoreCase(Whatsapp.trim())

assert tele.toString().trim().equalsIgnoreCase(Telegram.trim())

assert yout.toString().trim().equalsIgnoreCase(Youtube.trim())

assert lin.toString().trim().equalsIgnoreCase(LinkedIn.trim())

assert goo.toString().trim().equalsIgnoreCase(Google.trim())

