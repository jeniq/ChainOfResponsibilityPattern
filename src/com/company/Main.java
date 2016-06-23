package com.company;

public class Main {

    public static void main(String[] args) {
	    NoteModule note500 = new NoteModule500();
        NoteModule note200 = new NoteModule200();
        NoteModule note100 = new NoteModule100();
        NoteModule note50 = new NoteModule50();
        note500.setNextMoneyModule(note200);
        note200.setNextMoneyModule(note100);
        note100.setNextMoneyModule(note50);

        note500.takeMoney(new Money(950));

    }
}

class Note{
    public static final int D50 = 50;
    public static final int D100 = 100;
    public static final int D200 = 200;
    public static final int D500 = 500;
}

class Money{
    private int amt;

    public Money(int amt){
        setAmt(amt);
    }

    public int getAmt(){
        return amt;
    }

    public void setAmt(int amt){
        if (amt > 0 && amt <= 100_000 && amt%Note.D50 == 0){
            this.amt = amt;
        }else{
            throw new RuntimeException("Amount should be no more than 100 000 and multiple 50");
        }
    }
}

abstract class NoteModule{
    protected NoteModule next;

    abstract void takeMoney(Money money);

    void setNextMoneyModule(NoteModule module){
        next = module;
    }
}

class NoteModule500 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.D500;
        int remind = money.getAmt()%Note.D500;
        if (countNote > 0){
            System.out.println("Issued " + countNote + " banknote of " + Note.D500);
        }
        if (remind > 0 && next != null){
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule200 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.D200;
        int remind = money.getAmt()%Note.D200;
        if (countNote > 0){
            System.out.println("Issued " + countNote + " banknote of " + Note.D200);
        }
        if (remind > 0 && next != null){
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule100 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.D100;
        int remind = money.getAmt()%Note.D100;
        if (countNote > 0){
            System.out.println("Issued " + countNote + " banknote of " + Note.D100);
        }
        if (remind > 0 && next != null){
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule50 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.D50;
        int remind = money.getAmt()%Note.D50;
        if (countNote > 0){
            System.out.println("Issued " + countNote + " banknote of " + Note.D50);
        }
        if (remind > 0 && next != null){
            next.takeMoney(new Money(remind));
        }
    }
}