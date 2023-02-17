package model;

public class Node {

    private int turnNumber; // número de turno
    private int skipCount; // contador de veces que se ha saltado el turno

    private Node next;
    private Node previous;

    public Node(int turnNumber) {
        this.turnNumber = turnNumber;
        this.skipCount = 0;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(int skipCount) {
        this.skipCount = skipCount;
    }

    public Node getNext() {

        return next;
    }

    public void setNext(Node next) {

        this.next = next;
    }

    public Node getPrevious() {

        return previous;
    }

    public void setPrevious(Node previous) {

        this.previous = previous;
    }

}