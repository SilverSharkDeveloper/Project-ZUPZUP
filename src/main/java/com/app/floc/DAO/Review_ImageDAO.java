package com.app.floc.DAO;

import com.app.floc.mapper.Review_ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Review_ImageDAO {
    private final Review_ImageMapper reviewImageMapper;
}
