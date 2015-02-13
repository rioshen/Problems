/**
 * Created by Robbert on 1/26/15.
 * Fraction to Recurring Decimal
 * https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sign = "-";
        }
        long a = Math.abs((long)numerator), b = Math.abs((long)denominator);
        StringBuffer buf = new StringBuffer(sign+a/b);
        a=a%b*10;
        if(a!=0)
            buf.append('.');
        HashMap<Long, Integer>  map = new HashMap();// value of A to index of inserted
        while(a!=0){// we can have the result, and save a into the map
            if(map.containsKey(a)){// it is a loop
                buf.insert((int)map.get(a), '(');
                buf.append(')');
                return buf.toString();
            }
            map.put(a,buf.length());
            buf.append(""+ a/b );
            a = a%b *10;
        }
        return buf.toString();
    }
}
