package com.example.studyboard.domain.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    /**
     * 게시글 저장
     * @param params -게시글 정보
     */
    void save(PostRequest params);

    /**
     * 게시글 상세정보 조회
     * @param user_id-PK
     * @return 게시글 상세정보
     */
    PostRespone findById(Long user_id);
}
