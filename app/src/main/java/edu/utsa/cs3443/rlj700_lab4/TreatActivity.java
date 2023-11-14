package edu.utsa.cs3443.rlj700_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import java.util.Random;
public class TreatActivity extends AppCompatActivity {

    private int[] treatImages = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);

        displayRandomTreatImage();
    }

    private void displayRandomTreatImage() {
        ImageView treatImageView = findViewById(R.id.treatImageView);

        // Generate a random index to select a treat image
        Random random = new Random();
        int randomIndex = random.nextInt(treatImages.length);

        // Set the randomly chosen treat image in the ImageView
        treatImageView.setImageResource(treatImages[randomIndex]);
    }
}