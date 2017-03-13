package sample;

public class StudentRecord {

    public String StudentID;
    public float Assignments, Midterm, FinalExam, FinalMark;
    public char LetterGrade;

    public StudentRecord(String StudentID, float Assignments, float Midterm, float FinalExam){

        this.StudentID = StudentID;
        this.Assignments = Assignments;
        this.Midterm = Midterm;
        this.FinalExam = FinalExam;

        this.FinalMark = (Assignments * 0.2f) + (Midterm * 0.3f) + (FinalExam * 0.5f);

        if (this.FinalMark > 80){
            this.LetterGrade = 'A';
        }
        else if (this.FinalMark > 70){
            this.LetterGrade = 'B';
        }
        else if (this.FinalMark > 60){
            this.LetterGrade = 'C';
        }
        else if (this.FinalMark > 50){
            this.LetterGrade = 'D';
        }
        else {
            this.LetterGrade = 'F';
        }

    }

    public String getStudentID(){
        return this.StudentID;
    }

    public float getAssignments(){
        return this.Assignments;
    }

    public float getMidterm(){
        return this.Midterm;
    }

    public float getFinalExam() {
        return this.FinalExam;
    }

    public float getFinalMark(){
        return this.FinalMark;
    }

    public char getLetterGrade(){
        return this.LetterGrade;
    }
}