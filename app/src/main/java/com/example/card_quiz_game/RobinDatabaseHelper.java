package com.example.card_quiz_game;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class RobinDatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_QUESTION = "questionBank.db";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTION = "QuestionBank";

    private static final String KEY_ID = "id";
    private static final String QUESTION = "question";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";
    private static final String CHOICE5 = "choice5";
    private static final String ANSWER = "answer"

            // Question Table Create Query
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE "
            + TABLE_QUESTION + "(" + KEY_ID
            + "INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + " TEXT, " + CHOICE2 + " TEXT, " + CHOICE3 + " TEXT, "
            + CHOICE3 + " TEXT, " + CHOICE4+ " TEXT, " + CHOICE5 + " TEXT," + ANSWER + " TEXT);";

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL(CREATE_TABLE_QUESTION); // create question table
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_QUESTION);  // drop table if exists
        onCreate(db);

    }

    public long addInitialQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoice(0));
        values.put(CHOICE2, question.getChoice(1));
        values.put(CHOICE3, question.getChoice(2));
        values.put(CHOICE4, question.getChoice(3));
        values.put(CHOICE5, question.getChoice(4));
        values.put(ANSWER, question.getAnswer());
        long insert = db.insert(TABLE_QUESTION, null, values);
        return insert;
    }

    public List<Question> getAllQuestionsList() {
        List<Question> questionArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();

                String questText = c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);

                String choice1Text = c.getString(c.getColumnIndex(CHOICE1));
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(c.getColumnIndex(CHOICE2));
                question.setChoice(1, choice2Text);

                String choice3Text = c.getString(c.getColumnIndex(CHOICE3));
                question.setChoice(2, choice3Text);

                String choice4Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(3, choice4Text);

                String choice5Text = c.getString(c.getColumnIndex(CHOICE5));
                question.setChoice(4, choice3Text);

                String answerText = c.getString(c.getColumnIndex(ANSWER));
                question.setAnswer(answerText);

                questionArrayList.add(question);
            } while (c.moveToNext());
            Collections.shuffle(questionArrayList);
        }
        return questionArrayList;


            }
        }



    }


}
