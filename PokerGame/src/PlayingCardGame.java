import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayingCardGame {
    private static Scanner in = new Scanner(System.in);
    private static PlayingCardDeck deck = new PlayingCardDeck();
    private static int valueOfCurrentCard = 0;
    private static int valueOfNextCard = 0;
    private static String checkIfItsTen = "";
    private static String checkTheCard = "";
    private static int points = 0;
    private static int choice;


    public static void main(String[] args) {

        /*
         * Asking the user what he/she wishes to do.
         * If user enters a string, program will shut down.
         *
         */
        while (true) {
            System.out.println("\nWhat would you like to do? \n1. Play the game \n2. Show game rules. \n3. Quit game");
            try {
                choice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter 1-3. Program shutting down..");
                break;
            }

            /*
             * Based on the choice above, either plays the game, prints out the information about the game
             * or exits the game.
             *
             */
            switch (choice) {
                case 1:
                    /*
                     * Generates a new deck (52 cards) and shuffles them.
                     */
                    deck.generateDeck();
                    deck.shuffle();

                    /*
                     * Draw out the first card and prints it and asking the user if their guess is higher or
                     * lower than the current card. Also prints out how many points the user currently have.
                     *
                     */
                    String currentCard = deck.firstCard();
                    System.out.println("\n-= You have " + points + " points =-");
                    System.out.println("The current card is: " + currentCard);
                    System.out.println("Will it be higher or lower?");
                    String guess = in.next();

                    /*
                     * If cases based on if the player guesses higher or lower.
                     *
                     */
                    if (guess.equals("lower")) {
                        /*
                         * Checks if the cards are 10 or above and assigns them an int-value.
                         *
                         */
                        checkFirstCard();
                        checkSecondCard();
                        /*
                         * Prints out what the new (second card) is.
                         *
                         */
                        System.out.println("You guessed lower. Your card is: " + deck.secondCard());
                        String j = printOutCardValue(valueOfCurrentCard);

                        /*
                         * If-else cases to check the value of both cards and prints out accordingly if the user
                         * guessed right or wrong.
                         *
                         * There is a chance its a tie - if so, the user loses.
                         *
                         */
                        if (valueOfCurrentCard > valueOfNextCard) {
                            if (valueOfNextCard == 10) {
                                System.out.println("Correct! " + deck.secondCard().charAt(0) + deck.secondCard().charAt(1) + " is lower than " + j);
                            } else {
                                System.out.println("Correct! " + deck.secondCard().charAt(0) + " is lower than " + j);
                            }

                            /*
                             * Adds a point if the user guesses correctly and places the card in the back of the deck.
                             *
                             */
                            points++;
                            deck.returnCard();
                        }

                        /*
                         * If its a tie the user loses and the points goes back to 0.
                         *
                         */
                        else if (valueOfCurrentCard == valueOfNextCard) {
                            System.out.println("Ouch! Bad luck, its a tie!");
                            deck.returnCard();
                            points = 0;
                        }

                        /*
                         * If the user guesses wrong the points goes back to 0 and the first card is placed in the back
                         * of the deck again.
                         *
                         */
                        else {
                            if (valueOfNextCard == 10) {
                                System.out.println("Wrong! " + deck.secondCard().charAt(0) + deck.secondCard().charAt(1) + " is lower than " + j);
                            } else {
                                System.out.println("Wrong! " + deck.secondCard().charAt(0) + " is higher than " + j);
                            }
                            points = 0;
                            deck.returnCard();
                        }

                        /*
                         * Same as above except if the user guesses higher instead of lower.
                         *
                         */
                    } else if (guess.equals("higher")) {
                        checkFirstCard();
                        checkSecondCard();
                        System.out.println("You guessed higher. Your card is: " + deck.secondCard());

                        String j = printOutCardValue(valueOfCurrentCard);

                        if (valueOfCurrentCard < valueOfNextCard) {
                            if (valueOfNextCard == 10) {
                                System.out.println("Correct! " + deck.secondCard().charAt(0) + deck.secondCard().charAt(1) + " is higher than " + j);
                            } else {
                                System.out.println("Correct! " + deck.secondCard().charAt(0) + " is higher than " + j);
                            }
                            points++;
                            deck.returnCard();
                        } else if (valueOfCurrentCard == valueOfNextCard) {
                            System.out.println("Ouch! Bad luck, its a tie!");
                            points = 0;
                            deck.returnCard();
                        } else {
                            if (valueOfNextCard == 10) {
                                System.out.println("Wrong! " + deck.secondCard().charAt(0) + deck.secondCard().charAt((1)) + " is lower than " + j);
                            } else {
                                System.out.println("Wrong! " + deck.secondCard().charAt(0) + " is lower than " + j);
                            }
                            points = 0;
                            deck.returnCard();
                        }
                    } else {
                        System.out.println("You can either go lower or higher. Try again!");
                    }
                    break;

                /*
                 * Prints out the information about how to play the game.
                 *
                 */
                case 2:
                    System.out.println("LOW OR HIGH");
                    System.out.println("The objective is to guess if the next card is lower or higher than last card.");
                    System.out.println("You can choose lower, higher or equal.");
                    break;

                /*
                 * Exits the program.
                 *
                 */
                case 3:
                    System.exit(0);

                default:
                    System.out.println("Please pick a number 1-3.");
            }
        }

    }

    /**
     * A method to check if the card is 10 or above (J, Q, K and A)
     * If so, add a value to the card, J = 11, Q = 12, K = 13 and A = 14.
     * Else, just parse the String to an Int-value (2-9).
     */

    private static void checkFirstCard() {
        checkIfItsTen = String.valueOf(deck.firstCard().charAt(0)) + String.valueOf(deck.firstCard().charAt(1));
        checkTheCard = String.valueOf(deck.firstCard().charAt(0));

        if (checkIfItsTen.equals("10")) {
            valueOfCurrentCard = 10;
        } else if (checkTheCard.equals("J")) {
            valueOfCurrentCard = 11;
        } else if (checkTheCard.equals("Q")) {
            valueOfCurrentCard = 12;
        } else if (checkTheCard.equals("K")) {
            valueOfCurrentCard = 13;
        } else if (checkTheCard.equals("A")) {
            valueOfCurrentCard = 14;
        } else {
            valueOfCurrentCard = Integer.parseInt(String.valueOf(deck.firstCard().charAt(0)));
        }
    }

    /**
     * A method to check if the card is 10 or above (J, Q, K and A)
     * If so, add a value to the card, J = 11, Q = 12, K = 13 and A = 14.
     * Else, just parse the String to an Int-value (2-9).
     */

    private static void checkSecondCard() {
        checkIfItsTen = String.valueOf(deck.secondCard().charAt(0)) + String.valueOf(deck.secondCard().charAt(1));
        checkTheCard = String.valueOf(deck.secondCard().charAt(0));

        if (checkIfItsTen.equals("10")) {
            valueOfNextCard = 10;
        } else if (checkTheCard.equals("J")) {
            valueOfNextCard = 11;
        } else if (checkTheCard.equals("Q")) {
            valueOfNextCard = 12;
        } else if (checkTheCard.equals("K")) {
            valueOfNextCard = 13;
        } else if (checkTheCard.equals("A")) {
            valueOfNextCard = 14;
        } else {
            valueOfNextCard = Integer.parseInt(String.valueOf(deck.secondCard().charAt(0)));
        }
    }

    /**
     * Method when printing out the card when comparing to previous card.
     * If value = 11 print out "J", if 12 print out "Q" etc..
     *
     * @param valueOfCurrentCard
     * @return the card value in text (J, Q, K, A)
     */

    private static String printOutCardValue(int valueOfCurrentCard) {
        if (valueOfCurrentCard == 11)
            return "J";
        else if (valueOfCurrentCard == 12)
            return "Q";
        else if (valueOfCurrentCard == 13)
            return "K";
        else if (valueOfCurrentCard == 14)
            return "A";
        else
            return "" + valueOfCurrentCard;
    }
}



