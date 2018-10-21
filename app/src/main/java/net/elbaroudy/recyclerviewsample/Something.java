package net.elbaroudy.recyclerviewsample;

class Something {
    private String price;
    private String name;
    private String day;

    public Something(String price, String name, String day) {
        this.price = price;
        this.name = name;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDay() {
        return day;
    }
}
