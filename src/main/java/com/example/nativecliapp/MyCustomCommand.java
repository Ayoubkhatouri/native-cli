package com.example.nativecliapp;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.FileWriter;
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
    public String createFile(String name, String path) throws IOException {
        File file = new File(path + "/" +name);
        if(file.createNewFile()) return "File created: " + name;
        else return "File already exists.";
    }

    @ShellMethod(key = "echo")
    public String writeToFile(String content, String filePath){
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file, true)){
                writer.write(content);
            return "Content appended to file: " + filePath;
        } catch (IOException e) {
            return "Error writing to file: " + e.getMessage();
        }
    }

    @ShellMethod(key = "rm")
    public String deleteFile(String filePath){
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()) return "File deleted: " + filePath;
            return  "Failed to delete the file: " + filePath;
        }
        else return "File not found: " + filePath;
    }
}
