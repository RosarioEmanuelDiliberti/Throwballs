package throwballs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Ball extends javax.swing.JFrame {
    private float velX,velY;
    private boolean followMouse;
    private boolean throwBall;
    private Point prevpos ;
            
    public Ball(String string) {
        setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        jPanel1.setBackground(randomColor());
        setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
        setLocationRelativeTo(null);
        followMouse=false; velX=0; velY=0;
        jLabel1.setText(" "+string);
        acquirePos();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jLabel1.setText("num");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        //System.out.println("pressed");
        followMouse=true;
        setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        //System.out.println("released");
        followMouse=false;
        throwBall=true;
        setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jPanel1MouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ball.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ball("not").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void movePartialVelocity(float div){
        setPlace(getX()+velX/div, getY()+velY/div);        
    }
    public void setPlace(float X, float Y){
        setLocation((int)X, (int)Y);
    }
    
    public void varVel(float percX, float percY){
        velX+=velX/100*percX;
        velY+=velY/100*percY;
    }
    public void addVel(float X,float Y){
        velX+=X;
        velY+=Y;
    }
    public void invVarVelX(float perc){
        varVel(perc,0);
        velX=-velX;
    }
     public void invVarVelY(float perc){
        varVel(0,perc);
        velY=-velY;
    }
    
//  \/\/               Setters and Getters                 \/\/
    public Point getCenter() {
        return new Point(getX()+getWidth()/2,getY()+getHeight()/2);
    }
    public float getRadius() {
        return getWidth()/2;
    }
    public void setVel(float VelX, float VelY) {
        this.velX = VelX;
        this.velY = VelY;
    }
    public float getVelX() {
        return velX;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }
    public float getVelY() {
        return velY;
    }
    public void setVelY(float VelY) {
        this.velY = VelY;
    }
    public float getDistance (Ball b){
        //System.out.println("sqrt(("+b.getX()+"-"+getX()+")^2 + ("+b.getY()+"-"+getY()+")^2)");
        return (float)Math.sqrt(Math.pow((double)(getX()-b.getX()), 2)+Math.pow((double)(getY()-b.getY()), 2));
    }
    public Point getPrevPos(){
        return prevpos;
    }
    public void acquirePos(){
        prevpos=new Point(getX() ,getY() );
    }
    public void setThrowBall(boolean throwBall) {
        this.throwBall = throwBall;
    }
    public boolean isthrowBall() {
        return throwBall;
    }
    public boolean isFollowMouse() {
        return followMouse;
    }
    private Color randomColor(){
        return new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
    }
}
