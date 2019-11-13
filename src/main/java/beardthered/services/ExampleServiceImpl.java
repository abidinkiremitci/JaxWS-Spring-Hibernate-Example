package beardthered.services;

import org.springframework.stereotype.Service;

@Service("exampleService")
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
