package exam05;

public class Ex02 {
    public static void main(String[] args) {
        Book2 book2 = Book2.builder()
                .title("책1") // 메서드 체이닝 방식
                .author("저자1")
                .publisher("출판사1")
                .build();
        System.out.println(book2);
    }
}
