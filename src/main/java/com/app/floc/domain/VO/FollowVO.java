package com.app.floc.domain.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class FollowVO {
    private Long id;
    private Long followerId;
    private Long followingId;
    private String followStartDate;
}
