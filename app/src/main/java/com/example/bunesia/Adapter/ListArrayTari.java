package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelTari;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayTari extends ArrayAdapter<ModelTari> {

    private ArrayList<ModelTari> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayTari(Context context, int resource, ArrayList<ModelTari> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ListArrayTari.MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new ListArrayTari.MyHolder();

            holder.ListImageTari = convertView.findViewById(R.id.imgList);
            holder.ListJudulTari = convertView.findViewById(R.id.judulList);
            holder.ListAsalTari = convertView.findViewById(R.id.asalList);
            holder.HiddenIdTari = convertView.findViewById(R.id.HiddenId);

            convertView.setTag(holder);

        } else {

            holder = (ListArrayTari.MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarTari()).placeholder(R.drawable.kesenian_daerah_01).into(holder.ListImageTari);
        holder.ListJudulTari.setText(list.get(position).getJudulTari());
        holder.ListAsalTari.setText(list.get(position).getAsalTari());
        holder.HiddenIdTari.setText(list.get(position).getIdTari());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelTari object) {
        super.remove(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    static class MyHolder {

        ImageView ListImageTari;
        TextView ListJudulTari;
        TextView ListAsalTari;
        TextView HiddenIdTari;


    }
}
