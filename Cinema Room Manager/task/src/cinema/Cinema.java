package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    static final String INPUT_MARK = "> ";
    static final Scanner sc = new Scanner(System.in);
    static boolean isInterrupted = false;
    static char[][] room;
    static int ticketsBought = 0;
    static int currentIncome = 0;
    static int totalIncome = 0;

    public static void main(String[] args) {
        begin();
        while (!isInterrupted) {
            System.out.print("1. Show the seats \n2. Buy a ticket \n3. Statistics \n0. Exit\n" + INPUT_MARK);
            switch (sc.next()) {
                case "1":
                    showSeats();
                    System.out.println();
                    break;
                case "2":
                    buyTicket();
                    System.out.println();
                    break;
                case "0":
                    isInterrupted = !isInterrupted;
                    break;
                case "3" :
                    getStatistics();
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    private static void begin() {
        System.out.print("Enter the number of rows:\n" + INPUT_MARK);
        var numberOfRows = sc.nextInt();

        System.out.print("Enter the number of seats in each row:\n" + INPUT_MARK);
        var numberOfSeats = sc.nextInt();
        room = new char[numberOfRows][numberOfSeats];

        for (char[] chars : room) {
            Arrays.fill(chars, 'S');
        }

        totalIncome = room.length * room[0].length > 60 && room.length % 2 != 0
                ? ((room.length / 2 + room.length % 2) * room[0].length * 8) + ((room.length / 2) * room[0].length * 10)
                : room.length % 2 == 0
                    ? ((numberOfRows / 2) * numberOfSeats * 10) + ((numberOfRows / 2) * numberOfSeats * 8)
                    : room.length * room[0].length * 10;
    }

    private static void showSeats() {
        var builder = new StringBuilder();

        builder.append("Cinema:\n");
        builder.append("  ");
        for (int i = 1; i <= room[0].length; i++) {
            builder.append(i).append(" ");
        }
        builder.append("\n");
        for (int i = 1; i <= room.length; i++) {
            builder.append(i).append(" ");
            for (int j = 0; j < room[0].length; j++) {
                builder.append(room[i - 1][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private static int getPrice(int rowNumber) {
        if (room[0].length * room.length < 60) {
            return 10;
        } else {
            int frontHalf = room.length / 2;
            return rowNumber > frontHalf ? 8 : 10;
        }
    }

    private static void buyTicket() {
        System.out.print("Enter a row number:\n" + INPUT_MARK);
        var rowNumber = sc.nextInt();

        System.out.print("Enter a seat number in that row:\n" + INPUT_MARK);
        var seatNumber = sc.nextInt();

        if (room.length + 1 <= rowNumber | room[0].length + 1 <= seatNumber) {
            System.out.println("Wrong input!");
            buyTicket();
        } else {
            if (room[rowNumber - 1][seatNumber - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                buyTicket();
            } else {
                room[rowNumber - 1][seatNumber - 1] = 'B';

                var price = getPrice(rowNumber);
                ticketsBought++;
                currentIncome+=price;

                System.out.printf("Ticket price: $%s%n", price);
            }
        }
    }

    private static void getStatistics() {
        System.out.printf("Number of purchased tickets: %d%n", ticketsBought);
        System.out.printf("Percentage: %.2f", getPercentage());
        System.out.println("%");
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n%n", totalIncome);
    }

    private static float getPercentage() {
        return ticketsBought *  100.00f / (room.length * room[0].length);
    }

}