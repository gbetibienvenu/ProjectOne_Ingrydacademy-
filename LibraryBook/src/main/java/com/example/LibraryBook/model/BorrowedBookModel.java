package com.example.LibraryBook.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BorrowedBookModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank(message = "file this field,it is required")
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "file this field,it is required")
    @Column(name = "book_id")
    private  Integer bookId;

    @NotBlank(message = "file this field,it is required")
    @Column(name = "book_name")
    private  String bookname;

    @NotBlank(message = "file this field,it is required")
    @Column(name = "book_author")
    private String bookAuthor;

    public BorrowedBookModel(String id, int userId, int bookId, String bookname, String bookAuthor) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.bookname = bookname;
        this.bookAuthor = bookAuthor;
    }
}
