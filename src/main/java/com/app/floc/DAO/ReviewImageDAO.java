package com.app.floc.DAO;

import com.app.floc.mapper.ReviewImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewImageDAO {
    private final ReviewImageMapper reviewImageMapper;
}
