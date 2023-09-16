package com.yhs.board.repository;

import com.yhs.board.entity.Board;
import com.yhs.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query("DELETE FROM Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);
}
