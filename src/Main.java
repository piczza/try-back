public class Main {
    public static void main(String[] args) {
        System.out.println("시작");

        linkedList<Integer> myList = new linkedList<>();

        myList.add(123);
        myList.add(3);
        myList.add(6767);
        myList.add(99);
        myList.toString();
        System.out.println("===");
        System.out.println(myList.poll());
        System.out.println(myList.toString());
        System.out.println(myList.dequeue());
        System.out.println(myList.poll());
        System.out.println(myList.toString());



    }
}