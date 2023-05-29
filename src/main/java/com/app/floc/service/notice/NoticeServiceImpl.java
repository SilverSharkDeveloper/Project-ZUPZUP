package com.app.floc.service.notice;


import com.app.floc.DAO.NoticeDAO;


import com.app.floc.domain.DTO.AdminPagination;
import com.app.floc.domain.DTO.NoticeDTO;
import com.app.floc.domain.DTO.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<NoticeDTO> getList(AdminPagination adminPagination, Search search) {
        List<NoticeDTO> notices = noticeDAO.findAll(adminPagination, search);
        return notices;
    }

    //사엣보기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<NoticeDTO> read(Long id) {
        Optional<NoticeDTO> foundNotice = noticeDAO.findById(id);
        noticeDAO.updateReadCount(id);
        return foundNotice;
    }


    @Override
    public void write(NoticeDTO noticeDTO) {
        noticeDAO.save(noticeDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(NoticeDTO noticeDTO) {
        noticeDAO.setNoticeDTO(noticeDTO);
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

    @Override
    public List<NoticeDTO> selectByRecent() {
        return noticeDAO.selectByRecent();
    }


}


