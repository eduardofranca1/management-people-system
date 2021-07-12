package com.project.usermanagementsystem.service;

import com.project.usermanagementsystem.api.dto.MessageResponseDTO;
import com.project.usermanagementsystem.api.dto.UserDTO;
import com.project.usermanagementsystem.domain.model.User;
import com.project.usermanagementsystem.domain.repositories.UserRepository;
import com.project.usermanagementsystem.domain.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.any;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.project.usermanagementsystem.utils.UserUtils.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        UserDTO userDTO = createFakeDTO();
        User expectedSavedUser = createFakeEntity();

        when(userRepository.save(any(User.class))).thenReturn(expectedSavedUser);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedUser.getId());
        MessageResponseDTO successMessage = userService.createPerson(userDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long id) {
        return MessageResponseDTO.builder()
                .message("User successfully created with ID " + id)
                .build();
    }

}
