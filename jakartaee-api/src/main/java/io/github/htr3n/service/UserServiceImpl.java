package io.github.htr3n.service;

import io.github.htr3n.dto.UserCreationRequest;
import io.github.htr3n.dto.UserDto;
import io.github.htr3n.dto.UserUpdateRequest;
import jakarta.ejb.Stateless;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
public class UserServiceImpl implements UserService {

  @Override
  public List<UserDto> getUsers() {
    return Collections.emptyList();
  }

  @Override
  public UserDto getUser(String id) {
    return UserDto.builder().build();
  }

  @Override
  public void createUser(UserCreationRequest request) {
    log.info("Creating user");
  }

  @Override
  public void updateUser(UserUpdateRequest request) {
    log.info("Updating user");
  }

  @Override
  public void deleteUser(String id) {
    log.info("Deleting user");
  }
}
