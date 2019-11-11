package beardthered.services.impl;

import beardthered.services.ExampleService;
import org.springframework.stereotype.Service;

@Service("exampleWebService")
public class ExampleServiceImpl implements ExampleService
{
    @Override
    public String helloWorld(String word)
    {
        if(word !=null && word.equalsIgnoreCase("hello")) {
            return "world";
        }
        return "earth";
    }
}
