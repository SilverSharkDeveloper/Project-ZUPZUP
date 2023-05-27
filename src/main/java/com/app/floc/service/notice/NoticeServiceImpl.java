package com.app.floc.service.notice;


import com.app.floc.DAO.NoticeDAO;


import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;

    @Override
    public List<NoticeDTO> getList(AdminPagination adminPagination, Search search) {
        List<NoticeDTO> notices = noticeDAO.findAll(adminPagination, search);
        return notices;
    }

    //상세보기
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

    @Override
    public void deleteNoticeByIds(List<Long> noticeIds) {
        noticeDAO.deleteNoticeByIds(noticeIds);
    }
}


