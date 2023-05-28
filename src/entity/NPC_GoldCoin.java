/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Random;
import main.GamePanel;

/**
 *
 * @author trinh
 */
public class NPC_GoldCoin extends Entity{
    
    public NPC_GoldCoin(GamePanel gp){
        super(gp);
        
        direction ="down";
        speed = 1;
        
        getImage();
    }
    public void getImage(){
        
        up1 = setup("/npc/goldcoin_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/goldcoin_down_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/goldcoin_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/goldcoin_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/goldcoin_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/goldcoin_down_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/goldcoin_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/goldcoin_down_2", gp.tileSize, gp.tileSize);
        
    }
    
    
    public void setAction(){
        
        actionLockCounter++;
        
        if(actionLockCounter == 100){
            Random random = new Random();
            int i = random.nextInt(100)+1; // pick a number from 1 to 100
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
            
            actionLockCounter = 0;
        }
        
    }
}
