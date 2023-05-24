/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import main.GamePanel;
import object.OBJ_Potion_Red;

/**
 *
 * @author tranbachtung
 */
public class NPC_Merchant extends Entity{
    
    public NPC_Merchant(GamePanel gp){
        super(gp);
        
        direction ="down";
        speed = 1;
        
        dialogueSet = -1;
        
        getImage();
        setDialogue();
        setItems();
    }
    public void getImage(){
        
        up1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        
    }
    
    public void setDialogue(){
        
        dialogues[0][0] = "Hehe, so you found me.\nI have some good stuff.\nDo you want to trade?";
        dialogues[1][0] = "Come again, hehe!";
        dialogues[2][0] = "You need more coin to buy that!";
        dialogues[3][0] = "You cannot carry anymore!";
        dialogues[4][0] = "You cannot sell an equpped item!";

        
    }
    
    public void setItems(){
        
        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Potion_Red(gp));
    }
    
    public void speak(){
        // Do this character specific stuff

        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
        
    }
}
