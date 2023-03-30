package Business_Logic;

import Data_Models.Polynomial;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {

    public static Polynomial addP(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        for (Integer grad : p1.getGrade()) {
            double coef = p1.getCoef(grad);
            rez.addPolyn(grad, coef);
        }
        for (Integer grad : p2.getGrade()) {
            double coef = p2.getCoef(grad);
            if (rez.contineTerm(grad)) {
                double coefCurent = rez.getCoef(grad);
                rez.setCoef(grad, coef + coefCurent);
            } else
                rez.addPolyn(grad, coef);
        }
        return rez;
    }

    public static Polynomial subP(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        for (Integer grad : p1.getGrade()) {
            double coef = p1.getCoef(grad);
            rez.addPolyn(grad, coef);
        }
        for (Integer grad : p2.getGrade()) {
            double coef = p2.getCoef(grad);
            if (rez.contineTerm(grad)) {
                double coefCurent = rez.getCoef(grad);
                rez.setCoef(grad, coefCurent - coef);
                System.out.println();
            } else {
                rez.setCoef(grad, -coef);
            }
        }
        return rez;
    }

    public static Polynomial multP(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        for (Map.Entry<Integer, Double> termen1 : p1.getPolynomials().entrySet()) {
            for (Map.Entry<Integer, Double> termen2 : p2.getPolynomials().entrySet()) {
                int grad = termen1.getKey() + termen2.getKey();
                double coeff = termen1.getValue() * termen2.getValue();
                if (rez.contineTerm(grad)) {
                    coeff = coeff + rez.getCoef(grad);
                }
                rez.setCoef(grad, coeff);
            }
        }
        return rez;
    }
    public static Polynomial derivP(Polynomial p1) {
        Polynomial rez = new Polynomial();
        for (Map.Entry<Integer, Double> termen1 : p1.getPolynomials().entrySet()) {
            double coeff = termen1.getValue()*termen1.getKey();
            int grad = termen1.getKey()-1;
            rez.setCoef(grad, coeff);
        }
        return rez;
    }
    public static Polynomial integrareP(Polynomial p1) {
        Polynomial rez = new Polynomial();
        for (Map.Entry<Integer, Double> termen1 : p1.getPolynomials().entrySet()) {
            double coeff = termen1.getValue()/(termen1.getKey()+1);
            int grad = termen1.getKey()+1;
            rez.setCoef(grad, coeff);
        }
        return rez;
    }
    public static Polynomial verifP(String str) {

        Polynomial pol=new Polynomial();
        int exp=0;
        Pattern pattern = Pattern.compile("([+-]?\\d*)x\\^(\\d+)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int x=+1;
            if(matcher.group(1)!=null && matcher.group(1).equals("-")){
                x=-1;}
            double coef=1;
            if(!matcher.group(2).equals("")) {
                exp = Integer.parseInt(matcher.group(2));
            }
            coef=Double.parseDouble(matcher.group(1));
            pol.addPolyn(exp,coef);
        }
        return pol;
    }

}
