/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Entity;
import main.GamePanel;

/**
 *
 * @author trinh
 */
public class OBJ_BlueHeart extends Entity {
    GamePanel gp;
    
    public static final String objName = "Blue Heart";

    public OBJ_BlueHeart(GamePanel gp) {
        super(gp);
        this.gp = gp;
        
        type = type_pickupOnly;
        name = objName;
        down1 = setup("/objects/blueheart",gp.tileSize,gp.tileSize);
        
        setDialoges();
    }

    private void setDialoges() {
        dialogues[0][0] = "Welcome you!";
        dialogues[0][1] = "The bravest hero!";   
        dialogues[0][2] = "It has been a very long time ~\nI have been waiting for someone who is the owner \nof this treasure."; 
        dialogues[0][3] = "It's you...";
        dialogues[0][4] = "THE CHOSEN ONE.";
    }
    public boolean use (Entity entity){
        gp.gameState = gp.cutscenceState;
        gp.csManager.sceneNum = gp.csManager.ending;
        return true;
    }
}
