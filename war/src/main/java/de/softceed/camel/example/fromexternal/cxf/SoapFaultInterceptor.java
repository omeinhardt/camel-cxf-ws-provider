package de.softceed.camel.example.fromexternal.cxf;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

/**
 * Detecting and processing of invalid SOAP requests
 */
public class SoapFaultInterceptor extends AbstractSoapInterceptor {

  /**
   * Constructor, placing interceptor in PRE_STREAM phase of CXF handler chain
   */
  public SoapFaultInterceptor() {
    super(Phase.PRE_STREAM);
  }

  /**
   * @see org.apache.cxf.interceptor.Interceptor#handleMessage(org.apache.cxf.message.Message)
   */
  public void handleMessage(SoapMessage soapMessage) throws Fault {
    Fault fault = (Fault) soapMessage.getContent(Exception.class);
    String faultMessage = "Kein Fehler";
    if (fault != null) {
      faultMessage = fault.getMessage();
    }
    System.out.println("Fault: " + faultMessage);
  }
}
