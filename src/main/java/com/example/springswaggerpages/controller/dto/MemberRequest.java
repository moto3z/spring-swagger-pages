package com.example.springswaggerpages.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@ApiModel(value = "회원 정보", description = "아이디, 이름, 비밀번호, 이메일, 주소, 가입날짜를 가진 Domain Class")
public class MemberRequest {

    @ApiModelProperty(value = "아이디")
    private String id;
    @ApiModelProperty(value = "비밀번호")
    private String password;
    @ApiModelProperty(value = "이름")
    private String userName;
    @ApiModelProperty(value = "이메일")
    private String email;
    @ApiModelProperty(value = "주소")
    private String address;

    public static MemberRequest sample() {
        return new MemberRequest("sampleId", "password", "홍길동", "h@n.com", "address is here");
    }

    public static MemberRequest sample(String userId) {
        MemberRequest sample = sample();
        sample.setId(userId);
        return sample;
    }
}
