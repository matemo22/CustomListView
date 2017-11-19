package com.example.matemo.a20415005_jeffersonphinardikosasih;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matemo on 9/21/2017.
 */

public class BarangAdapter extends ArrayAdapter<Barang>
{
    public BarangAdapter(Context context, ArrayList<Barang> data)
    {
        super(context, R.layout.item_barang, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Barang barang = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_barang, parent, false);
        }

        TextView txtNama = (TextView) convertView.findViewById(R.id.textViewNama);
        TextView txtId = (TextView) convertView.findViewById(R.id.textViewId);
        TextView txtHarga = (TextView) convertView.findViewById(R.id.textViewHarga);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        txtNama.setText(barang.getNama());
        txtId.setText(barang.getId());
        txtHarga.setText("Rp "+barang.getHarga()+",-");
        img.setImageResource(barang.getImg());

        return convertView;
    }
}