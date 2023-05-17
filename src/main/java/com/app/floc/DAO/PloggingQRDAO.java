package com.app.floc.DAO;

import com.app.floc.mapper.PloggingQRMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PloggingQRDAO {
    private final PloggingQRMapper ploggingQRMapper;
}
