package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserServiceImpl implements UserService {
    private final IOService reader;

    public UserServiceImpl(IOService reader) {
        this.reader = reader;
    }

    @Override
    public User getStudentFromConsole() {

        System.out.print("Enter your:\n" + "1. Name: ");
        String name = reader.readLine();
        System.out.print("2. Group: ");
        String group = reader.readLine();
        System.out.println();
        return new User(name, group, 0);

    }
}
