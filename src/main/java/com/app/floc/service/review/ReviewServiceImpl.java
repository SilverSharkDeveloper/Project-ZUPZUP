package com.app.floc.service.review;

import com.app.floc.DAO.ReviewDAO;
import com.app.floc.DAO.ReviewImageDAO;
import com.app.floc.domain.DTO.Pagination;
import com.app.floc.domain.DTO.ReviewDTO;
import com.app.floc.domain.DTO.Search;
import com.app.floc.domain.ReviewImageType.ReviewImageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDAO reviewDAO;
    private final ReviewImageDAO reviewImageDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ReviewDTO> getList(Pagination pagination, Search search ) {
        final List<ReviewDTO> reviews = reviewDAO.findAll(pagination, search);
        reviews.forEach(review -> review.setFiles(reviewImageDAO.findAll(review.getId())));
        return reviews;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(ReviewDTO reviewDTO) {
        reviewDAO.save(reviewDTO);
        for(int i=0; i<reviewDTO.getFiles().size(); i++){
            reviewDTO.getFiles().get(i).setReviewId(reviewDTO.getId());
            reviewDTO.getFiles().get(i).setReviewImageType(i==0? ReviewImageType.REPRESENTATIVE.name():ReviewImageType.NON_REPRESENTATIVE.name());
            reviewImageDAO.save(reviewDTO.getFiles().get(i));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<ReviewDTO> read(Long id) {
        final Optional<ReviewDTO> foundReview = reviewDAO.findDetail(id);
        if(foundReview.isPresent()){
            foundReview.get().setFiles(reviewImageDAO.findAll(foundReview.get().getId()));
        }
        return foundReview;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(ReviewDTO reviewDTO) {
        reviewDAO.setReviewDTO(reviewDTO);
//        추가
        reviewDTO.getFiles().forEach(reviewImage -> {
            reviewImage.setReviewId(reviewDTO.getId());
            reviewImageDAO.save(reviewImage);
        });
//        삭제
        reviewDTO.getFileIdsForDelete().forEach(reviewImageDAO::delete);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        reviewDAO.delete(id);
//        replyDAO.deleteAll(id);
        reviewImageDAO.deleteAll(id);
    }
    
    @Override
    public int getTotal(Search search) {
        return reviewDAO.findCountOfReview(search);
    }

    @Override
    public List<ReviewDTO> getLocalList() {
        return reviewDAO.findAllLocal();
    }
}
