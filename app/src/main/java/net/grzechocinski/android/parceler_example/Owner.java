package net.grzechocinski.android.parceler_example;

import java.util.List;
import org.parceler.Parcel;
import org.parceler.Transient;

@Parcel
public class Owner {

    String name;

    List<Account> accounts;

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", accounts=#" + (accounts == null ? "0" : accounts.size()) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
