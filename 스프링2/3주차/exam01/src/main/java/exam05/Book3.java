package exam05;

import lombok.Builder;
import lombok.ToString;

@Builder @ToString
public class Book3 {
    @ToString.Exclude // ToString 출력 제외
    private String title;
    private String author;
    private  String publisher;
}
