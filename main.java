import java.util.Arrays;
import java.util.Scanner;

public class main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a 4-digit number (or 'q' to exit)");
        System.out.println("Not all numbers can be the same: eg 4444 is invalid. 4441 is valid");

        while (true)
        {
            System.out.println("Enter number:");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q"))
            {
                System.out.println("Goodbye!");
                break;
            }

            if (!input.matches("\\d{4}"))
            {
                System.out.println("Error: please enter exactly 4 digits.\n");
                continue;
            }

            int result = 0;

            while (result != 6174)
            {
                char[] digits = input.toCharArray();
                Arrays.sort(digits);

                String ascending  = new String(digits);
                String descending = new StringBuilder(ascending).reverse().toString();

                int high   = Integer.parseInt(descending);
                int low    = Integer.parseInt(ascending);
                result = high - low;

                System.out.println("  Highest to lowest : " + descending);
                System.out.println("  Lowest to highest : " + ascending);
                System.out.println("  Result            : " + result);
                System.out.println();

                input = String.format("%04d", result);
            }
        }

        scanner.close();
    }
}