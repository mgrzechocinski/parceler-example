package net.grzechocinski.android.parceler_example;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import java.util.Arrays;
import org.parceler.Parcels;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Owner owner = new Owner();
        owner.setName("John Brown");

        Account account1 = new Account();
        account1.setNumber("1234567890");
        account1.setOwner(owner);

        owner.setAccounts(Arrays.asList(account1));

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.OWNER_INTENT_KEY, Parcels.wrap(owner));

        startActivity(intent);
    }
}
