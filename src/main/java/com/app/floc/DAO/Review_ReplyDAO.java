package com.app.floc.DAO;

import com.app.floc.mapper.Review_ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Review_ReplyDAO {
    private final Review_ReplyMapper reviewReplyMapper;
}
