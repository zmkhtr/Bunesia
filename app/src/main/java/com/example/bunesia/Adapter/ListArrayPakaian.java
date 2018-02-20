package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelPakaian;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayPakaian extends ArrayAdapter<ModelPakaian> {

    private ArrayList<ModelPakaian> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayPakaian(Context context, int resource, ArrayList<ModelPakaian> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new MyHolder();

            holder.ListImagePakaian = convertView.findViewById(R.id.imgListSimple);
            holder.ListJudulPakaian = convertView.findViewById(R.id.listJudulsimple);
            holder.ListAsalPakaian = convertView.findViewById(R.id.listAsalsimple);
            holder.HiddenIdPakaian = convertView.findViewById(R.id.HiddenIdsimple);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarPakaian()).resize(80, 80).placeholder(R.drawable.adat_istiadatnew).into(holder.ListImagePakaian);
        holder.ListJudulPakaian.setText(list.get(position).getJudulPakaian());
        holder.ListAsalPakaian.setText(list.get(position).getAsalPakaian());
        holder.HiddenIdPakaian.setText(list.get(position).getIdPakaian());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelPakaian object) {
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

        ImageView ListImagePakaian;
        TextView ListJudulPakaian;
        TextView ListAsalPakaian;
        TextView HiddenIdPakaian;


    }
}
