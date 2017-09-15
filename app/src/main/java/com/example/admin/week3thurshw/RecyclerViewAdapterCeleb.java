package com.example.admin.week3thurshw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Admin on 9/13/2017.
 */

public class RecyclerViewAdapterCeleb extends RecyclerView.Adapter<RecyclerViewAdapterCeleb.ViewHolder> {
    
RecyclerView rvCelebList;
    private RecyclerViewAdapterCeleb.OnViewHolderInteractionListener mListener;
    private static final String TAG = "RecyclerViewAdapterCeleb";
    List<Celebrity> celebrityList = new ArrayList<>();
    Context context;

    public RecyclerViewAdapterCeleb( List<Celebrity> celebrityList) {

        this.celebrityList = celebrityList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName ;

        private ImageView imageDisplay;


        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            imageDisplay = itemView.findViewById(R.id.imageDisplay);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //    Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_celeb_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
      //  Log.d(TAG, "onBindViewHolder position: "+position);
        Celebrity celebrity = celebrityList.get(position);

        holder.tvName.setText(celebrity.getName());

        holder.imageDisplay.setImageResource(celebrity.getImageID());
        holder.imageDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null) {
                    //  Toast.makeText(context, position+"" , Toast.LENGTH_SHORT).show();
                    mListener.onViewHolderInteraction(String.valueOf(position));
                }
                //    Toast.makeText(context, "click" , Toast.LENGTH_SHORT).show();
            }
        });
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null) {
                  //  Toast.makeText(context, position+"" , Toast.LENGTH_SHORT).show();
                    mListener.onViewHolderInteraction(String.valueOf(position));
                }
            //    Toast.makeText(context, "click" , Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {

        return celebrityList.size();
    }

    //Dismiss
    public void dismissAnimal(int pos) {
        this.celebrityList.remove(pos);
        this.notifyItemRemoved(pos);
    }


    public interface OnViewHolderInteractionListener {
        void onViewHolderInteraction(String data);
    }

    public void setListener(RecyclerViewAdapterCeleb.OnViewHolderInteractionListener listener) {
        this.mListener = listener;
    }
}
