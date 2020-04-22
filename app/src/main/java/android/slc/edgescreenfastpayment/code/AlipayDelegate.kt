package android.slc.edgescreenfastpayment.code

import android.content.Intent
import android.net.Uri

/**
 * @author slc
 * @date 2020-04-22 10:48
 */
object AlipayDelegate {
    fun getAlipayScan(): Intent {
        return Intent(
            "android.intent.action.VIEW",
            Uri.parse("alipayqr" + "://platformapi/startapp?saId=10000007")
        )
    }

    fun getAlipayPayment(): Intent {
        return Intent(
            "android.intent.action.VIEW",
            Uri.parse("alipayqr://platformapi/startapp?saId=20000056")
        )
    }

    fun getAlipayCollectMoney(): Intent {
        return Intent(
            "android.intent.action.VIEW",
            Uri.parse("alipayqr://platformapi/startapp?saId=20000123")
        )
    }
}