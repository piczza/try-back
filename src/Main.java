import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.IntToDoubleFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("시작");

        linkedList<String> myList = new linkedList<>();

        myList.add("3");
        myList.add("굿");
        myList.add("잘 되는구만");
        myList.add("good");
        myList.toString();
        System.out.println("===========");

        for (String n : myList) System.out.println(n);

    }

}


