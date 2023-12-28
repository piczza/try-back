import java.util.HashSet;
import java.util.Set;


public class CartApp{
    public static void main(String[] args) {
        Product book = new Product("책");
        Product mouse = new Product("마우스");
        Product phone = new Product("폰");

        //상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        productSet.add(book);
        productSet.add(mouse);
        productSet.add(phone);

        //상품 목록 확인
        System.out.println("고유한 상품 목록: ");
        for(Product product : productSet){
            System.out.println(product.getName() + " : " + product.getPrice());
        }
    }
}