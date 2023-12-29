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
        if(cart.containsKey(product)) cart.replace(product,cart.get(product)-amount);
        if(cart.get(product) <= 0) cart.remove(product);
    }

    //화면에 장바구니 출력================
    public void showItems(){
        System.out.println("내 카트 출력=========================");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()){
            System.out.printf("%s가 %d개", entry.getKey().getName(), entry.getValue());
        }
    }



}
