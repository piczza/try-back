
public class Product{
    private static int keyNum = 0;
    private final int key;
    private final String name;
    private final int price;

    public Product(String name) {
        this.name = name;
        this.price = (int) (Math.random() * 50) * 100;
        this.key = keyNum++;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getKey() { return key; }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return product.key == key;
    }
    @Override
    public int hashCode() {
        return key;
    }
}
