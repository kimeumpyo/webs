package exam05;

public class Ex03 {
    public static void main(String[] args) {
        Book3 book3 = Book3.builder()
                .title("책1")
                .author("저자1")
                .publisher("출판사1")
                .build();
        System.out.println(book3);
    }
}
