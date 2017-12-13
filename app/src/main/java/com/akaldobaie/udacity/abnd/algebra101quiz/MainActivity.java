package com.akaldobaie.udacity.abnd.algebra101quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Author: Abdullah Aldobaie
 * Date: Dec 13, 2017
 * <p>
 * Udacity Android Basic Nano-Degree Project: Quiz App
 */
public class MainActivity extends AppCompatActivity {
	
	// Question 1
	RadioGroup question1;
	
	// Question 2
	EditText questionTwoAnswer;
	
	// Question 3
	CheckBox questionThreeBoxOne;
	CheckBox questionThreeBoxTwo;
	CheckBox questionThreeBoxThree;
	CheckBox questionThreeBoxFour;
	
	// Question 4
	RadioGroup question4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		question1 = findViewById(R.id.radio_question_1);
		
		questionTwoAnswer = findViewById(R.id.edit_text_question_2_answer);
		
		questionThreeBoxOne = findViewById(R.id.check_box_question_3_box_1);
		questionThreeBoxTwo = findViewById(R.id.check_box_question_3_box_2);
		questionThreeBoxThree = findViewById(R.id.check_box_question_3_box_3);
		questionThreeBoxFour = findViewById(R.id.check_box_question_3_box_4);
		
		question4 = findViewById(R.id.radio_question_4);
	}
	
	/**
	 * onClick function:
	 * Checks the answers of all questions and shows the number of correct ones
	 *
	 * @param v:
	 * 	 required onClick parameter
	 */
	public void submitQuiz(View v) {
		
		// Keep track of correct answers score
		int score = 0;
		
		// Check question 1's answer
		if (question1.getCheckedRadioButtonId() == R.id.radio_question_1_correct) {
			score += 1;
		}
		
		// Check question 2's answer
		if (questionTwoAnswer.getText().toString().equals("45")) {
			score += 1;
		}
		
		// Check question 3's answer
		if (!questionThreeBoxOne.isChecked() &&
			 questionThreeBoxTwo.isChecked() &&
			 questionThreeBoxThree.isChecked() &&
			 !questionThreeBoxFour.isChecked()
			 ) {
			score += 1;
		}
		
		// Check question 4's answer
		if (question4.getCheckedRadioButtonId() == R.id.radio_question_4_correct) {
			score += 1;
		}
		
		// Tell the user their score
		Toast.makeText(this, "Your score is " + score + " out of 4", Toast.LENGTH_LONG).show();
	}
	
	/**
	 * onClick function:
	 * shows the correct answers to all questions in the quiz
	 *
	 * @param v:
	 * 	 required onClick parameter
	 */
	public void showQuizAnswers(View v) {
		
		// Reset all answers before settign correct answers
		resetQuiz(v);
		
		// Set question 1 correct radioButton answer
		question1.check(R.id.radio_question_1_correct);
		
		// Set question 2 correct editText answer
		questionTwoAnswer.setText(R.string.editText_question_2_answer);
		
		// Set question 3 correct checkBoxes answer
		questionThreeBoxTwo.setChecked(true);
		questionThreeBoxThree.setChecked(true);
		
		// Set question 4 correct radioButton answer
		question4.check(R.id.radio_question_4_correct);
	}
	
	/**
	 * onClick function:
	 * resets the quiz and removes all current answers
	 *
	 * @param v:
	 * 	 required onClick parameter
	 */
	public void resetQuiz(View v) {
		
		// Reset question 1 radioButtons
		if (question1 == null) {
			question1 = findViewById(R.id.radio_question_1);
			question1.clearCheck();
		} else {
			question1.clearCheck();
		}
		
		// Reset question 2 editText
		questionTwoAnswer.setText("");
		questionTwoAnswer.clearFocus();
		
		// Reset question 3 checkBoxes
		questionThreeBoxOne.setChecked(false);
		questionThreeBoxTwo.setChecked(false);
		questionThreeBoxThree.setChecked(false);
		questionThreeBoxFour.setChecked(false);
		
		// Reset question 4 radioButtons
		question4.clearCheck();
	}
}