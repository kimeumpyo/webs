package controllers.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("list")
    public String list(){

        boolean result = false;
        if(!result){
            throw new RuntimeException("에러 발생!!");
        }

        return "board/list";
    }

    /* - 컨트롤러 한정 에러 처리
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model){
        model.addAttribute("message", e.getMessage());

        e.printStackTrace();

        return "error/common";
    }
    */
}