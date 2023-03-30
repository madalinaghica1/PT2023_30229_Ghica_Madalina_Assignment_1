package Data_Models;

import Business_Logic.Operations;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private HashMap<Integer, Double> polynomials;

    public Polynomial() {
        polynomials = new HashMap<Integer, Double>();
    }

    public HashMap<Integer, Double> getPolynomials() {
        return polynomials;
    }

    public void setPolynomials(HashMap<Integer, Double> polynomials) {
        this.polynomials = polynomials;
    }

    public void addPolyn(int exponent, Double coefficient) {
        polynomials.put(exponent, coefficient);
    }

    public int getGrad(int grad) {
        if (polynomials.containsKey(grad))
            return grad;
        else
            return -1;
    }

    public double getCoef(int grad) {
        if (polynomials.containsKey(grad))
            return polynomials.get(grad);
        else
            return 0;
    }


    public Set<Integer> getGrade() {
        return polynomials.keySet();
    }

    public boolean contineTerm(Integer grad) {
        return polynomials.containsKey(grad);
    }

    public void setCoef(Integer grad, double coef) {
        polynomials.put(grad, coef);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        for (int exp : polynomials.keySet()) {
            double coef = polynomials.get(exp);
            if (coef != 0) {
                if (!firstTerm) {
                    if (coef > 0) {
                        sb.append(" + ");
                    } else {
                        sb.append(" - ");
                        coef = -coef;
                    }
                } else if (coef < 0) {
                    sb.append("-");
                    coef = -coef;
                }
                if (coef != 1 || exp == 0) {
                    sb.append(coef);
                }
                if (exp > 0) {
                    sb.append("x");
                    if (exp > 1) {
                        sb.append("^").append(exp);
                    }
                }
                firstTerm = false;
            }
        }
        if (firstTerm) {
            sb.append("0");
        }
        return sb.toString();
    }
}

