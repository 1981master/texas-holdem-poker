/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdempoker;

import java.util.Random;

/**
 *
 * @author mvami
 */
public class Computer extends Player {
    private int decision;
    private String difficulty;
    
    public int decide(){
        Random rand = new Random(); 
        return  rand.nextInt(100);
    }
    
    public String getDifficultyLevel(){
        return this.difficulty;
    }
    
    public void setDifficultyLevel(String level){
        this.difficulty = level;
    }
}
