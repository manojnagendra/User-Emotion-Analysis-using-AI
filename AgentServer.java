import java.io.*;  // Get the Input Output libraries
import java.net.*; // Get the Java networking libraries

class Worker extends Thread {    // Class definition. Each connection gets its own Worker
  Socket sock;                   // Class member, socket, local to Worker.
  Worker (Socket s) {sock = s;}  // Constructor, assign arg s to local sock

  public void run(){
    // Get I/O streams in/out from the socket:
    PrintStream out = null;
    BufferedReader in = null;
    try {
      in = new BufferedReader
        (new InputStreamReader(sock.getInputStream()));
      out = new PrintStream(sock.getOutputStream());
      // Note that this branch might not execute when expected:
      try {
        String ClientMsg;
        ClientMsg = in.readLine ();
        System.out.println("AI: ");

	out.println("Hi! I am your Agent."); // To client...
	out.println("Client: " + ClientMsg + "\n\n");
  if(ClientMsg.contains("blue")) // checks for the incoming message if it has the keyword "blue". Java String contains() method is used
        {
          System.out.println("It reminds me of the blue sky");// if the word is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("Blue")) // checks for the incoming message if it has the keyword "Blue" with an uppercase "B"
        {
          System.out.println("It reminds me of the blue sky");// if the word is present, the Agent replies back the ClientMsg+this message
        }      
  if(ClientMsg.contains("red"))// checks for the incoming message if it has the keyword "red"
        {
          System.out.println("It reminds me of the cherry");// if the word is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("Red"))// checks for the incoming message if it has the keyword "Red" with an uppercase "R"
        {
          System.out.println("It reminds me of the cherry");// if the word is present, the Agent replies back the ClientMsg+this message
        }      
  if(ClientMsg.contains("yellow"))// checks for the incoming message if it has the keyword "yellow"
        {
          System.out.println("It reminds me of the sun");// if the word is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("Yellow"))// checks for the incoming message if it has the keyword "Yellow" with an uppercase "Y"
        {
          System.out.println("It reminds me of the sun");// if the word is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("Hey"))// checks for the incoming message if it has the keyword "Hey" with an uppercase H
        {
          System.out.println("Manoj! Nice to meet you!");// if the word is present, the Agent replies back the ClientMsg+this message
        }      
  if(ClientMsg.contains("hey"))// checks for the incoming message if it has the keyword "hey"
        {
          System.out.println("Manoj! Nice to meet you!");// if the word is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("Hi"))// checks for the incoming message if it has the keyword "Hi" with an uppercase "H"
        {
          System.out.println("Manoj! Nice to meet you!");// if the word is present, the Agent replies back the ClientMsg+this message
        }      
  if(ClientMsg.contains("hi"))// checks for the incoming message if it has the keyword "hi"
        {
          System.out.println("Manoj! Nice to meet you!");// if the word is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("joke"))// checks for the incoming message if it has the keyword "joke"
        {
          System.out.println("What do dentists call their X-Rays?..umm...Tooth Pics :D");// if the word is present, the Agent replies back the ClientMsg+this message
        } 
  if(ClientMsg.contains("how are you"))// checks for the incoming message if it has the phrase "how are you"
        {
          System.out.println("I am doing good, thanks for asking! How are you?");// if the line is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("who are you"))// checks for the incoming message if it has the phrase "who are you"
        {
          System.out.println("I am a smart chat agent");// if the line is present, the Agent replies back the ClientMsg+this message
        }
  if(ClientMsg.contains("bye"))// checks for the incoming message if it has the word "bye"
        {
          System.out.println("Thanks for chatting! Have a great day!");// if the line is present, the Agent replies back the ClientMsg+this message
        }                                               

      } catch (IOException x) {
        System.out.println("Server read error");
        x.printStackTrace ();
      }
      sock.close(); // close this connection, but not the server;
    } catch (IOException ioe) {System.out.println(ioe);}
  }
}

public class AgentServer {
  
  public static void main(String a[]) throws IOException {
    int q_len = 6; /* Not interesting. # of simultaneous requests for OpSys to queue */
    int port = 45565;
    Socket sock; // This will hold the new connection.
    
    ServerSocket servsock = new ServerSocket(port, q_len); // Create a doorbell socket
    
    System.out.println
      ("Manoj's Agent server 1.9 starting up, listening at port 45565.\n");
    while (true) {
      sock = servsock.accept(); // Wait for the next client connection. Ding-Dong! Hello?
      new Worker(sock).start(); // Spawn worker to handle it, and start the thread.
    }
  }
}
