package com.lizp.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.lizp.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.lizp.geoquiz.answer_shown";
    private static final String IS_ANSWER_SHOWN =
            "isAnswerShown";

    public static boolean wasAnswerShown(Intent intent) {
        return intent.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private boolean mIsAnswerShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        if (savedInstanceState != null) {
            mIsAnswerShown = savedInstanceState.getBoolean(IS_ANSWER_SHOWN, false);
            setAnswerShownResult(mIsAnswerShown);
            if (mAnswerIsTrue) {
                mAnswerTextView.setText(R.string.true_button);
            } else {
                mAnswerTextView.setText(R.string.false_button);
            }
        }
        else {
            mIsAnswerShown = false;
        }

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                mIsAnswerShown = true;
                setAnswerShownResult(mIsAnswerShown);
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswershown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswershown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_ANSWER_SHOWN, mIsAnswerShown);
    }
}
