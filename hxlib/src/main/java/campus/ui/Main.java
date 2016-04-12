package campus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.yiba.hx.DemoHXSDKHelper;
import com.yiba.hx.R;
import com.yiba.hx.activity.BaseActivity;
import com.yiba.hx.activity.ChatActivity;
import com.yiba.hx.activity.LoginActivity;

import campus.Constant;

public class Main extends BaseActivity {
    protected static final int FILECHOOSER_RESULTCODE = 0;
    private ChatAllHistoryFragment chatHistoryFragment;
    private RelativeLayout fragment_container;
    private int index;
    private int currentTabIndex;
    private Fragment[] fragments;
    private boolean hadIntercept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.getBoolean(Constant.ACCOUNT_REMOVED, false)) {
            // 防止被移除后，没点确定按钮然后按了home键，长期在后台又进app导致的crash
            // 三个fragment里加的判断同理
            DemoHXSDKHelper.getInstance().logout(true, null);
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            return;
        } else if (savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false)) {
            // 防止被T后，没点确定按钮然后按了home键，长期在后台又进app导致的crash
            // 三个fragment里加的判断同理
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web_main);
        installtabs();
        findViewById(R.id.btn_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进入聊天页面
                Intent intent = new Intent(Main.this, ChatActivity.class);
                //it is group chat
                intent.putExtra("chatType", ChatActivity.CHATTYPE_SINGLE);
                //  intent.putExtra("groupId", ((EMGroup) emContact).getGroupId());
                intent.putExtra("userId", "a");
                //it is single chat
                startActivity(intent);
            }
        });
    }

    private void installtabs() {
        chatHistoryFragment = new ChatAllHistoryFragment();
        fragments = new Fragment[]{chatHistoryFragment};
        // 添加显示第一个fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, chatHistoryFragment)
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}







