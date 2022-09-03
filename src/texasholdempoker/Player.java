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
public class Player {

    private String name;
    private int bet;
    private boolean victor;

    public Player() {
        this.name = null;
        this.bet = 0;
        this.victor = false;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBet(){
        return bet;
    }
    
    public void setBet(int bet){
        this.bet = bet;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setVictor(boolean victor){
        this.victor = victor;
    }
    
    public void raiseBet(int betUp){
        bet += betUp;
    }
    
    public void fold(){
        victor = false;
    }
    
    
}
