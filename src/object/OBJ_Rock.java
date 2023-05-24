/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Projectile;
import main.GamePanel;

/**
 *
 * @author tranbachtung
 */
public class OBJ_Rock extends Projectile{
    GamePanel gp;
    
    public OBJ_Rock(GamePanel gp){
        super(gp);
        this.gp = gp;
        name = "Rock";
        speed = 3;
        maxLife = 80;
        life = maxLife;
        attack = 6;
        useCost = 1;
        alive = false;
        getImage();
    }
    
    public void getImage(){
        up1 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        up2 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        down1 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        left1 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        left2 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        right1 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        right2 = setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
    }
}
