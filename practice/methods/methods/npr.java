package practice.methods;
import java.util.*;
public class npr {
    public static int fact(int x){
        int f=1;
        for(int i=1; i<=x; ++i){
            f*=i;
        }
        return f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

//        int nfact = fact(n);
//        int rmnfact = fact(n-r);

        int npr = fact(n)/fact(n-r);

        System.out.println(npr);

    }
}
