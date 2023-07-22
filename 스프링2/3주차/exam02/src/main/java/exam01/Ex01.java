package exam01;

public class Ex01 {
    public static void main(String[] args) {
        ImplCalculator cal1 = new ImplCalculator();
        RecCalculator cal2 = new RecCalculator();

        long stime = System.nanoTime(); // 추가 기능

       long result1 = cal1.factorial(10); // 핵심 기능
        System.out.printf("call: num: %d, result1=%d%n", 10, result1);

        long etime = System.nanoTime(); // 추가 기능
        System.out.println("걸린시간 : " + (etime - stime));

        stime = System.nanoTime();

       long result2 = cal2.factorial(10); // 핵심 기능
        System.out.printf("call: num: %d, result2=%d%n", 10, result2);

        etime = System.nanoTime(); // 추가 기능
        System.out.println("걸린시간 : " + (etime - stime));

    }
}
