/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdempoker;

/**
 *
 * @author mvami
 */
public class Main {
    
    public static void main(String[] args) {
        
        StartPage startPage = new StartPage();
        GamePage gamePage = new GamePage();
        Dealer dealer = new Dealer();
        Player player = new Player();
        Computer computer = new Computer();
        
        Controller controller = new Controller(startPage, gamePage, dealer, player, computer);
        
        controller.launchGame();
    }
}