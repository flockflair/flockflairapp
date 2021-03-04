package com.example.flockflairapp;

public class QuestionModel {

    public QuestionModel(){
        //Empty constructor for firebase
    }

    private String question, optionA, optionB, optionC, optionD, correctAnswer,setNo,explaination, difficulty,ChapterName;

    public QuestionModel(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer,String setNo, String explaination, String difficulty, String ChapterName) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.setNo = setNo;
        this.explaination = explaination;
        this.difficulty = difficulty;
        this.ChapterName = ChapterName;
    }

    public QuestionModel(String question, String chapterName) {
        this.question = question;
        this.ChapterName = chapterName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOtpionD(String otpionD) {
        this.optionD = otpionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getSetNo() {
        return setNo;
    }

    public void setSetNo(String setNo) {
        this.setNo = setNo;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        this.ChapterName = chapterName;
    }
}
