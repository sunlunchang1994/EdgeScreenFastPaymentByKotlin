package android.slc.edgescreenfastpayment.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.slc.edgescreenfastpayment.code.WxPayDelegate
import android.slc.edgescreenfastpayment.utils.Constants

/**
 * @author slc
 * @date 2020-04-22 11:07
 */
class WxActionBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Constants.Wx.ACTION_WX.equals(intent.action)) {
            WxPayDelegate.distributeWxAction(context, intent)
        }
    }
}