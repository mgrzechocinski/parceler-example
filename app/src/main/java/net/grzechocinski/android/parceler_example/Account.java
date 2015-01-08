package net.grzechocinski.android.parceler_example;

import org.parceler.Parcel;
import org.parceler.Transient;

@Parcel(converter = AccountConverter.class)
public class Account {

    String number;

    @Transient
    Owner owner;

    private Long uniqueKey;

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", owner=" + owner +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public long getUniqueKey() {
        return uniqueKey; //possibly, database_id or any other database identifier
    }
}
