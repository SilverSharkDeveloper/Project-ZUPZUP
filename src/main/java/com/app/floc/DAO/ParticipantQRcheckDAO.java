package com.app.floc.DAO;

import com.app.floc.mapper.ParticipantQRcheckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParticipantQRcheckDAO {
    private final ParticipantQRcheckMapper participantQRcheckMapper;
}
