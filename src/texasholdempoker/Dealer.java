/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdempoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author mvami
 */
public class Dealer {
    private ArrayList<Integer> deck;
    private int[] communityCards;
    private int[] playerCards;
    private int[] computerCards;
    
    
    Dealer(){
        deck = new ArrayList<>();
        communityCards = new int[5];
        playerCards = new int[2];
        computerCards = new int[2];
        
        for(int i=0; i <= 51; i++) deck.add(i);
    }
            
    
    /**
     *
     * @return
     */
    public ArrayList<Integer> getDeck(){
        return this.deck;
    }
    
    /**
     *
     * @param cardNumber
     * @return
     */
    public int getCard(int cardNumber){
        return this.deck.get(cardNumber);
    }
    
    /**
     *
     * @return
     */
    public int[] getCommunityCards(){
        return communityCards;
    }
    
    /**
     *
     * @return
     */
    public int[] getPlayerCards(){
        return playerCards;
    }
    
    /**
     *
     * @return
     */
    public int[] getComputerCards(){
        return computerCards;
    }
    
    /**
     *
     */
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }
    
    /**
     *
     */
    public void dealCards(){
        for(int i = 0; i <= 4; i++) communityCards[i] = deck.get(i);
        for(int i = 0; i <= 1; i++) playerCards[i] = deck.get(i+5);
        for(int i = 0; i <= 1; i++) computerCards[i] = deck.get(i+7);
    }
    
    /**
     *
     * @param ownerName
     * @return
     */
    public int DetermineBestHand(int[] towCards, int[] fiveCards){    
        //Card ca = new Card();
        int[] bestHand = new int[5];
        String[] compare = new String[10];
        // 123
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[0];
        bestHand[3] = fiveCards[1];
        bestHand[4] = fiveCards[2];
        sortArr(bestHand);
        String compare1 = identifyHand(bestHand);
        compare[0] = compare1;

        // 124
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[0];
        bestHand[3] = fiveCards[1];
        bestHand[4] = fiveCards[3];
        sortArr(bestHand);
        String compare2 = identifyHand(bestHand);
        compare[1] = compare2;

        // 125
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[0];
        bestHand[3] = fiveCards[1];
        bestHand[4] = fiveCards[4];
        sortArr(bestHand);
        String compare3 = identifyHand(bestHand);
        compare[2] = compare3;

        // 134
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[0];
        bestHand[3] = fiveCards[2];
        bestHand[4] = fiveCards[3];
        sortArr(bestHand);
        String compare4 = identifyHand(bestHand);
        compare[3] = compare4;

        // 135
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[0];
        bestHand[3] = fiveCards[2];
        bestHand[4] = fiveCards[4];
        sortArr(bestHand);
        String compare5 = identifyHand(bestHand);
        compare[4] = compare5;

        // 145
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[0];
        bestHand[3] = fiveCards[3];
        bestHand[4] = fiveCards[4];
        sortArr(bestHand);
        String compare6 = identifyHand(bestHand);
        compare[5] = compare6;

        // 234
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[1];
        bestHand[3] = fiveCards[2];
        bestHand[4] = fiveCards[3];
        sortArr(bestHand);
        String compare7 = identifyHand(bestHand);
        compare[6] = compare7;

        // 235
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[1];
        bestHand[3] = fiveCards[2];
        bestHand[4] = fiveCards[4];
        sortArr(bestHand);
        String compare8 = identifyHand(bestHand);
        compare[7] = compare8;

        // 245
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[1];
        bestHand[3] = fiveCards[3];
        bestHand[4] = fiveCards[4];
        sortArr(bestHand);
        String compare9 = identifyHand(bestHand);
        compare[8] = compare9;

        // 345
        bestHand[0] = towCards[0];
        bestHand[1] = towCards[1];
        bestHand[2] = fiveCards[2];
        bestHand[3] = fiveCards[3];
        bestHand[4] = fiveCards[4];
        sortArr(bestHand);
        String compare10 = identifyHand(bestHand);
        compare[9] = compare10;

        int counter = 10;
        for (int i = 0; i < 10; i++) {

            if (compare[i].equals("Royal Flush")) {
                
                counter = 1;
                return 1;
            } else if (compare[i].equals("Striaght Flush")) {
                   if(counter>2){
                         counter = 2;
                   }

            } else if (compare[i].equals("Four of a kind")) {
                if(counter>3){
                     counter = 3;
                }
                        

            } else if (compare[i].equals("Full House")) {
                if(counter>4){
                     counter = 4;
                }
                   

            }

            else if (compare[i].equals("Flush")) {
                if(counter>5){
                     counter = 5;
                }
                      

            } else if (compare[i].equals("Straight")) {
                   if(counter>6){
                        counter = 6;
                   }

            } else if (compare[i].equals("Three of kind")) {
                if(counter>7){
                     counter = 7;
                }
                        

            } else if (compare[i].equals("Two Pairs")) {
                   if(counter>8){
                        counter = 8;
                   }

            } else if (compare[i].equals("One Pair")) {
                if(counter>9){
                    counter = 9;
                }
                       

            } else {
                if(counter == 10)
                    counter =  10;
            }
        }
        return counter;
    }
            
    private String nameOfHand(int[] hand){
        
        return "";
    }
    
    private int rankOfHand(int[] hand){
        
        return 0;
    }
    
    /*
    * sortArr takes array of integer representing the Poker Hand, then it order
    * them regarding to its position as element%13
    *
    */
    public int[] sortArr(int[] hand) {
        int min = hand[0] % 13;
        int index = 0;
        int temp;
        for (int i = 0; i < hand.length; i++) {
            index = i;
            min = hand[i] % 13;
            for (int x = i; x < hand.length; x++) {
                if (hand[x] % 13 < min) {
                    min = hand[x] % 13;
                    index = x;
                }
            }
            temp = hand[i];
            hand[i] = hand[index];
            hand[index] = temp;

        } 
        return hand;
    }

    /*
    *isSameKind method it takes an array of integer and return boolean, its deteraom
    *if its the same kind or not.
    */
    public boolean isSameKind(int[] hand) {
        int cont;
        for (int i = 0; i < 4; i++) {
            cont = 0;
            for (int j = 0; j < hand.length; j++) {
                if (hand[j] / 13 == i)
                    cont++;
            } 
            if (cont == 5)
                return true;
        } 
        return false;
    }

    /*
    * identifyHand takes an array of intege representing the Hand, then determine the
    * kind of hand and return it, as String.
    */
    public String identifyHand(int[] hand) {
        
        boolean isItThreeOfKind = false;
        boolean isItStraight = true;
        boolean isItStraightFlush = true;
        int isItFullHouse = 0;
        int[] fourOrFullHouse = new int[5];
        int count = 10;
        
        for (int i = 0, j = 0; i < hand.length - 1; i++) {
            if (!(hand[i] == (hand[i + 1] - 1)))
                isItStraightFlush = false;

            if (!(hand[i] % 13 == ((hand[i + 1] % 13) - 1)))
                isItStraight = false;

            if (hand[i] % 13 == hand[i + 1] % 13) {
                isItFullHouse++;
                fourOrFullHouse[j++] = hand[i];

            } else
            count = i;
        } 

        if (isItStraightFlush || (isSameKind(hand) && isItStraigthAceTop(hand))) {
            if (Royal_Flush(hand)) {
                return "Royal Flush";
            }
            return "Striaght Flush";
        } // end of if
        else if (isItFullHouse == 3) {
            if (count == 0 || count == 3)
                return "Four of a kind";
            else
                return "Full House";
        } // end of if
        else if (isSameKind(hand))
            return "Flush";
        else if (isItStraight || isItStraigthAceTop(hand))
            return "Straight";
        else {
            boolean co = false;
            int forTwo = 0;
            int ofSuit[] = new int[2];
            for (int i = 0, j = 0; i < hand.length - 1; i++) {
                if (hand[i] % 13 == hand[i + 1] % 13) {
                if (co)
                    isItThreeOfKind = true;

                ofSuit[j++] = hand[i];
                co = true;
                forTwo++;
                } // end of if
                else
                    co = false;
            } // end of for loop
            if (isItThreeOfKind)
                return "Three of kind";
            else if (forTwo == 2)
                return "Two Pairs";
            else if (forTwo == 1)
                return "One Pair";
            else
                return "High Card";

        } // end of else

    }

    //Royal_Flush method it takes an array of hand (5 integers) and it return boolean.

    public boolean Royal_Flush(int[] hand) {
        sortArr(hand);// sorting the array hand.
        // all posable cases for Royal hands.
        int[] h = { 0, 9, 10, 11, 12 };
        int[] d = { 13, 22, 23, 24, 25 };
        int[] c = { 26, 35, 36, 37, 38 };
        int[] s = { 39, 48, 49, 50, 51 };

        if (Arrays.equals(hand, h) || Arrays.equals(hand, d) || Arrays.equals(hand, c) || Arrays.equals(hand, s))
            return true;
        return false;

    }

    /*
    * isItStraigthAceTop method it takes an array of integer "hand", and checks if its Straight, 
    * when the Ace on Top, and return boolean type regard to that.
    */
    public boolean isItStraigthAceTop(int[] hand) {

        int han[] = new int[5];

        // for loop copy hand into new array, whenever find Ace card, change its position
        // to the king position, else will push all the card one number down

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] % 13 == 0)
                han[i] = hand[i] + 12;
            else
                han[i] = hand[i] - 1;
        } // end of for loop

        sortArr(han);

        // then try to determine is the new array is straight or not
        for (int i = 0; i < han.length - 1; i++)
            if (han[i] % 13 != han[i + 1] % 13 - 1)
                return false;

        return true;
    }
    
    /*
    *identifyHouselast method it takes an integer and return.
    */
    public String identifyHouselast(int counter){
        
            if (counter == 1)
                return "Royal Flush";
            else if (counter == 2)
                return "Striaght Flush";
            else if (counter == 3)
                return "Four of a kind";
            else if (counter == 4)
                return "Full House";
            else if (counter == 5)
                return "Flush";
            else if (counter == 6)
                return "Straight";
            else if (counter == 7)
                return "Three of kind";
            else if (counter == 8)
                return "Two Pairs";
            else if (counter == 9)
                return "One Pair";
            else  
                return "High Card";
       
   
   
    }
    
    /*
    *identifyWinner it taker tow integers and return string, its for detrmsin the Winner.
    */
    public String identifyWinner(int playerHand, int ComputerHand){
        if(playerHand < ComputerHand){
            return "Player";
        }
        if(playerHand > ComputerHand){
            return "Computer";
        }
        return "Draw";
    
    }
    
}

