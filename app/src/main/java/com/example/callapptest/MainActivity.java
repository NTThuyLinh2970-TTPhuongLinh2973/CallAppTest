package com.example.callapptest;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.cometchat.pro.core.AppSettings;
import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.User;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView barmenu;
    CallLog call_log = new CallLog();
    Dial dial = new Dial();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        barmenu = findViewById(R.id.buttonBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen,dial).commit();

        barmenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (item.getItemId() == R.id.calltab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen, dial).commit();
                    return true;
                }
                if (item.getItemId() == R.id.historytab) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen,call_log).commit();
                        return true;
                }

                return false;
            }
        });
    }
}