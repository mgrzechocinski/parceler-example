package net.grzechocinski.android.parceler_example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import org.parceler.Parcels;

public class SecondActivity extends ActionBarActivity {

    public static final String OWNER_INTENT_KEY = "OWNER_INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView ownerTextView = (TextView) findViewById(R.id.owner);
        Owner owner = Parcels.unwrap(getIntent().getParcelableExtra(OWNER_INTENT_KEY));
        ownerTextView.setText(owner.toString());
    }

    public static Intent openForOwner(Context context, @NonNull Owner owner) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(OWNER_INTENT_KEY, Parcels.wrap(owner));
        return intent;
    }
}
