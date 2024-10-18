package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pilar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("3) Lista Pilares");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 3:
                    listPillars();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {

        reader.nextLine();

        System.out.println("Ingrese el tipo del pilar: 0. Biodiversidad, 1. Agua, 2. Tratamiento de basuras, 3. Energia");
        int pillarType = reader.nextInt();
        reader.nextLine();
        
        System.out.println("Ingrese el id del pilar:");
        String id =  reader.nextLine();

        System.out.println("Ingrese el nombre del pilar:");
        String name = reader.nextLine();

        System.out.println("Ingrese la descripción del proyecto:");
        String description = reader.nextLine();

        System.out.println("El proyecto está activo? (true/false):");
        boolean isStatus = reader.nextBoolean();
        reader.nextLine();


        if (control.registerProjectInPillar(pillarType, id, name, description, isStatus)) {
            System.out.println("Proyecto registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el proyecto.");
}


    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {

        System.out.println("Ingrese el nombre del pilar para ver los proyectos:");
        String name = reader.nextLine();
        String projectList = control.queryProjectsByPillar(name);

        if (projectList.isEmpty()) {
            System.out.println("No se encontraron proyectos en el pilar.");
        } else {
            System.out.println(projectList);
        }


    }

    public void listPillars() {
        System.out.println("Lista de Pilares:");
        System.out.println(control.getPillarList());
    }

}