package com.arba.menuwidget;

import android.content.ClipData;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CODE_LOGIN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences(CommonCode.FILE_PRIFERENCE, MODE_PRIVATE);

        if (pref.getBoolean(CommonCode.LOGIN_STATUS, false) == true) {
            NavigationView navView = findViewById(R.id.nav_view);
            menuSetTF(true, navView);

            xmlChanger(true, pref);
        } else {
            NavigationView navView = findViewById(R.id.nav_view);
            Menu menu = navView.getMenu();
            menuSetTF(false, navView);

            xmlChanger(false, pref);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_login) {
            Intent i = new Intent(MainActivity.this, LoginActivty.class);
            startActivityForResult(i, REQUEST_CODE_LOGIN);
        } else if (id == R.id.nav_logout) {
            NavigationView navView = findViewById(R.id.nav_view);
            Menu menu = navView.getMenu();
            menuSetTF(false, navView);

            SharedPreferences pref = getSharedPreferences(CommonCode.FILE_PRIFERENCE, MODE_PRIVATE);
            xmlChanger(false, pref);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //requestCode == REQUEST_CODE_LOGIN
        //requestCode == RESULT_OK or RESULT_FAIL
        //data == 처리된 결과 정보가 들어있음

        if (requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK) {
            boolean loginStatus = data.getBooleanExtra(CommonCode.LOGIN_STATUS, false);

            NavigationView navView = findViewById(R.id.nav_view);
            if (navView != null && loginStatus == true) {
                Menu menu = navView.getMenu();
                menuSetTF(true, navView);
            }
        }
    }

    private void menuSetTF(boolean login, NavigationView navView) {
        Menu menu = navView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(!login);
        menu.findItem(R.id.nav_logout).setVisible(login);
        menu.findItem(R.id.nav_regist).setVisible(!login);
        menu.findItem(R.id.nav_edit).setVisible(login);
    }

    private void xmlChanger(boolean value, SharedPreferences pref) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(CommonCode.LOGIN_STATUS, value);
        editor.apply();
    }
}
