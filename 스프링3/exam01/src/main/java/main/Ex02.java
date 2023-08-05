package main;

import config.AppCtx;
import models.Book;
import models.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        Book book = bookDao.get(5);
        System.out.println(book);

        long total = bookDao.getTotal();
        System.out.println("전체 갯수 : " + total);

        ctx.close();
    }
}
