package com.example.firstgit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.firstgit.QuizContract.*;

import androidx.annotation.Nullable;

public class QuizDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT," +
                QuestionTable.COLUMN_OPTION1 + " TEXT," +
                QuestionTable.COLUMN_OPTION2 + " TEXT," +
                QuestionTable.COLUMN_OPTION3 + " TEXT," +
                QuestionTable.COLUMN_OPTION4 + " TEXT," +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                " )"
                ;
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionTable(){
        Question q1 = new Question("A is Correct","A","B","C","D",1);
        addQuestion(q1);
        Question q2 = new Question("A is Correct","A","B","C","D",1);
        addQuestion(q2);
        Question q3 = new Question("A is Correct","A","B","C","D",1);
        addQuestion(q3);
        Question q4 = new Question("A is Correct","A","B","C","D",1);
        addQuestion(q4);
        Question q5 = new Question("A is Correct","A","B","C","D",1);
        addQuestion(q5);
    }
    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOptions1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOptions2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOptions3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOptions4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME,null,cv);
    }
}
