package ro.tuc.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.sql.Types.NULL;

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


    public void StringtoPol(String string) {
        Pattern p1 = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher m1 = p1.matcher(string);
        int m=0;
        double[] x= new double[100];
        while(m1.find()) {
            x[m]=Double.parseDouble(m1.group());
            m++;
        }
        while(m!=0) {
            map.put((int)x[m-1],x[m-2]);
            m=m-2;
        }
        Arrays.fill(x,NULL);

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
public double value(Polynomial polynomial)
{ double x=0;
    for (Map.Entry<Integer, Double> entry :  polynomial.getMap().entrySet())
    {
       if(Collections.max(polynomial.getMap().keySet())==entry.getKey())
           x=entry.getValue();

    }
    return x;
}
}
