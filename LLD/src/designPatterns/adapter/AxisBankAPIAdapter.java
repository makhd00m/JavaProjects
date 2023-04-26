package designPatterns.adapter;

import designPatterns.adapter.banks.AXISApi;
import designPatterns.adapter.banks.ICICIApi;

public class AxisBankAPIAdapter implements BankAPIAdapter {

    private AXISApi axisApi;

    public AxisBankAPIAdapter() {
        this.axisApi = new AXISApi();
    }

    @Override
    public float checkBalance(String accountNo, String pin) {
        //logic for balance checking using AXIS bank APi.
        return 0;
    }

    @Override
    public boolean authenticate(String accountNo, String pin) {
        //logic for user authentication using AXIS bank API.
        return false;
    }

    @Override
    public boolean transaction(String fromAccountNo, String toAccountNo) {
        //logic for transaction using AXIS bank API.
        return false;
    }
}
