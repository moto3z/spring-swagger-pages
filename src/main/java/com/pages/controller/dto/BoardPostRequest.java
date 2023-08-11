package com.pages.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
@ApiModel(value = "글 생성 요청", description = "글쓰기")
public class BoardPostRequest {

    @ApiModelProperty(value = "제목")
    private String title;
    @ApiModelProperty(value = "내용")
    private String contents;
    @ApiModelProperty(value = "익명글 여부")
    private Boolean isAnonymous;
    @ApiModelProperty(value = "예약글여부")
    private Boolean isReservation;
    @ApiModelProperty(value = "게시예정시간")
    private LocalDateTime reservedAt;

    public static BoardPostRequest sample() {
        return BoardPostRequest.builder()
            .title("해리포터와 일곱난쟁이")
            .contents("백설마녀와 꿀이든 사과")
            .isAnonymous(Boolean.FALSE)
            .isReservation(Boolean.TRUE)
            .reservedAt(LocalDateTime.now())
            .build();
    }
}
