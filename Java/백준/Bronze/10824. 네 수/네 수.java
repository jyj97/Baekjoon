import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        String d = sc.next();

        a += b;
        c += d;

        System.out.println(Long.parseLong(a) + Long.parseLong(c));
        sc.close();
    }
}