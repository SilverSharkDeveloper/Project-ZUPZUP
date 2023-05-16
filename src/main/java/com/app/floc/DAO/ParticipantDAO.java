package com.app.floc.DAO;

import com.app.floc.mapper.ParticipantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParticipantDAO {
    private final ParticipantMapper participantMapper;
}
