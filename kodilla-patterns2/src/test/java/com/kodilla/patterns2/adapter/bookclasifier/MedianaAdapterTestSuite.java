package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class MedianaAdapterTestSuite {
    @Test
    public void publicationYearMedianaTest() {
        //Given
        MedianAdapter bookAdapter = new MedianAdapter();
        Set<Book> booksFromLibraryA = new HashSet<>();
        Book book1 = new Book("Dmitrij Gluchowski", "Metro 2033", 2005, "Fantasy1");
        Book book2 = new Book("Jaroslaw Grzedowicz", "Hel 3", 2017, "Fantasy2");
        Book book3 = new Book("Jonathan Franzen", "Freedom", 2010, "Fantasy3");
        Book book4 = new Book("Scott Westerfeld", "Specials", 2006, "Fiction1");

        booksFromLibraryA.add(book1);
        booksFromLibraryA.add(book2);
        booksFromLibraryA.add(book3);
        booksFromLibraryA.add(book4);

        //Log
        booksFromLibraryA.forEach(System.out::println);
        System.out.println(booksFromLibraryA.size());
        //When
        int yearMedian = bookAdapter.publicationYearMedian(booksFromLibraryA);

        //Then
        assertThat(yearMedian).isEqualTo(2010);
    }
}
