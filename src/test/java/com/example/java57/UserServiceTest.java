package com.example.java57;

import com.example.java57.model.User;
import com.example.java57.repositoires.UserRepository;
import com.example.java57.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserRepository userRepositoryMock;
    @InjectMocks
    private UserService userServiceMock;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getAllUsersTest(){
        User user1=new User(1L,"Mihai","@mihaitest");
        User user2=new User(2L,"User2","@user2test");
        User user3=new User(3L,"User3","@user3test");
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userRepositoryMock.findAll()).thenReturn(userList);
        List<User> users=userServiceMock.getAllUsers();
        assertEquals(2,users.size());
        assertEquals("Mihai",users.get(0).getName());
    }
    @Test
    public void testGetUserById(){
        User user1=new User(1L,"Mihai","@mihaitest");
        User user2=new User(2L,"User2","@user2test");
        User user3=new User(3L,"User3","@user3test");
        when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(user1));
        Optional<User> result=userServiceMock.getUserById(1L);
        assertEquals(true,result.isPresent());
        User u=result.get();
        assertEquals("Mihai",u.getName());
    }
    @Test
    public void testSaveUser() {
        User user1 = new User(1L, "Mihai", "@mihaitest");

        userServiceMock.saveUser(user1);
        verify(userRepositoryMock, times(1)).save(user1);
    }

    @Test
    public void testDeleteUserById(){
        User user1 = new User(1L, "Mihai", "@mihaitest");
        userServiceMock.saveUser(user1);
        userServiceMock.deleteUserById(1L);
        verify(userRepositoryMock,times(1)).deleteById(1L);
    }

    @Test
    public void testFindByEmail(){
        User user1 = new User(1L, "Mihai", "@mihaitest.com");
        when(userRepositoryMock.findByEmail("@mihaitest.com")).thenReturn(Optional.of(user1));
        Optional<User> result= userServiceMock.findByEmail("@mihaitest.com");
        assertEquals(true,result.isPresent());
        assertEquals("@mihaitest.com",result.get().getEmail());
    }


}
