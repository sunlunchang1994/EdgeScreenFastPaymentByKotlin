package android.slc.edgescreenfastpayment.code

import android.content.Context
import android.content.Intent
import android.slc.edgescreenfastpayment.R
import android.slc.edgescreenfastpayment.utils.Constants
import com.topjohnwu.superuser.Shell

/**
 * @author slc
 * @date 2020-04-22 10:52
 */
object WxPayDelegate {

    /**
     * 派遣微信的事件
     *
     * @param intent
     */
    fun distributeWxAction(context: Context, intent: Intent) {
        when (intent.getIntExtra(Constants.Wx.KEY_PAY_TYPE, 0)) {
            R.id.wx_scan -> openWxFastPayByCmd(Constants.Wx.CMD_SCAN)
            R.id.wx_payment_code -> openWxFastPayByCmd(Constants.Wx.CMD_ALIPAY_PAYMENT)
            R.id.wx_collect_money_code -> openWxFastPayByCmd(Constants.Wx.CMD_ALIPAY_COLLECT_MONEY)
        }
    }

    /**
     * 打开微信相关快捷支付
     *
     * @param cmd
     */
    fun openWxFastPayByCmd(cmd: String) {
        Shell.su(cmd).submit()
    }
}