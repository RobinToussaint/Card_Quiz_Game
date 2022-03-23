package com.example.card_quiz_game;

// This file contains the questions//

public class Questions {
// the question objects
    List <Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;
    public int getLength(){
        return list.size();
    }
//returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }
//multiple choice item for question based on list index,
// based on number of multiple choice item in the list - 1, 2, 3, 4 or 5
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }

    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("1. What is the rarest M&M color?",
                    new String[]{"Red", "Blue", "Brown", "Yellow"}, "Brown"));
            myDataBaseHelper.addInitialQuestion(new Question("2. In what year were the first Air Jordan sneakers released?",
                    new String[]{"2001", "1984", "1820", "1928"}, "1984"));
            myDataBaseHelper.addInitialQuestion(new Question("3. In which European city would you find Orly airport?",
                    new String[]{"Paris", "Rome", "Berlin", "Lisbon"}, "Paris"));
            myDataBaseHelper.addInitialQuestion(new Question("4. How many of Snow White’s seven dwarfs have names ending in the letter Y?",
                    new String[]{"7", "1", "0", "5"}, "5"));
            myDataBaseHelper.addInitialQuestion(new Question("5. What was the first state?",
                    new String[]{"New Jersey", "Mississippi", "Delaware", "Pennsylvania"}, "Brown"));
            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }








    }





}
