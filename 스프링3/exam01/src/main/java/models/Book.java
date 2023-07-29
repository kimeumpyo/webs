package models;

import lombok.*;

@Data @Builder
public class Book {
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;
}
