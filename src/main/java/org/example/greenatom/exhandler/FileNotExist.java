package org.example.greenatom.exhandler;

public class FileNotExist extends RuntimeException {
    public FileNotExist(String message) {
        super(message);
    }
}
