package com.app.floc.mapper;

import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.VO.TissueVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TissueMapperTest {
    @Autowired
    private TissueMapper tissueMapper;

    @Test
    public void insertTest(){
        TissueVO tissueVO = new TissueVO();
        tissueVO.setTissuePoint(Long.valueOf(2000));
        tissueVO.setTissueHistory("unforgiven");
        tissueMapper.insert(tissueVO);
    }

    @Test
    public void selectAllTest(){
        Pagination pagination = new Pagination();
        pagination.setPage(1); //화면에서 전달받은 페이지
//        assertThat(TissueMapper.selectAll(pagination)).hasSize(2);
//        TissueMapper.selectAll(pagination, new Search("popular")).stream().map(TissueDTO::toString).forEach(log::info);
//        TissueMapper.selectAll(pagination, new Search()).stream().map(TissueDTO::toString).forEach(log::info);
    }

    @Test
    public void deleteTest(){
        tissueMapper.delete(6L);
//        assertThat(TissueMapper.selectAll()).hasSize(1);
    }

}