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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String [] args){
        System.out.println("this  is very close Server ");
        new Server();
    }
}
