package com.example.kleocida.lakebalatontourguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {

    private final static String TAG = PlaceAdapter.class.getSimpleName();

    private Context mContext;
    private List<Place> mPlace;


    public PlaceAdapter(Context context, List<Place> meals) {
        mContext = context;
        mPlace = meals;
    }

    @Override
    public PlaceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_place, parent, false);
        return new PlaceAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.MyViewHolder holder, int position) {
        Place meal = mPlace.get(position);
        holder.mNameText.setText(meal.getName());
        holder.mImageView.setImageResource(meal.getImage());
        holder.mDescText.setText(meal.getDescription());
        startActivityOnClick(holder);
    }

    private void startActivityOnClick(final MyViewHolder holder) {
        final Bundle params = new Bundle();
        params.putString("meal", holder.mNameText.getText().toString());
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "adapter position: " + holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlace.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameText;
        public ImageView mImageView;
        public TextView mDescText;
        public View mView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView) itemView.findViewById(R.id.titleText);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mDescText = (TextView) itemView.findViewById(R.id.descriptionText);
            mView = itemView;
        }
    }

}
