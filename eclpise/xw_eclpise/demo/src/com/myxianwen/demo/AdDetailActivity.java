package com.myxianwen.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.iimedia.xwsdk.activity.Common;
import com.iimedia.xwsdk.activity.XwAdDetailActivity;
import com.iimedia.xwsdk.interfaces.IOnNewsItemClickedListener;
import com.iimedia.xwsdk.model.entity.News;

/**
 * Created by iiMedia on 2016/11/28.
 */

public class AdDetailActivity extends XwAdDetailActivity implements IOnNewsItemClickedListener {
    private static final String TAG = "AdDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout mParent = (FrameLayout) findViewById(R.id.activity_main);
        //鍒濆鍖栧箍鍛�(娲诲姩)璇︽儏椤�
        initXwView(mParent);
    }

    @Override
    public void OnNewsItemClickedListener(News item, int newsType, int from) {

    }

    @Override
    public void OnActionItemClickedListener(News item, int actionType) {
        switch (actionType) {
            case Common.XWNEWS_ACTION_SHARE:
                Log.d(TAG, "鍒嗕韩");
                break;
            default:
                break;
        }
    }
}
