package de.softceed.camel.example.fromexternal;

import java.util.List;

import org.apache.camel.Body;
import org.apache.camel.Exchange;

import de.softceed.camel.example.fromexternal.ExampleRequest;
import de.softceed.camel.example.fromexternal.SyncResponse;

/**
 * Processing messages
 */
public class WsMessageProcessor {

  /**
   * Get SOAP request
   * 
   * @param message SOAP Message with SOAP request
   */
  public Object getSoapRequest(Exchange message) throws Exception {
    System.out.println("Getting SOAP request...");
    Object result = null;
    try {
      if (message != null) {
        result = message.getIn().getBody(List.class).get(0);
        if (result instanceof ExampleRequest) {
          System.out.println("ExampleRequest received");
        }
      }
    } catch (NullPointerException ex) {
      System.out.println("Exception in processing request...");
      System.out.println(ex);
      throw new Exception("Ungueltiger Request");
    }
    return result;
  }

  /**
   * Validating SOAP request
   * 
   * @param request Request
   */
  public void validateSoapRequest(@Body Object request) {
    System.out.println("Validating SOAP request...");
  }

  /**
   * Creating synchronous acknowledgement for request
   * 
   * @param request Request
   * @return Response
   */
  public SyncResponse getSyncSoapResponse(@Body Object request) {
    SyncResponse result = new SyncResponse();
    String responseMessage = "Message received...";
    result.setResult(responseMessage);
    return result;
  }
}
