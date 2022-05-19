package StudentSystem.bean;

public class Undergraduate extends Student{

    private UndergraduateScore score;
    {
        score = new UndergraduateScore();
    }

    public Undergraduate()
    {}
    public Undergraduate(int id, String name, int age, int classS, String major, Address address, UndergraduateScore score) {
        super(id, name, age, classS, major, address);
        this.score = score;
    }
    public int getMathS() {
        return score.MathS;
    }

    public void setMathS(int mathS) {
        score.MathS = mathS;
    }

    public int getEnglish() {
        return score.English;
    }

    public void setEnglish(int english) {
        score.English = english;
    }

    public int getJava() {
        return score.Java;
    }

    public void setJava(int java) {
        score.Java = java;
    }
    public UndergraduateScore getScore() {
        return score;
    }

    public void setScore(UndergraduateScore score) {
        this.score = score;
    }

    public int getSumScore()
    {
        return (this.getMathS()+this.getEnglish()+this.getJava());
    }
}
