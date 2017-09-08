package my.rajat.Offer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Detailed_Offer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_favor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        context_data_model detailed_favor = get_Intent();
        populateData(detailed_favor);
    }

    private context_data_model get_Intent(){
        Intent recieve_data_favor = getIntent();
        context_data_model detailed_favor = (context_data_model) recieve_data_favor.getSerializableExtra("detailed");
        return detailed_favor;
    }
    private void populateData(context_data_model item) {
        TextView title = (TextView) findViewById(R.id.favor_detailed_title);
        TextView category = (TextView) findViewById(R.id.favor_detailed_category);
        TextView amount = (TextView) findViewById(R.id.favor_detailed_amount);
        TextView description = (TextView) findViewById(R.id.favor_detailed_description);

        title.setText(item.getName());
        category.setText("Food");
        String amount_string = String.valueOf(item.getAmount());
        amount.setText(amount_string);
        description.setText(item.getDescription());
    }
    public void addToUserList(){
        Intent send_data_model = new Intent();
        send_data_model.putExtra("add_user_list", get_Intent());
        setResult(RESULT_OK, send_data_model);
        finish();
    }
    @Override
    public void onBackPressed() {
        Intent backpressed = new Intent();
        setResult(RESULT_CANCELED, backpressed);
        finish();
    }
}
