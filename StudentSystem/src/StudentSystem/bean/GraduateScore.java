package StudentSystem.bean;
public class GraduateScore
{

        public int MathS;
        public int English;
        public int MySQL;
        public GraduateScore()
        {
        }
        public GraduateScore(int mathS, int english, int mySQL) {
            MathS = mathS;
            this.English = english;
            this.MySQL = mySQL;
        }

        public int getMathS() {
        return MathS;
        }

        public void setMathS(int mathS) {
          MathS = mathS;
        }

        public int getEnglish() {
            return English;
        }

        public void setEnglish(int english) {
           English = english;
        }

        public int getMySQL() {
            return MySQL;
     }

     public void setMySQL(int mySQL) {
           MySQL = mySQL;
        }
}
