package example9_Sorted;

public class Film {
    private String title;
    private double price;

    public Film() {
    }

    public Film(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

