public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public Node<T> getHead(){
        return head;
    }
    public Node<T> getTail(){
        return tail;
    }

}
