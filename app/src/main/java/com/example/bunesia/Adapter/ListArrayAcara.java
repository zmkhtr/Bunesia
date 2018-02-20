package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.Model.ModelAcara;
import com.example.bunesia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListArrayAcara extends ArrayAdapter<ModelAcara> {

    private ArrayList<ModelAcara> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayAcara(Context context, int resource, ArrayList<ModelAcara> list) {
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

            holder.ListImageAcara = convertView.findViewById(R.id.imgListSimple);
            holder.ListJudulAcara = convertView.findViewById(R.id.listJudulsimple);
            holder.ListAsalAcara = convertView.findViewById(R.id.listAsalsimple);
            holder.HiddenIdAcara = convertView.findViewById(R.id.HiddenIdsimple);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/"+list.get(position).getGambarAcara()).resize(80, 80).placeholder(R.drawable.adat_istiadatnew).into(holder.ListImageAcara);
        holder.ListJudulAcara.setText(list.get(position).getJudulAcara());
        holder.ListAsalAcara.setText(list.get(position).getAsalAcara());
        holder.HiddenIdAcara.setText(list.get(position).getIdAcara());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelAcara object) {
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

        ImageView ListImageAcara;
        TextView ListJudulAcara;
        TextView ListAsalAcara;
        TextView HiddenIdAcara;


    }
}
