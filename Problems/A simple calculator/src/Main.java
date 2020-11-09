import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        long first = sc.nextLong();
        String action = sc.next();
        long second = sc.nextLong();

        switch (action.charAt(0)) {
            case '+' :
                System.out.println(first + second);
                break;
            case '-' :
                System.out.println(first - second);
                break;
            case '/' :
                if (first == 0L || second == 0L) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(first / second);
                break;
            case '*' :
                System.out.println(first * second);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}