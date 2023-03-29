package ro.tuc.Model;

import java.util.Collections;
import java.util.Map;

public class Operations {

    public Operations() {

    }

    public Polynomial add(Polynomial polynomial, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : polynomial.getMap().entrySet()) {
            Integer key = entry1.getKey();
            Double value = entry1.getValue();
            result.getMap().put(key, value);
        }
        for (Map.Entry<Integer, Double> entry2 : polynomial2.getMap().entrySet()) {
            Integer key = entry2.getKey();
            Double value = entry2.getValue();
            if (result.getMap().get(key) != null) {
                result.getMap().put(key, value + result.getMap().get(key));
            } else {
                result.getMap().put(key, value);
            }
        }
        result = result.empty(result);
        return result;
    }

    public Polynomial subtraction(Polynomial polynomial, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : polynomial.getMap().entrySet()) {
            Integer key = entry1.getKey();
            Double value = entry1.getValue();
            result.getMap().put(key, value);
        }
        for (Map.Entry<Integer, Double> entry2 : polynomial2.getMap().entrySet()) {
            Integer key = entry2.getKey();
            Double value = entry2.getValue();
            if (result.getMap().get(key) != null) {
                result.getMap().put(key, result.getMap().get(key) - value);
            } else {
                result.getMap().put(key, -value);
            }
        }
        result = result.empty(result);
        return result;
    }

    public Polynomial derivative(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : polynomial.getMap().entrySet()) {
            Integer key = entry1.getKey() - 1;
            Double value = entry1.getKey() * Double.valueOf(entry1.getValue());
            if (key >= 0) {
                result.getMap().put(key, value);
            }
        }
        result = result.empty(result);
        return result;
    }

    public Polynomial multiplication(Polynomial polynomial, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : polynomial.getMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : polynomial2.getMap().entrySet()) {
                int key = entry1.getKey() + entry2.getKey();
                double value = entry1.getValue() * entry2.getValue();
                if (result.getMap().get(key) != null) {
                    result.getMap().put(key, value + result.getMap().get(key));
                } else {
                    result.getMap().put(key, value);
                }
            }
        }
        result = result.empty(result);
        return result;
    }

    public Polynomial integration(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : polynomial.getMap().entrySet()) {
            Integer key = entry1.getKey() + 1;
            Double value = entry1.getValue() / Double.valueOf(entry1.getKey() + 1);
            if (key >= 0) {
                result.getMap().put(key, value);
            }
        }
        result = result.empty(result);
        return result;
    }

    public Polynomial[] division(Polynomial polynomial, Polynomial polynomial2) {
        Polynomial[] div = new Polynomial[2];
        div[0] = new Polynomial();
        div[1] = new Polynomial();
        Polynomial divisor = polynomial2;
        Polynomial dividend = polynomial;
        Polynomial quotient = new Polynomial();
        Polynomial temp = new Polynomial();
        Polynomial remainder = new Polynomial();
        remainder = remainder.copy(polynomial);
        while (!dividend.getMap().isEmpty() && Collections.max(dividend.getMap().keySet()) >= Collections.max(divisor.getMap().keySet())
                && Collections.max(remainder.getMap().keySet()) != 0) {
            double x = dividend.value(dividend);
            double y = divisor.value(divisor);
            int z = Collections.max(dividend.getMap().keySet()) - Collections.max(divisor.getMap().keySet());
            quotient.getMap().put(z, x / y);
            remainder.getMap().clear();
            temp.getMap().clear();
            temp.getMap().put(z, -(x / y));
            remainder = multiplication(temp, divisor);
            dividend = add(dividend, remainder);
        }
        if (dividend.getMap().isEmpty()) {
            dividend.getMap().put(0, 0.0);
        }
        div[0] = div[0].copy(dividend);
        div[1] = div[1].copy(quotient);
        return div;
    }
}
