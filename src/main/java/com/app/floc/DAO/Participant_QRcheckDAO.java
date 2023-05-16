package com.app.floc.DAO;

import com.app.floc.mapper.Participant_QRcheckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Participant_QRcheckDAO {
    private final Participant_QRcheckMapper participantQRcheckMapper;
}
