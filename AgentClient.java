import java.io.*; // Get the Input Output libraries
import java.net.*; // Get the Java networking libraries

public class AgentClient{
  public static void main (String args[]) {
    String serverName;
    if (args.length < 1) serverName = "localhost"; // declaring the name of the server
    else serverName = args[0];
    
    System.out.println("Manoj's Agent Client, 1.9.\n");
    System.out.println("Using server: " + serverName + ", Port: 45565");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //using BufferedReader Java class to read character from an input line
    try {
      String name;
      do {
        System.out.print
          ("Enter a string to send to the Agent, (quit) to end: ");
        System.out.flush ();
        name = in.readLine (); // here is where the user enters the query to talk with the Agent
        if (name.indexOf("quit") < 0)
          getAgentResponse(name, serverName);
      } while (name.indexOf("quit") < 0);
      System.out.println ("Cancelled by user request."); // users end the chat by typing "quit"
    } catch (IOException x) {x.printStackTrace ();}
  }
  
  
  static void getAgentResponse (String name, String serverName){
    Socket sock;
    BufferedReader fromServer;
    PrintStream toServer;
    String textFromServer;
    
    try{
      /* Open our connection to server port, choose your own port number.. */
      sock = new Socket(serverName, 45565);
      
      // Create filter I/O streams for the socket:
      fromServer =
        new BufferedReader(new InputStreamReader(sock.getInputStream()));
      toServer = new PrintStream(sock.getOutputStream());

      // Send the Agent Server your string:
      toServer.println(name);
      toServer.flush();
      
      // Read two or three lines of response from the server,
      // and block while synchronously waiting:
      for (int i = 1; i <=3; i++){
        textFromServer = fromServer.readLine();
        if (textFromServer != null) System.out.println(textFromServer);
      }
      sock.close();
    } catch (IOException x) {
      System.out.println ("Socket error.");
      x.printStackTrace ();
    }
  }
}