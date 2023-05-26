/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Bullet;
import object.OBJ_Key;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

/**
 *
 * @author tranbachtung
 */
public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    public boolean attackCanceled = false;
    
    
    
    public Player (GamePanel gp, KeyHandler keyH){
        
        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        // SOLID AREA
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        // ATTACK AREA

        
        setDefaultValues();
        
    } 
    public void setDefaultValues(){
        worldX = gp.tileSize *37;//11;
        worldY = gp.tileSize *8;
        defaultSpeed = 4;
        speed = defaultSpeed;
        direction = "down";
        
        // PLAYER STATUS
        level = 1;
        maxLife = 6;
        life = maxLife;
        maxMana = 4;
        mana = maxMana;
        strength = 1; // the more strength, the more damage given
        dexterity = 1; // the more dexterity, the less damage taken
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        projectile = new OBJ_Bullet(gp);
        attack = getAttack(); // total attack is decided by strength * weapon
        defense = getDefense(); // total defense is decided by dexterity * shield
        
        setDialogue();
        getPlayerImage();
        getPlayerAttackImage();
        setItems();
    }
    
    public void setDefaultPositions(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    
    public void setDialogue(){
        
        dialogues[0][0] = "You are level " + level + " now!\nYou feel stronger!";
    }
    
    public void restoreStatus(){
        
        life = maxLife;
        mana = maxMana;
        invincible = false;
        attacking = false;
//        guarding = false;
        knockBack = false;
    }
    
    public void setItems(){
        
        inventory.clear();
        inventory.add(currentWeapon);
        inventory.add(currentShield);
    }
    
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength + currentWeapon.attackValue;
    }
    
    public int getDefense(){
        return defense = dexterity + currentShield.defenseValue;
    }
    
    public void getPlayerImage(){
        
        up1 = setup("/player/boy_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/boy_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/boy_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/player/boy_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/boy_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/player/boy_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/boy_right_2", gp.tileSize, gp.tileSize);
        
    }
    
    public void getPlayerAttackImage(){
        
        if(currentWeapon.type == type_sword){
            attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize*2);
            attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize*2);
            attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize*2);
            attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize*2);
            attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize*2, gp.tileSize);
            attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize*2, gp.tileSize);
            attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize*2, gp.tileSize);
            attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize*2, gp.tileSize);
        }
        if(currentWeapon.type == type_axe){
            attackUp1 = setup("/player/boy_axe_up_1", gp.tileSize, gp.tileSize*2);
            attackUp2 = setup("/player/boy_axe_up_2", gp.tileSize, gp.tileSize*2);
            attackDown1 = setup("/player/boy_axe_down_1", gp.tileSize, gp.tileSize*2);
            attackDown2 = setup("/player/boy_axe_down_2", gp.tileSize, gp.tileSize*2);
            attackLeft1 = setup("/player/boy_axe_left_1", gp.tileSize*2, gp.tileSize);
            attackLeft2 = setup("/player/boy_axe_left_2", gp.tileSize*2, gp.tileSize);
            attackRight1 = setup("/player/boy_axe_right_1", gp.tileSize*2, gp.tileSize);
            attackRight2 = setup("/player/boy_axe_right_2", gp.tileSize*2, gp.tileSize);
        }
        
    }

    public void update(){
        
        if(attacking == true){
            attacking();
        }  
        else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true){
            if (keyH.upPressed == true){
            direction = "up";
        }
        else if (keyH.downPressed == true){
            direction = "down";   
        }
        else if (keyH.leftPressed == true){
            direction = "left";   
        }
        else if (keyH.rightPressed == true){
            direction = "right";   
        }
        // CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        // CHECK OBJECT COLLISION
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        
        // CHECK NPC COLLISION
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);
        
        // CHECK MONSTER COLLISION
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);
        
        // CHECK EVENT
        gp.eHandler.checkEvent();
        
        
        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false && keyH.enterPressed == false){
            
            switch(direction){
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
            }
        }
        
        if(keyH.enterPressed == true && attackCanceled == false){
            gp.playSE(7);
            attacking = true;
            spriteCounter = 0;
        }
        
        attackCanceled = false;
        gp.keyH.enterPressed = false;
            
        spriteCounter++;
        if (spriteCounter > 10){
            if (spriteNum == 1){
                spriteNum = 2;
            }
            else if (spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
            }
        }
        else {
            standCounter++;
            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }
        }
        
        if(gp.keyH.shotKeyPressed == true && projectile.alive == false 
                && shotAvailableCounter == 30 && projectile.haveResource(this) == true){
            
            // SET DEFAULT COODINATES, DIRECTION AND USER
            projectile.set(worldX, worldY, direction, true, this);
            
            // SUBTRACT THE COST (MANA, AMMO ETC.)
            projectile.subtractResource(this);
            
            // ADD IT TO THE LIST
            gp.projectileList.add(projectile);
            
            shotAvailableCounter = 0;
            
            gp.playSE(10);
        }
        
        // This need to be outside of key if statement!
        // INVINCIBLE
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
            
        }
        
        if(shotAvailableCounter < 30){
            shotAvailableCounter++;
        }
        
        if(life > maxLife){
            life = maxLife;
        }
        
        if(mana > maxMana){
            mana = maxMana;
        }
        
        if(life <= 0){
            gp.gameState = gp.gameOverState;
            gp.ui.commandNum = -1;
            gp.stopMusic();
            gp.playSE(11);
        }
        
    }
    
    public void attacking(){
        
        spriteCounter++;
        if(spriteCounter <= 5){
            spriteNum = 1;
        }
        if(spriteCounter > 5 && spriteCounter <= 25){
            spriteNum = 2;
            
            // Save the current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            
            // Adjust player's worldX/Y for the attack area
            switch(direction){
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;
            }
            // AttackArea becomes solidArea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            // Check monster collision with the updated worldX/Y and solidArea
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex, attack);
            
            // After checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
            
        }
        if(spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }
    
    public void pickUpObject(int i){
        
        if(i != 999){
            
            // PICKUP ONLY ITEMS
            if(gp.obj[gp.currentMap][i].type == type_pickupOnly){
                
                gp.obj[gp.currentMap][i].use(this);
                gp.obj[gp.currentMap][i] = null;
            }
            
            // OBSTACLE
            else if(gp.obj[gp.currentMap][i].type == type_obstacle){
                if(keyH.enterPressed == true){
                    attackCanceled = true;
                    gp.obj[gp.currentMap][i].interact();
                }
            }
            
            // INVENTORY ITEMS
            else{
                String text;
            
                if(inventory.size() != maxInventorySize){
                
                    inventory.add(gp.obj[gp.currentMap][i]);
                    gp.playSE(1);
                    text = "Got a " + gp.obj[gp.currentMap][i].name + "!";
                
                }
                else{
                    text = "You cannot carry anymore!";
                }
                gp.ui.addMessage(text);
                gp.obj[gp.currentMap][i] = null;
            }
            
        }
    }
    
    public void interactNPC(int i){
        
        if(gp.keyH.enterPressed == true){
            if(i != 999){
                attackCanceled = true;
                gp.npc[gp.currentMap][i].speak(); 
            }
        }
    }
    
    public void contactMonster(int i){
        
        if(i != 999){
            
            if(invincible == false && gp.monster[gp.currentMap][i].dying == false){
                gp.playSE(6);
                
                int damage = gp.monster[gp.currentMap][i].attack - defense;
                if(damage < 0){
                    damage = 0;
                }
                
                life -= damage;
                invincible = true;
            }            
        }
    }
    
    public void damageMonster(int i, int attack){
        if(i != 999){
            
            if (gp.monster[gp.currentMap][i].invincible == false){
                
                gp.playSE(5);
                
                knockBack(gp.monster[gp.currentMap][i]);
                
                int damage = attack - gp.monster[gp.currentMap][i].defense;
                if(damage < 0){
                    damage = 0;
                }
                
                gp.monster[gp.currentMap][i].life -= damage;
                gp.ui.addMessage(damage + " damage!");
                
                gp.monster[gp.currentMap][i].invincible = true;
                gp.monster[gp.currentMap][i].damageReaction();
                
                if (gp.monster[gp.currentMap][i].life <= 0){
                    gp.monster[gp.currentMap][i].dying = true;
                    gp.ui.addMessage("Killed the " + gp.monster[gp.currentMap][i].name + "!");
                    gp.ui.addMessage("Exp + " + gp.monster[gp.currentMap][i].exp + "!");
                    exp += gp.monster[gp.currentMap][i].exp;
                    checkLevelUp();
                }
            }
        }
    }
    public void knockBack(Entity entity){
        entity.direction = direction;
        entity.speed +=10;
        entity.knockBack = true;
    }
    
    public void checkLevelUp(){
        
        if(exp >= nextLevelExp){
            
            level++;
            nextLevelExp = nextLevelExp * 2 + 5;
            maxLife += 2;
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            
            gp.playSE(8);
            gp.gameState = gp.dialogueState;
            setDialogue();
            startDialogue(this,0);
   
        }
    }
    
    public void selectItem(){
        
        int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol,gp.ui.playerSlotRow);
        
        if(itemIndex < inventory.size()){
            
            Entity selectedItem = inventory.get(itemIndex);
            
            if(selectedItem.type == type_sword || selectedItem.type == type_axe){
                
                currentWeapon = selectedItem;
                attack = getAttack();            
                getPlayerAttackImage();
            }
            
            if(selectedItem.type == type_shield){
                
                currentShield = selectedItem;
                defense = getDefense();               
            }
            
            if(selectedItem.type == type_consumable){
                
                if(selectedItem.use(this) == true){
                    inventory.remove(itemIndex);
                }                
            }
        }
    }
    
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        
        switch(direction){
            case "up":
                if (attacking == false) {
                    if (spriteNum == 1) { image = up1; }
                    if (spriteNum == 2) { image = up2; } 
                }
                if (attacking == true) {
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNum == 1) { image = attackUp1; }
                    if (spriteNum == 2) { image = attackUp2; } 
                }
                break;
            case "down":
                if (attacking == false) {
                    if (spriteNum == 1) { image = down1; }
                    if (spriteNum == 2) { image = down2; }
                }
                if (attacking == true) {
                    if (spriteNum == 1) { image = attackDown1; }
                    if (spriteNum == 2) { image = attackDown2; }
                }
                break;
            case "left":
                if (attacking == false) {
                    if (spriteNum == 1) { image = left1; }
                    if (spriteNum == 2) { image = left2; }
                }
                if (attacking == true) {
                    tempScreenX = screenX - gp.tileSize;
                    if (spriteNum == 1) { image = attackLeft1; }
                    if (spriteNum == 2) { image = attackLeft2; }
                }
                break;
            case "right":
                if (attacking == false) {
                    if (spriteNum == 1) { image = right1; }
                    if (spriteNum == 2) { image = right2; }
                }
                if (attacking == true) {
                    if (spriteNum == 1) { image = attackRight1; }
                    if (spriteNum == 2) { image = attackRight2; }
                }
                break;
        }
        
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        
        // RESET ALPHA
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        

    }
}
