package com.example.degreetrackerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PostgradCalc extends AppCompatActivity {

    private EditText postgradCreditInputOne, postgradGradeInputOne, postgradModuleInputOne,
            postgradCreditInputTwo, postgradGradeInputTwo, postgradModuleInputTwo,
            postgradCreditInputThree, postgradGradeInputThree, postgradModuleInputThree,
            postgradCreditInputFour, postgradGradeInputFour, postgradModuleInputFour,
            postgradCreditInputFive, postgradGradeInputFive, postgradModuleInputFive,
            postgradCreditInputSix, postgradGradeInputSix, postgradModuleInputSix,
            postgradCreditInputSeven, postgradGradeInputSeven, postgradModuleInputSeven,
            postgradCreditInputEight, postgradGradeInputEight, postgradModuleInputEight,
            postgradCreditInputNine, postgradGradeInputNine, postgradModuleInputNine;
    private Button postgradCalculateButton;
    private TextView postgradGradeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_postgrad_calc);

        postgradCalculateButton = findViewById(R.id.postgradCalculateButton);
        postgradGradeOutput = findViewById(R.id.postgradGradeOutput);

        postgradCreditInputOne = findViewById(R.id.postgradCreditInputOne);
        postgradGradeInputOne = findViewById(R.id.postgradGradeInputOne);
        postgradModuleInputOne = findViewById(R.id.postgradModuleInputOne);

        postgradCreditInputTwo = findViewById(R.id.postgradCreditInputTwo);
        postgradGradeInputTwo = findViewById(R.id.postgradGradeInputTwo);
        postgradModuleInputTwo = findViewById(R.id.postgradModuleInputTwo);

        postgradCreditInputThree = findViewById(R.id.postgradCreditInputThree);
        postgradGradeInputThree = findViewById(R.id.postgradGradeInputThree);
        postgradModuleInputThree = findViewById(R.id.postgradModuleInputThree);

        postgradCreditInputFour = findViewById(R.id.postgradCreditInputFour);
        postgradGradeInputFour = findViewById(R.id.postgradGradeInputFour);
        postgradModuleInputFour = findViewById(R.id.postgradModuleInputFour);

        postgradCreditInputFive = findViewById(R.id.postgradCreditInputFive);
        postgradGradeInputFive = findViewById(R.id.postgradGradeInputFive);
        postgradModuleInputFive = findViewById(R.id.postgradModuleInputFive);

        postgradCreditInputSix = findViewById(R.id.postgradCreditInputSix);
        postgradGradeInputSix = findViewById(R.id.postgradGradeInputSix);
        postgradModuleInputSix = findViewById(R.id.postgradModuleInputSix);

        postgradCreditInputSeven = findViewById(R.id.postgradCreditInputSeven);
        postgradGradeInputSeven = findViewById(R.id.postgradGradeInputSeven);
        postgradModuleInputSeven = findViewById(R.id.postgradModuleInputSeven);

        postgradCreditInputEight = findViewById(R.id.postgradCreditInputEight);
        postgradGradeInputEight = findViewById(R.id.postgradGradeInputEight);
        postgradModuleInputEight = findViewById(R.id.postgradModuleInputEight);

        postgradCreditInputNine = findViewById(R.id.postgradCreditInputNine);
        postgradGradeInputNine = findViewById(R.id.postgradGradeInputNine);
        postgradModuleInputNine = findViewById(R.id.postgradModuleInputNine);

        postgradCalculateButton.setOnClickListener(v -> calculateGrade());
    }

    private void calculateGrade() {
        try {
            double totalCredits = 0;
            double weightedGradeSum = 0;

            weightedGradeSum += getWeightedGrade(postgradCreditInputOne, postgradGradeInputOne);
            weightedGradeSum += getWeightedGrade(postgradCreditInputTwo, postgradGradeInputTwo);
            weightedGradeSum += getWeightedGrade(postgradCreditInputThree, postgradGradeInputThree);
            weightedGradeSum += getWeightedGrade(postgradCreditInputFour, postgradGradeInputFour);
            weightedGradeSum += getWeightedGrade(postgradCreditInputFive, postgradGradeInputFive);
            weightedGradeSum += getWeightedGrade(postgradCreditInputSix, postgradGradeInputSix);
            weightedGradeSum += getWeightedGrade(postgradCreditInputSeven, postgradGradeInputSeven);
            weightedGradeSum += getWeightedGrade(postgradCreditInputEight, postgradGradeInputEight);
            weightedGradeSum += getWeightedGrade(postgradCreditInputNine, postgradGradeInputNine);

            totalCredits = sumCredits();

            if (totalCredits == 0) {
                postgradGradeOutput.setText("No credits entered.");
                return;
            }

            double finalGrade = weightedGradeSum / totalCredits;
            postgradGradeOutput.setText(String.format("Your Grade: %.2f", finalGrade));
        } catch (NumberFormatException e) {
            postgradGradeOutput.setText("Invalid input. Please enter numbers only.");
        }
    }

    private double getWeightedGrade(EditText creditInput, EditText gradeInput) {
        String creditStr = creditInput.getText().toString();
        String gradeStr = gradeInput.getText().toString();
        if (creditStr.isEmpty() || gradeStr.isEmpty()) return 0;

        double credits = Double.parseDouble(creditStr);
        double grade = Double.parseDouble(gradeStr);
        return credits * grade;
    }

    private double sumCredits() {
        return getCredits(postgradCreditInputOne) + getCredits(postgradCreditInputTwo) + getCredits(postgradCreditInputThree) +
                getCredits(postgradCreditInputFour) + getCredits(postgradCreditInputFive) + getCredits(postgradCreditInputSix) +
                getCredits(postgradCreditInputSeven) + getCredits(postgradCreditInputEight) + getCredits(postgradCreditInputNine);
    }

    private double getCredits(EditText creditInput) {
        String creditStr = creditInput.getText().toString();
        if (creditStr.isEmpty()) return 0;
        return Double.parseDouble(creditStr);
    }
}