package petRegistry.service;

import petRegistry.model.*;
import petRegistry.repository.Repository;
import petRegistry.utils.Counter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Service {
    private final Scanner scanner = new Scanner(System.in);
    private final Repository repository = new Repository();
    private final Counter counter = new Counter();

    public void showAllAnimals() {
        repository.showRepository();
        counter.show();
    }

    public void addCommand() {
        scanner.nextLine();
        System.out.println("Введите имя вашего животного.");
        String animalName = scanner.nextLine();
        System.out.println("Какой комманде вы хотите обучить ваше животное?");
        String animalCommand = scanner.nextLine();
        addCommandByAnimalName(animalName, animalCommand);
        System.out.println(getCommandByAnimalName(animalName));
    }

    public void showAllCommands() {
        scanner.nextLine();
        System.out.println("Введите имя вашего животного.");
        String animalName = scanner.nextLine();
        System.out.println(getCommandByAnimalName(animalName));
    }

    public void getAnimalByName() {
        scanner.nextLine();
        System.out.println("Введите имя вашего животного.");
        String animalName = scanner.nextLine();
        System.out.println(repository.getByName(animalName));
    }

    public void prepareForCreate() {
        scanner.nextLine();
        System.out.println("Введите тип вашего животного (Cat, Dog, Hamster, Horse, Donkey, Camel).");
        String animalType = scanner.nextLine();
        System.out.println("Введите имя вашего животного.");
        String animalName = scanner.nextLine();
        System.out.println("Введите год рождения вашего животного.");
        int yearBirth = scanner.nextInt();
        System.out.println("Введите месяц рождения вашего животного.");
        int monthBirth = scanner.nextInt();
        System.out.println("Введите число рождения вашего животного.");
        int dayBirth = scanner.nextInt();

        Set<String> animalCommands = new HashSet<>();
        System.out.println("""
                Ваше животное умеет выполнять комманды?
                1   ->   да
                2   ->   нет
                """);
        int userAnswer = scanner.nextInt();
        if (userAnswer == 1) {
            while (true) {
                System.out.println("Введите комманду, которую знает ваше животное.");
                String command = scanner.next();
                animalCommands.add(command);
                System.out.println("""
                        Добавить еще 1 комманду?
                        1   ->   да
                        2   ->   нет
                        """);
                int answer = scanner.nextInt();
                if (answer != 1) {
                    break;
                }
            }
        }
        create(animalName, LocalDate.of(yearBirth, monthBirth, dayBirth), animalCommands, animalType);
    }

    private void create(String name, LocalDate birthdate, Set<String> commands, String type) {
        Animal animal;
        switch (type) {
            case "Cat" -> {
                animal = new Cat(name, birthdate, commands);
                repository.addAnimalToRepository(animal);
                counter.add();
            }
            case "Dog" -> {
                animal = new Dog(name, birthdate, commands);
                repository.addAnimalToRepository(animal);
                counter.add();
            }
            case "Hamster" -> {
                animal = new Hamster(name, birthdate, commands);
                repository.addAnimalToRepository(animal);
                counter.add();
            }
            case "Horse" -> {
                animal = new Horse(name, birthdate, commands);
                repository.addAnimalToRepository(animal);
                counter.add();
            }
            case "Donkey" -> {
                animal = new Donkey(name, birthdate, commands);
                repository.addAnimalToRepository(animal);
                counter.add();
            }
            case "Camel" -> {
                animal = new Camel(name, birthdate, commands);
                repository.addAnimalToRepository(animal);
                counter.add();
            }
            default -> throw new IllegalStateException("Нет такого типа животного: " + type);
        }
    }


    private Set<String> getCommandByAnimalName(String name) {
        Animal byName = repository.getByName(name);
        return byName.getCommands();
    }

    private void addCommandByAnimalName(String name, String command) {
        repository.addCommandByAnimalName(name, command);
    }
}

