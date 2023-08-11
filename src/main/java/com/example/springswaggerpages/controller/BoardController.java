package com.example.springswaggerpages.controller;

import com.example.springswaggerpages.controller.dto.BoardPostRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Board API V0")
@RequestMapping("/board/v0")
public class BoardController {

    @ApiOperation(value = "CREATE", notes = "게시판에 글을 작성합니다")
    @PostMapping
    public Map<String, String> addPost(@RequestBody(required = false) BoardPostRequest boardPostRequest) {
        return Map.of(
            "result", "요청결과",
            "boardId", "게시글번호"
        );
    }
}
