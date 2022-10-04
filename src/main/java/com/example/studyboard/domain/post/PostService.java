package com.example.studyboard.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //클래스 내의 final로 선언된 모든 멤버에 대한 생성자를 만들어줌
public class PostService {
    private final PostMapper postMapper; //스프링 컨테이너에 등록된 PostMapper인터페이스. CRUD처리를 위한 bean 주입
    /**
     * 게시글 저장
     * @param params-게시글 정보
     * @return Generated PK
     */
    @Transactional //선언된 트랜잭션. 해당 메서드가 호출되면 트랜잭션이 시작, 정상종료여부에 따라 commit, rollback
    public Long savePost(final PostRequest params){
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id-PK
     * @return 게시글 상세 정보
     */
    public PostResponse findPostById(final Long id){
        return postMapper.findById(id);
    }

    /**게시글 수정
     * @param params -게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params){
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id-PK
     * @return PK
     */
    public Long deletePost(final Long id){
        postMapper.deleteById(id);
        return id;
    }

    /**게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    }
}