import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var result = "";

        switch (new Scanner(System.in).nextInt()) {
            case 1 :
                result = "square";
                break;
            case 2 :
                result = "circle";
                break;
            case 3 :
                result = "triangle";
                break;
            case 4 :
                result = "rhombus";
                break;
            default :
                result = "";
                break;
        }

        if (result.equals("")) {
            System.out.println("There is no such shape!");
        } else {
            System.out.printf("You have chosen a %s", result);
        }
    }
}