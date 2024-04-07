import java.util.Objects;

public class Product{
    private final String key;
    private final String name;
    private final int price;

    public Product(String key, String name, int price) {
        this.name = name;
        this.price = price;
        this.key = key;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getKey() { return key; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() == obj.getClass()) return false;
        Product temp = (Product) obj;
        return price == temp.price && Objects.equals(temp.name, name) && Objects.equals(temp.key, key);
    }
    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
