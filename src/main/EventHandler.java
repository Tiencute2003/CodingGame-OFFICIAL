/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import ai.data.Progress;
import entity.Entity;


/**
 *
 * @author tranbachtung
 */
public class EventHandler {
    
    GamePanel gp;
    EventRect eventRect[][][];
    Entity eventMaster;
    
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    public EventHandler(GamePanel gp){
        this.gp = gp;
        
        eventMaster = new Entity(gp);
        
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        
        int map = 0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow){
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
            
            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
                
                if(row == gp.maxWorldRow){
                    row = 0;
                    map++;
                }
            }
        }
        
        setDialogue();
    }
    
    public void setDialogue(){
        
        eventMaster.dialogues[0][0] = "You fall into a pit!";
        
        eventMaster.dialogues[1][0] = "Your life and mana has been recovered to fullest.\nThe progress has been saved";
    }
    
    public void checkEvent(){
        
        // check if the player character is more than 1 tile away from the last event
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance > gp.tileSize){
            canTouchEvent = true;
        }
        
        if(canTouchEvent == true) {
            if(hit(0,24,16,"right") == true) { damagePit(gp.dialogueState); }
            if(hit(0,26,16,"right") == true) { damagePit(gp.dialogueState); }
            //else if(hit(0,23,19,"any") == true) { damagePit(gp.dialogueState); }
            else if(hit(3,22,8,"any") == true) { healingPool(gp.dialogueState); }
            else if(hit(3,23,8,"any") == true) { healingPool(gp.dialogueState); }
            else if(hit(3,24,8,"any") == true) { healingPool(gp.dialogueState); }
            
            else if(hit(2,3,16,"any") == true) { healingPool(gp.dialogueState); }
            else if(hit(2,4,16,"any") == true) { healingPool(gp.dialogueState); }
            else if(hit(2,5,16,"any") == true) { healingPool(gp.dialogueState); }
            
            else if(hit(0,24,22,"any") == true) { healingPool(gp.dialogueState); }
            else if(hit(0,12,32,"any") == true) { teleport(1,12,13); }
//            else if(hit(1,12,13,"any") == true) { teleport(0,10,39); }
//            else if(hit(1,12,9,"up") == true) { speak(gp.npc[1][0]);}
            else if(hit(0,5,4,"any") == true) { teleport(2,26,5); }
            else if(hit(2,26,5,"any") == true) { teleport(0,5,4); }
            else if(hit(2,24,4,"any") == true) { teleport(2,25,40); }
            else if(hit(2,25,40,"any") == true) { teleport(2,24,4); }
            else if(hit(2,25,4,"any") == true) { teleport(2,26,40); }
            else if(hit(2,26,40,"any") == true) { teleport(2,25,4); }
            else if(hit(2,22,44,"any") == true) { teleport(3,25,5); }
            else if(hit(3,25,5,"any") == true) { teleport(2,22,44); }
            else if(hit(3,22,44,"any") == true) { teleport(3,25,5); }
            
            
            else if(hit(3,11,44,"any") == true) { teleport(5,25,34); }
            else if(hit(5,25,34,"any") == true) { teleport(3,11,44); }
            else if(hit(3,12,44,"any") == true) { teleport(5,26,34); }
            else if(hit(5,26,34,"any") == true) { teleport(3,12,44); }
            
            else if(hit(5,26,24,"up") == true) {skeletonLord();}//BOSS
            
            else if(hit(5,25,6,"any") == true) { teleport(4,26,40); }
            
            else if(hit(5,26,6,"any") == true) { teleport(4,26,40); }
        }
    }
    
    public boolean hit(int map, int col, int row, String reqDirection){
        
        boolean hit = false;
        
        if(map == gp.currentMap){
            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;
        
            if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false){
                if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                    hit = true;
                
                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }
        
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;     
        }
        
        return hit;
    }
    
    public void damagePit(int gameState){
        
        gp.gameState = gameState;
        gp.playSE(6);
        eventMaster.startDialogue(eventMaster, 0);
        gp.player.life -= 1;
        canTouchEvent = false;
    }
    
    public void healingPool(int gameState){
        
        if(gp.keyH.enterPressed == true){
            
            gp.gameState = gameState;
            gp.player.attackCanceled = true;
            gp.playSE(2);
            eventMaster.startDialogue(eventMaster, 1);
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            // one-time-only event
            //eventRect[col][row].eventDone = true;
            gp.aSetter.setMonster();
            gp.saveLoad.save();
        }
    }
    
    public void teleport(int map, int col, int row){
        
        gp.currentMap = map;
        gp.player.worldX = gp.tileSize * col;
        gp.player.worldY = gp.tileSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
        gp.playSE(12);
    }
    
    public void speak(Entity entity){
        
        if(gp.keyH.enterPressed == true){
            gp.gameState = gp.dialogueState;
        gp.player.attackCanceled = true;
            entity.speak();
        }
    }
    public void skeletonLord (){
        if(gp.bossBattleOn == false && Progress.skeletonLordDefeated == false){
            gp.gameState = gp.cutscenceState;
            gp.csManager.sceneNum = gp.csManager.skeletonLord;
        }
    }
}
