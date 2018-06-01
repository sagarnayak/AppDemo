package com.example.sagar.appdemo.ui.dashboard.master;

import com.example.sagar.appdemo.R;
import com.example.sagar.appdemo.ui.dashboard.pojo.GridItem;

import java.util.ArrayList;

public class GridMaster {
    public static ArrayList<GridItem> getGridItems() {
        ArrayList<GridItem> gridItems = new ArrayList<>();

        gridItems.add(
                new GridItem(
                        R.drawable.avatar,
                        "My Profile"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.fund_transfer,
                        "Fund Transfer"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.payment,
                        "Payment"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.transition_report,
                        "Transaction Report"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.register,
                        "Register"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.top_up,
                        "Top Up"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.other,
                        "Other"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.search,
                        "Search"
                )
        );
        gridItems.add(
                new GridItem(
                        R.drawable.settings,
                        "Settings"
                )
        );

        return gridItems;
    }
}
