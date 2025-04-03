package com.example.degreetrackerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class UndergradCalc extends AppCompatActivity {

    private EditText undergradCreditInputOneL5, undergradGradeInputOneL5, undergradModuleInputOneL5,
            undergradCreditInputTwoL5, undergradGradeInputTwoL5, undergradModuleInputTwoL5,
            undergradCreditInputThreeL5, undergradGradeInputThreeL5, undergradModuleInputThreeL5,
            undergradCreditInputFourL5, undergradGradeInputFourL5, undergradModuleInputFourL5,
            undergradCreditInputFiveL5, undergradGradeInputFiveL5, undergradModuleInputFiveL5,
            undergradCreditInputOneL6, undergradGradeInputOneL6, undergradModuleInputOneL6,
            undergradCreditInputTwoL6, undergradGradeInputTwoL6, undergradModuleInputTwoL6,
            undergradCreditInputThreeL6, undergradGradeInputThreeL6, undergradModuleInputThreeL6,
            undergradCreditInputFourL6, undergradGradeInputFourL6, undergradModuleInputFourL6,
            undergradCreditInputFiveL6, undergradGradeInputFiveL6, undergradModuleInputFiveL6;

    private Button undergradCalculateButton;
    private TextView undergradGradeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_undergrad_calc);

        undergradCalculateButton = findViewById(R.id.undergradCalculateButton);
        undergradGradeOutput = findViewById(R.id.undergradGradeOutput);

        undergradCreditInputOneL5 = findViewById(R.id.undergradCreditInputOneL5);
        undergradGradeInputOneL5 = findViewById(R.id.undergradGradeInputOneL5);
        undergradModuleInputOneL5 = findViewById(R.id.undergradModuleInputOneL5);

        undergradCreditInputTwoL5 = findViewById(R.id.undergradCreditInputTwoL5);
        undergradGradeInputTwoL5 = findViewById(R.id.undergradGradeInputTwoL5);
        undergradModuleInputTwoL5 = findViewById(R.id.undergradModuleInputTwoL5);

        undergradCreditInputThreeL5 = findViewById(R.id.undergradCreditInputThreeL5);
        undergradGradeInputThreeL5 = findViewById(R.id.undergradGradeInputThreeL5);
        undergradModuleInputThreeL5 = findViewById(R.id.undergradModuleInputThreeL5);

        undergradCreditInputFourL5 = findViewById(R.id.undergradCreditInputFourL5);
        undergradGradeInputFourL5 = findViewById(R.id.undergradGradeInputFourL5);
        undergradModuleInputFourL5 = findViewById(R.id.undergradModuleInputFourL5);

        undergradCreditInputFiveL5 = findViewById(R.id.undergradCreditInputFiveL5);
        undergradGradeInputFiveL5 = findViewById(R.id.undergradGradeInputFiveL5);
        undergradModuleInputFiveL5 = findViewById(R.id.undergradModuleInputFiveL5);

        undergradCreditInputOneL6 = findViewById(R.id.undergradCreditInputOneL6);
        undergradGradeInputOneL6 = findViewById(R.id.undergradGradeInputOneL6);
        undergradModuleInputOneL6 = findViewById(R.id.undergradModuleInputOneL6);

        undergradCreditInputTwoL6 = findViewById(R.id.undergradCreditInputTwoL6);
        undergradGradeInputTwoL6 = findViewById(R.id.undergradGradeInputTwoL6);
        undergradModuleInputTwoL6 = findViewById(R.id.undergradModuleInputTwoL6);

        undergradCreditInputThreeL6 = findViewById(R.id.undergradCreditInputThreeL6);
        undergradGradeInputThreeL6 = findViewById(R.id.undergradGradeInputThreeL6);
        undergradModuleInputThreeL6 = findViewById(R.id.undergradModuleInputThreeL6);

        undergradCreditInputFourL6 = findViewById(R.id.undergradCreditInputFourL6);
        undergradGradeInputFourL6 = findViewById(R.id.undergradGradeInputFourL6);
        undergradModuleInputFourL6 = findViewById(R.id.undergradModuleInputFourL6);

        undergradCreditInputFiveL6 = findViewById(R.id.undergradCreditInputFiveL6);
        undergradGradeInputFiveL6 = findViewById(R.id.undergradGradeInputFiveL6);
        undergradModuleInputFiveL6 = findViewById(R.id.undergradModuleInputFiveL6);

        undergradCalculateButton.setOnClickListener(v -> calculateGrade());
    }

    private void calculateGrade() {
        try {
            double totalCredits = 0;
            double weightedGradeSum = 0;

            weightedGradeSum += getWeightedGrade(undergradCreditInputOneL5, undergradGradeInputOneL5);
            weightedGradeSum += getWeightedGrade(undergradCreditInputTwoL5, undergradGradeInputTwoL5);
            weightedGradeSum += getWeightedGrade(undergradCreditInputThreeL5, undergradGradeInputThreeL5);
            weightedGradeSum += getWeightedGrade(undergradCreditInputFourL5, undergradGradeInputFourL5);
            weightedGradeSum += getWeightedGrade(undergradCreditInputFiveL5, undergradGradeInputFiveL5);
            weightedGradeSum += getWeightedGrade(undergradCreditInputOneL6, undergradGradeInputOneL6);
            weightedGradeSum += getWeightedGrade(undergradCreditInputTwoL6, undergradGradeInputTwoL6);
            weightedGradeSum += getWeightedGrade(undergradCreditInputThreeL6, undergradGradeInputThreeL6);
            weightedGradeSum += getWeightedGrade(undergradCreditInputFourL6, undergradGradeInputFourL6);
            weightedGradeSum += getWeightedGrade(undergradCreditInputFiveL6, undergradGradeInputFiveL6);

            totalCredits = sumCredits();

            if (totalCredits == 0) {
                undergradGradeOutput.setText("No credits entered.");
                return;
            }

            double finalGrade = weightedGradeSum / totalCredits;
            undergradGradeOutput.setText(String.format("Your Grade: %.2f", finalGrade));
        } catch (NumberFormatException e) {
            undergradGradeOutput.setText("Invalid input. Please enter numbers only.");
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
        return getCredits(undergradCreditInputOneL5) + getCredits(undergradCreditInputTwoL5) + getCredits(undergradCreditInputThreeL5) +
                getCredits(undergradCreditInputFourL5) + getCredits(undergradCreditInputFiveL5) + getCredits(undergradCreditInputOneL6) +
                getCredits(undergradCreditInputTwoL6) + getCredits(undergradCreditInputThreeL6) + getCredits(undergradCreditInputFourL6)+
                getCredits(undergradCreditInputFiveL6);
    }

    private double getCredits(EditText creditInput) {
        String creditStr = creditInput.getText().toString();
        if (creditStr.isEmpty()) return 0;
        return Double.parseDouble(creditStr);
    }
}