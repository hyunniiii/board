package com.boardd.bboard.repository;

import com.boardd.bboard.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Book,Long> {

}