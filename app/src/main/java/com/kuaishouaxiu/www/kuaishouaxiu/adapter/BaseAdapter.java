package com.kuaishouaxiu.www.kuaishouaxiu.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * 封装adapter
 *
 * @param <T>
 */
public abstract class BaseAdapter<T> extends CommonAdapter<T> {


    public BaseAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, T t, int position) {

    }
}
