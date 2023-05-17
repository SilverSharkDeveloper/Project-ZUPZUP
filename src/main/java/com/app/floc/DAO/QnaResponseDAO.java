package com.app.floc.DAO;

import com.app.floc.mapper.QnaResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QnaResponseDAO {
    private final QnaResponseMapper qnaResponseMapper;
}
