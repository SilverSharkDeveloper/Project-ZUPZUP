package com.app.floc.DAO;

import com.app.floc.mapper.TissueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TissueDAO {
    private final TissueMapper tissueMapper;
}
