package com.dalong.androidimagetag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * Created by zhouweilong on 2016/11/3.
 */

public class ImageTagLayout extends ViewGroup {
    //控件的宽
    public int width;
    //控件的高
    public int height;

    public ImageTagLayout(Context context) {
        this(context,null);
    }

    public ImageTagLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImageTagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChild(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //设置宽度
        if (widthMode == MeasureSpec.EXACTLY) { // match_parent
            width = widthSize;
        } else {
            // 由图片决定的宽
            int desireByImg = getPaddingLeft() + getPaddingRight() + getBackground().getIntrinsicWidth();
            // wrap_content
            width = Math.min(widthSize, desireByImg);
        }
        //设置高度
        if (heightMode == MeasureSpec.EXACTLY) { // match_parent
            height = heightSize;
        } else {
            //计算实际背景图的图片比例
            if(getBackground()!=null){
                double ratio=1.0d*getBackground().getIntrinsicHeight()/getBackground().getIntrinsicWidth();
                height= (int) (ratio*width);
            }
            height = Math.min(height, heightSize);
        }
        setMeasuredDimension(width,height);
    }

    /**
     * 测量子view
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    private void measureChild(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            if (v != null) {
                measureChild(v,widthMeasureSpec, heightMeasureSpec);
            }
        }

    }


    /**
     * 确定子View位置
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int releaseWidth=getMeasuredWidth()-getPaddingLeft()-getPaddingRight();
        int releaseheight=getMeasuredHeight()-getPaddingTop()-getPaddingBottom();
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            if (v != null) {
                int childWidth=v.getMeasuredWidth();
                int childHeight=v.getMeasuredHeight();
                int left=getPaddingLeft();
                int top=getPaddingTop();
                //随机位置,还可以做下，位置确认，避免item重叠在一起
                int offsetX=getRandom(100,Math.max(0,releaseWidth-childWidth));
                int offsetY=getRandom(100,Math.max(0,releaseheight-childHeight));
                v.layout(left+offsetX, top+offsetY, left+childWidth+offsetX, top+childHeight+offsetY);
            }
        }
    }

    /**
     * 添加view
     * @param view
     */
    public void addImageTag(final View view){
        removeAllViews();
        addView(view);
    }


    /**
     * 随机位置
     * @param start
     * @param end
     * @return
     */
    public int getRandom(int start,int end){
        int number = (int) (Math.random() * (end-start+1)) + start;
        return number;
    }


}
