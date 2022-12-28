package com.vi.service;

import com.vi.models.User;
import com.vi.repository.UserRepository;
import com.vi.repository.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.vi.common.Constants.SPACE;

@Service
public class UserManagementService {


    @Autowired
    private UserRepository userRepository;

      public List<User> getAllUsers() {
          List<UserDTO> userDTOS = userRepository.findAll();
          return convertToServiceObjects(userDTOS);
      }

      private List<User> convertToServiceObjects(List<UserDTO> userDTOS) {
          List<User> users = new ArrayList<>();
          if(userDTOS == null)
              return users;
          for(UserDTO dto : userDTOS) {
              users.add(convertToServiceObject(dto));
          }
          return users;
      }
      private User convertToServiceObject(UserDTO userDTO) {
          if(userDTO == null)
              return new User();
          User user = new User();
//          if(userDTO.getUserId() != null)
//              user.setUserId(userDTO.getUserId());
          user.setUserId(userDTO.getUserId());
          user.setFistName(userDTO.getFirstName());
          userDTO.setLastName(userDTO.getLastName());

          if(userDTO.getFirstName() != null && userDTO.getLastName() != null) {
              user.setFullName(String.format("%s %s",user.getFistName() ,userDTO.getLastName()));
          }
          return user;
      }


}
