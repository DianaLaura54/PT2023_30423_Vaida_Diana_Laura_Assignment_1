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
result=result.empty(result);
        return result;
    }

    public Polynomial substraction(Polynomial polynomial, Polynomial polynomial2) {
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
        result=result.empty(result);
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
        result=result.empty(result);
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
        result=result.empty(result);
        return result;
    }

    public Polynomial integrative(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : polynomial.getMap().entrySet()) {
            Integer key = entry1.getKey() + 1;
            Double value = entry1.getValue() / Double.valueOf(entry1.getKey() + 1);
            if (key >= 0) {
                result.getMap().put(key, value);
            }
        }
        result=result.empty(result);
        return result;
    }

    public Polynomial division(Polynomial polynomial, Polynomial polynomial2) {
        Polynomial divisor = polynomial2;
        Polynomial dividend=polynomial;
        Polynomial quotient = new Polynomial();
        Polynomial temp= new Polynomial();
        Polynomial remainder = new Polynomial();
        remainder=remainder.copy(polynomial);
    while (!dividend.getMap().isEmpty() && Collections.max(dividend.getMap().keySet()) >= Collections.max(divisor.getMap().keySet())
            && Collections.max(remainder.getMap().keySet())!=0 ) {
            double x = Collections.max(dividend.getMap().values());
            double y = Collections.max(divisor.getMap().values());
            int z = Collections.max(dividend.getMap().keySet()) - Collections.max(divisor.getMap().keySet());
           quotient.getMap().put(z, x / y);
           remainder.getMap().clear();
            temp.getMap().clear();
           temp.getMap().put(z, -(x / y));
           remainder = multiplication(temp, divisor);
            dividend=add(dividend,remainder);
       }
    if(dividend.getMap().isEmpty())
     dividend.getMap().put(0, 0.0);

return quotient;// trebuie sa fac un vector pt quotient si dividend si sa le returnez pe amandoua
    }
}
