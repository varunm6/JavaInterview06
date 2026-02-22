package com.app.Service;

import com.app.DTO.UserDetailsDTO;
import com.app.Repository.UserRepository;
import com.app.Request.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    UserRepository userRepository;

    public UserDetailsDTO saveUser(UserDetails uiInput) {
        UserDetailsDTO dtoInput = new UserDetailsDTO();
        dtoInput.setName(uiInput.getName());
        dtoInput.setAddress(uiInput.getAddress());
        return userRepository.save(dtoInput);
    }


    public UserDetailsDTO getUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserDetails(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDetailsDTO> getAllUsers() {
         ArrayList<UserDetailsDTO> list= (ArrayList<UserDetailsDTO>) userRepository.findAll();
        return list;
    }

    public void deleteAllUserDetails() {
        userRepository.deleteAll();
    }

    public List<UserDetailsDTO> saveAllUserDetails(List<UserDetails> userDetails) {

        List<UserDetailsDTO> list= userDetails.stream()
                        .map(entry->{
                            UserDetailsDTO userDetailsDTO =new UserDetailsDTO();
                            userDetailsDTO.setName(entry.getName());
                            userDetailsDTO.setAddress(entry.getAddress());
                            return userDetailsDTO;
                        }).toList();
        List<UserDetailsDTO> savedList= (List<UserDetailsDTO>) userRepository.saveAll(list);
        return savedList;
    }
}
