package com.example.demo.model;

public class Music {
    private String title;
    private String genre;
    private String fileName;

    // Конструктор
    public Music(String title, String genre, String fileName) {
        this.title = title;
        this.genre = genre;
        this.fileName = fileName;
    }

    // Геттери та сеттери
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
}