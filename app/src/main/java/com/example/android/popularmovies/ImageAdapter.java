package com.example.android.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acowell on 4/12/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mImageUrls = new ArrayList<String>();

    public ImageAdapter(Context c, List<String> imageUrls) {
        mContext = c;
        mImageUrls = imageUrls;
    }

    public int getCount() {
        return mImageUrls.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
       //     imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(mImageUrls.get(position))
                .into(imageView);

        //   imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


}
