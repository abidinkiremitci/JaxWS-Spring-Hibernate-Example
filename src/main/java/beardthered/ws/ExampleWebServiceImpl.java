package beardthered.ws;

import beardthered.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "beardthered.ws.ExampleWebService", serviceName = "ExampleWebService")
@HandlerChain(file = "../handler-chain-ws-logging.xml")
public class ExampleWebServiceImpl extends SpringBeanAutowiringSupport implements ExampleWebService
{
    @Autowired
    @Qualifier("exampleService")
    ExampleService exampleService;

    @Override
    public String helloWorld(String word) {
        return exampleService.helloWorld(word);
    }
}
