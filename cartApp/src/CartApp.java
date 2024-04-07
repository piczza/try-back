import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.*;

public class CartApp{
    public static void main(String[] args) {
        //상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        List<Product> myProducts = new ArrayList<>();

        //파일에서 읽어와서 상품 목록 생성
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/productList.csv"), "UTF-8"));
            while((line = br.readLine()) != null){
                String[] temp= line.split(",");

                Product tempP = new Product(temp[0], temp[1], Integer.parseInt(temp[2]));
                productSet.add(tempP);
                myProducts.add(tempP);
            }
        }catch (Exception e){
            System.out.println("오류가 발생했습니다.");
        }

        //상품 목록 확인
        System.out.println("진열된 상품 목록===================================");
        for(Product product : productSet){
            System.out.println(product.getKey() + ". " + product.getName() + ": " + product.getPrice() + "원");
        }
        System.out.println("===============================================");

        //장바구니
        Cart myCart = new Cart();

        //장바구니 숫자 입력으로 구현
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try {
            System.out.println("가능 행동: 추가/제거. 아래 양식에 맞춰 입력해주세요.");
            System.out.println("상품 번호, 상품 갯수, 원하는 행동 (ex: 1, 1, 추가)");
            while((str = reader.readLine()) != null){
                switch (str.split(",")[2].trim()){
                    case "추가":
                        int tempIdx = Integer.parseInt(str.split(",")[0].trim());
                        int tempAmount = Integer.parseInt(str.split(",")[1].trim());
                        if(tempIdx > myProducts.size()){
                            System.out.println("존재하지 않는 상품입니다. 다시 시도해주세요.");
                            break;
                        }
                        myCart.addProduct(myProducts.get(tempIdx-1), tempAmount);
                        myCart.showItems();
                        break;
                    case "제거":
                        int tempIdx2 = Integer.parseInt(str.split(",")[0].trim());
                        int tempAmount2 = Integer.parseInt(str.split(",")[1].trim());
                        if(tempIdx2 > myProducts.size()){
                            System.out.println("존재하지 않는 상품입니다. 다시 시도해주세요.");
                            break;
                        }
                        myCart.removeProduct(myProducts.get(tempIdx2-1), tempAmount2);
                        myCart.showItems();
                        break;
                    default:
                        System.out.println("지원하지 않는 기능입니다. 다시 시도해주세요.");
                        break;
                }


            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("형식에 맞지 않는 입력입니다.");
        }

    }

}