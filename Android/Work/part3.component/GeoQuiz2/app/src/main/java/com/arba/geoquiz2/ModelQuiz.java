package com.arba.geoquiz2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018-01-17.
 */

public class ModelQuiz implements Parcelable{

    private String quiz   = "";
    private boolean answer = false;
    private boolean correct = false;
    private boolean cunning = false;

    protected ModelQuiz(Parcel in) {
        quiz = in.readString();
        answer = in.readByte() != 0;
        correct = in.readByte() != 0;
        cunning = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(quiz);
        dest.writeByte((byte) (answer ? 1 : 0));
        dest.writeByte((byte) (correct ? 1 : 0));
        dest.writeByte((byte) (cunning ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelQuiz> CREATOR = new Creator<ModelQuiz>() {
        @Override
        public ModelQuiz createFromParcel(Parcel in) {
            return new ModelQuiz(in);
        }

        @Override
        public ModelQuiz[] newArray(int size) {
            return new ModelQuiz[size];
        }
    };

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isCunning() {
        return cunning;
    }

    public void setCunning(boolean cunning) {
        this.cunning = cunning;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "ModelQuiz{" +
                "quiz='" + quiz + '\'' +
                ", answer='" + answer + '\'' +
                ", correct='" + correct + '\'' +
                ", cunning='" + cunning + '\'' +
                '}';
    }

    public ModelQuiz(String quiz, boolean answer, boolean correct, boolean cunning) {
        this.quiz = quiz;
        this.answer = answer;
        this.correct = correct;
        this.cunning = cunning;
    }

    public ModelQuiz() {
    }
}
