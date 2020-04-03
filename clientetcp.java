
package comunicacion_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteTCP {

    
    public static void main(String[] args) {
       
       
            final String HOST="127.0.0.1";
            final int PUERTO = 8080;
            DataInputStream in;
            DataOutputStream out;
            DataInputStream in1;
            DataOutputStream out1;
            
            try {
            Socket sc = new Socket(HOST, PUERTO);
            in = new DataInputStream (sc.getInputStream());
            out = new DataOutputStream (sc.getOutputStream());
            in1 = new DataInputStream (sc.getInputStream());
            out1 = new DataOutputStream (sc.getOutputStream());
            
            out.writeUTF("Hola desde el cliente ");
            
            String mensaje =in.readUTF();
            
            
                System.out.println(mensaje);
                
             out1.writeUTF("bye");
             
             String mensaje1 = in.readUTF();
                
                
                sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
