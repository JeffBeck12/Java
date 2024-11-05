import java.util.Scanner;  // Needed for the Scanner class

/**
   This program allows the user to order a sub, but needs updates to work properly
   Jeffrey Beckett
   10/6/24
   I hereby attest that this code is original and written by me alone. I understand that I risk a penalty for violating the Academic Integrity policy at CCM.
*/

public class OrderApp106_JB {
    public static void main (String[] args) {
        // Create a Scanner object to read input.
        Scanner keyboard = new Scanner (System.in);

        String name;                  // User's first name
        char subTypeLetter;           // For type of sub
        double cost = 10.25;          // Default Cost of the sub
        final double ORDER_FEE = 1.00;// Online order fee
        char choice;                  // User's choice (just 1 character)
        String input;                 // User input (for Strings)
        String toppings = "Oil and Vinegar ";  // List of toppings
        int numberOfToppings = 0;     // Number of toppings
        String loyalDiscountCode;     // User's loyalty code
        boolean loyalCustomer = false; // Flag for loyal customer
        int size;                     // Sub size
        String subTypeDescription = ""; // Description of the sub type
        final double TAX_RATE = 0.06625; // Tax rate in NJ
        double tax_amount;            // Amount of the tax

        //*************************************************************************************
        // Prompt user and get first name and initial.
        System.out.println("Welcome to CS24 Subs");
        System.out.print("Enter the first name and initial for the order: ");
        name = keyboard.nextLine();

        //*************************************************************************************
        // Update #2: Prompt for loyalty discount code
        System.out.print("Enter your loyalty discount code or 'None' if you don't have one: ");
        loyalDiscountCode = keyboard.nextLine();

        // Validate loyalty discount code
        if (loyalDiscountCode.equalsIgnoreCase("LoyalCustomer1024") || 
            loyalDiscountCode.equalsIgnoreCase("FallSubFan")) {
            loyalCustomer = true;
        }

        //*************************************************************************************
        // Prompt user and get sub size choice.
        System.out.println("Sub (inches)\tCost");
        System.out.println("5:\t\t\t\t\t$5.98");
        System.out.println("7:\t\t\t\t$9.98");
        System.out.println("9:\t\t\t\t$10.25");
        System.out.println("15:\t\t\t\t$15.98");
        System.out.println("What size sub would you like?");
        System.out.print("5, 7, 9, or 15 inch? (enter the number only): ");

        //*************************************************************************************
        // Update #3: Accept sub size input and assign cost based on size
        size = keyboard.nextInt();
        keyboard.nextLine();  // Consume the newline after nextInt()

        // Assign price based on sub size
        if (size == 5) {
            cost = 5.98;
        } else if (size == 7) {
            cost = 9.98;
        } else if (size == 9) {
            cost = 10.25;
        } else if (size == 15) {
            cost = 15.98;
        } else {
            // Default to 9-inch sub if input is invalid
            System.out.println("Invalid choice. A 9-inch sub will be made.");
            size = 9;
            cost = 10.25;
        }

        //*************************************************************************************
        // Update #4: Prompt user for sub type and assign description
        System.out.println("\n\nWhat type of sub do you want?");
        System.out.print("(T) Turkey, (I) Italian, or (R) Roastbeef (enter T, I, or R): ");
        input = keyboard.nextLine();
        subTypeLetter = input.charAt(0);  // Grab the first letter only

        // Switch statement to assign sub type description
        switch (Character.toUpperCase(subTypeLetter)) {
            case 'T':
                subTypeDescription = "Turkey";
                break;
            case 'I':
                subTypeDescription = "Italian";
                break;
            case 'R':
                subTypeDescription = "Roastbeef";
                break;
            default:
                System.out.println("Invalid type entered. Defaulting to Turkey sub.");
                subTypeDescription = "Turkey";
                break;
        }

        //*************************************************************************************
        // Update #5: Prompt for all toppings, with "Y" or "N" options for each
        System.out.println("All subs come with oil and vinegar.");
        System.out.println("Additional toppings are $0.95 each, choose from:");
        System.out.println("Mayo, Provolone, Lettuce, and Tomato");

        // If Mayo is desired
        System.out.print("Do you want Mayo? (Y/y): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings += "Mayo ";
        }

        // If Provolone is desired
        System.out.print("Do you want Provolone? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings += "Provolone ";
        }

        // If Lettuce is desired
        System.out.print("Do you want Lettuce? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings += "Lettuce ";
        }

        // If Tomato is desired
        System.out.print("Do you want Tomato? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings += "Tomato ";
        }

        // Add cost for toppings
        cost = cost + (0.95 * numberOfToppings);

        //*************************************************************************************
        // Update #6: Apply loyalty discount
        if (loyalCustomer) {
            System.out.println("Applying loyalty discount of 15%.");
            cost = cost - (cost * 0.15);  // Apply 15% discount
        }

        //*************************************************************************************
        // Update #7: Calculate tax amount and add online order fee
        tax_amount = cost * TAX_RATE; // Calculate tax amount based on the current cost
        cost = cost + tax_amount;     // Add tax amount to the total cost
        cost = cost + ORDER_FEE;      // Add the online order fee ($1.00)

        //*************************************************************************************
        // Update #8: Display order confirmation
        System.out.println();
        System.out.println("Your order is as follows: ");
        System.out.println(size + " inch " + subTypeDescription + " Sub");
        System.out.println("with " + toppings);

        // Final cost and details
        System.out.println("\n\nThe cost of your order is: $" + cost);
        System.out.println("This includes the $" + ORDER_FEE + " online ordering fee.");
        System.out.println("Your order will be ready for pickup in 10 minutes.");
    }
}
