import java.net.*;
import java.io.*;

class Server
{
    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;


    public Server(){
        try {
         server=new ServerSocket(7778);
         System.out.println("Server is ready to accept connection");
         System.out.println("waiting....");
         socket=server.accept();

         br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
         out=new PrintWriter(socket.getOutputStream());

         startReading();
         startWriting();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void startReading()
    {
      Runnable r1=()->{
          System.out.println("reader started read ..");
          while(true){
          String msg=br.readLine();
          if(msg.equals("exit")){
              System.out.println("Client terminated the chat");

              socket.close();
              break;

          }
          System.out.println("Client " +msg);
        


          }


      };
      new Thread(r1).start();
    }

    public void startWriting()
    {
      Runnable r2=()->{
          System.out.println("Writer started");
          while(true)
          {
              try {
                  BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                  String content=br1.readLine();
                  out.println(content);
                  out.flush();
                  
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }

      };
      new Thread(r2).start();
    }
    public static void main(String [] args){
        System.out.println("this  is very close Server ");
        new Server();
    }
}
