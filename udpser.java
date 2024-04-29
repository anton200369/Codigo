import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class udpser{


  public static void main(String[] args) throws Exception{

    if( args.length !=2) {System.out.println("Wrong format. Correct :'udpser port_number secret' ");
    return;
  }

    else{

 
    int portnum= Integer.parseInt(args[0]);
    int secret= Integer.parseInt(args[1]);
    String dataforop= null;
    String basicstr= null;
    DatagramSocket fromclientsock= new DatagramSocket(portnum);
    DatagramPacket fromclientpack= null;
    int basicint= 0;
    int fullresultint=0;
    String fullresultstring=null;
    DatagramPacket toclientpack=null;

    while(true){

      fromclientpack= new DatagramPacket(new byte[1024], 1024);
      fromclientsock.receive(fromclientpack);
      dataforop = new String(fromclientpack.getData());
      basicstr= Calcu(dataforop);
      basicint= Integer.parseInt(basicstr);
      fullresultint= basicint+secret;
      fullresultstring= Integer.toString(fullresultint);
      toclientpack= new DatagramPacket(fullresultstring.getBytes(), fullresultstring.length(), fromclientpack.getSocketAddress());

      fromclientsock.send(toclientpack);

          }
        }

        

        }

  
        private static String Calcu(String data) {

            int number1=0; 
            int number2=0; 
            int result=0;
            char operator;
            int i=0;
            data.replaceAll(" ", "");

            while(true){

              if(Character.isDigit(data.charAt(i))){ 
                
                number1= number1*10 + Character.getNumericValue(data.charAt(i));
              }else break;

                i++;
              
              }

               operator= data.charAt(i);
            
            i++;

            while(true){

              if(Character.isDigit(data.charAt(i))){ 
                
                number2= number2*10 + Character.getNumericValue(data.charAt(i));
              }else break;

                i++;
              
              }

          switch (operator){
        
              // performs addition between numbers
              case '+':
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;
        
              // performs subtraction between numbers
              case '-':
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;
        
              // performs multiplication between numbers
              case '*':
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;
        
              // performs division between numbers
              case '/':
                result = number1 / number2;
                System.out.println(number1 + " / " + number2 + " = " + result);
                break;
        
              default:
                System.out.println("try with another operator!!");
                break;
            }
            
            return Integer.toString(result);

          }
}