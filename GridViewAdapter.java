package com.teclever.test.slidingfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by teclever on 21/11/16.
 */
public class GridViewAdapter extends BaseAdapter
{
    String[] str={"one","two","three","four","five","six","seven","eight","nine","1","2","3","4","5","6","7","8","9","10"};
    MainActivity activity;
    String[] imageId=null;
   ImageView imageView;
    public GridViewAdapter(MainActivity activity, String[] imageId)
    {
        this.activity=activity;
        this.imageId=imageId;
    }
    @Override
    public int getCount()
    {
        return imageId.length;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflate = activity.getLayoutInflater();
        if(view==null)
        {
            view= inflate.inflate(R.layout.icons,null);
            imageView=(ImageView)view.findViewById(R.id.imageView);
           // Bitmap bitmap= BitmapFactory.decodeFile(imageId[i]);

           //  imageView.setImageBitmap(imageId[i]);

            Picasso.with(activity).load(imageId[i]).resize(300,300).into(imageView);
        }
        return view;
    }
}
