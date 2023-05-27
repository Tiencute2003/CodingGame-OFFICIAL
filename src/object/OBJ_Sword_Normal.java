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
public class OBJ_Sword_Normal extends Entity{
    
    public OBJ_Sword_Normal(GamePanel gp){
        super(gp);
        
        type = type_sword;
        name = "Normal Sword";
        down1 = setup("/objects/sword_normal",gp.tileSize,gp.tileSize);
        attackValue = 1;
        attackArea.width = 38;
        attackArea.height = 38;
        description = "[ " + name + " ]\nAn old sword.";
        knockBackPower = 3;
        
    }
}
