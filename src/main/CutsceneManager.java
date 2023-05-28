/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.PlayerDummy;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import monster.MON_SkeletonLord;
import object.OBJ_BlueHeart;
import object.OBJ_Door;

/**
 *
 * @author trinh
 */
public class CutsceneManager {
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;
    int counter = 0;
    public float alpha = 0f;
    int y;
    
    //Scene Number
    public final int NA = 0;
    public final int skeletonLord = 1;
    public final int ending = 2;

    public CutsceneManager(GamePanel gp) {
        this.gp = gp;
    }
    
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        
        switch(sceneNum){
            case skeletonLord: scene_skeletonLord();break;
            case ending: scene_ending();break;
        }
    }
    public void scene_skeletonLord(){
        if(scenePhase == 0){
            gp.bossBattleOn = true;
            
            // SHUT THE DOOR
            for(int i = 0; i< gp.obj[1].length;i++){
                if(gp.obj[gp.currentMap][i] == null){
                    gp.obj[gp.currentMap][i] = new OBJ_Door(gp);
                    gp.obj[gp.currentMap][i].worldX = gp.tileSize*26;
                    gp.obj[gp.currentMap][i].worldY = gp.tileSize*25;
                    gp.obj[gp.currentMap][i].temp = true;
                    gp.playSE(16);
                    break;
                }
            }
            // Search a vacant slot for the dummy
            for(int i = 0; i < gp.npc[1].length;i++) {
                if(gp.npc[gp.currentMap][i] == null) {
                    gp.npc[gp.currentMap][i] = new PlayerDummy(gp);
                    gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
                    gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
                    gp.npc[gp.currentMap][i].direction = gp.player.direction;
                    break;
                }
            }
            gp.player.drawing = false;
            scenePhase++;
        }
        if(scenePhase == 1){
            gp.player.worldY -= 2;
            if ( gp.player.worldY < gp.tileSize*14){
                scenePhase++;
            }
        }
        if(scenePhase == 2 ) {
             //search the boss
             for(int i = 0; i < gp.monster[1].length;i++){
                 if(gp.monster[gp.currentMap][i] != null && gp.monster[gp.currentMap][i].name == MON_SkeletonLord.monName){
                     gp.monster[gp.currentMap][i].sleep = false;
                     gp.ui.npc = gp.monster[gp.currentMap][i];
                     scenePhase++;
                     break;
                 }
             }
        }
        if(scenePhase == 3){
            
            //The boss speaks
            gp.ui.drawDialogueScreen();
        }
        if(scenePhase == 4) {
            for(int i = 0; i < gp.npc[1].length;i++){
                if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].name.equals(PlayerDummy.npcName)){
                    // Restore the player position
                    gp.player.worldX = gp.npc[gp.currentMap][i].worldX;
                    gp.player.worldY = gp.npc[gp.currentMap][i].worldY;
                    // Delete the dummy
                    gp.npc[gp.currentMap][i] = null;
                    break;
                }
            }
            
            // Start drawing the player
            gp.player.drawing = true;
            
            // Reset
            sceneNum = NA;
            scenePhase = 0;
            gp.gameState = gp.playState;
            gp.stopMusic();
            gp.playMusic(17);
        }
    }
    public void scene_ending() {
        if(scenePhase == 0) {
            gp.stopMusic();
            gp.ui.npc = new OBJ_BlueHeart(gp);
            scenePhase++;
        }
        if(scenePhase == 1){
            gp.ui.drawDialogueScreen();
        }
        if(scenePhase == 2){
            gp.playSE(4);
            scenePhase++;
        }
        if(scenePhase == 3){
            if(counterReached(300) == true){
                scenePhase++;
            }
        }
        if(scenePhase == 4){
            // The screen get darker
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            drawBlackBackground(alpha);
            
            if(alpha == 1f) {
                alpha = 0;
                scenePhase++;
            }
        }
        if(scenePhase == 5){
            
            drawBlackBackground(1f);
            
            alpha += 0.005f;
            if(alpha > 1f){
                alpha = 1f;
            }
            
            String text = "THE END";
            drawString(alpha, 120f, 200, text, 70);
            
            if(counterReached(2000) == true){
                scenePhase++;
            }
        }
    }
    public boolean counterReached ( int target) {
        boolean counterReached = false;
        counter ++;
        if(counter > target) {
            counterReached = true;
            counter = 0;
        }
        return counterReached;
    }
    public void drawBlackBackground(float alpha){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
        g2.setColor(Color.black);
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }
    public void drawString(float alpha, float fontSize, int y, String text, int lineHeight){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(fontSize));
        
        for(String line: text.split("\n")){
            int x = gp.ui.getXforCenteredText(line);
            g2.drawString(line, x, y);
            y += lineHeight;
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }
}
