package is.iska;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Dictionary dictionary = new Dictionary();
        Scanner sc= new Scanner(System.in);
        int count = 1;
        while(count <= 6){

            Updates updates = new Updates();
            System.out.println("************************");
            System.out.println("Guess Number " + count);
            System.out.println("************************");
            System.out.println("Guess: " + dictionary.getNextGuess());

            boolean valid = false;
            while(!valid){
                System.out.print("Is this guess valid? Enter y for yes or n for no: " );
                String input = sc.nextLine();
                if(input.equalsIgnoreCase("y")){
                    valid = true;
                } else{
                    System.out.println("New Guess: " + dictionary.getNextGuess());
                }
            }

            System.out.print("Enter letters you got missed: ");
            String missed = sc.nextLine();
            updates.setMissed(missed);


            System.out.print("Enter the correct letters with missed positions (yellow letters): ");
            String correct_no_positions = sc.nextLine();
            updates.setCorrect_no_position(correct_no_positions);


            System.out.print("Enter the correct letters with correct positions in order (green letters): ");
            String correct_positions = sc.nextLine();
            System.out.print("Enter the positions of the correct letters (zero index): ");
            String correct_nums = sc.nextLine();
            updates.setCorrect_positions(correct_positions, correct_nums);

            int removed = dictionary.updateAll(updates);
            System.out.println("Removed a total of " + removed + " entries.");
            System.out.println();
            count++;
        }

    }
}
