import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    
    int lcmA=a.get(0);
    for (int i=1;i<a.size();i++) {
        lcmA=lcm(lcmA,a.get(i));
    }
    int gcdB = b.get(0);
    for (int i = 1; i < b.size(); i++) {
        gcdB = gcd(gcdB, b.get(i));
    }
    int count = 0;
    for (int i = lcmA; i <= gcdB; i += lcmA) {
        if (gcdB % i == 0) {
            count++;
        }
    }
    return count;
}
    public static int gcd(int a,int b){
    while(b!=0) {
        int temp=b;
        b=a%b;
        a=temp;
    }
    return a;
    }
    public static int lcm(int a, int b) {
        return a*(b/gcd(a,b));
    }
}
public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
