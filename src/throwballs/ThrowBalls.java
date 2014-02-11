package throwballs;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThrowBalls {
    static final int MAXBALLS = 10;
    static int quant=MAXBALLS;
    //static Ball[] ball = new Ball[MAXBALLS];
    static private Point oldMouse;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static List<Ball> ball = new ArrayList();
    
    
    public static void main(String[] args) {  
       
        initBalls(quant);
        
        Shake sh=new Shake();
        
        boolean stay=true;
        int fps=50;
        while(stay){
            dormi(1000/fps);
            for(int i=0;i<quant;i++){
                if(ball.get(i).isFollowMouse()){                                    //System.out.println("follow");
                    oldMouse = getMouse();
                    ball.get(i).setLocation(oldMouse.x-ball.get(i).getWidth()/2,oldMouse.y-ball.get(i).getHeight()/2);
                    
                }else if(ball.get(i).isthrowBall())
                {                                                               //System.out.println("throw");
                    ball.get(i).setVel((getMouse().x-oldMouse.x)*20, (getMouse().y-oldMouse.y)*20);
                    ball.get(i).setThrowBall(false);
                    System.out.println("Throwing ball n° "+i);
                }    
                else{
                    CollisionHandler.collideWalls(ball.get(i));                    
                    
                    ball.get(i).addVel(0, 5);
                    ball.get(i).varVel(i, 0);
                    ball.get(i).movePartialVelocity(fps);
                    
                }
            }//end for
            //CollisionHandler.collideBalls(ball, quant);
        }//end while(stay)
}    
        
        static private void initBalls(int num){
            for(int i=0;i<num;i++){
                ball.add(new Ball(" "));
                ball.get(i).setVisible(true);
            }
        }
        static private Point getMouse(){
            return MouseInfo.getPointerInfo().getLocation();
        }
        static void dormi(int fps){
        try { Thread.sleep(fps); } catch (InterruptedException ex) { Logger.getLogger(ThrowBalls.class.getName()).log(Level.SEVERE, null, ex);}
        }
}
