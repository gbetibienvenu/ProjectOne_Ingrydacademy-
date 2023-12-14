package com.example.LibraryBook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book")

public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "book title field is reqiured")
    @Column (name = "book_title")
    private String book;

//    @NotBlank(message = "book subject field is required")
//    @Column (name = "book_subject")
//    private String subject;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private String author;

    @NotBlank(message = "isbn field is required")
    @Column (name = "isbn")
    private String isbn;

    @NotBlank(message = "year of publication field is required")
    @Column (name = "year_of_publication")
    private int yearOfPublication;

    public BookModel(Long id, String book, String author, String isbn, int yearOfPublication) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.isbn = isbn;
        this.yearOfPublication = yearOfPublication;
    }
}
