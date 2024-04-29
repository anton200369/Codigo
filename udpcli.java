import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.TimeoutException;

class udpcli {

    public static void main(String[] args) throws Exception{

        if(args.length !=3){ System.out.println("Wrong format. Correct :'udpcli ip_server_address server_port_number operation' ");

        System.out.println("Ex: udpcli 127.0.0.1 888 3+2");

        return;

    }

     else{

        InetAddress direccserver =  InetAddress.getByName(args[0]);
        int serverportnum= Integer.parseInt(args[1]);
        String opString= args[2];
        DatagramSocket infoforserver= new DatagramSocket();

        DatagramPacket serverdat= new DatagramPacket(opString.getBytes(),opString.length() , direccserver, serverportnum);
        DatagramPacket receiveddata = new DatagramPacket(new byte[1024],1024);

        
            

        infoforserver.send(serverdat);

        infoforserver.setSoTimeout(10000);

        try {
        infoforserver.receive(receiveddata);

    } catch ( SocketTimeoutException e) {
        System.out.println("Timeout has happened");
    }

        String resulttxt= new String(receiveddata.getData());
        System.out.println(resulttxt);

        infoforserver.close();




        }
    }
}
