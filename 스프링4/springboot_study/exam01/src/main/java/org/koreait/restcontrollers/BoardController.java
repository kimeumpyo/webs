package org.koreait.restcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/board")
public class BoardController {
    @PostMapping
    public void save(@RequestBody BoardForm boardForm){ // @RequestBody -> JSON 형태도 Java 객체로 바꿔준다!
      log.info(boardForm.toString());
    }
}
