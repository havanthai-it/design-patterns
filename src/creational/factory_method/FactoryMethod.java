package creational.factory_method;

import com.sun.javaws.exceptions.InvalidArgumentException;

import static creational.factory_method.BankType.VCB;

public class FactoryMethod {
}



class BankFactory {
    public Bank getBank(BankType bankType) {
        Bank bank;
        switch (bankType) {
            case VCB:
                bank = new Vietcombank();
                break;
            case TPB:
                bank = new Tpbank();
                break;
            default:
                throw new IllegalArgumentException("Invalid bank type!");
        }
        return bank;
    }
}

enum BankType {
    VCB,
    TPB
}

interface Bank {
    String getBankName();
}

class Vietcombank implements Bank {

    @Override
    public String getBankName() {
        return "Vietcombank";
    }
}

class Tpbank implements Bank {

    @Override
    public String getBankName() {
        return "Tpbank";
    }
}