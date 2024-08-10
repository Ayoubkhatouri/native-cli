package com.example.nativecliapp;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.IOException;

@ShellComponent
public class MyCustomCommand {

    @ShellMethod(key = "hello")
    public String hello(@ShellOption(defaultValue = "Ayoub") String name, @ShellOption(defaultValue = "1") int counter){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= counter ; i++){
            sb.append("Hello ").append(name).append(" iteration: ").append(i);
            if(i!=counter) sb.append("\n");
        }
        return sb.toString();
    }

    @ShellMethod(key = "test")
    public String test(){
        return "Shell Test";
    }

    @ShellMethod(key = "touch")
    public String createFile(String name) throws IOException {
        File file = new File(name);
        if(file.createNewFile()) return "File created: " + name;
        else return "File already exists.";
    }
}
