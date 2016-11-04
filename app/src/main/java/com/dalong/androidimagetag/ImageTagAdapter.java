package com.dalong.androidimagetag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.dalong.androidimagetag.view.LinearLayoutTarget;

import java.util.List;

/**
 * Created by zhouweilong on 2016/11/4.
 */

public class ImageTagAdapter extends BaseAdapter {

    List<ImageTag> list;
    Context mContext;

    public ImageTagAdapter(List<ImageTag> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.image_tag_listitem,null);
            holder=new ViewHolder();
            holder.imageTagLayout= (ImageTagLayout) convertView.findViewById(R.id.list_imagetag_layout);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        /**
         * 第一种
         */
//        Glide.with(mContext)
//                .load(list.get(position).getImageUrl())
//                .asBitmap().placeholder(R.drawable.test)
//                .into(new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                Drawable drawable =new BitmapDrawable(resource);
//                holder.imageTagLayout.setBackground(drawable);
//            }
//        });

        /**
         * 第二种
         */
        Glide.with(mContext)
                .load(list.get(position).getImageUrl())
                .asBitmap()
                .placeholder(R.drawable.test)//默认图 可以设置成ui设计的展位图
                .into(new LinearLayoutTarget(mContext, holder.imageTagLayout));


        ImageTagView imageTagView=new ImageTagView(mContext);
        imageTagView.setTagName(list.get(position).getName());
        imageTagView.setTagPrice(list.get(position).getPrice());
        imageTagView.setTagBgBackgroundResource(list.get(position).getTagBg());
        holder.imageTagLayout.addImageTag(imageTagView);
        return convertView;
    }

    class ViewHolder{
        ImageTagLayout  imageTagLayout;
    }
}
