package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.HomeDashboardItem;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomeDashBoardRecyclerAdapter extends RecyclerView.Adapter<HomeDashBoardRecyclerAdapter.ViewHolder> {
    ArrayList<HomeDashboardItem> homeDashboardItems=new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    public void setHomeDashboardItems(ArrayList<HomeDashboardItem> homeDashboardItems) {
        this.homeDashboardItems = homeDashboardItems;
    }

    // data is passed into the constructor
    public HomeDashBoardRecyclerAdapter(Context context) {
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.dashboardrecyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: "+homeDashboardItems.get(position).getTitle() );
        if(homeDashboardItems.size()>0){
        holder.txtTitleCashpot.setText(homeDashboardItems.get(position).getTitle());
        holder.imgLogoCashpot.setImageDrawable(context.getResources().getDrawable( homeDashboardItems.get(position).getLogo()));
        holder.cardCashpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) mClickListener.onItemClick( position);

            }
        });}
    }

    @Override
    public int getItemCount() {
        if(homeDashboardItems.size()>0)
        return homeDashboardItems.size();
        else
            return 0;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitleCashpot;
        ImageView imgLogoCashpot;
        CardView cardCashpot;

        ViewHolder(View itemView) {
            super(itemView);
            txtTitleCashpot = itemView.findViewById(R.id.txtTitleCashpot);
            imgLogoCashpot=itemView.findViewById(R.id.imgLogoCashpot);
            cardCashpot=itemView.findViewById(R.id.cardCashpot);
        }

        @Override
        public void onClick(View view) {
        }
    }

    public  void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}