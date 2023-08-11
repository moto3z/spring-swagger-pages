package com.example.springswaggerpages.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Comment API V0")
@RequestMapping("/v0/comment")
public class CommentController {

    @ApiOperation(value = "read board", notes = "글 하나를 조회 합니다")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "NG")
    })
    @GetMapping("/{boardId}")
    public Map<String, String> readBoard(
        @ApiParam(value = "글번호", required = true, example = "142857") @PathVariable("boardId") String boardNumber
    ) {
        return Map.of(
            "title", "글제목",
            "boardId", "글번호",
            "author", "글쓴이",
            "count", "조회수"
        );

    }
}

