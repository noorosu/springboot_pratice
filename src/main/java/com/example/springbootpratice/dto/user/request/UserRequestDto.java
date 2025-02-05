package com.example.springbootpratice.dto.user.request;

import lombok.Data;

/**
 * 사용자 생성 및 요청 데이터를 처리하는 DTO
 */
@Data
public class UserRequestDto {

    private String name;   // 사용자 이름
    private String email;  // 사용자 이메일
}