package dev.gustavo.analiticatest.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import dev.gustavo.analiticatest.R;
import dev.gustavo.analiticatest.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCounter;
    private TextView textViewStatus;
    private CardView cardViewEvent;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewCounter = findViewById(R.id.textCounter);
        textViewStatus = findViewById(R.id.textStatus);
        cardViewEvent = findViewById(R.id.eventCard);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.counter.observe(this, it -> {
            textViewCounter.setText(it.toString());
            viewModel.getTelemetry();
            viewModel.checkStatus(it);
        });

        viewModel.status.observe(this, it -> {
            textViewStatus.setText(it);
            if(it.equals("Evento indeterminado"))
                cardViewEvent.setCardBackgroundColor(getResources().getColor(R.color.undeterminedEvent));
            else cardViewEvent.setCardBackgroundColor(getResources().getColor(R.color.inOperation));

        });
        viewModel.getTelemetry();
    }
}