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
        parcel.writeParcelable(Parcels.wrap(new AccountParcelableWrapper(input)), 0);
        parents.put(input.getUniqueKey(), input.getOwner());
    }

    @Override
    public Account fromParcel(Parcel parcel) {
        AccountParcelableWrapper account = Parcels.unwrap(parcel.readParcelable(getClass().getClassLoader()));
        account.setOwner(parents.get(account.getUniqueKey()));
        return account;
    }

    //Override annotation from super class - we don't need converter anymore
    @org.parceler.Parcel
    public static class AccountParcelableWrapper extends Account{

        public AccountParcelableWrapper() {
        }

        //Deep copy
        public AccountParcelableWrapper(Account account) {
            this.number = account.getNumber();
            this.owner = account.getOwner();
        }
    }
}
