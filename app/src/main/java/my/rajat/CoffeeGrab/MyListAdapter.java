package my.rajat.CoffeeGrab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajat on 2017-08-26.
 */

class MyListAdapter extends ArrayAdapter<context_data_model> {

    public MyListAdapter( Context context, ArrayList<context_data_model> list) {
        super(context, R.layout.row_layout, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        context_data_model item = getItem(position);

        LayoutInflater theinflator = LayoutInflater.from(getContext());
        View theView = theinflator.inflate(R.layout.row_layout, parent, false);

        TextView name = (TextView)theView.findViewById(R.id.textViewtitle);
        TextView description = (TextView)theView.findViewById(R.id.textViewdescription);
        TextView amount = (TextView)theView.findViewById(R.id.textViewamount);
        TextView time = (TextView)theView.findViewById(R.id.textViewtime);

        name.setText(item.getName());
        description.setText(item.getDescription());
        amount.setText(String.valueOf(item.getAmount()));
        time.setText(String.valueOf(item.getDt()));

        return theView;

    }
}
