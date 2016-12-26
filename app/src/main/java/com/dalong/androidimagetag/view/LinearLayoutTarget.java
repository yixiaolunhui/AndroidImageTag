package com.dalong.androidimagetag.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.ViewGroup;

/**
 * Created by zhouweilong on 2016/11/4.
 */

public class LinearLayoutTarget extends ViewGroupTarget<Bitmap> {
    private Context context;

    public LinearLayoutTarget(Context context, ViewGroup linearLayout) {

        super(linearLayout);

        this.context = context;
    }

    /**
     * Sets the {@link android.graphics.Bitmap} on the view using
     * {@link android.widget.ImageView#setImageBitmap(android.graphics.Bitmap)}.
     *
     * @param resource The bitmap to display.
     */
    @Override
    protected void setResource(Bitmap resource) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(new BitmapDrawable(context.getResources(), resource));
        }else{
            view.setBackgroundDrawable(new BitmapDrawable(context.getResources(), resource));
        }

    }
}
