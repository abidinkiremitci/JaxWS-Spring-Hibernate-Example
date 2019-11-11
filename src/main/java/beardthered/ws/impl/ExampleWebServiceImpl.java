package beardthered.ws.impl;

import beardthered.services.ExampleService;
import beardthered.ws.ExampleWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "beardthered.ws.ExampleWebService", serviceName = "ExampleWebService")
@HandlerChain(name = "WebServiceLoggingHandler", file = "../handler-chain-ws-logging.xml")
public class ExampleWebServiceImpl implements ExampleWebService
{
    @Autowired
    @Qualifier("exampleService")
    ExampleService exampleService;

    @Override
    public String helloWorld(String word) {
        return exampleService.helloWorld(word);
    }
}
