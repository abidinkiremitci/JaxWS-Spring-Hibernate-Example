package beardthered.ws;

import beardthered.db.model.Foo;
import beardthered.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "beardthered.ws.ExampleWebService", serviceName = "ExampleWebService")
@HandlerChain(file = "../handler-chain-ws-logging.xml")
public class ExampleWebServiceImpl extends SpringBeanAutowiringSupport implements ExampleWebService
{
    @Autowired
    ExampleService exampleService;

    @Override
    public String helloWorld(String word) {
        List<Foo> allConfig = exampleService.getAllConfig();
        return exampleService.helloWorld(word);
    }
}
