package com.example.LibraryBook.service;

import com.example.LibraryBook.model.BookModel;
import com.example.LibraryBook.model.BorrowedBookModel;
import com.example.LibraryBook.repository.BorrowedBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BorrowedBookService {
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    public List<BorrowedBookModel> getBorrowedBookByUserId(Long borrowedBookId){
        return borrowedBookRepository.findByBookId(borrowedBookId);

    }

}
