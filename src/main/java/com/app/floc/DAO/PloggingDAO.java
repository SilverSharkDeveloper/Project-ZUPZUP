package com.app.floc.DAO;

import com.app.floc.mapper.PloggingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PloggingDAO {
    private final PloggingMapper ploggingMapper;
}
