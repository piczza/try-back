import java.util.HashSet;
import java.util.Set;
import java.io.*;

public class CartApp{
    public static void main(String[] args) {
        //상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        Product book = new Product("책");
        Product mouse = new Product("마우스");
        Product phone = new Product("폰");
        productSet.add(book);
        productSet.add(mouse);
        productSet.add(phone);

        //상품 목록 확인
        System.out.println("고유한 상품 목록======================");
        for(Product product : productSet){
            System.out.println(product.getName() + ": " + product.getPrice() + "원");
        }

        //장바구니
        Cart myCart = new Cart();

        //장바구니에 상호작용
        myCart.addProduct(book, 5);

        myCart.showItems();
    }
}