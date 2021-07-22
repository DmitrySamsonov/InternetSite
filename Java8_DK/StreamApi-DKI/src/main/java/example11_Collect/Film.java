package example11_Collect;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Double.compare(film.price, price) == 0 && Objects.equals(title, film.title);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);


    }
}

