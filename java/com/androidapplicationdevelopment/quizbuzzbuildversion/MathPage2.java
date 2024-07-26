package com.androidapplicationdevelopment.quizbuzzbuildversion;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathPage2 extends AppCompatActivity {

    TextView quiztext, aans, bans, cans, dans;
    List<QuestionsItem> questionsItems;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;
    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_page);

        quiztext = findViewById(R.id.QuizText);
        aans = findViewById(R.id.Aanswer);
        bans = findViewById(R.id.Banswer);
        cans = findViewById(R.id.Canswer);
        dans = findViewById(R.id.Danswer);

        loadAllQuestions();
        Collections.shuffle(questionsItems);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer1().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    correct++;
                    aans.setBackgroundResource(R.color.primary_blue);
                    aans.setTextColor(getResources().getColor(R.color.white));
                } else {
                    wrong++;
                    aans.setBackgroundResource(R.color.primary_blue);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            aans.setBackgroundResource(R.color.card_background);
                            aans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(MathPage2.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer2().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    wrong++;
                    bans.setBackgroundResource(R.color.primary_blue);
                    bans.setTextColor(getResources().getColor(R.color.white));
                } else {
                    correct++;
                    bans.setBackgroundResource(R.color.primary_blue);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            bans.setBackgroundResource(R.color.card_background);
                            bans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(MathPage2.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer3().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    wrong++;
                    cans.setBackgroundResource(R.color.primary_blue);
                    cans.setTextColor(getResources().getColor(R.color.white));
                } else {
                    correct++;
                    cans.setBackgroundResource(R.color.primary_blue);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            cans.setBackgroundResource(R.color.card_background);
                            cans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(MathPage2.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer4().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    wrong++;
                    dans.setBackgroundResource(R.color.primary_blue);
                    dans.setTextColor(getResources().getColor(R.color.white));
                } else {
                    correct++;
                    dans.setBackgroundResource(R.color.primary_blue);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            dans.setBackgroundResource(R.color.card_background);
                            dans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(MathPage2.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    private void setQuestionScreen(int currentQuestions) {
        quiztext.setText(questionsItems.get(currentQuestions).getQuestions());
        aans.setText(questionsItems.get(currentQuestions).getAnswer1());
        bans.setText(questionsItems.get(currentQuestions).getAnswer2());
        cans.setText(questionsItems.get(currentQuestions).getAnswer3());
        dans.setText(questionsItems.get(currentQuestions).getAnswer4());
    }

    private void loadAllQuestions() {
        questionsItems = new ArrayList<>();
        String jsonquiz = loadJsonFromAsset("math2.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("mathquiz2");
            for (int i = 0; i < questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String answer4String = question.getString("answer4");
                String correctString = question.getString("correct");

                questionsItems.add(new QuestionsItem(questionsString, answer1String, answer2String, answer3String, answer4String, correctString));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s) {
        String json = "";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MathPage2.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are you sure want to exit the quiz?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(MathPage2.this, MainActivity.class));
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }

}
