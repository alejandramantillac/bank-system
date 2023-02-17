package model;

public class CircleList {

    private Node head;
    private Node current;

    public CircleList() {
        current = null;
    }

    public void addNode(int turnNumber) {
        Node node = new Node(turnNumber);

        if (current == null) {
            current = node;
            node.setNext(node);
        } else {
            node.setNext(current.getNext());
            current.setNext(node);
            current = node;
        }
    }

    public int getLastTurnNumber() {
        if (current == null) {
            return 0;
        } else {
            return current.getTurnNumber();
        }
    }

    public Node getCurrentNode() {
        return current;
    }

    public void delete(int turnNumber) {
        if (current != null) {
            Node temp = current;
            while (temp.getNext() != current) {
                if (temp.getNext().getTurnNumber() == turnNumber) {
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
                temp = temp.getNext();
            }
            if (temp == current && current.getTurnNumber() == turnNumber) {
                current = (current.getNext() == current) ? null : current.getNext();
            }
        }
    }

    public void delete() {
        if (current == null) {
            return;
        }

        if (current == current.getNext()) {
            current = null;
        } else {
            Node temp = current.getNext();
            current.setNext(temp.getNext());
            temp.getNext().setPrevious(current);
            temp = null;
        }
    }


    public void printList() {
        if (current == null) {
            System.out.println("Actualmente no hay turnos en la lista. ");
        } else {
            System.out.print("Lista de turnos: ");
            Node temp = current.getNext();
            do {
                System.out.print(temp.getTurnNumber() + " ");
                temp = temp.getNext();
            } while (temp != current.getNext());
            System.out.println();
        }
    }


}
