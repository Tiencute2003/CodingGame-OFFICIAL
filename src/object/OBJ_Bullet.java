/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

/**
 *
 * @author tranbachtung
 */
public class OBJ_Bullet extends Projectile{
    
    GamePanel gp;
    
    public OBJ_Bullet(GamePanel gp){
        super(gp);
        this.gp = gp;
        name = "Bullet";
        speed = 10;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        knockBackPower = 5;
        getImage();
    }
    
    public void getImage(){
        up1 = setup("/projectile/bullet_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/projectile/bullet_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/projectile/bullet_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/projectile/bullet_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/projectile/bullet_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/projectile/bullet_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/projectile/bullet_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/projectile/bullet_right_2",gp.tileSize,gp.tileSize);
    }
    public boolean haveResource(Entity user){
        
        boolean haveResource = false;
        if(user.mana >= useCost){
            haveResource = true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        
        user.mana -= useCost;
    }
}
