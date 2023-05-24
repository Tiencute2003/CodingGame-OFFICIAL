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
public class OBJ_Axe extends Entity{
    
    public OBJ_Axe (GamePanel gp){
        super(gp);
        
        type = type_axe;
        name = "Woodcutter's Axe";
        down1 = setup("/objects/axe",gp.tileSize,gp.tileSize);
        attackValue = 2;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "[ " + name + " ]\nA bit rusty but still can \ncut some trees.";
        
    }
    
}
