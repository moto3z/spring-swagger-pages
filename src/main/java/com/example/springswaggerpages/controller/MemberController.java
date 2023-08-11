package com.example.springswaggerpages.controller;

import com.example.springswaggerpages.controller.dto.MemberRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("member API V0")
@RequestMapping("/v0/member")
public class MemberController {

    @ApiOperation(value = "다건조회", notes = "회원<strong>목록</strong>")
    @GetMapping(value = "", headers = {"Content-type=application/json"})
    public List<Map<String, String>> userList() {
        return List.of(
            Map.of(
                "name", "이름",
                "id", "회원고유번호"
            ),
            Map.of(
                "name", "이름",
                "id", "회원고유번호"
            )
        );
    }

    @ApiOperation(value = "단건조회", notes = "회원 <strong>상세 정보 조회</strong>")
    @GetMapping(value = "/{userid}", headers = {"Content-type=application/json"})
    public MemberRequest userInfo(@PathVariable @ApiParam(value = "검색할 회원의 아이디") String userid) {
        return MemberRequest.sample();
    }

    @ApiOperation(value = "생성", notes = "회원 <strong>등록</strong>")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "NG"),
        @ApiResponse(code = 500, message = "ㅈㅅ")
    })
    @PostMapping(headers = {"Content-type=application/json"})
    public Map<String, String> userRegister(
        @RequestBody @ApiParam(value = "회원 한 명의 정보를 갖는 객체", required = true) MemberRequest memberRequest) {
        return Map.of(
            "name", "이름",
            "id", "회원고유번호"
        );
    }

    @ApiOperation(value = "수정", notes = "회원 정보 변경")
    @PutMapping(value = "/{userId}", headers = {"Content-type=application/json"})
    public MemberRequest modify(
        @RequestParam @ApiParam(value = "회원 식별자", required = true) String userId) {
        return MemberRequest.sample(userId);
    }

    @ApiOperation(value = "삭제", notes = "회원 정보 삭제")
    @DeleteMapping(value = "/{userId}", headers = {"Content-type=application/json"})
    public Map<String, String> withdrawal(
        @RequestParam @ApiParam(value = "회원 식별자", required = true) String userId
    ) {
        return Map.of(
            "target", userId,
            "processingStatus", "처리현황",
            "submissionDate", "삭제요청일",
            "caseNumber", "삭제요청접수번호"
        );
    }
}
