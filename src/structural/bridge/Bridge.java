package structural.bridge;

public class Bridge {
    public static void main(String[] args) {
        Bank vcb = new Vietcombank(new CheckingAccount());
        vcb.openAccount();

        Bank tpb = new Tpbank(new SavingAccount());
        tpb.openAccount();
    }
}

abstract class Account {
    abstract void openAccount();
}

class CheckingAccount extends Account {

    @Override
    public void openAccount() {
        System.out.println("Open checking account");
    }
}

class SavingAccount extends Account {

    @Override
    public void openAccount() {
        System.out.println("Open saving account");
    }
}

abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract void openAccount();
}

class Tpbank extends Bank {
    public Tpbank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Open account for Tpbank");
        account.openAccount();
    }
}

class Vietcombank extends Bank {
    public Vietcombank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Open account for Vietcombank");
        account.openAccount();
    }
}
