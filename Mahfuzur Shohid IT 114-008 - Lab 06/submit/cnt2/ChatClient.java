import java.net.*;
import java.util.Scanner;
import java.io.*;

/* ChatClient.java
* A simple client program that connects to a server, and then
* exchanges messages with the server until either side sends "quit" (or an error occurs).
*
* Basic algorithm for the Client:
* 1. Ask for the IP or domain name of the server (127.0.0.1 or localhost)
* 2. Request connection to server on specified host and port.
* 3. Establish connection
* 4. Send message to server (OutputStream)
* 5. Listen for message from server (InputStream)
* 6. Repeat steps 4 and 5 until either side sends "quit" (or error occurs)
* 7. Close connection.
*/

class ChatClient {

    public static void main(String[] args) {

        String ipAddress; // IP address or domain name of Server
        int port = 1728; // The port on which the server listens.

        Socket connection; // For communication with the server.

        BufferedReader incoming; // Stream for receiving data from server.
        PrintWriter outgoing; // Stream for sending data to server.
        String messageOut; // A message to be sent to the server.
        String messageIn; // A message received from the server.

        Scanner userInput = new Scanner(System.in); // Standard input, for reading lines of input from the user.

        // 1. TODO: Get the IP address or domain name of the server from the user.
            //YOUR CODE HERE

            System.out.println("Enter the Server IP Adress: ");
            ipAddress = userInput.nextLine();
        
        
        // 2. Request connection to server on specified host and port
        try {
            System.out.println("Connecting to " + ipAddress + " on port " + port);
            //TODO: Create new socket w/ IP address and port
                //YOUR CODE HERE

                connection = new Socket(ipAddress, port); //So, the socket class is just so we can make a conection to the server, with the two variables, the IP adress (the local which is 127.0.0.1) that is submitted and then the port, which is 1728.
            
            System.out.println("Connected.  Enter your first message.");
        }
        // If connection fails (or invalid ip), print error message, close streams and end the program.
        catch (Exception e) {
            //YOUR CODE HERE
            
            System.out.println("Sorry, Could not connect to, " + ipAddress + ".");
            System.out.println(e.getMessage()); //The e message would be for telling us what the actual error message is, like if its a connection refused issue or etc. 

            userInput.close(); //Always close out the stream 
            return;
        }
        // 3. Exchange messages with the server.
        try {
            System.out.println("NOTE: Enter 'quit' to end the program.\n");
            while (true) {
                System.out.print("SEND:      ");
                // TODO: Create input and output streams
                    //YOUR CODE HERE

                    incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    outgoing = new PrintWriter(connection.getOutputStream());
                
                    //I had to look at the slidees to double check but I'm pretty sure this is how the loop is made
                    //So, the incoming code is for reading the message and then the out is just how its being sent. 
                    

                //TODO: Have client send the first message.
                // If message sent is "quit", then close the connection and streams, print Connection closed and end the program.
                   //YOUR CODE HERE
                    
                messageOut = userInput.nextLine();
                    outgoing.println(messageOut); //I tried do this without the flush but it kinda just doesn't work without it idk?
                    outgoing.flush();  //We would have the client send out their message 
                  
                   if(messageOut.equals("quit")){
                    System.out.println("The Connection is Closed.");
                    connection.close();
                    return;
                  } //Close out of all the streams, so this connection is fully cut off, after the user types out 'quit' 

                
                // Check for errors while transmitting message.
                
                if (outgoing.checkError()) {
                    userInput.close();
                    connection.close();
                    throw new IOException("Error occurred while transmitting message.");
                }
                System.out.println("WAITING...");
                // TODO: Have Client receive a message from the server.
                // If message sent is "quit", then close the connection and streams, print Connection closed and end the program.
                    //YOUR CODE HERE

                    messageIn = incoming.readLine();
                    if(messageIn.equals("quit")){
                         System.out.print("The Connection is Closed");
                        connection.close();
                        return;
                    } //Pretty much the same thing from the the code above, but the client just recieves the message. 
                
                    System.out.println("RECIEVED: " + messageIn);
            }
        }
        // TODO: If failed to exchange messages, print error message, close connections and streams, and end the program.
        catch (Exception e) {
                //YOUR CODE HERE
                System.out.println("There seems to be a connection error: "); 
                System.out.println(e.getMessage());
        }
        
        // 4. Close the connection and end the program, whether error or not.
        finally {
            userInput.close();
            try {
                connection.close();
            } catch (Exception e) {
                // Ignore errors that occur while closing the connection.
            }
        }

    } // end main()

} // end class ChatClient