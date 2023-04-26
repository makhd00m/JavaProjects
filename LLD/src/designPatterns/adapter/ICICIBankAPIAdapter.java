package designPatterns.adapter;

import designPatterns.adapter.banks.ICICIApi;
import designPatterns.factory.SupportedPlatform;

public class ICICIBankAPIAdapter implements BankAPIAdapter {
    private ICICIApi iciciApi;

    public ICICIBankAPIAdapter() {
        this.iciciApi = new ICICIApi();
    }

    @Override
    public float checkBalance(String accountNo, String pin) {
        // logic for balance checking using ICICI bank API.
        return 0;
    }

    @Override
    public boolean authenticate(String accountNo, String pin) {
        // logic for user authentication using ICICI bank API.
        return false;
    }

    @Override
    public boolean transaction(String fromAccountNo, String toAccountNo) {
        // logic for transaction using ICICI bank API.
        return false;
    }
}
