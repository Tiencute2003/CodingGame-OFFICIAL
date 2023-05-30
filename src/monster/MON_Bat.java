/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monster;

/**
 *
 * @author trinh
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import entity.Entity;
import java.util.Random;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

/**
 *
 * @author tranbachtung
 */
public class MON_Bat extends Entity{
    
    GamePanel gp;
    
    public MON_Bat(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_monster;
        name = "Bat";
        defaultSpeed = 4;
        speed = defaultSpeed;
        maxLife = 10;
        life = maxLife;
        attack = 4;
        defense = 0;
        exp = 4;
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
        
        up1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
        down1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
        right1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
    }
    
    public void setAction(){
        
        if(onPath == true){
//            checkStopChasingOrNot(gp.player, 15, 100);           
//            //SEARCH THE DIRECTION TO GO 
//            searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
//            //CHECK IF IT SHOOTS A PROJECTILE
//            checkShootOrNot(200, 30);
        }
        else{
//            checkStartChasingOrNot(gp.player, 5, 100); 
            
            getRandomDirection(40);
        }
        
    }
    
    public void damageReaction(){
//        direction= gp.player.direction;
        actionLockCounter = 0;
//        onPath = true;
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

