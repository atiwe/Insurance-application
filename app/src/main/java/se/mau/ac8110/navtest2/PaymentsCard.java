package se.mau.ac8110.navtest2;

public class PaymentsCard {
    private String date;
    private String title;
    private String type;

    public PaymentsCard(String date, String title, String type) {
        this.date = date;
        this.title = title;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

}