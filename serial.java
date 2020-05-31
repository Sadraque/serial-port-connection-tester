
package serialportconnectiontester;

import processing.core.PApplet;
import processing.serial.Serial;

/**
 *
 * @author Sadraque Nunes
 */
public class serial extends PApplet{ //when you use the Processing IDE Serial library you need to extends the Processing PApplet 
       
  boolean status = true; //status of the serial connection
  String port; //serial port
  Serial serial; //object serial
  final int BAUD_RATE = 8; //baude rate
  final String ERROR_MESSAGE = "FAILED! ";
  final String FINAL_MESSAGE = "SUCCESS!";
  String outputMessage;
  
 /**
 * Open the conncetion with the serial port.
     * @param port
     * @return outputMessage
 */
  public String connect(String port){
  
  this.port = "COM" +port;    
  try{
     this.serial = new Serial(this, this.port, this.BAUD_RATE); //initialize the serial object and open the connection with the serial port 
 }
 catch(Exception E){
     this.status = false;
     this.outputMessage = this.ERROR_MESSAGE; //in case of error, send the ERROR_MESSAGE
 }
 finally{
    if(this.status == true){
      this.outputMessage = this.FINAL_MESSAGE; //confirm the connection STATUS
      
    }    
   } 
   
  return this.outputMessage;
  }

  /**
   * Close the connection 
   */
  public void close(){
     this.serial.stop();    
  }
}     
