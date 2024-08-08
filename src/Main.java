public class Main {
    public static void main(String[] args) {
        var ch1 = 'h';
        char ch2 = 'i';
        char ch3 = 'b';

        System.out.println(decode(ch1) + " " + decode(ch2) + " " + decode(ch3));
    }

    public static String decode(char ch) {
        switch (ch) {
            case 'h':
                return "Hello";
            case 'i':
                return "I can decode!";
            case 'b':
                return "Bye";
            default:
                return "Ничего не подошло";
        }
    }
}