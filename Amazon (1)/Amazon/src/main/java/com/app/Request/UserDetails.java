package com.app.Request;

import com.app.DTO.UserDetailsDTO;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDetails {
    String Name;
    String Address;

    public UserDetails(UserDetails product) {
    }

    public UserDetails(Optional<UserDetailsDTO> byId) {
    }
}
