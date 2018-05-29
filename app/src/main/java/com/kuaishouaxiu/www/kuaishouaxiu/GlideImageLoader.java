package com.kuaishouaxiu.www.kuaishouaxiu;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * 创建日期：2018/5/25 on 16:59
 * 描述:
 * 作者:zhahaijun 18655961751@163.com
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load((String) path).into(imageView);
    }
}
