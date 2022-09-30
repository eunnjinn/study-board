package com.example.studyboard.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    /**
     * 게시글 저장
     * @param params-게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final PostRequest params){
        postMapper.save(params);
        return params.getPost_idx();
    }

    /**
     * 게시글 상세정보 조회
     * @param post_idx-PK
     * @return 게시글 상세 정보
     */
    public PostResponse findByPostIdx(final Long post_idx){
        return postMapper.findByPostIdx(post_idx);
    }

    /**게시글 수정
     * @param params -게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params){
        postMapper.update(params);
        return params.getPost_idx();
    }

    /**
     * 게시글 삭제
     * @param post_idx-PK
     * @return PK
     */
    public Long deletePost(final Long post_idx){
        postMapper.deleteByPostIdx(post_idx);
        return post_idx;
    }

    /**게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    }
}