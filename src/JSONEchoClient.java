import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class JSONEchoClient {
    public static void main(String[] args){
        JSONEchoClient theClient = new JSONEchoClient();
        theClient.go();
    }

    private void go() {
        while(true){
            try {
                Scanner systemInScanner = new Scanner(System.in);
                System.out.printf("Enter the message to send to the server.\n");
                String messageForServer = systemInScanner.nextLine();

                /*
                * This is the original code that Brother Barney gave us.
                * */

//                URL url = new URL("http://localhost:8080/json");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setDoOutput(true);//allows POST
//                JSONOutputStream outToServer = new JSONOutputStream(connection.getOutputStream());
//
//
//                HashMap<String, Object> request = new HashMap<>();
//                request.put("command", "Wrong");
//                request.put("message", messageForServer);
//
//                outToServer.writeObject(request);
//
//                JSONInputStream inFromServer = new JSONInputStream(connection.getInputStream());
//                HashMap<String, Object> response = (HashMap<String, Object>) inFromServer.readObject();
//
//                if (response.get("command").equals("Done")) {
//                    System.out.println("Sent request: " + request + "and  got response  " + response);
//                } else {
//                    System.out.println("Oops. got " + response);
//                }

                /*
                * This is the code that I wrote to make my handler work.
                * */

                URL url2 = new URL("http://localhost:8080/json");
                HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
                connection2.setDoOutput(true);//allows POST
                JSONOutputStream outToServer2 = new JSONOutputStream(connection2.getOutputStream());

                HashMap<String, Object> request2 = new HashMap<>();
                request2.put("command", "Console");
                request2.put("message", messageForServer);

                outToServer2.writeObject(request2);

                JSONInputStream inFromServer = new JSONInputStream(connection2.getInputStream());
                HashMap<String, Object> response = (HashMap<String, Object>)inFromServer.readObject();

                if (response.get("command").equals("Done")) {
                    System.out.println("Sent request: " + request2 + "and  got response  " + response);
                } else {
                    System.out.println("Oops. got " + response);
                }


            }
            catch (Exception e){
//                e.printStackTrace();
            }
        }

    }
}
