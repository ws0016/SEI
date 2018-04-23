/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author nl0012
 */
public class ClientHandler extends Thread {
     Server server;
    BufferedReader inReader;
    PrintWriter outWriter;
    
    public ClientHandler(Server s, Socket sock) {
        server = s;
        System.out.println("Client started: " + sock.getInetAddress().toString());
        
        try{
            inReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            outWriter = new PrintWriter(sock.getOutputStream());
            
        }catch(IOException e){
            System.out.println("Exception in ClientHandler");
        }
        
    }
    public void run(){
        try{        
            String input;
            while((input = inReader.readLine()) != null){  
                //System.err.println("test" + input);
                processInput(input);
            }
        }catch(IOException e){
            System.out.println("Exception in ClientHandler:  Client likely Disconnected");
        }
         
    }
    
    private void processInput(String inputstring){
        System.out.println("Processing Command");
        if(server.check(inputstring).equals("student")){
          outWriter.println("student");
          outWriter.flush();
          
        }
        else if(server.check(inputstring).equals("professor")){
          outWriter.println("professor");
          outWriter.flush();
          
        }
        
        else if(server.check(inputstring).equals("dean")){
          outWriter.println("dean");
          outWriter.flush();
          
        }
        
        else if(server.check(inputstring).equals("provost")){
          outWriter.println("provost");
          outWriter.flush();
          
        }
        else if(server.check(inputstring).equals("chairman")){
          outWriter.println("chairman");
          outWriter.flush();
          
        }
        else{
            outWriter.println("false");
            outWriter.flush();
        }

                
    }
}
