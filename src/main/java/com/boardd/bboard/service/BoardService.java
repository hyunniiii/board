package com.boardd.bboard.service;

import com.boardd.bboard.domain.Book;
import com.boardd.bboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService{

    @Autowired
    private BoardRepository boardRepository;

    public List<Book> boardListFindAll(){
        return boardRepository.findAll();
    }

    public void boardCreate(Book book){
        boardRepository.save(book);
    }

    public Book boardFindById(Long idx){
        return boardRepository.findById(idx).orElse(new Book());
    }

    public void boardUpdate(Book book){
        boardRepository.save(book);
    }

    public void boardDelete(Long idx){
        boardRepository.deleteById(idx);
    }



}
