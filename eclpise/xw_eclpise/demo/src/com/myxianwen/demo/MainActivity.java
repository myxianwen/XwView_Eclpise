package com.myxianwen.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.iimedia.xwsdk.activity.XwNewsListActivity;
import com.iimedia.xwsdk.model.entity.News;

public class MainActivity extends XwNewsListActivity {
    private static final String TAG = "MainActivity";
    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout mParent = (FrameLayout) findViewById(R.id.activity_main);
        initXwView(mParent);
    }

    @Override
    public void OnNewsItemClickedListener(News item, int newsType, int from) {
        super.OnNewsItemClickedListener(item, newsType, from);
        switch (newsType) {
            case News.TYPE_NEWS:
                NewsDetailActivity.intentTo(mContext, NewsDetailActivity.class, item, from);
                break;
            case News.TYPE_VIDEO:
                VideoDetailActivity.intentTo(mContext, VideoDetailActivity.class, item, from);
                break;
            case News.TYPE_PIC:
                PicDetailActivity.intentTo(mContext, PicDetailActivity.class, item, from);
                break;
            case News.TYPE_SUBJECT:
                SubjectListActivity.intentTo(mContext, SubjectListActivity.class, item);
                break;
            case News.TYPE_AD:
                AdDetailActivity.intentTo(mContext, AdDetailActivity.class, item);
                break;
            case News.TYPE_SUBJECT_DETAIL:
                Intent mainIntent = SubjectListActivity.newIntent(mContext, SubjectListActivity.class, item.topic_id);
                Intent detailIntent = NewsDetailActivity.newIntent(mContext, NewsDetailActivity.class, item, from);
                Intent[] intents = {mainIntent, detailIntent};
                startActivities(intents);
                break;
            default:
                break;
        }
    }
}
