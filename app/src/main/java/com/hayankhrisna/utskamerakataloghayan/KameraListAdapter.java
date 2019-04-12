package com.hayankhrisna.utskamerakataloghayan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class KameraListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Kamera> kamerasList;

    public KameraListAdapter(Context context, int layout, ArrayList<Kamera> kamerasList) {
        this.context = context;
        this.layout = layout;
        this.kamerasList = kamerasList;
    }

    @Override
    public int getCount() {
        return kamerasList.size();
    }

    @Override
    public Object getItem(int position) {
        return kamerasList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.imgKamera);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Kamera kamera = kamerasList.get(position);

        holder.txtName.setText(kamera.getName());
        holder.txtPrice.setText(kamera.getPrice());

        byte[] kameraImage = kamera.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(kameraImage, 0, kameraImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
