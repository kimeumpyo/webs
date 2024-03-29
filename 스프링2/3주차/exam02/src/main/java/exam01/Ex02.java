package exam01;

public class Ex02 {
    public static void main(String[] args) {
        ProxyCalculator cal1 = new ProxyCalculator(new ImplCalculator());
        ProxyCalculator cal2 = new ProxyCalculator(new RecCalculator());

        long result1 = cal1.factorial(10);
        System.out.println("cal1 : " + result1);

        long result2 = cal2.factorial(10);
        System.out.println("cal2 : " + result2);
    }
}
