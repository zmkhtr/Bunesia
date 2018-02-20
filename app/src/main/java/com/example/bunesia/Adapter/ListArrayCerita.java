package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelCerita;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayCerita extends ArrayAdapter<ModelCerita> {

    private ArrayList<ModelCerita> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayCerita(Context context, int resource, ArrayList<ModelCerita> list) {
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

            holder.ListImageCerita = convertView.findViewById(R.id.imgListSimple);
            holder.ListJudulCerita = convertView.findViewById(R.id.listJudulsimple);
            holder.ListAsalCerita = convertView.findViewById(R.id.listAsalsimple);
            holder.HiddenIdCerita = convertView.findViewById(R.id.HiddenIdsimple);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarCerita()).resize(80, 80).placeholder(R.drawable.cerita_daerah_01).into(holder.ListImageCerita);
        holder.ListJudulCerita.setText(list.get(position).getJudulCerita());
        holder.ListAsalCerita.setText(list.get(position).getAsalCerita());
        holder.HiddenIdCerita.setText(list.get(position).getIdCerita());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelCerita object) {
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

        ImageView ListImageCerita;
        TextView ListJudulCerita;
        TextView ListAsalCerita;
        TextView HiddenIdCerita;


    }
}
