
public class Main{
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("abc");
        StringBuilder s1 = new StringBuilder("abc");

        System.out.println(s1==s);
        System.out.println(s1.equals(s));
    }
}
