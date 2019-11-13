package beardthered.services;

import beardthered.db.model.Foo;

import java.util.List;

public interface ExampleService
{
    String helloWorld(String word);

    List<Foo> getAllConfig();
}
