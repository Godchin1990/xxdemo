package www.godchin.demo;

import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiReceiver wifiReceiver = new WifiReceiver();
        IntentFilter intentFilter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        intentFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.NETWORK_IDS_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.ACTION_PICK_WIFI_NETWORK);
        intentFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);
        registerReceiver(wifiReceiver, intentFilter);
    }
    //region 自定义弹出菜单

    boolean isShowing = false;
    private View v;

    private void animation(View v) {
        if (!isShowing) {
            v.setVisibility(View.VISIBLE);
            v.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_popipwindow_enter));
        } else {
            v.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_popipwindow_exit));
            v.setVisibility(View.GONE);
        }
        isShowing = !isShowing;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        isInIgnoredView(event);
        return super.onTouchEvent(event);
    }

    /**
     * 判断是否点击在指定区域，如果不是则隐藏对话框
     */
    private boolean isInIgnoredView(MotionEvent ev) {
        Rect rect = new Rect();
        getRectInScreen(v, rect);
        if (!rect.contains((int) ev.getX(), (int) ev.getY()) && isShowing) {
            animation(v);
            return true;
        }
        return false;
    }

    /**
     * Get the boundary of a view in screen coordinates.
     * 类似 Windows SDK 中的 GetWindowRect + ClientToScreen
     *
     * @param v
     * @param r The result.
     */
    private void getRectInScreen(View v, Rect r) {
        final int w = v.getWidth();
        final int h = v.getHeight();
        r.left = v.getLeft();
        r.top = v.getTop();
        r.right = r.left + w;
        r.bottom = r.top + h;
    }
    //endregion
}


