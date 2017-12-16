package pl.krystianminta.factory;

import java.util.List;
import java.util.Queue;

public interface AbstractFactory {

    Object getObject(String name);

    List<Object> makeOrder(Queue<String> order);

}
