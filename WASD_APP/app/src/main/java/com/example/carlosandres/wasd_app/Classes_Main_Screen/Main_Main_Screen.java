package com.example.carlosandres.wasd_app.Classes_Main_Screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.carlosandres.wasd_app.Classes_News_Screen.News_Main_Screen;
import com.example.carlosandres.wasd_app.Classes_Personal_Profile_Screen.My_Personal_Profile_Screen.My_Personal_Profile_Screen;
import com.example.carlosandres.wasd_app.Classes_Trends_Screen.Trends_Main_Screen;
import com.example.carlosandres.wasd_app.Classes_Upload_Publication_Screen.Upload_Publication_Main_Screen;
import com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data.View_Pager_Adapter;
import com.example.carlosandres.wasd_app.R;
import com.example.carlosandres.wasd_app.Support_Classes.Main_Support_Screen.About;
import com.example.carlosandres.wasd_app.Support_Classes.support_screen;

public class Main_Main_Screen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager IManager;

    private Toolbar toolbar;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] pageTitle = {"Publicaciones", "Usuarios"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
        List<Publication_Main_Screen> items = new ArrayList<>();

        items.add(new Publication_Main_Screen(R.drawable.f, "Esto es un texto de publicacion", "45", "87"));
        items.add(new Publication_Main_Screen(R.drawable.l, "Esto es OTRO text de prueba para una publicacion", "80", "357"));

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        IManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(IManager);

        adapter = new Publication_Adapter_Main_Screen(items);
        recycler.setAdapter(adapter);
*/


//set viewpager adapter





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                        Intent intent = new Intent (getApplicationContext(), Upload_Publication_Main_Screen.class);
                        startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        viewPager = (ViewPager)findViewById(R.id.view_pager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < pageTitle.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        View_Pager_Adapter pagerAdapter = new View_Pager_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tabs) {
                viewPager.setCurrentItem(tabs.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tabs) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tabs) {
            }
        });
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
        getMenuInflater().inflate(R.menu.main__main__screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(getApplicationContext(), support_screen.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            case R.id.action_exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

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
            Intent intent = new Intent(getApplicationContext(), My_Personal_Profile_Screen.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(getApplicationContext(), Upload_Publication_Main_Screen.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(getApplicationContext(), Trends_Main_Screen.class);
            startActivity(intent);
        } else if (id == R.id.nav_news) {
            Intent intent = new Intent(getApplicationContext(), News_Main_Screen.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



