package com.app.floc.DAO;

import com.app.floc.mapper.Plogging_QRcodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Plogging_QRcodeDAO {
    private final Plogging_QRcodeMapper ploggingQRcodeMapper;
}
