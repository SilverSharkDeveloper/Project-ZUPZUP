package com.app.floc.DAO;

import com.app.floc.mapper.Qna_ResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Qna_ResponseDAO {
    private final Qna_ResponseMapper qnaResponseMapper;
}
