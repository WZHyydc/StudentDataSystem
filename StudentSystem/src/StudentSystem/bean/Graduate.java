package StudentSystem.bean;

public class Graduate extends Student{
    public GraduateScore score ;
    {
        score = new GraduateScore();
    }
    private String tutor;
    public Graduate()
    {
    }
    public Graduate(int id, String name, int age, int classS, String major, Address address, GraduateScore score, String tutor) {
        super(id, name, age, classS, major, address);
        this.score = score;
        this.tutor = tutor;
    }

    public GraduateScore getScore() {
        return score;
    }

    public void setScore(GraduateScore score) {
        this.score = score;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
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

    public int getMySQL() {
        return score.MySQL;
    }

    public void setMySQL(int mySQL) {
        score.MySQL = mySQL;
    }

    public int getSumScore()
    {
        return (this.getMathS()+this.getEnglish()+this.getMySQL());
    }

    }


