package com.team4.erunn.confirmticket;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Confirm extends AppCompatActivity {

    private Menu menu;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.upper_button_ticket:
                    callTicketFragment();

//                    menu.getItem(R.id.bottom_button_search).setTitle(R.string.trainSearch);
                    return true;
                case R.id.upper_button_season_ticket:
                    callSeasonTicketFragment();
//                    menu.getItem(R.id.bottom_button_search).setTitle(R.string.seasonSearch);
                    return true;
                case R.id.bottom_button_home:
                    return true;
                case R.id.bottom_button_basket:
                    return true;
                case R.id.bottom_button_search:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        menu = (Menu)findViewById(R.id.bottom_menu);

        if (savedInstanceState == null)
            callTicketFragment();


        BottomNavigationView upperNavigationView = (BottomNavigationView) findViewById(R.id.upper_navigation);
        upperNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    void callTicketFragment() {
        android.app.Fragment fragment = new FragmentTicket();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_scene, fragment);
        fragmentTransaction.commit();

    }

    void callSeasonTicketFragment() {
        android.app.Fragment fragment = new FragmentSeasonTicket();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_scene, fragment);
        fragmentTransaction.commit();
    }


}
