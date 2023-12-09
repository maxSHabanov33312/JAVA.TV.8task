package interfaceLine;

import domain.Program;
import manager.ProgramDAO;

import java.util.Scanner;

public class CommandLineInterface {
    private ProgramDAO programDAO;
    private Scanner scanner;

    public CommandLineInterface() {
        programDAO = new ProgramDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            System.out.println();
            System.out.print("Введите команду(ДобавитьПередачу, ОбновитьПередачу, УдалениеПередачи, ПоказатьПередачи): ");
            String command = scanner.nextLine();

            if (command.equals("ПоказатьПередачи")) {
                System.out.println(programDAO.getAllPrograms());
            } else if (command.equals("ДобавитьПередачу")) {
                System.out.print("Введите Название передачи: ");
                String title = scanner.nextLine();
                System.out.print("Введите название канала для трансляции: ");
                String channel = scanner.nextLine();
                System.out.print("введите жанр передачи: ");
                String genre = scanner.nextLine();
                System.out.print("День показа передачи: ");
                String dayOfWeek = scanner.nextLine();
                System.out.print("Время начала показа передачи: ");
                String startTime = scanner.nextLine();

                Program program = new Program(title, channel, genre, dayOfWeek, startTime);
                programDAO.addProgram(program);
                System.out.println("Передача добавлена");
            } else if (command.equals("ОбновитьПередачу")) {
                System.out.print("Введите id передачи для обновления: ");
                int id = Integer.parseInt(scanner.nextLine());


                System.out.print("Введите Название передачи: ");
                String title = scanner.nextLine();
                System.out.print("Введите название канала для трансляции: ");
                String channel = scanner.nextLine();
                System.out.print("введите жанр передачи: ");
                String genre = scanner.nextLine();
                System.out.print("День показа передачи: ");
                String dayOfWeek = scanner.nextLine();
                System.out.print("Время начала показа передачи: ");
                String startTime = scanner.nextLine();

                Program updatedProgram = new Program(title, channel, genre, dayOfWeek, startTime);
                updatedProgram.setId(id);
                programDAO.updateProgram(updatedProgram);
                System.out.println("Передача обновлена");
            } else if (command.equals("УдалениеПередачи")) {
                System.out.print("Enter program ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());


                programDAO.deleteProgram(id);
                System.out.println("Program deleted successfully!");
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}