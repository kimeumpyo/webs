package exam05;

import lombok.*;


//@Getter @Setter @ToString
@Data    //@Getter @Setter @ToString 동일하게 작용
//@NoArgsConstructor(access = AccessLevel.PRIVATE) // 기본 생성자
//@NoArgsConstructor
//@AllArgsConstructor // 멤버 변수 초기화 생성자
@RequiredArgsConstructor
public class Book {
    private final String title;
    @NonNull
    private String author;
    private String publisher;

}
