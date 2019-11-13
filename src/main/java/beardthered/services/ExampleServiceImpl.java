package beardthered.services;

import beardthered.db.dao.FooDAO;
import beardthered.db.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService
{
    @Autowired
    FooDAO fooDAO;

    @Override
    public String helloWorld(String word)
    {
        if(word !=null && word.equalsIgnoreCase("hello")) {
            return "world";
        }
        return "earth";
    }

    public List<Foo> getAllConfig()
    {
        return fooDAO.findAll();
    }
}
