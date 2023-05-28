/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author tranbachtung
 */
public class Main {
    
    public static JFrame window;
    
    public static void main(String[] args) {
        
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("The land of fantasy");
        new Main().setIcon();
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        gamePanel.config.loadConfig();
        if(gamePanel.fullScreenOn == true){
            window.setUndecorated(true);
        }
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread(); 
    }
    public void setIcon() {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("objects/blueheart.png"));
        window.setIconImage(icon.getImage());
    }
}
