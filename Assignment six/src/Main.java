import java.util.*;


public class Main {

	 public static void main(String[] args) {
	        Scanner keyboard = new Scanner (System.in);
	            introduction();
	            boolean runAgain = true;
	            while (runAgain){
	                boolean rolledYahtzee = false;
	                int numRolls = 0;
	                Die [] dieArray = dieArray(keyboard);
	                while(!rolledYahtzee){
	                    dieArray = rollDice (dieArray);
	                    numRolls++;
	                    printDots(numRolls);
	                    rolledYahtzee = checkForYahtzee(dieArray, numRolls);
	                }
	                printResults (numRolls, dieArray);
	                runAgain = runAgain(keyboard);
	            }
	    }

	    public static void introduction(){
	        System.out.println("This program will");
	    }


	    public static Die [] dieArray(Scanner keyboard){
	        int numDice = getInt(keyboard, "How many dice do you want to throw? ");
	        while (numDice <= 0){
	            System.out.println("Sorry, you must enter a positive number.");
	            numDice = getInt(keyboard, "How many dice do you want to throw? ");
	        }
	        Die [] dieArray = new Die [numDice];
	        return dieArray;
	    }

	    public static int getInt (Scanner keyboard, String prompt){
	        System.out.print(prompt);
	        while (!keyboard.hasNextInt()){
	            keyboard.next();
	            System.out.println("Sorry, you must enter an integer.");
	            System.out.print(prompt);
	        }
	        return keyboard.nextInt();
	    }

	    public static Die [] rollDice(Die [] dieArray){
	        for (int num = 0; num < dieArray.length; num++){
	            dieArray[num] = new Die ();
	            dieArray[num].roll();
	            dieArray[num].faceValue = dieArray[num].getValue();
	        }
	        return dieArray;
	    }

	    public static void printDots(int numRolls){
	        System.out.print(".");
	        if ((numRolls%50) == 0){
	            System.out.println();
	        }
	    }

	    public static boolean checkForYahtzee(Die[] dieArray, int numRolls) {
	        for(int num = 0; num < dieArray.length; num++) {
	            for(int count = num+1; count < dieArray.length; count++) {
	                if(dieArray[num].getValue() != dieArray[count].getValue()) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public static void printResults (int numRolls, Die[] dieArray){
	        System.out.println();
	        System.out.println("Yahtzee!!");
	        System.out.print("After " + numRolls + " rolls, I finally rolled ");
	        System.out.println(dieArray.length + " " + dieArray[0].getValue() + "'s");
	        System.out.println();   
	    }

	    public static boolean runAgain (Scanner keyboard){
	        System.out.print("Would you like to roll again? (y|n)):    ");
	        String answer = keyboard.next().trim().toLowerCase();
	        keyboard.nextLine();
	        System.out.println();
	        return (answer.charAt(0) == 'y');
	    }
	}
	
class Die {
    int faceValue;
    public void roll(){
        faceValue = (int)(Math.random() * 6 + 1);
    }

    public int getValue(){
        return faceValue;   
    }

    public String toString(){
        return Integer.toString(faceValue);
    }

/*
 *Nea 
 */
    
}




