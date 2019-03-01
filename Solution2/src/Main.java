import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    /* m! / r!(m-r)! = (1*2*..*m)/(1*2*..*r)(1*2*..*(m-r))
      = ((r+1)*..*m)/(1*2*..*(m-r))
       когда r+1 < m-r можно еще упростить:
       ... = ((m-r+1)*..*m)/(1*2*..*r)
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        BigInteger a;
        BigInteger b;

        if(r + 1 < m - r){
            a = multRange(m - r + 1, m);
            b = multRange(1, r);
        }
        else{
            a = multRange(r + 1, m);
            b = multRange(1, m - r);
        }
        BigDecimal res = new BigDecimal(a).divide(new BigDecimal(b));
        System.out.println(res);
    }

    private static BigInteger multRange(int start, int end) {
        BigInteger res = BigInteger.ONE;
        for(int i = start; i <= end; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
