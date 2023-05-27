package com.app.floc.service.mypage;

import com.app.floc.DAO.PloggingDAO;
import com.app.floc.DAO.TissueDAO;
import com.app.floc.DAO.UserDAO;
import com.app.floc.domain.DTO.MyPloggingPagination;
import com.app.floc.domain.DTO.PloggingDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.VO.TissueVO;
import com.app.floc.domain.VO.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final PloggingDAO ploggingDAO;
    private final UserDAO userDAO;
    private final TissueDAO tissueDAO;

    @Override
    public List<PloggingDTO> getList(MyPloggingPagination myPloggingPagination, Search search){
        final List<PloggingDTO> ploggings = ploggingDAO.findMyAll(myPloggingPagination, search);
        //        게시글 하나씩 첨부파일 목록 담기
        ploggings.forEach(plogging -> plogging.setPloggingImageName(String.valueOf(ploggingDAO.findFiles(plogging.getId()))));
        return ploggings;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(PloggingDTO ploggingDTO) {
        ploggingDAO.save(ploggingDTO);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<PloggingDTO> read(Long id){
        final Optional<PloggingDTO> foundPlogging = ploggingDAO.findById(id);

        return foundPlogging;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PloggingDTO ploggingDTO) {
        ploggingDAO.setPloggingDTO(ploggingDTO);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        ploggingDAO.delete(id);

    }

    @Override
    public int getTotal(Search search) {
        return ploggingDAO.findCountOfPlogging(search);
    }

    @Override
    public void modifyUser(UserVO userVO) {
        userDAO.updateUser(userVO);
    }

    @Override
    public void modifyPassword(UserVO userVO) {
        userDAO.crystalPassword(userVO);
    }

    @Override
    public void exitUser(UserVO userVO) {
        userDAO.deleteUser(userVO);
    }

    @Override
    public List<TissueVO> getListPoint(MyPloggingPagination myPloggingPagination,Search search) {
        final List<TissueVO> tissues = tissueDAO.findAll(myPloggingPagination,search);
        return tissues;
    }

    @Override
    public void usePoint(TissueVO tissueVO) {
        tissueDAO.save(tissueVO);
    }
}
