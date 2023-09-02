package org.koreait.restcontrollers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.koreait.commons.CommonException;
import org.koreait.commons.rest.JSONData;
import org.koreait.models.board.BoardValidationExceprion;
import org.koreait.models.board.NotAuthorizedException;
import org.koreait.models.board.SaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final SaveService saveService;
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid BoardForm boardForm, Errors errors)
    { // @RequestBody -> JSON 형태도 Java 객체로 바꿔준다!

        // log.info(boardForm.toString());

        // DB에 게시글 작성...
        if (errors.hasErrors()) {
            String messages = errors.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));

           // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
            throw new BoardValidationExceprion(messages);

        }

        saveService.save(boardForm); // NotAuthorizedException



        // return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.created(URI.create("/api/board/list")).build();
    }


}
