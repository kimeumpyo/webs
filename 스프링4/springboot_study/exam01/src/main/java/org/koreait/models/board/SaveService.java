package org.koreait.models.board;

import org.koreait.restcontrollers.BoardForm;
import org.springframework.stereotype.Service;

@Service
public class SaveService {
    // 게시글 저장
    public void save(BoardForm form) {
        boolean isPossible = false;

        if (!isPossible) { // 작성 권한 없음
            throw new NotAuthorizedException("작성 권한이 없습니다.");
        }
    }
}
