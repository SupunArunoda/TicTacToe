package tictactoe_2;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TicTacToe_2 extends JFrame {

private ImagePanel board;
private ImagePanel redX;
private ImagePanel blueX;
private ImagePanel redO;
private ImagePanel blueO;
private JFrame frame;
private int cellCount=0;

private final int WIDTH = 506;
private final int HEIGHT = 527;
private JPanel panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7,panel_8,panel_9;
private JLabel lable_1,lable_2,lable_3,lable_4,lable_5,lable_6,lable_7,lable_8,lable_9;
private JLabel lableArray[]=new JLabel[9];
private Point userpoint;
private Point computerpoint;
private  Board userboard;
private int user=0;

private String redCirclepath="src/res/redCircle.png";
private String bluCrosspath="src/res/blueX.png";

private boolean enables[]=new boolean[9];
private static int choise;//static for allow in main method
public TicTacToe_2(int choise){
    
    
    board=new ImagePanel(new ImageIcon("src/res/board.png").getImage());
   
    userboard=new Board();
panel_1=new JPanel(new FlowLayout());
panel_2=new JPanel(new FlowLayout());
panel_3=new JPanel(new FlowLayout());
panel_4=new JPanel(new FlowLayout());
panel_5=new JPanel(new FlowLayout());
panel_6=new JPanel(new FlowLayout());
panel_7=new JPanel(new FlowLayout());
panel_8=new JPanel(new FlowLayout());
panel_9=new JPanel(new FlowLayout());

lable_1=new JLabel();
lable_2=new JLabel();
lable_3=new JLabel();
lable_4=new JLabel();
lable_5=new JLabel();
lable_6=new JLabel();
lable_7=new JLabel();
lable_8=new JLabel();
lable_9=new JLabel();

 lableArray[0]=lable_1;lableArray[1]=lable_2;lableArray[2]=lable_3;
 lableArray[3]=lable_4;lableArray[4]=lable_5;lableArray[5]=lable_6;
 lableArray[6]=lable_7;lableArray[7]=lable_8;lableArray[8]=lable_9;
 
 enables[0]=true;enables[1]=true;enables[2]=true;enables[3]=true;enables[4]=true;
 enables[5]=true;enables[6]=true;enables[7]=true;enables[8]=true;
 
 
panel_1.setBounds(0, 0, 160, 160);
panel_2.setBounds(170, 0, 160, 160);
panel_3.setBounds(340, 0, 160, 160);
panel_4.setBounds(0, 170, 160, 160);
panel_5.setBounds(170, 170, 160, 160);
panel_6.setBounds(340, 170, 160, 160);
panel_7.setBounds(0, 340, 160, 160);
panel_8.setBounds(170, 340, 160, 160);
panel_9.setBounds(340, 340, 160, 160);

panel_1.add(lable_1);
panel_2.add(lable_2);
panel_3.add(lable_3);
panel_4.add(lable_4);
panel_5.add(lable_5);
panel_6.add(lable_6);
panel_7.add(lable_7);
panel_8.add(lable_8);
panel_9.add(lable_9);
loadListners();
    frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe");
              //frame.add(but);
                frame.add(panel_1);
                frame.add(panel_2);
                frame.add(panel_3);
                frame.add(panel_4);
                frame.add(panel_5);
                frame.add(panel_6);
                frame.add(panel_7);
                frame.add(panel_8);
                frame.add(panel_9);
		frame.getContentPane().add(board);
                  
                
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(400, 100);
    frame.setResizable(false);
    frame.setVisible(true);
    if(choise==2){
        AIStart();
    }
}
public void AIStart(){
    Random r=new Random();
    int x=r.nextInt(3);
    int y=r.nextInt(3);
    if(x==0){
        if(y==0){
             lable_1.setIcon(new ImageIcon(bluCrosspath));
             enables[0]=false;
        }else if(y==1){
             lable_2.setIcon(new ImageIcon(bluCrosspath));
             enables[1]=false;
        }else{
             lable_3.setIcon(new ImageIcon(bluCrosspath));
             enables[2]=false;
        }
    }
    if(x==1){
        if(y==0){
             lable_4.setIcon(new ImageIcon(bluCrosspath));
             enables[3]=false;
        }else if(y==1){
             lable_5.setIcon(new ImageIcon(bluCrosspath));
             enables[4]=false;
        }else{
             lable_6.setIcon(new ImageIcon(bluCrosspath));
             enables[5]=false;
        }
    }
    if(x==2){
        if(y==0){
             lable_7.setIcon(new ImageIcon(bluCrosspath));
             enables[6]=false;
        }else if(y==1){
             lable_8.setIcon(new ImageIcon(bluCrosspath));
             enables[7]=false;
        }else{
             lable_9.setIcon(new ImageIcon(bluCrosspath));
             enables[8]=false;
        }
    }
    userpoint=new Point(x, y);
     userboard.placeAMove(userpoint, 1); //2 for O and O is the user
            
     userboard.displayBoard();
           /* userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);*/
    
}
public void loadListners(){
    //panel 1
    
   panel_1.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[0]==true){
    lable_1.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(0, 0);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
            
     
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
           if(user==0){
              gameOver();
               return;
           }
            lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
          gameOver();
    }       }
@Override
public void mouseReleased(MouseEvent e) {
enables[0]=false;
enables[user-1]=false;
                }
});
   //panel 2
      panel_2.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[1]==true){
    lable_2.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(0, 1);
     userboard.placeAMove(userpoint, 2); //2 for O and 1 is the user
         
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
            if(user==0){
              gameOver();
               return;
           }
              lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
          gameOver();
          
                }}
@Override
public void mouseReleased(MouseEvent e) {
enables[1]=false;
enables[user-1]=false;
                }
});
        //panel 3
      panel_3.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[2]==true){
  lable_3.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(0, 2);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
             
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
            if(user==0){
              gameOver();
               return;
           }
            lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
           gameOver();
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[2]=false;
enables[user-1]=false;
                }
});
      //panel 4
      panel_4.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[3]==true){
 lable_4.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(1, 0);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
            
     
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
            if(user==0){
              gameOver();
               return;
           }
           lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
          gameOver();      
           
                }}
@Override
public void mouseReleased(MouseEvent e) {
enables[3]=false;
enables[user-1]=false;
                }
});
      //panel 5
      panel_5.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[4]==true){
 lable_5.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(1, 1);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
            
     
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
            if(user==0){
              gameOver();
               return;
           }
           lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
           gameOver();
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[4]=false;
enables[user-1]=false;
                }
});
      //panel 6
      panel_6.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[5]==true){
 lable_6.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(1, 2);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
         
      
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
            if(user==0){
              gameOver();
               return;
           }
           lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
            gameOver();
    }}
@Override
public void mouseReleased(MouseEvent e) {
enables[5]=false;
enables[user-1]=false;
                }
});
      //panel 7
      panel_7.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[6]==true){
 lable_7.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(2, 0);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
             userboard.displayBoard();
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           
            if(user==0){
              gameOver();
               return;
           }
           lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
           gameOver();
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[6]=false;
enables[user-1]=false;
                }
});
      //panel 8
      panel_8.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[7]==true){
 lable_8.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(2, 1);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
       userboard.displayBoard();
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);  
           
            if(user==0){
              gameOver();
               return;
           }
           lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
            gameOver();
                }}
@Override
public void mouseReleased(MouseEvent e) {
enables[7]=false;
enables[user-1]=false;
                }
});
      //panel 9
      panel_9.addMouseListener(new MouseAdapter() {
@Override
public void mousePressed(MouseEvent e) {
    if(enables[8]==true){
     lable_9.setIcon(new ImageIcon(redCirclepath));
    userpoint=new Point(2, 2);
     userboard.placeAMove(userpoint, 2); //2 for O and O is the user
            
      
            userboard.callMinimax(0, 1);
            user= getBestPosition();
           System.out.println(user);
           userboard.displayBoard();
            if(user==0){
              gameOver();
               return;
           }
           lableArray[user-1].setIcon(new ImageIcon(bluCrosspath));
           userboard.placeAMove(userboard.returnBestMove(), 1);
           userboard.displayBoard();
           gameOver();
    }
                }
@Override
public void mouseReleased(MouseEvent e) {
enables[8]=false;
enables[user-1]=false;
                }
});
}
   /* public static void main(String[] args) {
        TicTacToe_2 ticTacToe_2=new TicTacToe_2();
        
    }*/
    
 int getBestPosition(){
     for (PointsAndScores pas : userboard.rootsChildrenScores) {
                if(pas.score==1){
            if(pas.point.x==0){
                if(pas.point.y==0){
                    return 1;
                }else if(pas.point.y==1){
                    return 2;
                }else{
                    return 3;
                }
            }else if(pas.point.x==1){
                if(pas.point.y==0){
                    return 4;
                }else if(pas.point.y==1){
                    return 5;
                }else{
                    return 6;
                }
            }if(pas.point.x==2){
                if(pas.point.y==0){
                    return 7;
                }else if(pas.point.y==1){
                    return 8;
                }else{
                    return 9;
                }
            }
         }
                else if(pas.score==0){
            if(pas.point.x==0){
                if(pas.point.y==0){
                    return 1;
                }else if(pas.point.y==1){
                    return 2;
                }else{
                    return 3;
                }
            }else if(pas.point.x==1){
                if(pas.point.y==0){
                    return 4;
                }else if(pas.point.y==1){
                    return 5;
                }else{
                    return 6;
                }
            }if(pas.point.x==2){
                if(pas.point.y==0){
                    return 7;
                }else if(pas.point.y==1){
                    return 8;
                }else{
                    return 9;
                }
            }
         }
            }
     return 0;
}
void makeChoises(int choise){
    if(choise==0){
        frame.dispose();
//        TicTacToe_2 tictac=new TicTacToe_2();
    }else if(choise==1){
        frame.dispose();
    }
    
}
void gameOver(){
     if (userboard.isGameOver()) {
                if (userboard.hasXWon()) {
            choise=JOptionPane.showConfirmDialog(null, "OOPS.... \n You have lost the game...\nDo You wish to play again?");
            makeChoises(choise);
        } else if (userboard.hasOWon()) {
            choise=JOptionPane.showConfirmDialog(null, "Congratulations!!!!! \nYou have won the game...\nDo You wish to play again?");//choise=JOptionPane.showConfirmDialog(null, "Congratulations!!!!! \nYou have won the game...\nDo You wish to play again?");
            makeChoises(choise);
        } else {
            choise=JOptionPane.showConfirmDialog(null, "Game TIED\nDo You wish to play again?");//choise=JOptionPane.showConfirmDialog(null, "Game TIED\nDo You wish to play again?");
           makeChoises(choise); 
        }
                return;
            } 
}
}