package com.kuaishouaxiu.www.kuaishouaxiu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kuaishouaxiu.www.kuaishouaxiu.adapter.BaseAdapter;
import com.kuaishouaxiu.www.kuaishouaxiu.view.pullview.AbPullToRefreshView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Activity activity;

    RecyclerView mRecyclerView;
    AbPullToRefreshView abPullToRefreshView;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        mRecyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            list.add("模拟数据+" + i);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        Adapter adapter = new Adapter(activity, R.layout.item_recyclerview, list);
        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        banner(headerAndFooterWrapper);
        mRecyclerView.setAdapter(headerAndFooterWrapper);
        pullview();
    }

    private void banner(HeaderAndFooterWrapper headerAndFooterWrapper) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_headview, (ViewGroup) findViewById(android.R.id.content),
                false);
        Banner mHeadBanner = view.findViewById(R.id.banner);
        mHeadBanner.setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(BannerConfig.CENTER).setDelayTime(5000);
        headerAndFooterWrapper.addHeaderView(view);
        List<String> image = new ArrayList<>(4);
        image.add("http://img.tuku.cn/file_thumb/201804/m2018042218460867.jpg");
        image.add("http://imgphoto.gmw.cn/attachement/jpg/site2/20160824/f44d305ea096192731f363.jpg");
        image.add("http://www.jvnan.com/uploads/160426/2_143829_1.jpg");
        image.add("http://img.tuku.cn/file_big/201804/0a16c3f3b40d4e259538f6e343387e0a.jpg");
        mHeadBanner.setImages(image).start();
    }

    private void pullview() {
        abPullToRefreshView = findViewById(R.id.pullview);
        abPullToRefreshView.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                abPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        abPullToRefreshView.onHeaderRefreshFinish();
                    }
                }, 1000);
            }
        });
        abPullToRefreshView.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                abPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        abPullToRefreshView.onFooterLoadFinish();
                    }
                }, 1000);
            }
        });
        abPullToRefreshView.setLoadMoreEnable(true);
    }

    class Adapter extends BaseAdapter<String> {

        Adapter2 adapter2 = new Adapter2(activity, android.R.layout.simple_list_item_1, list);

        public Adapter(Context context, int layoutId, List<String> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, String s, int position) {
            RecyclerView recyclerView = holder.getView(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(adapter2);
        }
    }

    class Adapter2 extends BaseAdapter<String> {

        public Adapter2(Context context, int layoutId, List<String> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, String s, int position) {
            TextView textView = holder.getView(android.R.id.text1);
            textView.setText(mDatas.get(position));
        }
    }

    private void pay() {
      /*  findViewById(R.id.ali).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XsPay.getInstance(activity).aliPay(order, new AlipayPayCallBack() {
                    @Override
                    public void onSuccess() {
                        toast("ali 成功");
                    }

                    @Override
                    public void onDealing() {

                    }

                    @Override
                    public void onError(int i) {

                    }

                    @Override
                    public void onCancel() {
                        toast("ali取消");
                    }
                });
            }
        });
        findViewById(R.id.wechat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XsPay.getInstance(activity).wxPay("appid", wxOrder, new WXPayCallBack() {
                    @Override
                    public void onSuccess() {
                        toast("wx 成功");
                    }

                    @Override
                    public void onError(int i) {
                        toast("wx 错误" + i);
                    }

                    @Override
                    public void onCancel() {
                        toast("wx 取消");
                    }
                });
            }
        });*/
    }

    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
