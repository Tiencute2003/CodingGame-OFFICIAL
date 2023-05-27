package monster;


import entity.Entity;
import java.util.Random;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trinh
 */
public class MON_GreySkeleton extends Entity{
    GamePanel gp;
    
    public MON_GreySkeleton(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_monster;
        name = "Grey Skeleton";
        defaultSpeed = 2;
        speed = defaultSpeed;
        maxLife = 6;
        life = maxLife;
        attack = 7;
        defense = 2;
        exp = 3;
        projectile = new OBJ_Rock(gp);
        
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getImage();
    }
    
    public void getImage(){
        
        up1 = setup("/monster/l0_sprite_064", gp.tileSize, gp.tileSize);
        up2 = setup("/monster/l0_sprite_065", gp.tileSize, gp.tileSize);
        down1 = setup("/monster/l0_sprite_055", gp.tileSize, gp.tileSize);
        down2 = setup("/monster/l0_sprite_056", gp.tileSize, gp.tileSize);
        left1 = setup("/monster/l0_sprite_061", gp.tileSize, gp.tileSize);
        left2 = setup("/monster/l0_sprite_062", gp.tileSize, gp.tileSize);
        right1 = setup("/monster/l0_sprite_058", gp.tileSize, gp.tileSize);
        right2 = setup("/monster/l0_sprite_059", gp.tileSize, gp.tileSize);
    }
    
    public void setAction(){
        
        if(onPath == true){
            checkStopChasingOrNot(gp.player, 15, 100);           
            //SEARCH THE DIRECTION TO GO 
            searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
            //CHECK IF IT SHOOTS A PROJECTILE
            checkShootOrNot(200, 30);
        }
        else{
            checkStartChasingOrNot(gp.player, 5, 100); 
            
            getRandomDirection();
        }
        
    }
    
    public void damageReaction(){
        
        actionLockCounter = 0;
        onPath = true;
    }
    
    public void checkDrop(){
        
        // CAST A DIE
        int i = new Random().nextInt(100)+1;
        
        // SET THE MONSTER DROP
        if(i < 50){
            dropItem(new OBJ_Coin_Bronze(gp));
        }
        if(i >= 50 && i < 75){
            dropItem(new OBJ_Heart(gp));
        }
        if(i >= 75 && i < 100){
            dropItem(new OBJ_ManaCrystal(gp));
        }
    }
}
