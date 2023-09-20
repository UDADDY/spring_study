package com.yhs.board.repository;

import com.yhs.board.entity.Board;
import com.yhs.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // Board 삭제 시에 댓글들 삭
    @Modifying
    @Query("DELETE FROM Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);

    // 게시물로 댓글 목록 가져오기
    List<Reply> getRepliesByBoardOrderByRno(Board board);
}
