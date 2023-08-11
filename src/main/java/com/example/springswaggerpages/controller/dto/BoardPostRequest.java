package com.example.springswaggerpages.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
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
    private Date ReservedAt;
}
