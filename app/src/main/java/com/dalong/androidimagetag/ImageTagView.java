package com.dalong.androidimagetag;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 标签view
 * Created by zhouweilong on 2016/11/3.
 */

public class ImageTagView extends LinearLayout{

    private TextView mTagName;
    private TextView mTagPrice;

    public ImageTagView(Context context) {
        this(context,null);
    }

    public ImageTagView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImageTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LayoutInflater.from(getContext()).inflate(R.layout.image_tag_view, this,true);
        mTagName=(TextView)findViewById(R.id.tag_name);
        mTagPrice=(TextView)findViewById(R.id.tag_price);
    }

    /**
     * 设置名字
     * @param tagName
     */
    public void setTagName(String tagName){
        if(mTagName!=null && !TextUtils.isEmpty(tagName)){
            mTagName.setText(tagName);
        }
    }

    /**
     * 设置价格
     * @param tagPrice
     */
    public void setTagPrice(String tagPrice){
        if(mTagPrice!=null && !TextUtils.isEmpty(tagPrice)){
            mTagPrice.setText(tagPrice);
        }
    }

    /**
     * 设置背景图片
     * @param tagBgBackgroundResource
     */
    public void setTagBgBackgroundResource(int tagBgBackgroundResource){
        setBackgroundResource(tagBgBackgroundResource);
    }

    /**
     * 设置背景色
     * @param tagBgColor
     */
    public void setTagBgBackgroundColor(int tagBgColor){
        setBackgroundColor(tagBgColor);
    }
}
