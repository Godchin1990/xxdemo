package www.godchin.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

class WifiReceiver extends BroadcastReceiver {
    private String str;
    private SupplicantState state;
    private WifiManager wm;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            Log.i("wifi", WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.toString());
        } else if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
            wm = (WifiManager)
                    context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wm.getConnectionInfo();
            state = info.getSupplicantState();
            if (state == SupplicantState.ASSOCIATED) {
                str = "关联AP完成";
            } else if (state == SupplicantState.AUTHENTICATING) {
                str = "正在验证";
            } else if (state == SupplicantState.ASSOCIATING) {
                str = "正在关联AP...";
            } else if (state == SupplicantState.COMPLETED) {
                str = "COMPLETED";
                Log.i("wifi", str);
            } else if (state == SupplicantState.DISCONNECTED) {
                str = "已断开";
                Log.i("wifi", str);
            } else if (state == SupplicantState.DORMANT) {
                str = "暂停活动";
                Log.i("wifi", str);
            } else if (state == SupplicantState.FOUR_WAY_HANDSHAKE) {
                str = "四路握手中...";
                Log.i("wifi", str);
            } else if (state == SupplicantState.GROUP_HANDSHAKE) {
                str = "GROUP_HANDSHAKE";
                Log.i("wifi", str);
            } else if (state == SupplicantState.INACTIVE) {
                str = "休眠中...";
                Log.i("wifi", str);
            } else if (state == SupplicantState.INVALID) {
                str = "无效";
                Log.i("wifi", str);
            } else if (state == SupplicantState.SCANNING) {
                str = "扫描中...";
                Log.i("wifi", str);
            } else if (state == SupplicantState.UNINITIALIZED) {
                str = "未初始化";
                Log.i("wifi", str);
            } else {
                Log.i("wifi", state.toString());
            }
            final int errorCode = intent.getIntExtra(WifiManager.EXTRA_SUPPLICANT_ERROR, -1);
            if (errorCode == WifiManager.ERROR_AUTHENTICATING) {
                Log.i("wifi", "WIFI验证失败！");
            }
        } else if (WifiManager.RSSI_CHANGED_ACTION.equals(action)) {
            Log.i("wifi", "信号改变");
        } else if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(action)) {
            Log.i("wifi", "网络状态改变");
        } else if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
            Log.i("wifi", "wifi状态改变");
        } else {
            Log.i("wifi", action);
        }
    }
}