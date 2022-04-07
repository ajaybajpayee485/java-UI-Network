import java.net.*;

class Server
{
    ServerSocket server;
    Socket socket;
    public Server(){
        try {
         server=new ServerSocket(7777);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String [] args){
        System.out.println("this  is very close Server ");
        new Server();
    }
}
