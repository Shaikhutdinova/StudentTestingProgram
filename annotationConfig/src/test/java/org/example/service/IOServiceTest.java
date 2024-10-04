package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IOServiceTest {

    @InjectMocks
    private IOService ioService;

    @Mock
    private Scanner scanner;

    @Test
    public void testReadLine() {
        String expectedLine = "Test line";
        Mockito.when(scanner.nextLine()).thenReturn(expectedLine);

        String actualLine = ioService.readLine();

        assertEquals(expectedLine, actualLine);
    }
}
