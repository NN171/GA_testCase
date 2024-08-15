package org.example.greenatom.exhandler;

import java.io.FileNotFoundException;

public class FileNotExist extends RuntimeException {
    public FileNotExist(String message) {
        super(message);
    }
}
