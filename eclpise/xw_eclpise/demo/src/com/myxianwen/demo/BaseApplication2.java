package com.myxianwen.demo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.iimedia.xwsdk.net.listener.UICallbackListener;
import com.iimedia.xwsdk.setting.SettingHelper;
import com.iimedia.xwsdk.setting.SettingUtils;

/**
 * Created by iiMedia on 2016/11/11.
 */

public class BaseApplication2 extends Application {
    private String TAG = "BaseApplication";
    private Context mContext = BaseApplication2.this;

    @Override
    public void onCreate() {
        super.onCreate();
        //鍒濆鍖栭矞闂�
        SettingHelper.xwInit(BaseApplication2.this);
        //璁剧疆椴滈椈appid鍜宎ppkey锛岃缃悗鎵嶈兘鎺ュ叆鎺ㄨ崘绯荤粺鍜岄閬撶鐞嗭紝鍚庣画浼氬紑鏀剧敵璇峰钩鍙�
        SettingHelper.xwRegisterApp(mContext, "idxxxxx", "keyxxxxx", new UICallbackListener() {
            @Override
            public void onSuccess(Object data) {
                String userid = (String) data;
                //璁剧疆鐢ㄦ埛鏄电О鍜屽ご鍍忥紝杩欓噷榛樿璁剧疆涓衡�滄煇鏌愬簲鐢ㄧ殑鐢ㄦ埛鈥濓紝鍙湪鐧诲綍鍚庤缃浉搴旂殑鏄电О鍜屽ご鍍�
                SettingHelper.setUserInfo(mContext, SettingUtils.getApplicationName(mContext) + "鐨勭敤鎴�",
                        "http://images.iimedia.cn/10001aa87a43d23ea19a3a04ea9e2c301724d24a29690911e1ef304bf72a1d577e72a");
            }
            @Override
            public void onFailure(int errorEvent, String message) {
                Log.e(TAG, "xw register failed: errorEvent=" + errorEvent + ", message=" + message);
            }
        });

        //璁剧疆鏄惁榛樿绗竴涓閬撲负鎺ㄨ崘棰戦亾锛岄粯璁や负true
        //SettingHelper.setRecommendChannel(false);
        //璁剧疆鍒楄〃鑳屾櫙鑹�
        //SettingHelper.setBackgroundColor(0, "#FFFFFF");
        //璁剧疆棰戦亾鏍忛鑹�
        //SettingHelper.setIndicatorColor(0, "#3F51B5");
        //璁剧疆鍒楄〃鏂伴椈鏍囩棰滆壊
        //SettingHelper.setLabelColor(0, "#3F51B5");
        //璁剧疆鍒楄〃涓嬫媺鍒锋柊鎺т欢棰滆壊
        //SettingHelper.setRefreshProgressBarColorId(0, R.color.colorPrimary);
        //璁剧疆鍒楄〃鏂伴椈Title鍜孲ubtext棰滆壊
        //SettingHelper.setTextColor(0, "#1b1b1b", "#7a7a7a");
        //璁剧疆鍒楄〃鍔犺浇鍔ㄧ敾
        //SettingHelper.setProgressbarDrawable(R.drawable.progressbar_rotate_test);
    }
}
