import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.IntToDoubleFunction;

public class Main {
    public static void main(String[] args) {
        linkedList<String> myList = new linkedList<>();

        myList.add("3");        //추가
        myList.add("굿");        //추가
        System.out.println(myList.get(1));//반환
        myList.delete(1);   //삭제
        myList.add("잘 되는구만"); //추가
        myList.add("good");     //추가
        myList.toString();      //투스트링 오버라이딩
        System.out.println("\n===========");
        myList.pop();           //마지막 제거
        myList.insert("헤헤");//처음에 추가
        myList.insert("히히");
        myList.toString();

        System.out.println("\n===========이하 포이치");
        for (String n : myList) System.out.println(n);//포이치

    }

}


