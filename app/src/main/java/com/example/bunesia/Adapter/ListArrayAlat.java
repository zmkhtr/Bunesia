package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelAlat;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayAlat extends ArrayAdapter<ModelAlat> {

    private ArrayList<ModelAlat> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayAlat(Context context, int resource, ArrayList<ModelAlat> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ListArrayAlat.MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new ListArrayAlat.MyHolder();

            holder.ListImageAlat = convertView.findViewById(R.id.imgList);
            holder.ListJudulAlat = convertView.findViewById(R.id.judulList);
            holder.ListAsalAlat = convertView.findViewById(R.id.asalList);
            holder.HiddenIdAlat = convertView.findViewById(R.id.HiddenId);

            convertView.setTag(holder);

        } else {

            holder = (ListArrayAlat.MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarAlat()).placeholder(R.drawable.kesenian_daerah_01).into(holder.ListImageAlat);
        holder.ListJudulAlat.setText(list.get(position).getJudulAlat());
        holder.ListAsalAlat.setText(list.get(position).getAsalAlat());
        holder.HiddenIdAlat.setText(list.get(position).getIdAlat());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelAlat object) {
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

        ImageView ListImageAlat;
        TextView ListJudulAlat;
        TextView ListAsalAlat;
        TextView HiddenIdAlat;


    }
}
