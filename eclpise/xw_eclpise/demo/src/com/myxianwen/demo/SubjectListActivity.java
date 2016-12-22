package com.myxianwen.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.FrameLayout;

import com.iimedia.xwsdk.activity.Common;
import com.iimedia.xwsdk.activity.XwSubjectListActivity;
import com.iimedia.xwsdk.interfaces.IOnNewsItemClickedListener;
import com.iimedia.xwsdk.model.entity.News;

/**
 * Created by iiMedia on 2016/11/11.
 */

public class SubjectListActivity extends XwSubjectListActivity implements IOnNewsItemClickedListener {
    private static final String TAG = "SubjectListActivity";
    private Context mContext = SubjectListActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout mParent = (FrameLayout) findViewById(R.id.activity_main);
        //鍒濆鍖栨柊闂昏鎯呴〉
        initXwView(mParent);
    }

    @Override
    public void OnNewsItemClickedListener(News item, int newsType, int from) {
        switch (newsType) {
            case News.TYPE_NEWS:
                Log.d(TAG, "鏅�氭柊闂�");
                NewsDetailActivity.intentTo(mContext, NewsDetailActivity.class, item, from);
                break;
            case News.TYPE_VIDEO:
                Log.d(TAG, "瑙嗛");
                VideoDetailActivity.intentTo(mContext, VideoDetailActivity.class, item, from);
                break;
            case News.TYPE_PIC:
                Log.d(TAG, "鍥剧墖鏂伴椈");
                PicDetailActivity.intentTo(mContext, PicDetailActivity.class, item, from);
                break;
            default:
                break;
        }
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
