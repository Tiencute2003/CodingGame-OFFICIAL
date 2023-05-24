/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Entity;
import main.GamePanel;

/**
 *
 * @author tranbachtung
 */
public class OBJ_Key extends Entity {
    
    GamePanel gp;
    
    public OBJ_Key(GamePanel gp){        
        super(gp);
        this.gp = gp;
        
        type = type_consumable;
        name = "Key";
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
        description = "[ " + name + " ]\nIt open a door.";
               
    }
    
    public void setDialogue(){
        
        dialogues[0][0] = "You use the" + name + " to open the door!";
        dialogues[1][0] = "It doesn't have any door nearby.";
    }
    
    public boolean use(Entity entity){
        

        int objIndex = getDetected(entity, gp.obj, "Door");
        
        if(objIndex != 999){
            startDialogue(this,0);
            gp.playSE(3);
            gp.obj[gp.currentMap][objIndex] = null;
            return true;
        }
        else{
            startDialogue(this,1);
            return false;
        }
    }
}
