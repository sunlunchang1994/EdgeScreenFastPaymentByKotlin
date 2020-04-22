package android.slc.edgescreenfastpayment.utils

/**
 * @author slc
 * @date 2020-04-22 10:42
 */
class Constants {
    object Alipay {

    }

    object Wx {
        const val KEY_PAY_TYPE = "pay_type"
        const val ACTION_WX = "com.slc.edgescreenfastpayment.WxAction"
        const val CMD_BASE_START_WX_ACTIVITY = "am start -n com.tencent.mm/"
        const val CMD_SCAN =
            CMD_BASE_START_WX_ACTIVITY + "com.tencent.mm.plugin.scanner.ui.BaseScanUI"
        const val CMD_ALIPAY_PAYMENT =
            CMD_BASE_START_WX_ACTIVITY + "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI"
        const val CMD_ALIPAY_COLLECT_MONEY =
            CMD_BASE_START_WX_ACTIVITY + "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI"
    }
}