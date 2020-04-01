package com.annusza.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {

    private TextView counter, points, counterTextField, pointsTextField, contents;
    private Question[] questions = new Question[9];
    private Button a, b, c, d;
    private int nrOfQuestion = 0;
    private int result = 0;
    private String correctAnswer = "";

    public QuizFragment() {

    }

    public static QuizFragment newInstance(String arg1, String arg2) {

        QuizFragment quizFragment = new QuizFragment();
        Bundle args = new Bundle();
        quizFragment.setArguments(args);
        return quizFragment;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        a = view.findViewById(R.id.a);
        a.setOnClickListener(listenersButton);
        b = view.findViewById(R.id.b);
        b.setOnClickListener(listenersButton);
        c = view.findViewById(R.id.c);
        c.setOnClickListener(listenersButton);
        d = view.findViewById(R.id.d);
        d.setOnClickListener(listenersButton);
        contents = view.findViewById(R.id.content);
        points = view.findViewById(R.id.points);
        counter = view.findViewById(R.id.counter);
        pointsTextField = view.findViewById(R.id.pointsTextField);
        counterTextField = view.findViewById(R.id.counterTextField);

        startQuiz();
        readQuestion();
    }

    private void startQuiz() {

        questions = new Question[]{
                new Question(
                        getResources().getString(R.string.q1),
                        new String[]{
                                getResources().getString(R.string.q1A),
                                getResources().getString(R.string.q1B),
                                getResources().getString(R.string.q1C),
                                getResources().getString(R.string.q1D)
                        },
                        getResources().getString(R.string.q1C)),

                new Question(
                        getResources().getString(R.string.q2),
                        new String[]{
                                getResources().getString(R.string.q2A),
                                getResources().getString(R.string.q2B),
                                getResources().getString(R.string.q2C),
                                getResources().getString(R.string.q2D)
                        },
                        getResources().getString(R.string.q2D)),

                new Question(
                        getResources().getString(R.string.q3),
                        new String[]{
                                getResources().getString(R.string.q3A),
                                getResources().getString(R.string.q3B),
                                getResources().getString(R.string.q3C),
                                getResources().getString(R.string.q3D)
                        },
                        getResources().getString(R.string.q3A)),

                new Question(
                        getResources().getString(R.string.q4),
                        new String[]{
                                getResources().getString(R.string.q4A),
                                getResources().getString(R.string.q4B),
                                getResources().getString(R.string.q4C),
                                getResources().getString(R.string.q4D)
                        },
                        getResources().getString(R.string.q4C)),

                new Question(
                        getResources().getString(R.string.q5),
                        new String[]{
                                getResources().getString(R.string.q5A),
                                getResources().getString(R.string.q5B),
                                getResources().getString(R.string.q5C),
                                getResources().getString(R.string.q5D)
                        },
                        getResources().getString(R.string.q5B)),

                new Question(
                        getResources().getString(R.string.q6),
                        new String[]{
                                getResources().getString(R.string.q6A),
                                getResources().getString(R.string.q6B),
                                getResources().getString(R.string.q6C),
                                getResources().getString(R.string.q6D)
                        },
                        getResources().getString(R.string.q6C)),

                new Question(
                        getResources().getString(R.string.q7),
                        new String[]{
                                getResources().getString(R.string.q7A),
                                getResources().getString(R.string.q7B),
                                getResources().getString(R.string.q7C),
                                getResources().getString(R.string.q7D)
                        },
                        getResources().getString(R.string.q7A)),

                new Question(
                        getResources().getString(R.string.q8),
                        new String[]{
                                getResources().getString(R.string.q8A),
                                getResources().getString(R.string.q8B),
                                getResources().getString(R.string.q8C),
                                getResources().getString(R.string.q8D)
                        },
                        getResources().getString(R.string.q8B)),

                new Question(
                        getResources().getString(R.string.q9),
                        new String[]{
                                getResources().getString(R.string.q9A),
                                getResources().getString(R.string.q9B),
                                getResources().getString(R.string.q9C),
                                getResources().getString(R.string.q9D)
                        },
                        getResources().getString(R.string.q9D))
        };
    }

    private View.OnClickListener listenersButton = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            Button button = ((Button)view);
            String answer = button.getText().toString();

            if(nrOfQuestion <= 9) {
                if(answer.equals(correctAnswer)) {
                    result += 1;
                    points.setText(Integer.toString(result));
                }
                readQuestion();
            } else {
                if(button.getId() == R.id.a) {
                    result = 0;
                    nrOfQuestion = 0;
                    b.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);
                    d.setVisibility(View.VISIBLE);
                    counterTextField.setVisibility(View.VISIBLE);
                    pointsTextField.setVisibility(View.VISIBLE);
                    counter.setVisibility(View.VISIBLE);
                    points.setVisibility(View.VISIBLE);
                    readQuestion();
                }
            }
        }
    };

    private void readQuestion() {

        if(nrOfQuestion < 9) {
            Question shownQuestion = questions[nrOfQuestion];
            contents.setText(shownQuestion.question);
            a.setText(shownQuestion.answers[0]);
            b.setText(shownQuestion.answers[1]);
            c.setText(shownQuestion.answers[2]);
            d.setText(shownQuestion.answers[3]);
            correctAnswer = shownQuestion.okAnswer;
            nrOfQuestion = nrOfQuestion + 1;
            counter.setText(Integer.toString(nrOfQuestion) + " z 9");
        } else {
            nrOfQuestion = 10;
            contents.setText("Your score: " + Integer.toString(result));
            a.setText(R.string.end);
            b.setVisibility(View.INVISIBLE);
            c.setVisibility(View.INVISIBLE);
            d.setVisibility(View.INVISIBLE);
            points.setVisibility(View.INVISIBLE);
            points.setText(R.string.zero);
            pointsTextField.setVisibility(View.INVISIBLE);
            counter.setVisibility(View.INVISIBLE);
            counterTextField.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }
}
