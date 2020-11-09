import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var result = "";

        switch (new Scanner(System.in).nextInt()) {
            case 1 :
                result = "up";
                break;
            case 2 :
                result = "down";
                break;
            case 3 :
                result = "left";
                break;
            case 4 :
                result = "right";
                break;
            case 0 :
                result = "do not move";
                break;
            default :
                result = "";
                break;
        }

        if (result.equals("")) {
            System.out.println("error!");
        } else if(result.equals("do not move")) {
            System.out.println(result);
        } else {
            System.out.printf("move %s", result);
        }
    }
}