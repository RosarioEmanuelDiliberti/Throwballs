package throwballs;

import java.awt.Dimension;
import java.awt.Toolkit;
import static throwballs.ThrowBalls.ball;
import static throwballs.ThrowBalls.screenSize;



public class CollisionHandler {
     
   public static void collideWalls(Ball ball){
            if(ball.getY()+ball.getHeight()>=screenSize.getHeight()){
                ball.invVarVelY(-50);
                ball.setLocation(ball.getX(),(int)screenSize.getHeight()-ball.getHeight());
                ball.varVel(-20, 0);
            }
            else if(ball.getY()<=27){
                ball.invVarVelY(-50);
                ball.setLocation(ball.getX(),27);
            }
            if(ball.getX()+ball.getWidth()>=screenSize.getWidth()){
                ball.invVarVelX(-50);
                ball.setLocation((int)screenSize.getWidth()-ball.getWidth(),ball.getY());
            }
            else if(ball.getX()<=0){
                ball.invVarVelX(-50);
                ball.setLocation(0,ball.getY());
            }
   }
   
   public static void collideBalls(Ball[] ball, int quant){
        for(int i=0;i<quant-1;i++)
            for(int k=1;k<quant;k++){
                if(ball[i].getRadius()+ball[k].getRadius() >= ball[i].getDistance(ball[k])){
                    //System.out.println("i="+i+" X1="+ball[i].getX()+"    k="+k+" X2="+ball[k].getX()+" dist="+ball[i].getDistance(ball[k]));
                    float tvelX=ball[i].getVelX(),tvelY=ball[i].getVelY();
                    ball[i].addVel(ball[k].getVelX(), ball[k].getVelY());
                    ball[k].addVel(tvelX, tvelY);
                    
                    ball[i].invVarVelX(-50);
                    ball[k].invVarVelX(-50);
                    ball[i].invVarVelY(-50);
                    ball[k].invVarVelY(-50);
                }
             }

    }
   public static void collideWallsarr(Ball[] ball, int quant){
       for(int i=0;i<quant;i++){
            if(ball[i].getY()+ball[i].getHeight()>=screenSize.getHeight())
                ball[i].invVarVelY(-50);
            else if(ball[i].getY()<=27)
                ball[i].invVarVelY(-50);
            if(ball[i].getX()+ball[i].getWidth()>=screenSize.getWidth())
                ball[i].invVarVelX(-50);
            else if(ball[i].getX()<=0)
                ball[i].invVarVelX(-50);
       }
   }
   public static void collideBallsarr(Ball[] ball, int quant){
        for(int i=0;i<quant-1;i++)
            for(int k=1;k<quant;k++){
                if(ball[i].getRadius()+ball[k].getRadius() >= ball[i].getDistance(ball[k])){
                    //System.out.println("i="+i+" X1="+ball[i].getX()+"    k="+k+" X2="+ball[k].getX()+" dist="+ball[i].getDistance(ball[k]));
                    float tvelX=ball[i].getVelX(),tvelY=ball[i].getVelY();
                    
                    ball[i].addVel(ball[k].getVelX(), ball[k].getVelY());
                    ball[k].addVel(tvelX, tvelY);
                    ball[i].setLocation(ball[i].getPrevPos());
                    ball[k].setLocation(ball[k].getPrevPos());
                    ball[i].invVarVelX(-50);
                    ball[k].invVarVelX(-50);
                    ball[i].invVarVelY(-50);
                    ball[k].invVarVelY(-50);
                    ball[i].movePartialVelocity(10);
                    ball[k].movePartialVelocity(10);
                }
             }

    }

}
    
   
