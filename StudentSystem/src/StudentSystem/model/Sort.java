package StudentSystem.model;

import StudentSystem.bean.Graduate;
import StudentSystem.bean.Undergraduate;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {
    public static  void graduateBy(ArrayList<Graduate> allGraduate, String condition) {
        switch (condition) {
            case "学号" -> allGraduate.sort(new SortById());
            case "总成绩" -> allGraduate.sort(new SortBySumScore());
            case "数学" -> allGraduate.sort(new SortByScore1());
            case "数据库" -> allGraduate.sort(new SortByScore2());
            case "英语" -> allGraduate.sort(new SortByScore3());
        }

        return ;
    }

    public static  void undergraduateBy(ArrayList<Undergraduate> allUndergraduate, String condition) {
        switch (condition) {
            case "学号" -> allUndergraduate.sort(new USortById());
            case "总成绩" -> allUndergraduate.sort(new USortBySumScore());
            case "数学" -> allUndergraduate.sort(new USortByScore1());
            case "Java" -> allUndergraduate.sort(new USortByScore2());
            case "英语" -> allUndergraduate.sort(new USortByScore3());
        }

        return ;
    }
}


class SortById implements Comparator<Graduate> {
    public int compare(Graduate a, Graduate b) {
        return (a.getId()-b.getId());
    }
}

class SortBySumScore implements Comparator<Graduate> {
    public int compare(Graduate a, Graduate b) {
        return a.getSumScore() - b.getSumScore();
    }
}

class SortByScore1 implements Comparator<Graduate> {
    public int compare(Graduate a, Graduate b) {
        return a.getMathS() - b.getMathS();
    }
}

class SortByScore2 implements Comparator<Graduate> {
    public int compare(Graduate a, Graduate b) {
        return a.getMySQL() - b.getMySQL();
    }
}

class SortByScore3 implements Comparator<Graduate> {
    public int compare(Graduate a, Graduate b) {
        return a.getEnglish() - b.getEnglish();
    }
}

class USortById implements Comparator<Undergraduate> {
    public int compare(Undergraduate a, Undergraduate b) {
        return (a.getId()-b.getId());
    }
}

class USortBySumScore implements Comparator<Undergraduate> {
    public int compare(Undergraduate a, Undergraduate b) {
        return a.getSumScore() - b.getSumScore();
    }
}

class USortByScore1 implements Comparator<Undergraduate> {
    public int compare(Undergraduate a,Undergraduate b) {
        return a.getMathS() - b.getMathS();
    }
}

class USortByScore2 implements Comparator<Undergraduate> {
    public int compare(Undergraduate a, Undergraduate b) {
        return a.getJava() - b.getJava();
    }
}

class USortByScore3 implements Comparator<Undergraduate> {
    public int compare(Undergraduate a, Undergraduate b) {
        return a.getEnglish() - b.getEnglish();
    }
}

