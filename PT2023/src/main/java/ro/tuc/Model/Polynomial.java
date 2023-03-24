package ro.tuc.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private Map<Integer,Double> map=new HashMap<>();

    public Polynomial()
    {

    }
    //split
    //border layout
    public Map<Integer,Double> getMap() {
        return map;
    }

    public void setMap(Map<Integer,Double> map) {
        this.map = map;
    }
    //aici trebuie sa modific citirea cu pattern

    public void StringtoPol(String string) {
        String poly = string;
        String[] terms = poly.replace(" ", "").split("(?=\\+|\\-)");
        for (String term : terms) {
            String[] splitAroundX = term.split("x", 2);
            int exponent = 0;
            if (splitAroundX.length > 1) {
                String sExp = splitAroundX[1].replace("^", "");
                exponent = sExp.isEmpty() ? 1 : Integer.parseInt(sExp);
            }
            String sCoeff = splitAroundX[0];
            double coefficient = sCoeff.isEmpty() ? 1.0 : ("-".equals(sCoeff) ? -1.0 : Double.parseDouble(sCoeff));
            map.put(Integer.valueOf(exponent), Double.valueOf(coefficient));
        }

    }
public Polynomial empty(Polynomial polynomial)
{
    Polynomial x=new Polynomial();

    for (Map.Entry<Integer, Double> entry : polynomial.getMap().entrySet())
    {
       if(entry.getValue()!=0){
           x.getMap().put(entry.getKey(), entry.getValue());}
    }
return x;

}
public Polynomial copy(Polynomial polynomial)
{
    Polynomial x=new Polynomial();
    for (Map.Entry<Integer, Double> entry : polynomial.getMap().entrySet())
    {
        x.getMap().put(entry.getKey(), entry.getValue());

    }
    return x;
}

}
