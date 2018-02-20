package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelSenjata;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArraySenjata extends ArrayAdapter<ModelSenjata> {

    private ArrayList<ModelSenjata> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArraySenjata(Context context, int resource, ArrayList<ModelSenjata> list) {
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

            holder.ListImageSenjata = convertView.findViewById(R.id.imgListSimple);
            holder.ListJudulSenjata = convertView.findViewById(R.id.listJudulsimple);
            holder.ListAsalSenjata = convertView.findViewById(R.id.listAsalsimple);
            holder.HiddenIdSenjata = convertView.findViewById(R.id.HiddenIdsimple);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarSenjata()).resize(80, 80).placeholder(R.drawable.adat_istiadatnew).into(holder.ListImageSenjata);
        holder.ListJudulSenjata.setText(list.get(position).getJudulSenjata());
        holder.ListAsalSenjata.setText(list.get(position).getAsalSenjata());
        holder.HiddenIdSenjata.setText(list.get(position).getIdSenjata());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelSenjata object) {
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

        ImageView ListImageSenjata;
        TextView ListJudulSenjata;
        TextView ListAsalSenjata;
        TextView HiddenIdSenjata;


    }
}
