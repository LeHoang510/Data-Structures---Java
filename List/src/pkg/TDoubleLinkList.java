package pkg;

public class TDoubleLinkList<T> implements TList<T>{
    private final Node<T> head;
    private final Node<T> tail;
    private Node<T> currentNode;

    private static class Node<T>{
        T value;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T value){
            this.value = value;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    public TDoubleLinkList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.head.nextNode = this.tail;
        this.tail.prevNode = this.head;
        this.currentNode = this.head;
    }

    @Override
    public void toHead() {
        if(isNull()){
            return;
        }
        this.currentNode = this.head.nextNode;
    }

    @Override
    public void toTail() {
        if(isNull()){
            return;
        }
        this.currentNode = this.tail.prevNode;
    }

    @Override
    public void next() throws TException {
        if(isOut()){
            throw new TException("Out of bound");
        }
        this.currentNode = this.currentNode.nextNode;
    }

    @Override
    public void prev() throws TException {
        if(isOut()){
            throw new TException("Out of bound");
        }
        this.currentNode = this.currentNode.prevNode;
    }

    @Override
    public void addRight(T object) throws TException{
        if(!isNull() && isOut()){
            throw new TException("Out of bound");
        }
        Node<T> newNode = new Node<>(object);
        newNode.prevNode = this.currentNode;
        newNode.nextNode = this.currentNode.nextNode;
        this.currentNode.nextNode.prevNode = newNode;
        this.currentNode.nextNode = newNode;
        this.currentNode = newNode;
    }

    @Override
    public void remove() throws TException {
        if(isOut()){
            throw new TException("Out of bound");
        }
        this.currentNode.prevNode.nextNode = this.currentNode.nextNode;
        this.currentNode.nextNode.prevNode = this.currentNode.prevNode;
        this.currentNode = this.currentNode.nextNode;
        // what if the next value is tail?
    }

    @Override
    public T currentValue() throws TException {
        return this.currentNode.value;
    }

    @Override
    public boolean isOut() {
        return this.currentNode == this.head || this.currentNode == this.tail;
    }

    @Override
    public boolean isNull() {
        return this.head.nextNode == this.tail;
    }
}
