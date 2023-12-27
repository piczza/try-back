public class Main {
    public static void main(String[] args) {
        System.out.println("시작");

        linkedList myLinkedList = new linkedList();
        myLinkedList.add(1);
        myLinkedList.add(4.454);
        myLinkedList.add('우');
        myLinkedList.add('와');
        myLinkedList.add("되는거같은데");
//        myLinkedList.add(new char[] {'되', '나'}); // 출력이 안되네ㅠㅠ

        System.out.println(myLinkedList.toString());
        myLinkedList.delete(0);
        System.out.println(myLinkedList.toString());


    }
}