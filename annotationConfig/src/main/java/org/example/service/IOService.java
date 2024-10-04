package org.example.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOService {
    Scanner scanner = new Scanner(System.in);
    public String readLine(){
        String line = scanner.nextLine();
        return line;
    }
}
