package com.wcy.GUI.snake.source;

public class UserCharts {
    String name;
    int score;

    public UserCharts(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public UserCharts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
