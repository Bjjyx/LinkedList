package linkedList;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> end;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public void addToEnd(T value){

        Node<T> tempNode = new Node<>(value, null, null);

        if (head == null){
            head = tempNode;
            end = head;
        } else {
            tempNode.addPrev(end);
            end.addNext(tempNode);
            end = tempNode;
        }
        ++length;

    }

    public  void addToHead(T value){

        Node<T> tempNode = new Node<>(value, null, null);

        if (head == null){
            head = tempNode;
            end = head;
        } else {
            tempNode.addNext(head);
            head.addPrev(tempNode);
            head = tempNode;
        }
        ++length;

    }

    private Node<T> findFirst(T value){

        Node<T> tempNode = head;

        for (int i = 0; i < length; i++){
            if (tempNode.getValue() == value){
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return  head;

    }

    private void isEmpty(Node<T> node){

        if (node == null){
            throw new IllegalArgumentException("Not found");
        }

    }

    public T findFirstByValue(T value){

        isEmpty(findFirst(value));
        return findFirst(value).getValue();

    }

    public void delFirstByValue(T value){

        Node<T> tempNode = head;

        for (int i = 0; i < length; i++){
            if (tempNode.getValue() == value){
                if (tempNode == head){
                    head.getNext().addPrev(null);
                    head = head.getNext();
                } else if (tempNode == end) {
                    end.getPrev().addNext(null);
                    end = end.getPrev();
                } else {
                    tempNode.getPrev().addNext(tempNode.getNext());
                    tempNode.getNext().addPrev(tempNode.getPrev());
                }
            }
            tempNode = tempNode.getNext();
        }
        --length;

    }

    private void isOutOfBounds(int idx){

        if (idx > length) {
            throw new IllegalArgumentException("Out of bounds");
        }

    }

    public T findByIndex(int idx){

        Node<T> tempNode = head;

        isOutOfBounds(idx);
        for (int i = 0; i < length; i++){
            if (i == idx){
                return tempNode.getValue();
            }
            tempNode = tempNode.getNext();
        }
        return tempNode.getValue();

    }

    public void delByIndex(int idx){

        Node<T> tempNode = head;

        isOutOfBounds(idx);
        for (int i = 0; i < length; i++){
            if (i == idx){
                if (tempNode == head){
                    head.getNext().addPrev(null);
                    head = head.getNext();
                } else {
                    tempNode.getPrev().addNext(tempNode.getNext());
                    tempNode.getNext().addPrev(tempNode.getPrev());
                }
            }
            tempNode = tempNode.getNext();
        }
        --length;

    }

    public String toString(){

        StringBuilder list = new StringBuilder();
        Node<T> tempNode = head;

        for(int i = 0; i < length; i++){
            list.append(tempNode.getValue().toString());
            tempNode = tempNode.getNext();
        }

        return list.toString();

    }

}
