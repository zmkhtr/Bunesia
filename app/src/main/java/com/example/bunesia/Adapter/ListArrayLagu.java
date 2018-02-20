package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelLagu;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayLagu extends ArrayAdapter<ModelLagu> {

    private ArrayList<ModelLagu> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayLagu(Context context, int resource, ArrayList<ModelLagu> list) {
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

            holder.ListImageLagu = convertView.findViewById(R.id.imgListSimple);
            holder.ListJudulLagu = convertView.findViewById(R.id.listJudulsimple);
            holder.ListAsalLagu = convertView.findViewById(R.id.listAsalsimple);
            holder.HiddenIdLagu = convertView.findViewById(R.id.HiddenIdsimple);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarLagu()).resize(80, 80).placeholder(R.drawable.ic_play_arrow).into(holder.ListImageLagu);
        holder.ListJudulLagu.setText(list.get(position).getJudulLagu());
        holder.ListAsalLagu.setText(list.get(position).getAsalLagu());
        holder.HiddenIdLagu.setText(list.get(position).getIdLagu());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelLagu object) {
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

        ImageView ListImageLagu;
        TextView ListJudulLagu;
        TextView ListAsalLagu;
        TextView HiddenIdLagu;


    }
}
