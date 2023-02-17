package ui;

import java.util.Scanner;
import model.*;
public class Main {

    private Scanner scan;

    public Main() {
        scan = new Scanner(System.in);
    }

    public Scanner getScan() {

        return scan;
    }

    public static void main(String[] args) {

        CircleList list = new CircleList();

        Main main = new Main();

        int option = -1;

        do{
            option = main.getOptionShowMenu();
            main.executeOption(option, list);

        } while(option != 0);

        main.getScan().close();

    }

    public int getOptionShowMenu(){

        int option = 0;
        System.out.println("<<<<< Sistema de turnos - Bancolombia >>>>>");
        System.out.println(
                "1. Dar turno \n" +
                "2. Mostrar turno actual \n" +
                "3. Pasar turno \n" +
                "4. Seguir \n" +
                "0. Exit. ");
        option = validateIntegerOption();


        return option;
    }

    public void executeOption(int option, CircleList list) {
        Node nextNode = list.getCurrentNode();

        switch(option) {
            // Dar turno
            case 1:
                int turnNumber = list.getLastTurnNumber() + 1; // obtiene el último turno y le suma +1 para asignarle su turno actual
                list.addNode(turnNumber);
                System.out.println("Turno asignado en la fila: " + turnNumber);
                list.printList(); // muestra la lista de turnos

                break;

            // Mostrar turno actual
            case 2:
                Node currentNode = list.getCurrentNode();
                if (currentNode == null) {
                    System.out.println("No hay turnos aún. ");
                } else {
                    System.out.println("Turno actual en la fila: " + list.getLastTurnNumber());
                }
                break;

            // Pasar turno
            case 3:
                if (list.getLastTurnNumber() == 0) {
                    System.out.println("Actualmente no hay turnos.");
                } else {
                    int currentTurn = list.getLastTurnNumber();
                    turnNumber = list.getLastTurnNumber() + 1; // obtiene el último turno y le suma +2 para asignarle su turno actual
                    list.addNode(turnNumber);
                    System.out.println("Se atendió con éxito el turno " + currentTurn + " y ha pasado al siguiente.");
                    list.printList();
                }
                break;

            // Seguir
            case 4:
                if (list.getLastTurnNumber() == 0) {
                    System.out.println("No hay turnos en espera.");
                } else {
                    int currentTurn = list.getCurrentNode().getTurnNumber();
                    list.delete();
                    nextNode = list.getCurrentNode();
                    if (nextNode == null) {
                        System.out.println("No hay más turnos en espera.");
                    } else {
                        System.out.println("Se eliminó el turno " + currentTurn + " y se ha pasado al siguiente: " + nextNode.getTurnNumber());
                        list.printList();
                    }
                }
                break;

            case 0:
                System.out.println("Fin.");
                break;

            default:
                System.out.println("Seleccionaste una opción inválida. ");
                break;

        }
    }

    public int validateIntegerOption(){
        int option = 0;

        if(scan.hasNextInt()){
            option = scan.nextInt();
        }
        else{
            scan.nextLine();
            option = -1;
        }

        return option;
    }

}