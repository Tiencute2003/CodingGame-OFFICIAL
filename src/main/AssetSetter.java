/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.NPC_GoldCoin;
import entity.NPC_Merchant;
import entity.NPC_OldMan;
import monster.MON_Bat;
import monster.MON_GreenSlime;
import monster.MON_Orc;
import monster.MON_RedSlime;
import monster.MON_SkeletonLord;
import object.OBJ_Axe;
import object.OBJ_BlueHeart;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;

/**
 *
 * @author tranbachtung
 */
public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        
        int mapNum = 0;
        int i = 0;
        
        // MAP 0
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*24;
        gp.obj[mapNum][i].worldY = gp.tileSize*22;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*34;
        gp.obj[mapNum][i].worldY = gp.tileSize*39;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*8;
        gp.obj[mapNum][i].worldY = gp.tileSize*29;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*11;
        gp.obj[mapNum][i].worldY = gp.tileSize*9;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*38;
        gp.obj[mapNum][i].worldY = gp.tileSize*28;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*11;
        gp.obj[mapNum][i].worldY = gp.tileSize*35;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*24;
        gp.obj[mapNum][i].worldY = gp.tileSize*5;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*10;
        gp.obj[mapNum][i].worldY = gp.tileSize*18;
        i++;
        gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*26;
        gp.obj[mapNum][i].worldY = gp.tileSize*4;
        i++;
        gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*38;
        gp.obj[mapNum][i].worldY = gp.tileSize*21;
        i++;
        gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*38;
        gp.obj[mapNum][i].worldY = gp.tileSize*22;
        i++;
        gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*38;
        gp.obj[mapNum][i].worldY = gp.tileSize*23;
        i++;
//        gp.obj[mapNum][i] = new OBJ_Heart(gp);
//        gp.obj[mapNum][i].worldX = gp.tileSize*22;
//        gp.obj[mapNum][i].worldY = gp.tileSize*29;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
//        gp.obj[mapNum][i].worldX = gp.tileSize*22;
//        gp.obj[mapNum][i].worldY = gp.tileSize*31;
//        i++;
        mapNum = 2;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*23;
        gp.obj[mapNum][i].worldY = gp.tileSize*44;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*24;
        gp.obj[mapNum][i].worldY = gp.tileSize*44;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*25;
        gp.obj[mapNum][i].worldY = gp.tileSize*44;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*16;
        gp.obj[mapNum][i].worldY = gp.tileSize*32;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*46;
        gp.obj[mapNum][i].worldY = gp.tileSize*11;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*44;
        gp.obj[mapNum][i].worldY = gp.tileSize*25;
        i++;
        
        mapNum = 3;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*12;
        gp.obj[mapNum][i].worldY = gp.tileSize*35;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*11;
        gp.obj[mapNum][i].worldY = gp.tileSize*37;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*12;
        gp.obj[mapNum][i].worldY = gp.tileSize*39;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*4;
        gp.obj[mapNum][i].worldY = gp.tileSize*30;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*24;
        gp.obj[mapNum][i].worldY = gp.tileSize*43;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*41;
        gp.obj[mapNum][i].worldY = gp.tileSize*34;
        i++;
        
        mapNum = 5;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*25;
        gp.obj[mapNum][i].worldY = gp.tileSize*6;
        i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*26;
        gp.obj[mapNum][i].worldY = gp.tileSize*6;
        
        mapNum = 4;
        i++;
        gp.obj[mapNum][i] = new OBJ_BlueHeart(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*25;
        gp.obj[mapNum][i].worldY = gp.tileSize*10;

    }
    public void setNPC(){
        
        int mapNum = 0;
        int i = 0;
        gp.npc[mapNum][i] = new NPC_OldMan(gp);
        gp.npc[mapNum][i].worldX = gp.tileSize*35;
        gp.npc[mapNum][i].worldY = gp.tileSize*7;
        i++;
        
        // MAP 1
        mapNum = 1;
        i = 0;
        gp.npc[mapNum][i] = new NPC_Merchant(gp);
        gp.npc[mapNum][i].worldX = gp.tileSize*12;
        gp.npc[mapNum][i].worldY = gp.tileSize*7;
        i++;
        
        mapNum = 4;
        for( int l = 21; l< 30; l++ ){
            for( int k = 37; k < 42; k++){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*k;
            i++;
            }
        }
        for( int l = 6; l< 12; l++ ){
            for( int k = 18; k < 21; k++){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*k;
            i++;
            }
        }
        for( int l = 6; l< 12; l++ ){
            for( int k = 39; k < 45; k++){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*k;
            i++;
            }
        }
        for( int l = 24; l< 28; l++ ){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*25;
            i++;
        }
        for( int l = 24; l< 28; l++ ){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*22;
            i++;
        }
        for( int l = 4; l< 47; l+=2 ){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*23;
            i++;
        }
        for( int l = 5; l< 47; l+=2 ){
            gp.npc[mapNum][i] = new NPC_GoldCoin(gp);
            gp.npc[mapNum][i].worldX = gp.tileSize*l;
            gp.npc[mapNum][i].worldY = gp.tileSize*24;
            i++;
        }
    }
        
    public void setMonster(){
        
        int mapNum = 0;
        int i = 0;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*34;
        gp.monster[mapNum][i].worldY = gp.tileSize*37;
        i++;   
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*34;
        gp.monster[mapNum][i].worldY = gp.tileSize*38;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*43;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*41;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*36;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*37;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*38;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*39;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*40;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*5;
        gp.monster[mapNum][i].worldY = gp.tileSize*26;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*6;
        gp.monster[mapNum][i].worldY = gp.tileSize*26;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*7;
        gp.monster[mapNum][i].worldY = gp.tileSize*26;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*8;
        gp.monster[mapNum][i].worldY = gp.tileSize*26;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*5;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*6;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*7;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*8;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*9;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*10;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        
        
        
        
        mapNum = 2;
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*27;
        gp.monster[mapNum][i].worldY = gp.tileSize*16;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*25;
        gp.monster[mapNum][i].worldY = gp.tileSize*16;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*28;
        gp.monster[mapNum][i].worldY = gp.tileSize*16;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*27;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*25;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*28;
        gp.monster[mapNum][i].worldY = gp.tileSize*15;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*6;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*7;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*8;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*12;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*13;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*14;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*33;
        gp.monster[mapNum][i].worldY = gp.tileSize*31;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*34;
        gp.monster[mapNum][i].worldY = gp.tileSize*31;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*35;
        gp.monster[mapNum][i].worldY = gp.tileSize*31;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*40;
        gp.monster[mapNum][i].worldY = gp.tileSize*28;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*42;
        gp.monster[mapNum][i].worldY = gp.tileSize*28;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*44;
        gp.monster[mapNum][i].worldY = gp.tileSize*28;
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*39;
        gp.monster[mapNum][i].worldY = gp.tileSize*12;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*12;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*37;
        gp.monster[mapNum][i].worldY = gp.tileSize*12;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*39;
        gp.monster[mapNum][i].worldY = gp.tileSize*13;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*13;
        
        i++;
        gp.monster[mapNum][i] = new MON_Bat(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*37;
        gp.monster[mapNum][i].worldY = gp.tileSize*13;
        
        
        mapNum = 3;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*16;
        gp.monster[mapNum][i].worldY = gp.tileSize*28;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*11;
        gp.monster[mapNum][i].worldY = gp.tileSize*32;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*6;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*33;
        gp.monster[mapNum][i].worldY = gp.tileSize*26;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*22;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*37;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_Orc(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*42;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*11;
        gp.monster[mapNum][i].worldY = gp.tileSize*24;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*13;
        gp.monster[mapNum][i].worldY = gp.tileSize*29;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*13;
        gp.monster[mapNum][i].worldY = gp.tileSize*28;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*8;
        gp.monster[mapNum][i].worldY = gp.tileSize*32;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*32;
        gp.monster[mapNum][i].worldY = gp.tileSize*31; 
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*37;
        gp.monster[mapNum][i].worldY = gp.tileSize*32;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*33;
        gp.monster[mapNum][i].worldY = gp.tileSize*31;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*42;
        gp.monster[mapNum][i].worldY = gp.tileSize*24;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*32;
        gp.monster[mapNum][i].worldY = gp.tileSize*25;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*25;
        gp.monster[mapNum][i].worldY = gp.tileSize*39;
        i++;
        gp.monster[mapNum][i] = new MON_RedSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*28;
        gp.monster[mapNum][i].worldY = gp.tileSize*43;
        
        mapNum = 5;
        gp.monster[mapNum][i] = new MON_SkeletonLord(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*24;
        gp.monster[mapNum][i].worldY = gp.tileSize*12;
    }
        
}
