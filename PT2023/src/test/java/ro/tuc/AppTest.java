package ro.tuc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.tuc.Model.Operations;
import ro.tuc.Model.Polynomial;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {
    Polynomial polynomial1;
    Polynomial polynomial2;
    Operations operations;

    void setUp() {
    }

    @Test
    void testAdd() {
        polynomial1 = new Polynomial();
        polynomial2 = new Polynomial();
        operations = new Operations();
        polynomial1.getMap().put(2, 3.0);
        polynomial1.getMap().put(1, 6.0);
        polynomial1.getMap().put(0, 9.0);
        polynomial2.getMap().put(3, 5.0);
        polynomial2.getMap().put(2, 4.0);
        polynomial2.getMap().put(0, 7.0);
        Polynomial result = operations.add(polynomial1, polynomial2);
        Polynomial expected = new Polynomial();
        expected.getMap().put(3, 5.0);
        expected.getMap().put(2, 7.0);
        expected.getMap().put(1, 6.0);
        expected.getMap().put(0, 16.0);
        result.getMap().forEach((d, c) -> {
            assertEquals(c, expected.getMap().get(d));
        });
    }

    @Test
    void testSubtraction() {
        polynomial1 = new Polynomial();
        polynomial2 = new Polynomial();
        operations = new Operations();
        polynomial1.getMap().put(2, 3.0);
        polynomial1.getMap().put(1, 6.0);
        polynomial1.getMap().put(0, 9.0);
        polynomial2.getMap().put(3, 5.0);
        polynomial2.getMap().put(2, 4.0);
        polynomial2.getMap().put(0, 7.0);
        Polynomial result = operations.subtraction(polynomial1, polynomial2);
        Polynomial expected = new Polynomial();
        expected.getMap().put(3, -5.0);
        expected.getMap().put(2, -1.0);
        expected.getMap().put(1, 6.0);
        expected.getMap().put(0, 2.0);
        result.getMap().forEach((d, c) -> {
            assertEquals(c, expected.getMap().get(d));
        });
    }

    @Test
    void testMultiplication() {
        polynomial1 = new Polynomial();
        polynomial2 = new Polynomial();
        operations = new Operations();
        polynomial1.getMap().put(2, 3.0);
        polynomial1.getMap().put(1, 6.0);
        polynomial1.getMap().put(0, 9.0);
        polynomial2.getMap().put(3, 5.0);
        polynomial2.getMap().put(2, 4.0);
        polynomial2.getMap().put(0, 7.0);
        Polynomial result = operations.multiplication(polynomial1, polynomial2);
        Polynomial expected = new Polynomial();
        expected.getMap().put(5, 15.0);
        expected.getMap().put(4, 42.0);
        expected.getMap().put(3, 69.0);
        expected.getMap().put(2, 57.0);
        expected.getMap().put(1, 42.0);
        expected.getMap().put(0, 63.0);
        result.getMap().forEach((d, c) -> {
            assertEquals(c, expected.getMap().get(d));
        });
    }

    @Test
    void testDerivative() {
        polynomial1 = new Polynomial();
        operations = new Operations();
        polynomial1.getMap().put(2, 3.0);
        polynomial1.getMap().put(1, 6.0);
        polynomial1.getMap().put(0, 9.0);
        Polynomial result = operations.derivative(polynomial1);
        Polynomial expected = new Polynomial();
        expected.getMap().put(1, 6.0);
        expected.getMap().put(0, 6.0);
        result.getMap().forEach((d, c) -> {
            assertEquals(c, expected.getMap().get(d));
        });
    }
    @Test
    void testIntegration() {
        polynomial1 = new Polynomial();
        operations = new Operations();
        polynomial1.getMap().put(2, 3.0);
        polynomial1.getMap().put(1, 6.0);
        polynomial1.getMap().put(0, 9.0);
        Polynomial result = operations.integration(polynomial1);
        Polynomial expected = new Polynomial();
        expected.getMap().put(3, 1.0);
        expected.getMap().put(2, 3.0);
        expected.getMap().put(1, 9.0);

        result.getMap().forEach((d, c) -> {
            assertEquals(c, expected.getMap().get(d));
        });
    }
    @Test
    void testDivision() {
        polynomial1 = new Polynomial();
        polynomial2 = new Polynomial();
        operations = new Operations();
        polynomial1.getMap().put(2, 1.0);
        polynomial1.getMap().put(1, 1.0);
        polynomial1.getMap().put(0, 3.0);
        polynomial2.getMap().put(1, 1.0);
        polynomial2.getMap().put(0, -3.0);
        Polynomial[] result = operations.division(polynomial1, polynomial2);
        Polynomial[] expected = new Polynomial[2];
        expected[0] = new Polynomial();
        expected[1] = new Polynomial();
        expected[0].getMap().put(0, 15.0);
        expected[1].getMap().put(1, 1.0);
        expected[1].getMap().put(0, 4.0);
        result[0].getMap().forEach((d, c) -> {
            assertEquals(c, expected[0].getMap().get(d));
        });
        result[1].getMap().forEach((d, c) -> {
            assertEquals(c, expected[1].getMap().get(d));
        });
    }
}
