import java.net.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.KeyListener;
import java.io.*;

public class Client extends JFrame {

  Socket socket;
  BufferedReader br;
  PrintWriter out;
  private JLabel heading=new JLabel("Client Area");
  private JTextArea messageArea=new JTextArea();
  private JTextField messagTextField=new JTextField();
  private Font Font=new Font("Roboto",java.awt.Font.PLAIN,20);

  public Client (){
  
    try {
      // System.out.println("Sending request to server");
      // socket=new Socket("127.0.0.1",7778);
      // System.out.println("connection done");

      // br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      //    out=new PrintWriter(socket.getOutputStream());
           createGUI();
           handleEvents();
      //    startReading();
      //    startWriting();


    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  private void handleEvents() {
    messagTextField.addKeyListener(new KeyListener);
  }

  private void createGUI (){

    this.setTitle("Client Messager[END]");
    this.setSize(600,700);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    heading.setFont(Font);
    messageArea.setFont(Font);
    messagTextField.setFont(Font);

    heading.setIcon(new ImageIcon("google.png"));
    heading.setHorizontalTextPosition(SwingConstants.CENTER);
    heading.setVerticalTextPosition(SwingConstants.BOTTOM);

    heading.setHorizontalAlignment(SwingConstants.CENTER);
    heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    messagTextField.setHorizontalAlignment(SwingConstants.CENTER);



    this.setLayout( new BorderLayout());

    this.add(heading,BorderLayout.NORTH);
    this.add(messageArea,BorderLayout.CENTER);
    this.add(messagTextField,BorderLayout.SOUTH);

    this.setVisible(true);
  }
   public void startReading()
    {
      Runnable r1=()->{
          System.out.println("reader started read ..");
          try{
          while(true){
              
          String msg=br.readLine();
          if(msg.equals("exit")){
              System.out.println("Server terminated the chat");
              socket.close();
              break;

          }
          System.out.println("Server " + msg);
        


          }
        }catch(Exception e ){
          //e.printStackTrace();
          System.out.println("Connection closed");
        }


      };
      new Thread(r1).start();
    }

     public void startWriting()
    {
      Runnable r2=()->{
          System.out.println("Writer started");
          try {
          while( !socket.isClosed())
          {
              
                  BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                  String content=br1.readLine();
                  out.println(content);
                  out.flush();

                  if(content.equals("exit")){
                      socket.close();
                      break;
                  }
                  
             
          }
        } catch(Exception e){
          e.printStackTrace();
        }

      };
      new Thread(r2).start();
    }

  public static void main(String[] args) {
      System.out.println("this is client");
      new Client();
      
  }
}
