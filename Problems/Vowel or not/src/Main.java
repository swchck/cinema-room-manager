import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        var c = Character.toString(ch).toLowerCase();
        return c.equals("a")
                || c.equals("e")
                || c.equals("i")
                || c.equals("o")
                || c.equals("u");
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}