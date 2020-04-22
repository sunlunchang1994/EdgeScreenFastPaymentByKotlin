package android.slc.edgescreenfastpayment.provider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.slc.edgescreenfastpayment.R
import android.slc.edgescreenfastpayment.code.AlipayDelegate
import android.slc.edgescreenfastpayment.receiver.WxActionBroadcastReceiver
import android.slc.edgescreenfastpayment.utils.Constants
import android.widget.RemoteViews
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailManager
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider

/**
 * @author slc
 * @date 2020-04-22 10:40
 */
class EdgeScreenFastPaymentProvider : SlookCocktailProvider() {
    override fun onUpdate(
        context: Context,
        cocktailManager: SlookCocktailManager,
        cocktailIds: IntArray?
    ) {
        super.onUpdate(context, cocktailManager, cocktailIds)
        panelUpdate(context, cocktailManager, cocktailIds)
    }

    private fun panelUpdate(
        context: Context,
        slookCocktailManager: SlookCocktailManager,
        iArr: IntArray?
    ) {
        val remoteViews =
            RemoteViews(context.packageName, R.layout.shortcut_edge_screen_fast_payment)
        setPendingIntentByActivity(context, remoteViews)
        if (iArr != null) {
            for (updateCocktail in iArr) {
                slookCocktailManager.updateCocktail(updateCocktail, remoteViews)
            }
        }
    }

    private fun setPendingIntentByActivity(
        context: Context,
        remoteViews: RemoteViews
    ) {
        setPendingIntentByBroadcast(context, R.id.wx_scan, remoteViews)
        setPendingIntentByBroadcast(context, R.id.wx_payment_code, remoteViews)
        setPendingIntentByBroadcast(context, R.id.wx_collect_money_code, remoteViews)
        setPendingIntentByActivity(
            context,
            R.id.alipay_scan,
            AlipayDelegate.getAlipayScan(),
            remoteViews
        )
        setPendingIntentByActivity(
            context,
            R.id.alipay_payment_code,
            AlipayDelegate.getAlipayPayment(),
            remoteViews
        )
        setPendingIntentByActivity(
            context,
            R.id.alipay_collect_money_code,
            AlipayDelegate.getAlipayCollectMoney(),
            remoteViews
        )
    }

    private fun setPendingIntentByActivity(
        context: Context,
        i: Int,
        intent: Intent,
        remoteViews: RemoteViews
    ) {
        remoteViews.setOnClickPendingIntent(
            i, PendingIntent.getActivity(
                context, i, intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        )
    }

    private fun setPendingIntentByBroadcast(
        context: Context,
        i: Int,
        remoteViews: RemoteViews
    ) {
        val intent = Intent(context, WxActionBroadcastReceiver::class.java)
        intent.action = Constants.Wx.ACTION_WX
        intent.putExtra(Constants.Wx.KEY_PAY_TYPE, i)
        remoteViews.setOnClickPendingIntent(
            i,
            PendingIntent.getBroadcast(context, i, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        )
    }
}