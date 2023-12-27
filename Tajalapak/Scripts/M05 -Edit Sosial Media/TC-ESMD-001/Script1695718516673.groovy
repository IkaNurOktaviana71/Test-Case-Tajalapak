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

WebUI.callTestCase(findTestCase('M05 -Edit Sosial Media/TC-ESMS-001'), [('Facebook') : 'Runarun', ('Twitter') : 'Runaya71'
        , ('Instagram') : 'Runarun', ('Whatsapp') : '+6281122223333', ('Telegram') : '@Runaya71', ('Youtube') : 'Runarun'
        , ('LinkedIn') : 'RunaOkta', ('Google') : '+Runaya'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('edit sosial media/Edit Sosial Media'))

WebUI.clearText(findTestObject('edit sosial media/input_Facebook_a'))

WebUI.clearText(findTestObject('edit sosial media/input_Twitter_b'))

WebUI.clearText(findTestObject('edit sosial media/input_Instagram_c'))

WebUI.clearText(findTestObject('edit sosial media/input_Whatsapp_d'))

WebUI.clearText(findTestObject('edit sosial media/input_Telegram_e'))

WebUI.clearText(findTestObject('edit sosial media/input_Youtube_f'))

WebUI.clearText(findTestObject('edit sosial media/input_LinkedIn_g'))

WebUI.clearText(findTestObject('edit sosial media/input_Google_h'))

WebUI.click(findTestObject('edit sosial media/center_Simpan Sosial Media'))

face = WebUI.getText(findTestObject('Object Repository/hasil sosmed/hasil facebook_a'))

twit = WebUI.getText(findTestObject('hasil sosmed/hasil twitter_b'))

insta = WebUI.getText(findTestObject('hasil sosmed/hasil Instagram_c'))

wa = WebUI.getText(findTestObject('hasil sosmed/hasil whatsapp d'))

tele = WebUI.getText(findTestObject('hasil sosmed/hasil Telegram e'))

yout = WebUI.getText(findTestObject('hasil sosmed/hasil youtube f'))

lin = WebUI.getText(findTestObject('hasil sosmed/hasil linkedin g'))

goo = WebUI.getText(findTestObject('hasil sosmed/hasil google h'))

assert face.toString().trim().equalsIgnoreCase(facebook.trim())

assert twit.toString().trim().equalsIgnoreCase(variable.trim())

assert insta.toString().trim().equalsIgnoreCase(instagram.trim())

assert wa.toString().trim().equalsIgnoreCase(whatsaap.trim())

assert tele.toString().trim().equalsIgnoreCase(telegram.trim())

assert yout.toString().trim().equalsIgnoreCase(youtube.trim())

assert lin.toString().trim().equalsIgnoreCase(linkedin.trim())

assert goo.toString().trim().equalsIgnoreCase(google.trim())

