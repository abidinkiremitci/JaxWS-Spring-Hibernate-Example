package beardthered.ws;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
@HandlerChain(name = "WebServiceLoggingHandler", file = "../handler-chain-ws-logging.xml")
public interface ExampleWebService
{
    @WebMethod
    @WebResult(name = "helloWorldOutput")
    String helloWorld(@WebParam(name = "word") String word);
}
