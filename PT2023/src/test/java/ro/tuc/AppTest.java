package ro.tuc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.tuc.Model.Operations;
import ro.tuc.Model.Polynomial;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest 

{
    Polynomial polynomial1;
    Polynomial polynomial2;
    Operations operations;
    void setUp()
    {
        polynomial1=new Polynomial();
        polynomial2=new Polynomial();
        operations=new Operations();
    }
    void testAdd(){
polynomial1.getMap().put(2,3.0);
polynomial1.getMap().put(1,6.0);
polynomial1.getMap().put(0,9.0);
polynomial2.getMap().put(3,5.0);
polynomial2.getMap().put(2,4.0);
polynomial2.getMap().put(0,7.0);
Polynomial result=operations.add(polynomial1,polynomial2);
Polynomial expected=new Polynomial();
expected.getMap().put(3,5.0);
expected.getMap().put(2,7.0);
expected.getMap().put(1,6.0);
expected.getMap().put(0,16.0);
result.getMap().forEach((d,c)->{
    assertEquals(c,expected.getMap().get(d));
});
    }

}
