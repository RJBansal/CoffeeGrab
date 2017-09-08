package my.rajat.Offer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final int add_favor_activity_request_code = 1;
    final int detailed_favor_request_code = 2;
    final int user_list_request_code = 3;

    ArrayList<context_data_model> array_of_Favors = new ArrayList<context_data_model>();
    ArrayList<context_data_model> array_of_User_Favors = new ArrayList<context_data_model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add_Offer.class);
                startActivityForResult(intent, add_favor_activity_request_code);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        array_of_Favors.add(new context_data_model("hey","work","asshole","Pickup",100,101));
        initListView(array_of_Favors);
    }

    private void initListView(ArrayList<context_data_model> list ) {

        MyListAdapter theAdapter = new MyListAdapter(this, list);
        ListView theListView = (ListView) findViewById(R.id.theListView);

        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                context_data_model item_selected = (context_data_model) adapterView.getItemAtPosition(i);
                Intent detailed_intent = new Intent(MainActivity.this, Detailed_Offer.class);
                detailed_intent.putExtra("detailed", item_selected);

                startActivityForResult(detailed_intent, detailed_favor_request_code);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == add_favor_activity_request_code) {
            if (resultCode == RESULT_OK) {
                String favor_title = data.getStringExtra("title");
                String favor_description = data.getStringExtra("description");
                int favor_amount = data.getIntExtra("amount", 0);
                String favor_category = data.getStringExtra("category");
                String favor_devlivery = data.getStringExtra("deliver");

                context_data_model create_new = new context_data_model(favor_title, favor_description, favor_category,favor_devlivery,
                        favor_amount, 60);
                array_of_Favors.add(create_new);
                initListView(array_of_Favors);
            }
        }
        if(requestCode == detailed_favor_request_code && resultCode == RESULT_OK){
            context_data_model item = (context_data_model) data.getSerializableExtra("add_user_list");
            array_of_User_Favors.add(item);
        }
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
       /// getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_userlist) {
            Intent userlist = new Intent(MainActivity.this, userList.class);
            userlist.putExtra("userlist", array_of_User_Favors);
            startActivityForResult(userlist, user_list_request_code);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
