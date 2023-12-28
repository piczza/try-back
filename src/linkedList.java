import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class linkedList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node { //각 노드!
        private final T data;
        private Node nextNode;
        private int idx;
        private Node preNode; //이전 노드 넣어서 양방향 검색 쉽게 해봐야지!

        public Node(T input) {
            this.data = input;
            this.nextNode = null;
            this.preNode = null;
            this.idx = size;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getIdx() {
            return idx;
        }

        public T getData() {
            return data;
        }
    }

    @Override
    public String toString() {
        if (head == null) return "-1";
        else {
            Node tempNode = head;
            for (int i = 0; i < size(); i++) {
                System.out.print(tempNode == tail ?
                        tempNode.data + "" : tempNode.data + ", ");
                tempNode = tempNode.nextNode;
            }
        }
        return "";
    }

    public int size() {
        return size;
    }

    public void add(T input) {
        Node newNode = new Node(input);
        if (head == null) {
            head = newNode;
            size++;
        } else if (tail == null) {
            tail = newNode;
            head.nextNode = tail;
            tail.preNode = head;
            size++;
        } else {
            Node tempNode = head;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = newNode;
            newNode.preNode = tempNode;
            tail = newNode;
            size++;
        }
    }

    public T get(int idx) {
        Node tempNode = head;
        while (tempNode.idx != idx) {
            tempNode = tempNode.nextNode;
        }
        return tempNode.data;
    }

    public void delete(int idx) {
        if (head == null) {
            System.out.println("이미 빈 배열입니다");
            return;
        }
        if (idx == 0) {
            head = head.nextNode;
            head.preNode = null;
            editIdx();
            return;
        }
        if (idx == size - 1) {
            tail = tail.preNode;
            tail.nextNode = null;
            editIdx();
            return;
        }

        for (Node temp = head; temp != null; temp = temp.nextNode) {
            if (temp.idx == idx) {
                if (temp.idx == size - 1) {
                    temp = null;
                    editIdx();
                    return;
                }
                temp.preNode.nextNode = temp.nextNode;
                temp.nextNode.preNode = temp.preNode;
            }
        }
        editIdx();
    }

    public void editIdx() {
        int num = 0;
        for (Node temp = head; temp != null; temp = temp.nextNode) {
            temp.setIdx(num++);
        }
        size--;
    }

    //Iterable 인터페이스의 메소드!====== 포이치가 알아서 갖다쓰는듯...!
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentN = head;
            @Override
            public boolean hasNext() {
                return currentN != null;
            }

            @Override
            public T next() {
                T data = currentN.getData();
                currentN = currentN.nextNode;
                return data;
            }
        };
    }



    //스택메소드!=========================================
        public T pop() {
            T temp = (T) tail.getData();
            delete(size - 1);
            return temp;
        }

        public T peek() {
            return (T) tail.getData();
        }

        //큐메소드!===============================================
        public T dequeue() {
            return (T) head.getData();
        }

        public T poll() {
            T temp = (T) head.getData();
            delete(0);
            return temp;
        }

        public void insert(T input){
        Node tempN = new Node(input);
            if(head == null) head = tempN;
            else {
                head.preNode = tempN;
                tempN.nextNode = head;
                head = tempN;
            }
            editIdx();
            size += 2;
        }


}
