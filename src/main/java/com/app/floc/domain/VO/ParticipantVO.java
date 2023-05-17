package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ParticipantVO {
    private Long id;
    private Long ploggingId;
    private Long userId;
}
