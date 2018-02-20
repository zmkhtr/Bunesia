package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelRumah;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayRumah extends ArrayAdapter<ModelRumah> {

    private ArrayList<ModelRumah> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayRumah(Context context, int resource, ArrayList<ModelRumah> list) {
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

            holder.ListImageRumah = convertView.findViewById(R.id.imgListSimple);
            holder.ListJudulRumah = convertView.findViewById(R.id.listJudulsimple);
            holder.ListAsalRumah = convertView.findViewById(R.id.listAsalsimple);
            holder.HiddenIdRumah = convertView.findViewById(R.id.HiddenIdsimple);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarRumah()).resize(80, 80).placeholder(R.drawable.adat_istiadatnew).into(holder.ListImageRumah);
        holder.ListJudulRumah.setText(list.get(position).getJudulRumah());
        holder.ListAsalRumah.setText(list.get(position).getAsalRumah());
        holder.HiddenIdRumah.setText(list.get(position).getIdRumah());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelRumah object) {
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

        ImageView ListImageRumah;
        TextView ListJudulRumah;
        TextView ListAsalRumah;
        TextView HiddenIdRumah;


    }
}
