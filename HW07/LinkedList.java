import java.util.NoSuchElementException;
public class LinkedList<T> implements List<T>{
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

    public void addAtIndex(T data, int index) throws NoSuchElementException, IllegalArgumentException {
        if (data==null){
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        if (index<0 || index>size){
            throw new NoSuchElementException("Your index is out of the list bounds");
        }
        Node<T> element = new Node<>(data);
        if (index==0) {
            Node<T> oldHead = head;
            head = element;
            head.setNext(oldHead);
        }
        if (index==size) {
            tail.setNext(element);
            tail = element;
        }
        else {
            Node<T> rightBefore = getToIndex(index-1, head);
            Node<T> rightAfter = rightBefore.getNext();
            rightBefore.setNext(element);
            element.setNext(rightAfter);
        }
        size++;
    }

    public T getAtIndex(int index) throws IllegalArgumentException {
        if (index<0 || index>(size-1)){
            throw new NoSuchElementException("Your index is out of the list bounds");
        }
        return getToIndex(index, head).getData();
    }

    public T removeAtIndex(int index) throws IllegalArgumentException {
        if (index<0 || index>(size-1)){
            throw new NoSuchElementException("Your index is out of the list bounds");
        }
        Node<T> removing = null;
        if (index==0) {
            removing = head;
            head = head.getNext();
        }
        else {
            Node<T> rightBefore = getToIndex(index-1, head);
            removing = rightBefore.getNext();
            Node<T> rightAfter = removing.getNext();
            rightBefore.setNext(rightAfter);
            if (index==(size-1)) {
            tail = rightBefore;
            }
        }
        T removedData = removing.getData();

        if (size==1){
            head = null;
            tail = null;
        }
        size--;
        return removedData;
    }

    public T remove(T data) {
        if (data==null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        int removingIndex = getToData(data, head, 0);
        if (removingIndex==size) {
            throw new NoSuchElementException("The data is not present in the list.");
        }
        return removeAtIndex(removingIndex);
    }

    public void clear() {
        head.setNext(null);
    }

    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
    private Node<T> getToIndex(int index, Node<T> current) throws NoSuchElementException, IllegalArgumentException {
        if (index==0){
            return current;
        }
        return getToIndex(index-1, current.getNext());
    }

    private int getToData(T data, Node<T> current, int index) {
        if (current.getData()==data){
            return index;
        }
        else if (index==(size-1)){
            return size;
        }
        return getToData(data, current.getNext(), index++);
    }



}
