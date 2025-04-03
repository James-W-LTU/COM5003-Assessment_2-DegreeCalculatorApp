package com.example.degreetrackerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FoundationCalc extends AppCompatActivity {

    private EditText foundCreditInputOne, foundGradeInputOne, foundModuleInputOne,
            foundCreditInputTwo, foundGradeInputTwo, foundModuleInputTwo,
            foundCreditInputThree, foundGradeInputThree, foundModuleInputThree,
            foundCreditInputFour, foundGradeInputFour, foundModuleInputFour,
            foundCreditInputFive, foundGradeInputFive, foundModuleInputFive,
            foundCreditInputSix, foundGradeInputSix, foundModuleInputSix,
            foundCreditInputSeven, foundGradeInputSeven, foundModuleInputSeven,
            foundCreditInputEight, foundGradeInputEight, foundModuleInputEight,
            foundCreditInputNine, foundGradeInputNine, foundModuleInputNine;
    private Button foundCalculateButton;
    private TextView foundGradeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foundation_calc);

        foundCalculateButton = findViewById(R.id.foundCalculateButton);
        foundGradeOutput = findViewById(R.id.foundGradeOutput);

        foundCreditInputOne = findViewById(R.id.foundCreditInputOne);
        foundGradeInputOne = findViewById(R.id.foundGradeInputOne);
        foundModuleInputOne = findViewById(R.id.foundModuleInputOne);

        foundCreditInputTwo = findViewById(R.id.foundCreditInputTwo);
        foundGradeInputTwo = findViewById(R.id.postgradGradeInputTwo);
        foundModuleInputTwo = findViewById(R.id.foundModuleInputTwo);

        foundCreditInputThree = findViewById(R.id.foundCreditInputThree);
        foundGradeInputThree = findViewById(R.id.foundGradeInputThree);
        foundModuleInputThree = findViewById(R.id.foundModuleInputThree);

        foundCreditInputFour = findViewById(R.id.foundCreditInputFour);
        foundGradeInputFour = findViewById(R.id.foundGradeInputFour);
        foundModuleInputFour = findViewById(R.id.foundModuleInputFour);

        foundCreditInputFive = findViewById(R.id.foundCreditInputFive);
        foundGradeInputFive = findViewById(R.id.foundGradeInputFive);
        foundModuleInputFive = findViewById(R.id.foundModuleInputFive);

        foundCreditInputSix = findViewById(R.id.foundCreditInputSix);
        foundGradeInputSix = findViewById(R.id.foundGradeInputSix);
        foundModuleInputSix = findViewById(R.id.foundModuleInputSix);

        foundCreditInputSeven = findViewById(R.id.foundCreditInputSeven);
        foundGradeInputSeven = findViewById(R.id.foundGradeInputSeven);
        foundModuleInputSeven = findViewById(R.id.foundModuleInputSeven);

        foundCreditInputEight = findViewById(R.id.foundCreditInputEight);
        foundGradeInputEight = findViewById(R.id.foundGradeInputEight);
        foundModuleInputEight = findViewById(R.id.foundModuleInputEight);

        foundCreditInputNine = findViewById(R.id.foundCreditInputNine);
        foundGradeInputNine = findViewById(R.id.foundGradeInputNine);
        foundModuleInputNine = findViewById(R.id.foundModuleInputNine);

        foundCalculateButton.setOnClickListener(v -> calculateGrade());
    }

    private void calculateGrade() {
        try {
            double totalCredits = 0;
            double weightedGradeSum = 0;

            weightedGradeSum += getWeightedGrade(foundCreditInputOne, foundGradeInputOne);
            weightedGradeSum += getWeightedGrade(foundCreditInputTwo, foundGradeInputTwo);
            weightedGradeSum += getWeightedGrade(foundCreditInputThree, foundGradeInputThree);
            weightedGradeSum += getWeightedGrade(foundCreditInputFour, foundGradeInputFour);
            weightedGradeSum += getWeightedGrade(foundCreditInputFive, foundGradeInputFive);
            weightedGradeSum += getWeightedGrade(foundCreditInputSix, foundGradeInputSix);
            weightedGradeSum += getWeightedGrade(foundCreditInputSeven, foundGradeInputSeven);
            weightedGradeSum += getWeightedGrade(foundCreditInputEight, foundGradeInputEight);
            weightedGradeSum += getWeightedGrade(foundCreditInputNine, foundGradeInputNine);

            totalCredits = sumCredits();

            if (totalCredits == 0) {
                foundGradeOutput.setText("No credits entered.");
                return;
            }

            double finalGrade = weightedGradeSum / totalCredits;
            foundGradeOutput.setText(String.format("Your Grade: %.2f", finalGrade));
        } catch (NumberFormatException e) {
            foundGradeOutput.setText("Invalid input. Please enter numbers only.");
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
        return getCredits(foundCreditInputOne) + getCredits(foundCreditInputTwo) + getCredits(foundCreditInputThree) +
                getCredits(foundCreditInputFour) + getCredits(foundCreditInputFive) + getCredits(foundCreditInputSix) +
                getCredits(foundCreditInputSeven) + getCredits(foundCreditInputEight) + getCredits(foundCreditInputNine);
    }

    private double getCredits(EditText creditInput) {
        String creditStr = creditInput.getText().toString();
        if (creditStr.isEmpty()) return 0;
        return Double.parseDouble(creditStr);
    }
}