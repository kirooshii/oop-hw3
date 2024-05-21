package lms;

public class LMSTester {
    public static void main(String[] args) {

        LMS iliauniLibrary = new LMS();

        iliauniLibrary.loadState("libraryState.txt");

        Book lor = new Book("Lord of the rings", "tolkien");
        Book oop = new Book("OOP", "paata gogisvhili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);

        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);

        iliauniLibrary.saveState("libraryState.txt");
    }
}
