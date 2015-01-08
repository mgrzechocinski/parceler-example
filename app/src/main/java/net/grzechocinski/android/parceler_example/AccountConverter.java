package net.grzechocinski.android.parceler_example;

import android.os.Parcel;
import java.util.HashMap;
import java.util.Map;
import org.parceler.ParcelConverter;
import org.parceler.Parcels;

public class AccountConverter implements ParcelConverter<Account> {

    Map<Long, Owner> parents = new HashMap<>();

    @Override
    public void toParcel(Account input, Parcel parcel) {
        parcel.writeParcelable(Parcels.wrap(input), 0);
        parents.put(input.getUniqueKey(), input.getOwner());
    }

    @Override
    public Account fromParcel(Parcel parcel) {
        Account account = Parcels.unwrap(parcel.readParcelable(getClass().getClassLoader()));
        account.setOwner(parents.get(account.getUniqueKey()));
        return account;
    }
}
