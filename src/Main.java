import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.IntToDoubleFunction;

public class Main {
    public static void main(String[] args) {
        linkedList<String> myList = new linkedList<>();
        myList.add("내가");
        myList.add("해냄");
        myList.add("와!");

        for(String str : myList){
            System.out.println(str);
        }



    }

}


