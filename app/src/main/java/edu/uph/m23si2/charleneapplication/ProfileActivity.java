package edu.uph.m23si2.charleneapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText edtName, edtProdi, edtEmail, edtNilai1, edtNilai2;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSubmit = findViewById(R.id.btnSubmit);
        edtName = findViewById(R.id.edtName);
        edtProdi = findViewById(R.id.edtProdi);
        edtEmail = findViewById(R.id.edtEmail);
        edtNilai1 = findViewById(R.id.edtNilai1);
        edtNilai2 = findViewById(R.id.edtNilai2);
        txtResult = findViewById(R.id.txtResult);

        edtName.setText(getIntent().getStringExtra("nama"));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String prodi = edtProdi.getText().toString();
                String email = edtEmail.getText().toString();

                double nilai1 = Double.parseDouble(edtNilai1.getText().toString());
                double nilai2 = Double.parseDouble(edtNilai2.getText().toString());

                double ipk1 = konversiKeIPK(nilai1);
                double ipk2 = konversiKeIPK(nilai2);
                double ipkFinal = (ipk1 + ipk2) / 2;

                String fakultas;
                if (prodi.equalsIgnoreCase("hukum") || prodi.equalsIgnoreCase("law")) {
                    fakultas = "Fakultas Hukum";
                } else if (prodi.equalsIgnoreCase("sistem informasi") || prodi.equalsIgnoreCase("informatika")) {
                    fakultas = "Fakultas Teknologi Informasi";
                } else if (prodi.equalsIgnoreCase("Hospitality") || prodi.equalsIgnoreCase("Akuntansi") || prodi.equalsIgnoreCase("Manajemen")) {
                    fakultas = "Fakultas Bisnis Manajemen";
                } else {
                    fakultas = "Fakultas tidak diketahui";
                }

                txtResult.setText(
                        name + "\n" +
                                email + "\n" +
                                prodi + "\n" +
                                fakultas + "\n\n" +
                                "Nilai 1: " + nilai1 + "\n" +
                                "Nilai 2: " + nilai2 + "\n" +
                                "IPK Akhir: " + String.format("%.2f", ipkFinal)
                );
            }
        });
    }

    private double konversiKeIPK(double nilai) {
        if (nilai >= 85) return 4.00;
        else if (nilai >= 80) return 3.75;
        else if (nilai >= 75) return 3.50;
        else if (nilai >= 70) return 3.00;
        else if (nilai >= 65) return 2.75;
        else if (nilai >= 60) return 2.50;
        else if (nilai >= 55) return 2.00;
        else if (nilai >= 40) return 1.00;
        else return 0.00;
    }
}


