package main;

import config.AppCtx;
import models.Book;
import models.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        BookDao bookDao = ctx.getBean(BookDao.class);

        /* 추가 */
        /*
        Book book = Book.builder()
                .bookName("책6")
                .publisher("출판사6")
                .price(10000)
                .build();

         boolean result = bookDao.insert(book);
        System.out.println(result);
        */


        Book book = Book.builder()
                .bookId(6)
                .bookName("(수정)책6")
                .publisher("(수정)출판사6")
                .price(10000)
                .build();

        boolean result = bookDao.update(book);
        System.out.println(result);


         /*
        boolean result = bookDao.delete(7);
        System.out.println(result);
         */

         /*
        List<Book> books = bookDao.gets();
        for(Book book : books){
            System.out.println(book);
        }
        */

        ctx.close();
    }
}
