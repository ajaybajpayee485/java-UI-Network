import java.net.Socket;

public class Client {

  Socket socket;

  public Client()
  {
    try {
      System.out.println("Sending request to server");
      socket=new Socket("127.0.0.1",7777);

    } catch (Exception e) {
      //TODO: handle exception
    }
  }
  public static void main(String[] args) {
      System.out.println("this is client");
      
  }
}
