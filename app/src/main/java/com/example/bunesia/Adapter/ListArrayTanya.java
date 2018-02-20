package com.example.bunesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bunesia.Model.ModelTanya;
import com.example.bunesia.R;

import java.util.ArrayList;

/**
 * Created by acer on 2/19/2018.
 */


public class ListArrayTanya extends ArrayAdapter<ModelTanya> {

    private ArrayList<ModelTanya> list;
    private LayoutInflater inflater;
    private Context context;
    private int res;

    public ListArrayTanya(Context context, int resource, ArrayList<ModelTanya> list) {
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

            holder.namaPenanya = convertView.findViewById(R.id.namaPenanya);
            holder.jawaban = convertView.findViewById(R.id.jawaban);
            holder.pertanyaan = convertView.findViewById(R.id.pertanyaan);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        holder.namaPenanya.setText(list.get(position).getNama());
        holder.pertanyaan.setText(list.get(position).getPertanyaan());
        holder.jawaban.setText(list.get(position).getJawaban());


        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelTanya object) {
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


        TextView namaPenanya, pertanyaan, jawaban;


    }
}
