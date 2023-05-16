package com.app.floc.DAO;

import com.app.floc.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FollowDAO {
    private final FollowMapper followMapper;
}
