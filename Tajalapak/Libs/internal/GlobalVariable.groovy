package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object urlWeb
     
    /**
     * <p></p>
     */
    public static Object namaLengkap
     
    /**
     * <p></p>
     */
    public static Object noHp
     
    /**
     * <p></p>
     */
    public static Object metodePembayaran
     
    /**
     * <p></p>
     */
    public static Object tujuanSedekah
     
    /**
     * <p></p>
     */
    public static Object doa
     
    /**
     * <p></p>
     */
    public static Object email
     
    /**
     * <p></p>
     */
    public static Object nominalSedekah
     
    /**
     * <p></p>
     */
    public static Object duaDigitAkhir
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            urlWeb = selectedVariables['urlWeb']
            namaLengkap = selectedVariables['namaLengkap']
            noHp = selectedVariables['noHp']
            metodePembayaran = selectedVariables['metodePembayaran']
            tujuanSedekah = selectedVariables['tujuanSedekah']
            doa = selectedVariables['doa']
            email = selectedVariables['email']
            nominalSedekah = selectedVariables['nominalSedekah']
            duaDigitAkhir = selectedVariables['duaDigitAkhir']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
