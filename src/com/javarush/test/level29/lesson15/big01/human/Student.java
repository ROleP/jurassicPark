package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta)
    {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setAverageGrade(double averageGrade)
    {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course)
    {
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }
    
    public void setBeginningOfSession(Date beginSessionDate) {
        beginningOfSession = beginSessionDate;
    }

    public void setEndOfSession(Date endSessionDate) {
        endOfSession = endSessionDate;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}
