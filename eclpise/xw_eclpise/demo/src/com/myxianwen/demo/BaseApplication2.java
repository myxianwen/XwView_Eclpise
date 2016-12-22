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
        //閸掓繂顫愰崠鏍煘闂傦拷
        SettingHelper.xwInit(BaseApplication2.this);
        //鐠佸墽鐤嗘ご婊堟appid閸滃畮ppkey閿涘矁顔曠純顔兼倵閹靛秷鍏橀幒銉ュ弳閹恒劏宕樼化鑽ょ埠閸滃矂顣堕柆鎾额吀閻炲棴绱濋崥搴ｇ敾娴兼艾绱戦弨鍓ф暤鐠囧嘲閽╅崣锟�
        SettingHelper.xwRegisterApp(mContext, "105", "keyxxxxx", new UICallbackListener() {
            @Override
            public void onSuccess(Object data) {
                String userid = (String) data;
                //鐠佸墽鐤嗛悽銊﹀煕閺勭數袨閸滃苯銇旈崓蹇ョ礉鏉╂瑩鍣锋妯款吇鐠佸墽鐤嗘稉琛★拷婊勭厙閺屾劕绨查悽銊ф畱閻€劍鍩涢垾婵撶礉閸欘垰婀惂璇茬秿閸氬氦顔曠純顔炬祲鎼存梻娈戦弰鐢敌為崪灞姐仈閸嶏拷
                SettingHelper.setUserInfo(mContext, SettingUtils.getApplicationName(mContext) + "的用户",
                        "http://images.iimedia.cn/10001aa87a43d23ea19a3a04ea9e2c301724d24a29690911e1ef304bf72a1d577e72a");
            }
            @Override
            public void onFailure(int errorEvent, String message) {
                Log.e(TAG, "xw register failed: errorEvent=" + errorEvent + ", message=" + message);
            }
        });

        //鐠佸墽鐤嗛弰顖氭儊姒涙顓荤粭顑跨娑擃亪顣堕柆鎾茶礋閹恒劏宕樻０鎴︿壕閿涘矂绮拋銈勮礋true
        //SettingHelper.setRecommendChannel(false);
        //鐠佸墽鐤嗛崚妤勩�冮懗灞炬珯閼癸拷
        //SettingHelper.setBackgroundColor(0, "#FFFFFF");
        //鐠佸墽鐤嗘０鎴︿壕閺嶅繘顤侀懝锟�
        //SettingHelper.setIndicatorColor(0, "#3F51B5");
        //鐠佸墽鐤嗛崚妤勩�冮弬浼存閺嶅洨顒锋０婊嗗
        //SettingHelper.setLabelColor(0, "#3F51B5");
        //鐠佸墽鐤嗛崚妤勩�冩稉瀣閸掗攱鏌婇幒褌娆㈡０婊嗗
        //SettingHelper.setRefreshProgressBarColorId(0, R.color.colorPrimary);
        //鐠佸墽鐤嗛崚妤勩�冮弬浼存Title閸滃ubtext妫版粏澹�
        //SettingHelper.setTextColor(0, "#1b1b1b", "#7a7a7a");
        //鐠佸墽鐤嗛崚妤勩�冮崝鐘烘祰閸斻劎鏁�
        //SettingHelper.setProgressbarDrawable(R.drawable.progressbar_rotate_test);
    }
}
