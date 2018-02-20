package com.example.bunesia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by acer on 2/20/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<String> mText = new ArrayList<>();
    ArrayList<String> mImage = new ArrayList<>();
    Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> text, ArrayList<String> image) {
        mText = text;
        mImage = image;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.imgMain);
        holder.textMain.setText(mText.get(position));

        holder.imgMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                final Intent intent;
                switch (position){
                    case 0:
                        intent =  new Intent(mContext, CeritaDaerahActivity.class);
                        break;

                    case 1:
                        intent =  new Intent(mContext, KesenianDaerahActivity.class);
                        break;

                    case 2:
                        intent =  new Intent(mContext, AdatIstiadatActivity.class);
                        break;

                    case 3:
                        intent =  new Intent(mContext, TanyaBuNesiaActivity.class);
                        break;

                    case 4:
                        intent =  new Intent(mContext, QuizBuNesiaActivity.class);
                        break;

                    default:
                        intent =  new Intent(mContext, MainActivity.class);
                        break;
                }
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgMain;
        TextView textMain;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMain = itemView.findViewById(R.id.imgMain);
            textMain = itemView.findViewById(R.id.textMain);
            mContext = itemView.getContext();
        }

    }
}
