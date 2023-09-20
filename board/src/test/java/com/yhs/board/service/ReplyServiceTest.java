package com.yhs.board.service;

import com.yhs.board.dto.ReplyDTO;
import com.yhs.board.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testGetList() {
        Long bno = 99L;

        List<ReplyDTO> replyDTOList = replyService.getList(bno);

        replyDTOList.forEach(replyDTO -> System.out.println(replyDTO));
    }
}
