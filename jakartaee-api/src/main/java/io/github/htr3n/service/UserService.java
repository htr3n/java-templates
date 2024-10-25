package io.github.htr3n.service;

import io.github.htr3n.dto.UserCreationRequest;
import io.github.htr3n.dto.UserDto;
import io.github.htr3n.dto.UserUpdateRequest;
import java.util.List;

public interface UserService {

  List<UserDto> getUsers();

  UserDto getUser(String id);

  void createUser(UserCreationRequest request);

  void updateUser(UserUpdateRequest request);

  void deleteUser(String id);
}
