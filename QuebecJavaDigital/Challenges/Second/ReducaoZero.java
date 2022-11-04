package QuebecJavaDigital.Challenges.Second;

import java.util.Scanner;

public class ReducaoZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int step = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            /* System.out.printf("NUM antes: %d\n", num);
            System.out.printf("Passo antes: %d\n", step); */
            step++;
            /*System.out.printf("Passo depois: %d\n", step);
            System.out.printf("NUM depois: %d\n", num); */
        }
        System.out.printf("\nPassos: %d\n", step);
        scanner.close();
    }
}
