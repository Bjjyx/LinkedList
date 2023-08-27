package linkedList;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> end;
    private int length = 0;

    public void addNext(T value){

        Node<T> tempNode = new Node<>(value, null, null);

        if (head == null){
            head = tempNode;
            end = head;
        } else {
            end.addNext(tempNode);
            end = tempNode;
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
        return tempNode;

    }

    public void delFirstByValue(T value){

        Node<T> tempNode = head;
        Node<T> prevTempNode = head;

        for (int i = 0; i < length; i++){
            if (tempNode.getValue() == value){
                if (tempNode == head){
                    head = head.getNext();
                } else {
                    prevTempNode.addNext(tempNode.getNext());
                }
                --length;

            }
            prevTempNode = tempNode;
            tempNode = tempNode.getNext();
        }

    }

    private void isOutOfBounds(int idx){

        if (idx > length) {
            throw new IllegalArgumentException("Out of bounds");
        }

    }

    public T findByIndex(int idx){

        isOutOfBounds(idx);
        Node<T> tempNode = head;

        for(int i = 0; i < length; i++){
            if (idx == i){
                return tempNode.getValue();
            }
            tempNode = tempNode.getNext();
        }
        return tempNode.getValue();

    }

    public void delByIndex(int idx){

        Node<T> tempNode = head;
        Node<T> prevTempNode = head;

        for (int i = 0; i < length; i++){
            if (idx == i){
                if (tempNode == head){
                    head = head.getNext();
                }
                prevTempNode.addNext(tempNode.getNext());
                --length;
            }
            prevTempNode = tempNode;
            tempNode = tempNode.getNext();
        }

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

    public String toString(){

        StringBuilder list = new StringBuilder();
        Node<T> tempNode = head;

        for(int i = 0; i < length; i++){
            list.append(tempNode.getValue().toString());
            tempNode = tempNode.getNext();
        }
        return list.toString();

    }

    public int getLength(){

        return length;

    }

}
