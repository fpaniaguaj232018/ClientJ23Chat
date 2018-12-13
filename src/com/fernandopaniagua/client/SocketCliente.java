package com.fernandopaniagua.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketCliente {
    Socket clientSocket;
    InetSocketAddress addr;
    OutputStream os;
    BufferedWriter bw;
    public SocketCliente(){
        try {
            clientSocket = new Socket();
            addr = new InetSocketAddress("10.10.1.50",5555);
            clientSocket.connect(addr);
            System.out.println("Conectado en " + 
                    clientSocket.getInetAddress() +
                    ":" +
                    clientSocket.getPort());
            //ESTOY CONECTADO
            os = clientSocket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));
            System.out.println("bw" + bw);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void enviarMensaje(String mensaje){
        try {
            bw.write(mensaje);
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void cerrar(){
        try {
            os.close();
            clientSocket.close();
            System.out.println("Terminado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
