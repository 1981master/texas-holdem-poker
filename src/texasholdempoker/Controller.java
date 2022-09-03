/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdempoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author mvami
 */
public class Controller {
    
    StartPage startPage;
    GamePage gamePage;
    Dealer dealer;
    Player player;
    Computer computer;
    
    int stage = 0;
    
    public Controller(StartPage startPage, GamePage gamePage, Dealer dealer, Player player, Computer computer){
        this.startPage = startPage;
        this.dealer = dealer;
        this.gamePage = gamePage;
        this.player = player;
        this.computer = computer;
        
        this.startPage.addjButtonStartGame(new jButtonStartGameListener());
        this.gamePage.addjButtonNewRound(new jButtonNewRoundListener());
        this.gamePage.addjButtonRaise(new jButtonRaiseListener());
        this.gamePage.addjButtonCall(new jButtonCallListener());
        this.gamePage.addjButtonFold(new jButtonFoldListener());
    }

    private void displayWinner() {
        int playerRank = this.dealer.DetermineBestHand(this.dealer.getPlayerCards(), this.dealer.getCommunityCards());
        int computerRank = this.dealer.DetermineBestHand(this.dealer.getComputerCards(), this.dealer.getCommunityCards());
        
        String winner = this.dealer.identifyWinner(playerRank, computerRank);
        
        switch(winner){
            case "Player":
               this.gamePage.setDisplayWinner("The Winner is Player!");
               this.handOverBet("C->P"); 
               break;
            case "Computer":
               this.gamePage.setDisplayWinner("The Winner is Computer!");
               this.handOverBet("P->C"); 
               break;
            case "Draw":
               this.gamePage.setDisplayWinner("Draw!");
               break;
            default:
                break;
        }
        //
        
        //if
        
        this.gamePage.setComputerBestHand(this.dealer.identifyHouselast(computerRank));
        this.gamePage.setPlayerBestHand(this.dealer.identifyHouselast(playerRank));
    }

    private void displayWinnerAsComputer() {
        this.gamePage.setDisplayWinner("The Computer Won!");
        
        this.gamePage.setComputerBestHand("Default Winner!");
        this.gamePage.setPlayerBestHand("Forfeited!");

        this.handOverBet("P->C"); 
    }

    private void displayWinnerAsPlayer() {
        this.gamePage.setDisplayWinner("The Player Won!");
        
        this.gamePage.setComputerBestHand("Forfeited!");
        this.gamePage.setPlayerBestHand("Default Winner!");

        this.handOverBet("C->P"); 
    }

    private void disableBetButtons() {
        this.gamePage.disableBetButtons();
    }

    private void hideAllCards() {
        this.gamePage.setPlayerCard1(52);
        this.gamePage.setPlayerCard2(52);
        
        this.gamePage.setComputerCard1(52);
        this.gamePage.setComputerCard2(52);
        
        this.gamePage.setCommunityCard1(52);
        this.gamePage.setCommunityCard2(52);
        this.gamePage.setCommunityCard3(52);
        this.gamePage.setCommunityCard4(52);
        this.gamePage.setCommunityCard5(52);
           
    }

    private void computerPlays() {
        Random rand = new Random();
        
        this.computer.setDifficultyLevel(this.gamePage.getDifficultyLevel());
        
        int decision = this.computer.decide();
        
        switch(this.computer.getDifficultyLevel()){
            case "Easy":
                if(0 <= decision && decision <= 50){ // omputer Raises
                    this.gamePage.setcomputerDecision("Raise!");

                    this.computer.raiseBet(rand.nextInt(100));
                    this.gamePage.setComputerBet(Integer.toString(this.computer.getBet()));
                } else if(50 < decision && decision <= 45){ //Calls
                        this.gamePage.setcomputerDecision("Call!");
                } else { //Folds
                        this.disableBetButtons();
                        this.gamePage.setcomputerDecision("Fold!");
                        this.displayWinnerAsPlayer();
                }   
                break;
            case "Medium":
                if(0 <= decision && decision <= 50){ // omputer Raises
                    this.gamePage.setcomputerDecision("Raise!");

                    this.computer.raiseBet(rand.nextInt(100));
                    this.gamePage.setComputerBet(Integer.toString(this.computer.getBet()));
                } else if(50 < decision && decision <= 85){ //Calls
                        this.gamePage.setcomputerDecision("Call!");
                } else { //Folds
                        this.disableBetButtons();
                        this.gamePage.setcomputerDecision("Fold!");
                        this.displayWinnerAsPlayer();
                }   
                break;
            case "Hard":
                if(0 <= decision && decision <= 75){ // omputer Raises
                    this.gamePage.setcomputerDecision("Raise!");

                    this.computer.raiseBet(rand.nextInt(100));
                    this.gamePage.setComputerBet(Integer.toString(this.computer.getBet()));
                } else if(75 < decision && decision <= 95){ //Calls
                        this.gamePage.setcomputerDecision("Call!");
                } else { //Folds
                        this.disableBetButtons();
                        this.gamePage.setcomputerDecision("Fold!");
                        this.displayWinnerAsPlayer();
                }   
                break;
            default:
                break;
        }
            
    }

    private void handOverBet(String dec) {
        if (dec.equals("P->C")){
            this.computer.raiseBet(this.player.getBet());
            this.player.setBet(0);
        } else {
            this.player.raiseBet(this.computer.getBet());
            this.computer.setBet(0);
        }
        
        this.gamePage.setComputerBet(Integer.toString(this.computer.getBet()));
        this.gamePage.setPlayerBet(Integer.toString(this.player.getBet()));
    }
    
    
    private class jButtonCallListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            playerCall();
        }
    }
    
    private class jButtonFoldListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            playerFold();
        }
    }
    
    private class jButtonRaiseListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            playerRaise(gamePage.getPlayerBet());
        }
    }
    
    private class jButtonStartGameListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    }
    
    private class jButtonNewRoundListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            newRound();
        }
    }
    
    public void displayPlayerCards(){
        this.gamePage.setPlayerCard1(this.dealer.getPlayerCards()[0]);
        this.gamePage.setPlayerCard2(this.dealer.getPlayerCards()[1]);
    }
    
    public void displayFlopCards(){
            this.gamePage.setCommunityCard1(this.dealer.getCommunityCards()[0]);
            this.gamePage.setCommunityCard2(this.dealer.getCommunityCards()[1]);
            this.gamePage.setCommunityCard3(this.dealer.getCommunityCards()[2]);
    }
    
    public void displayComputerCards(){
        this.gamePage.setComputerCard1(this.dealer.getComputerCards()[0]);
        this.gamePage.setComputerCard2(this.dealer.getComputerCards()[1]);
    }
    
    public void displayRiverCards(){
        this.gamePage.setCommunityCard1(this.dealer.getCommunityCards()[0]);
            this.gamePage.setCommunityCard2(this.dealer.getCommunityCards()[1]);
            this.gamePage.setCommunityCard3(this.dealer.getCommunityCards()[2]);
        this.gamePage.setCommunityCard4(this.dealer.getCommunityCards()[3]);
    }
    
    public void displayShowDownCards(){
        this.gamePage.setCommunityCard1(this.dealer.getCommunityCards()[0]);
            this.gamePage.setCommunityCard2(this.dealer.getCommunityCards()[1]);
            this.gamePage.setCommunityCard3(this.dealer.getCommunityCards()[2]);
        this.gamePage.setCommunityCard4(this.dealer.getCommunityCards()[3]);
               this.gamePage.setCommunityCard5(this.dealer.getCommunityCards()[4]);

    }
    
    public void newRound(){
        this.stage = 0;
        
        this.dealer.shuffleDeck();
        this.dealer.dealCards();
        
        hideAllCards();
        
        displayPlayerCards();
        
        this.gamePage.enableBetButtons();
        
        this.gamePage.setcomputerDecision("Decision");
        this.gamePage.setComputerBestHand("Computer's best hand...");
        this.gamePage.setPlayerBestHand("Player's best hand...");
        
    }
    
    public void playerRaise(int bet){

        switch (this.stage){
            case 0:
                this.player.raiseBet(bet);
                this.gamePage.setPlayerBet(Integer.toString(this.player.getBet()));
                
                this.computerPlays();
      
                
                this.displayFlopCards();
                this.stage++;
                break;
            case 1:
                this.player.raiseBet(bet);
                this.gamePage.setPlayerBet(Integer.toString(this.player.getBet()));
                
                this.computerPlays();
                
                this.displayRiverCards();
                this.stage++;
                break;
            case 2:
                this.player.raiseBet(bet);
                this.gamePage.setPlayerBet(Integer.toString(this.player.getBet()));
                
                this.computerPlays();

                this.displayShowDownCards();
                this.stage++;
                break;
            case 3:
                this.disableBetButtons();
                this.displayComputerCards();
                this.displayWinner();
                break;
            default:
                this.disableBetButtons();
                this.displayWinner();
                break;
        }
    }
    
    public void playerCall(){
        switch (this.stage){
            case 0:
                this.displayFlopCards();
                this.computerPlays();

                this.stage++;
                break;
            case 1:
                this.displayRiverCards();
                this.computerPlays();
                this.stage++;
                break;
            case 2:
                this.displayShowDownCards();
                this.computerPlays();
                this.stage++;
                break;
            case 3:
                this.disableBetButtons();
                this.displayWinner();
                this.displayComputerCards();
                break;
            default:
                this.displayWinner();
                this.disableBetButtons();
                break;
        }
    }
    
    public void playerFold(){
        this.disableBetButtons();
        this.displayWinnerAsComputer();
    }
    
    public void endRound(){
        
    }
    
    public void launchGame(){
        this.startPage.setVisible(true);
    }
    
    public void startGame(){
        
        this.player.setName(this.startPage.getPlayerName());
        this.gamePage.setVisible(true);
        this.startPage.dispose();
        this.gamePage.setPlayerName(this.player.getName());
        this.disableBetButtons();
    }
    
    public void quitGame(){
        
    }
}
