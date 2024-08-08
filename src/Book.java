import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String name;
    private int price;
    private int yearPublish;
     private static ArrayList<Book> card = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public ArrayList<Book> getCard() {
        return card;
    }

    public void setCard(ArrayList<Book> card) {
        this.card = card;
    }

    public static void main(String[] args) {
        printAll(card);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в картотеку онлайн библиотеки!!!" + "\n");
        boolean isContinue = false;
        int action;
        Book book = new Book();
        book.setName("Преступление");
        book.setYearPublish(1959);
        book.setPrice(999);
        card.add(book);
        while (!isContinue) {
            System.out.println("1.Поиск книги по названию. \n2.Поиск книги по году издания");
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 1:
                    System.out.println("Введите название книги:");
                    String name = scanner.nextLine();
                    searchBookForName(name);
                    break;
                case 2:
                    System.out.println("Введите год издания книги:");
                    int date = scanner.nextInt();
                    searchBookForDate(date);
                    break;
                case 3:
                    printAll(card);
                    break;
                case 4:
                    isContinue = true;
                    break;
                default:
                    System.out.println("Введите корректную операцию");
            }
        }
    }
    public static void searchBookForName(String name) {
        boolean isCheck = false;
        for (Book book : card) {
            if (name.equals(book.getName())) {
                isCheck = true;
                System.out.println("Книга с таким названием уже существует." + "\n" +
                        "Год издания: " + book.getYearPublish());
                break;
            }
        }
        if (!isCheck) {
            Book endBook = new Book();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите год издания книги: ");
            endBook.setYearPublish(scanner.nextInt());
            System.out.println("Введите стоимость книги: ");
            endBook.setPrice(scanner.nextInt());
            scanner.nextLine(); // Считываем остаток строки
            endBook.setName(name);
            card.add(endBook);
        }
    }
    public static void searchBookForDate (int date){
        boolean isCheck = false;
        for (Book book: card){
            if (book.getYearPublish() == date) {
                isCheck = true;
                break;
            }
            if (isCheck) {
                System.out.println("Книга с таким годом издания уже существует." + "\n" +
                        "Название книги: " + book.getName());
            }
            else {
                Scanner scanner = new Scanner(System.in);
                Book newBook = new Book();
                System.out.println("Введите название книги: " );
                newBook.setName(scanner.nextLine());
                System.out.println("Введите стоимость книги: ");
                newBook.setPrice(scanner.nextInt());
                newBook.setYearPublish(date);
                card.add(newBook);
            }
        }
    }
    public static void printAll(ArrayList<Book> books) {
        int cnt = 1;
        for (Book book: books) {
            String res = String.format("Книга № %d: название: %s, год издания %d г , цена - %d USD",
                    cnt,book.getName(), book.getYearPublish(), book.getPrice());
            System.out.println(res);
            cnt++;
        }
    }
}
