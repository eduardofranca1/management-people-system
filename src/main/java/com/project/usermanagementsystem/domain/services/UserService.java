package com.project.usermanagementsystem.domain.services;

import com.project.usermanagementsystem.api.dto.UserDTO;
import com.project.usermanagementsystem.api.dto.mapper.UserMapper;
import com.project.usermanagementsystem.domain.exceptions.ResourceNotFoundException;
import com.project.usermanagementsystem.domain.model.User;
import com.project.usermanagementsystem.api.dto.MessageResponseDTO;
import com.project.usermanagementsystem.domain.exceptions.BusinessException;
import com.project.usermanagementsystem.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    public MessageResponseDTO createPerson(UserDTO userDTO) {

        User user = userMapper.toModel(userDTO);

        boolean existingCpf = userRepository.findOptionalByCpf(user.getCpf())
                .stream()
                .anyMatch(existingPerson -> !existingPerson.equals(user));

        if (existingCpf) {
            throw new BusinessException("Already have an user with this CPF. Please insert another CPF.");
        }

        User savedUser = userRepository.save(user);

        return createMessageResponse("User successfully created with ID ", savedUser.getId());
    }

    public List<UserDTO> listAll() {
        List<User> people = userRepository.findAll();
        return people.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not found."));

        return userMapper.toDTO(user);
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findOptionalByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("User cpf does not found"));

        return userMapper.toDTO(user);
    }

    public UserDTO findByCity(String city) {
        User user = userRepository.findAllByAddressCity(city).orElseThrow(() -> new ResourceNotFoundException("City does not found."));

        return userMapper.toDTO(user);
    }

    public UserDTO findByState(String state) {
        User user = userRepository.findAllByAddressState(state).orElseThrow(() -> new ResourceNotFoundException("State does not found."));

        return userMapper.toDTO(user);
    }

    public MessageResponseDTO update(Long id, UserDTO userDTO) {

        verifyIfExists(id);

        User updatedUser = userMapper.toModel(userDTO);
        User savedUser = userRepository.save(updatedUser);

        return createMessageResponse("User successfully updated with ID ", savedUser.getId());
    }

    public void delete(Long id) {

        verifyIfExists(id);

        userRepository.deleteById(id);
    }

    private void verifyIfExists(Long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not found"));
    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }

}
