/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author nl0012
 */
public class Server extends Thread {
     Boolean running = true;
    ArrayList<ClientHandler> clientList = new ArrayList();
    HashMap<String, String> students = new HashMap ();
    HashMap<String, String> professors = new HashMap ();
    HashMap<String, String> deans = new HashMap ();
    HashMap<String, String> provost = new HashMap ();
    HashMap<String, String> chairman = new HashMap ();
 
            
    Server(){
      students.put("std", "123");
      professors.put("nl0012", "123");
      deans.put("jdoe", "123");
      provost.put("jsmith", "123");
      chairman.put("jdoe2", "123");
    }
    public String check (String str){
        String [] wtv = str.trim().split(",");

        if (students.get(wtv[0].trim()) != null && students.get(wtv[0].trim()).equals(wtv[1].trim())) {
            return "student";
        }
         else if (professors.get(wtv[0].trim()) != null && professors.get(wtv[0].trim()).equals(wtv[1].trim())) {
            return "professor";
        }
          else if (deans.get(wtv[0].trim()) != null && deans.get(wtv[0].trim()).equals(wtv[1].trim())) {
            return "dean";
        } 
         else if (provost.get(wtv[0].trim()) != null && provost.get(wtv[0].trim()).equals(wtv[1].trim())) {
            return "provost";
        }
         else if (chairman.get(wtv[0].trim()) != null && chairman.get(wtv[0].trim()).equals(wtv[1].trim())) {
            return "chairman";
        }
         else return "false";
    }
            
    @Override
    public void run(){
        System.out.println("Starting Server");

        try{
            ServerSocket ss = new ServerSocket(32345);
            while(running){
                Socket clientSocket = ss.accept();
                ClientHandler ch = new ClientHandler(this, clientSocket);
                ch.start();
                clientList.add(ch);
            }
        }catch(IOException e){
            System.out.println("Server Error");
        }
        
        System.out.println("Server Stopped");
    }
    
    public static void main(String [] args){
        new Server().start();
    }
}
