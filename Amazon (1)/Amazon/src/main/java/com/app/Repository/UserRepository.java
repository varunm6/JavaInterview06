package com.app.Repository;

import com.app.DTO.UserDetailsDTO;
import com.app.Request.UserDetails;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsDTO, Long> {

//    public UserDetails save(UserDetailsDTO dto);
//    public UserDetails getBy(Long id);

}
