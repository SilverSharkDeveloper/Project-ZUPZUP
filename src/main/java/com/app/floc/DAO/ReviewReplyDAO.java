package com.app.floc.DAO;

import com.app.floc.mapper.ReviewReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewReplyDAO {
    private final ReviewReplyMapper reviewReplyMapper;
}
