package exam05;

public class Book2 {
    private  String title;
    private  String author;
    private  String publisher;

    private  Book2() {}
    static  class Builder{
        private Book2 book2 = new Book2();
        public Builder title(String title){
            book2.title = title;
            return this;
        }
        public Builder author(String author){
            book2.author = author;
            return this;
        }
        public Builder publisher(String publisher){
            book2.publisher = publisher;
            return this;
        }
        public Book2 build(){
            return book2;
        }
    }
}
