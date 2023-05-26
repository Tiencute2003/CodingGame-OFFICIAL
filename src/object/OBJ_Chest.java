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
//neu muon lam open chest thi bat 53/64 - 25:20s va video 44
public class OBJ_Chest extends Entity{
    
    public OBJ_Chest(GamePanel gp){
        super(gp);
        name = "Chest";
        down1 = setup("/objects/chest", gp.tileSize, gp.tileSize);
    }
    
}
