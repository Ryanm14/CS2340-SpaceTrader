package neighbors.com.spacetrader.ui.damage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import neighbors.com.spacetrader.R;

/**
 * Activity to handle displaying taking damage after an encounter
 */
public class DamageActivity extends AppCompatActivity {

    /**
     * Begins damage activity
     * @param savedInstanceState data to load into new activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage);
    }

}
