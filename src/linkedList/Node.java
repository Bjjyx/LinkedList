package linkedList;

//Класс "узла", который будет связывать элементы друг с другом внутри списка
//Класс реализован сразу для использования как LinkedList, так и для DoubleLinkedList
//Доступа к классу из вне нет
class Node<T> {
    //Ссылка на следующий элемент списка
    private Node<T> next;
    //Ссылка на предыдущий элемент списка. Используется только в DoubleLinkedList
    private Node<T> prev;
    //Объект, хронящийся в узле
    private final T value;

    Node(T value, Node<T> prev, Node<T> next){

        this.value = value;
        this.prev = prev;
        this.next = next;

    }

    void addNext(Node<T> node){

        next = node;

    }

    void addPrev(Node<T> node){

        prev = node;

    }

    void addNextByParam(T value, Node<T> prev){

        next = new Node<>(value, prev, null);

    }

    Node<T> getNext(){
        return next;
    }

    Node<T> getPrev(){
        return prev;
    }
    T getValue(){
        return value;
    }





}
