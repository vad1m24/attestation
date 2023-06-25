package petRegistry;

import petRegistry.service.Service;

import java.util.Scanner;

public class Main {

    public static Service service = new Service();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");
        while (true) {
            System.out.println("""
                    Вот список комманд для проведения операций:
                    1   ->   добавить новое животное
                    2   ->   найти животное по имени
                    3   ->   отобразить список комманд животного
                    4   ->   обучить животное новой комманде
                    5   ->   отобразить список всех животных
                    6   ->   выйти из приложения
                    """);
            System.out.println("Введите вашу комманду: ");

            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                service.prepareForCreate();
            } else if (userChoice == 2) {
                service.getAnimalByName();
            } else if (userChoice == 3) {
                service.showAllCommands();
            } else if (userChoice == 4) {
                service.addCommand();
            } else if (userChoice == 5) {
                service.showAllAnimals();
            } else if (userChoice == 6) {
                System.out.println("До свидания!");
                break;
            }
        }
    }
}
