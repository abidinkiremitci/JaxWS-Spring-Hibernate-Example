package beardthered.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class WebServiceLoggingHandler extends SpringBeanAutowiringSupport implements SOAPHandler<SOAPMessageContext>
{
    private static final Logger logger = LoggerFactory.getLogger(WebServiceLoggingHandler.class);

    public boolean handleMessage(SOAPMessageContext context)
    {
        return true;
    }

    public boolean handleFault(SOAPMessageContext context)
    {
        return true;
    }

    public void close(MessageContext context)
    {
    }

    public Set<QName> getHeaders()
    {
        return null;
    }
}
