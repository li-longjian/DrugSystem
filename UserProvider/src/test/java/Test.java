import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        String ans = s.replace("-","");
        System.out.println(ans);
    }
}
