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
import org.apache.commons.collections4.map.HashedMap as HashedMap
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('T08 - Konfirmasi Pesanan/TC-LS-001'), [:], FailureHandling.STOP_ON_FAILURE)

sisaSaldo = WebUI.getText(findTestObject('konfirmasi pesanan/sisa saldo rekening')).replace("Rp","").replace(",","").trim()
println sisaSaldo
saldo = Integer.parseInt(sisaSaldo)
println saldo

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
    WebUI.check(findTestObject('Object Repository/co saldo akun/tf saldo akun'))
}

WebUI.click(findTestObject('chekout/button_Proses Pembayaran'))

//mengambil invoice
invoice = WebUI.getText(findTestObject('Object Repository/co saldo akun/saldo akun no invoice'))

println(invoice)

//mengambil dikirim pada
penerima = WebUI.getText(findTestObject('Object Repository/chekout/dikirim kepada sama dengan pengirim di tf di konfirmaasi bayar'))

println(penerima)

//mengambil total harga
total = WebUI.getText(findTestObject('Object Repository/chekout/total harga bayar'))

println(total)

total1 = total.replace(',', '').trim()

totalHarga = Integer.parseInt(total1)

println(totalHarga)

//mengambil ongkir
ongkir = WebUI.getText(findTestObject('Object Repository/co saldo akun/ongkir'))

ongkir1 = ongkir.substring(2, ongkir.size()).replace(',', '').trim()

ongkosKirim = Integer.parseInt(ongkir1)

println(ongkosKirim)

//mengambil biaya admin
admin = WebUI.getText(findTestObject('Object Repository/co saldo akun/fee admin'))

admin1 = admin.substring(2, admin.size()).replace(',', '').trim()

Badmin = Integer.parseInt(admin1)

println(Badmin)

//mengambil subtotal
sub = WebUI.getText(findTestObject('Object Repository/co saldo akun/subtotal'))

sub1 = sub.substring(2, sub.size()).replace(',', '').trim()

subtotal = Integer.parseInt(sub1)

println(subtotal)

//mengambil total ongkir untuk chek di admin
tOng = (ongkosKirim + subtotal)

println(tOng)

//mengambil kode unik
unik = WebUI.getText(findTestObject('Object Repository/co saldo akun/kode unik'))

unik1 = unik.replace('+', '').trim()

kode = Integer.parseInt(unik1)

println(kode)

totalBayar = (((ongkosKirim + Badmin) + subtotal) + kode)

println(totalBayar)
assert totalBayar == totalHarga

//MENGHITUNG SALDO AKUN YANG TERSISA
TotalSaldo = saldo - totalBayar
println TotalSaldo

WebUI.click(findTestObject('Object Repository/konfirmasi pesanan/a_Akun 0'))
WebUI.click(findTestObject('Object Repository/konfirmasi pesanan/a_Profile'))

SiSaldo = WebUI.getText(findTestObject('konfirmasi pesanan/sisa saldo rekening')).replace("Rp","").replace(",","").trim()
println SiSaldo
saldo1 = Integer.parseInt(SiSaldo)
println saldo1

assert saldo1 == TotalSaldo


HashMap<String, Object> data1 = new HashMap<String, Object>()

data1.put('invoice', invoice)

data1.put('nmPengirim', penerima)

data1.put('hargaBayar', total)

data1.put('totalOngkir', tOng)

return data1

