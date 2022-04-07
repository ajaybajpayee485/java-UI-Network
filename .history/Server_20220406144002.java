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
         server=new ServerSocket(7777);
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

      };
    }

    public void startWriting()
    {
      Runnable r2=()->{

      };
    }
    public static void main(String [] args){
        System.out.println("this  is very close Server ");
        new Server();
    }
}
