package se.mau.ac8110.navtest2;

public class Card {
    private String ensurance;
    private String date;

    public Card(String ensurance, String date) {
        this.ensurance = ensurance;
        this.date = "Giltig till: " + date;
    }

    public String getLine1() {
        return ensurance;
    }

    public String getLine2() {
        return date;
    }

}