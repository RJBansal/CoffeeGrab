package my.rajat.Offer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Add_Offer extends AppCompatActivity {

    String category, delivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favor);

        addItemsToCategorySpinner();
        addItemsToDeliverySpinner();
    }

    private void addItemsToDeliverySpinner() {

        String[] delivery_array = {"Delivery", "Pickup", "N/A"};
        Spinner delivery_spinner = (Spinner)findViewById(R.id.delivery_spinner);

        ArrayAdapter<CharSequence> deliveryAdapter = new ArrayAdapter<CharSequence>
                (this, android.R.layout.simple_spinner_item, delivery_array);
        deliveryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        delivery_spinner.setAdapter(deliveryAdapter);

        delivery_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                delivery = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                TextView error = (TextView)findViewById(R.id.select);
                error.setError("Must Select an option");
            }
        });

    }


    private void addItemsToCategorySpinner() {

        Spinner category_spinner = (Spinner)findViewById(R.id.category_spinner);

        ArrayAdapter<CharSequence> SpinnerAdapter = ArrayAdapter.createFromResource
                (this, R.array.favor_categories, android.R.layout.simple_spinner_item);

        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(SpinnerAdapter);

        addListenerToCategorySpinner(category_spinner);

    }

    private void addListenerToCategorySpinner(Spinner spin) {

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                category = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                TextView error = (TextView)findViewById(R.id.category);
                error.setError("Must Select a category");
            }
        });
    }


    public void onSendContext(View view) {
        EditText titleET = (EditText)findViewById(R.id.edit_text_title);
        EditText descriptionET = (EditText)findViewById(R.id.edit_text_description);
        EditText amountET = (EditText)findViewById(R.id.edit_text_amount);

        if(titleET.getText().toString().trim().equals("")){
            titleET.setError(getString(R.string.error_title_required));
        }
        else if(descriptionET.getText().toString().trim().equals("")){
            descriptionET.setError(getString(R.string.error_description_required));
        }
        else if(amountET.getText().toString().trim().equals("")){
            amountET.setError(getString(R.string.error_amount_required));
        }
        else {
            String title = String.valueOf(titleET.getText());
            String description = String.valueOf(descriptionET.getText());
            int amount = Integer.parseInt(amountET.getText().toString());

            Intent send_data_back = new Intent();

            send_data_back.putExtra("title", title);
            send_data_back.putExtra("description", description);
            send_data_back.putExtra("amount", amount);
            send_data_back.putExtra("category", category);
            send_data_back.putExtra("deliver", delivery);

            setResult(RESULT_OK, send_data_back);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent backbutton = new Intent();
        setResult(RESULT_CANCELED, backbutton);
        finish();
    }
}
