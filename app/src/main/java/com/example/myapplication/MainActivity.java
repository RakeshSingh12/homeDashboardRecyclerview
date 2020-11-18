package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapter.HomeDashBoardRecyclerAdapter;
import com.example.myapplication.model.HomeDashboardItem;
import com.example.myapplication.util.ConnectivityUtils;

import java.util.ArrayList;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,HomeDashBoardRecyclerAdapter.ItemClickListener {
    private ArrayList<HomeDashboardItem> homeDashboardItems  = new ArrayList<>();
    public HomeDashBoardRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager( new GridLayoutManager(this,numberOfColumns));
        adapter =  new HomeDashBoardRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        initDashboardItems();
    }

    private void initDashboardItems() {
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.cashpot2, getString(R.string.cashpot), getString(R.string.cash_pot)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.pick_two), getString(R.string.pick2_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.pick_three), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.pick_four), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        homeDashboardItems.add(new HomeDashboardItem(R.drawable.pick2, getString(R.string.ticket_payouts), getString(R.string.pick3_url)));
        adapter.setHomeDashboardItems(homeDashboardItems);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(int position) {
        switch (homeDashboardItems.get(position).getTitle()) {
            case "Cashpot":
                if (ConnectivityUtils.isConnected(this)) {
                    //showProgressDialog();
                    Toast.makeText(MainActivity.this, "CashPot Click here", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Internet Connection", Toast.LENGTH_LONG).show();
                }
                break;

            case "Pick 2": {
                if (ConnectivityUtils.isConnected(this)) {
                    //showProgressDialog();
                    Toast.makeText(MainActivity.this, "Pick 2 Click here", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Internet Connection", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case "Pick 3": {
                if (ConnectivityUtils.isConnected(this)) {
                    //showProgressDialog();
                    Toast.makeText(MainActivity.this, "Pick 3 Click here", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Internet Connection", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }


        }
    }