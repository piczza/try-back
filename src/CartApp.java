import java.util.HashSet;
import java.util.Set;
import java.io.*;

public class CartApp{
    public static void main(String[] args) {
        //상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/productList.csv"), "UTF-8"));
            while((line = br.readLine()) != null){
                String[] temp= line.split(",");

                Product tempP = new Product(temp[0], temp[1], Integer.parseInt(temp[2]));
                productSet.add(tempP);

            }
        }catch (Exception e){
            System.out.println("오류가 발생했습니다.");
        }

        //상품 목록 확인
        System.out.println("진열된 상품 목록======================");
        for(Product product : productSet){
            System.out.println(product.getName() + ": " + product.getPrice() + "원");
        }

        //장바구니
        Cart myCart = new Cart();

        //장바구니에 상호작용

        myCart.showItems();
    }
}