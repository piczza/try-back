import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart = new HashMap<>();

    //추가=============================
    public void addProduct(Product product, int amount){
        cart.merge(product, amount, Integer::sum); //캬! 머지!
    }

    //삭제=============================
    public void removeProduct(Product product, int amount){
        if(cart.containsKey(product)) cart.put(product,cart.get(product)-amount);
        else {
            System.out.println("이미 존재하지 않는 상품입니다");
            cart.put(product,-1);
        }
        if(cart.get(product) <= 0) cart.remove(product);

    }

    //화면에 장바구니 출력================
    public void showItems(){
        System.out.println("내 장바구니 출력==================================");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()){
            System.out.printf("%s: %d개\n", entry.getKey().getName(), entry.getValue());
        }
        System.out.println("==============================================");
    }


}
