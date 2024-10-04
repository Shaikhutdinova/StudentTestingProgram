package org.example.service;

import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private IOService ioService;

    @Test
    public void testGetStudentFromConsole() {
        String name = "John Doe";
        String group = "CS101";

        Mockito.when(ioService.readLine()).thenReturn(name).thenReturn(group);

        User user = userService.getStudentFromConsole();

        assertEquals(name, user.getName());
        assertEquals(group, user.getGroup());
        assertEquals(0, user.getPoints());
    }
}
