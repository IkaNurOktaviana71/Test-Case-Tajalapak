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

WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('chekout/input aku mau belanja'), 'acer')

WebUI.click(findTestObject('chekout/button_Cari di halaman tajalapak'))

WebUI.click(findTestObject('chekout/NEW read more acer'))

WebUI.click(findTestObject('chekout/button_Beli Sekarang di detail produk'))

WebUI.verifyElementPresent(findTestObject('chekout/halaman keranjang belanja'), 0)

WebUI.click(findTestObject('chekout/button_Lanjut ke Pembayaran'))

WebUI.selectOptionByValue(findTestObject('Object Repository/chekout/select_- Kirim via Kurir Lokal -Roda 2Roda 4'), Roda, 
    false)

WebUI.click(findTestObject('chekout/jenis kendaraan'))

if (MetodePembayaran.toString().equalsIgnoreCase('transfer')) {
    WebUI.check(findTestObject('chekout/input metode tf bank'))
} else if (MetodePembayaran.toString().equalsIgnoreCase('saldo')) {
    WebUI.check(findTestObject('chekout/input metode tf bank'))
}

WebUI.click(findTestObject('chekout/button_Proses Pembayaran'))

//mengambil nomor pesanan

noPesanan = WebUI.getText(findTestObject('Object Repository/chekout/nomor invoice dari halaman menunggu pembayaran'))

println(noPesanan)

pengirim = WebUI.getText(findTestObject('Object Repository/chekout/dikirim kepada sama dengan pengirim di tf di konfirmaasi bayar'))

totalharga = WebUI.getText(findTestObject('Object Repository/chekout/total harga bayar'))


//mengambil ongkir
ongkir = WebUI.getText(findTestObject('co saldo akun/new ongkir tf'))

ongkirr = ongkir.substring(2, ongkir.size()).replace(',', '').trim()

ongkir1 = Integer.parseInt(ongkirr)

println(ongkir1)

//mengambil biaya admin
biayaAdmin = WebUI.getText(findTestObject('co saldo akun/new fee admin tf'))

bAdmin = biayaAdmin.substring(2, biayaAdmin.size()).replace(',', '').trim()

Integer.parseInt(bAdmin)

Admin = Double.parseDouble(bAdmin)

println(Admin)

//mengambil subtotal

subtotal = WebUI.getText(findTestObject('co saldo akun/new subtotal tf'))

subtotall = subtotal.substring(2, subtotal.size()).replace(',', '').trim()

Integer.parseInt(subtotall)

sub = Double.parseDouble(subtotall)

println(sub)


//mengambil kode unik
kode = WebUI.getText(findTestObject('co saldo akun/new kode unik tf'))

kodee = kode.replace('+', '').trim()

Integer.parseInt(kodee)

code = Double.parseDouble(kodee)

//mengambil total ongkir untuk chek di admin
tOng = (ongkir1 + sub)

println(tOng)

//mengambil total bayar untuk diassert dengan total bayar di tajalapak
totalBayar = ((tOng + Admin) + code)

println(totalBayar)

int totalBayar1 = ((totalBayar) as int)

println(totalBayar1)

total = WebUI.getText(findTestObject('co saldo akun/new total harga tf'))

total1 = total.replace(',', '').trim()

total2 = Integer.parseInt(total1)

println(total2)

assert totalBayar1 == total2

//membuat objek hashmap
HashMap<String, Object> data = new HashMap<String, Object>()

data.put('invoice', noPesanan)

data.put('namaPengirim', pengirim)

data.put('totalBayar', totalharga)

data.put('totalOngkir', tOng)
return data

