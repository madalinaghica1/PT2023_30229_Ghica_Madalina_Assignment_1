
import Business_Logic.Operations;
import Data_Models.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
public class Teste {
    @ParameterizedTest
    @MethodSource("Adunare")
    void testAdditions(String rezultat,String expectedRez){
        assertEquals(rezultat,expectedRez); }
    private static List<Arguments> Adunare(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        p1.getPolynomials().put(0,5.0);
        p1.getPolynomials().put(2,3.0);
        p2.getPolynomials().put(1,2.0);
        p2.getPolynomials().put(2,5.0);
        arguments.add(Arguments.of(Operations.addP(p1,p2).toString(),"5.0 + 2.0x + 8.0x^2"));
        return arguments;
    }
    @ParameterizedTest
    @MethodSource("Scadere")
    void testSub(String rezultat,String expectedRez){
        assertEquals(rezultat,expectedRez); }
    private static List<Arguments> Scadere(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        p1.getPolynomials().put(0,5.0);
        p1.getPolynomials().put(2,3.0);
        p2.getPolynomials().put(0,4.0);
        p2.getPolynomials().put(1,2.0);
        p2.getPolynomials().put(2,5.0);
        arguments.add(Arguments.of(Operations.subP(p1,p2).toString(),"1.0 - 2.0x - 2.0x^2"));
        return arguments;
    }
    @ParameterizedTest
    @MethodSource("Inmultire")
    void testMul(String rezultat,String expectedRez){
        assertEquals(rezultat,expectedRez); }
    private static List<Arguments> Inmultire(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        p1.getPolynomials().put(0,5.0);
        p2.getPolynomials().put(0,4.0);
        p2.getPolynomials().put(1,2.0);
        p2.getPolynomials().put(2,5.0);
        arguments.add(Arguments.of(Operations.multP(p1,p2).toString(),"20.0 + 10.0x + 25.0x^2"));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource("Derivare")
    void testDeriv(String rezultat,String expectedRez){
        assertEquals(rezultat,expectedRez); }
    private static List<Arguments> Derivare(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        p1.getPolynomials().put(0,5.0);
        p1.getPolynomials().put(2,4.0);

        arguments.add(Arguments.of(Operations.derivP(p1).toString(),"8.0x"));
        return arguments;
    }
    @ParameterizedTest
    @MethodSource("Integrare")
    void testIntegrare(String rezultat,String expectedRez){
        assertEquals(rezultat,expectedRez); }
    private static List<Arguments> Integrare(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        p1.getPolynomials().put(0,5.0);
        p1.getPolynomials().put(1,4.0);

        arguments.add(Arguments.of(Operations.integrareP(p1).toString(),"5.0x + 2.0x^2"));
        return arguments;
    }
}