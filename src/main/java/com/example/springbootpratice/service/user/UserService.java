package com.example.springbootpratice.service.user;

import com.example.springbootpratice.dto.user.response.UserResponseDto;
import com.example.springbootpratice.dto.user.request.UserRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final List<UserResponseDto> users = new ArrayList<>();

    // 기본 데이터
    static {
        users.add(new UserResponseDto(1L, "John Doe", "john.doe@example.com"));
        users.add(new UserResponseDto(2L, "Jane Doe", "jane.doe@example.com"));
    }

    // 모든 사용자 조회
    public List<UserResponseDto> getAllUsers() {
        return users;
    }

    // 특정 사용자 조회
    public UserResponseDto getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 사용자 생성
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        Long newId = (long) (users.size() + 1);
        UserResponseDto newUser = new UserResponseDto(newId, userRequestDto.getName(), userRequestDto.getEmail());
        users.add(newUser);
        return newUser;
    }

    // 사용자 수정
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        UserResponseDto user = getUserById(id);
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        return user;
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        UserResponseDto user = getUserById(id);
        users.remove(user);
    }
}