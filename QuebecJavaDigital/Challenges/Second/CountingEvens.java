import java.util.Scanner;

/*
 * Acho que dá para fazer um código menor usando a String fornecida pelo usuário sem convertê-la
 * para Integer imediatamente.
 * Este código executa diversas conversões, que parecem desnecessárias.
 */

public class CountingEvens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        var count = 0;

        for (var i = 1; i <= num; i++) {
            var strNum = String.valueOf(i);
            if (strNum.length() == 1) {
                if (i % 2 == 0) {
                    count++;
                }
                continue;
            }
            char[] vs = strNum.toCharArray();
            var sum = 0;
            for (var j = 0; j < vs.length; j++) {
                sum += (int)Character.getNumericValue(vs[j]);
            }
            if (sum % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
