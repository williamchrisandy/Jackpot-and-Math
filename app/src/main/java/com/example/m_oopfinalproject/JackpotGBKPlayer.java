package com.example.m_oopfinalproject;

import java.util.ArrayList;

public class JackpotGBKPlayer {
    // How moves are stored in Player?:
    // u: Unassigned
    // n: NULL
    // g: Scissors
    // b: Rock
    // k: Paper

    public String name = "";
    public int score;
    private ArrayList<Character> pendingMoves = new ArrayList<>();

    // Constructor
    JackpotGBKPlayer(String name){
        overrideName(name);
        resetScore();
        resetPendingMoves();
    }

    // Resets (or overriders)
    void resetScore(){
        score = 0;
    }
    void resetPendingMoves(){
        pendingMoves.clear();
    }
    void overrideName(String name){
        this.name = name;
    }

    // Getters
    public ArrayList<Character> getPendingMoves(){
        return pendingMoves;
    }

    // Setters
    public int addScore(int n){
        score += n;
        return score;
    }
    public int pushMove(char move){
        pendingMoves.add(move);
        return pendingMoves.size();
    }
    public char popMove(){
        if (pendingMoves.size() == 0) return 'u';
        char res = pendingMoves.get(0);
        pendingMoves.remove(0);
        return res;
    }
}
