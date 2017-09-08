package my.rajat.Offer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class userList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<context_data_model> userlist = get_Intent();
    }
    private ArrayList<context_data_model> get_Intent(){
        Intent recieve_data_favor = getIntent();
        ArrayList<context_data_model> detailed_favor = (ArrayList<context_data_model>) recieve_data_favor.getSerializableExtra("userlist");
        return detailed_favor;
    }
    private void initListView(ArrayList<context_data_model> list ) {
        //ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        MyListAdapter theAdapter = new MyListAdapter(this, list);
        ListView theListView = (ListView) findViewById(R.id.theListView);

        theListView.setAdapter(theAdapter);
    }
}
