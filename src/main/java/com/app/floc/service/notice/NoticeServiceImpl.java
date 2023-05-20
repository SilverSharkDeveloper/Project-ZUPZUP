package com.app.floc.service.notice;


import com.app.floc.DAO.NoticeDAO;
import com.app.floc.domain.VO.NoticeVO;
import com.app.floc.domain.dto.NoticeDTO;
import com.app.floc.domain.dto.Pagination;
import com.app.floc.domain.dto.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;

    @Override
    public List<NoticeDTO> getList(Pagination pagination, Search search) {
        return noticeDAO.findAll(pagination, search);
    }

    @Override
    public Optional<NoticeDTO> read(Long id) {
        return noticeDAO.findById(id);
    }

    @Override
    public void write(NoticeDTO noticeDTO) {
        noticeDAO.save(noticeDTO);
    }

    @Override
    public void modify(NoticeDTO noticeDTO) {

    }

    @Override
    public void remove(Long id) {
        noticeDAO.delete(id);
    }

    @Override
    public int getTotal(Search search) {
        return noticeDAO.findCountOfNotice(search);

    }
}


