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
    EditText edtName, edtProdi, edtEmail;
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
        btnSubmit = findViewById(R.id.btnSubmit); //  menghubungkan kode program java dengan xml
        edtName = findViewById(R.id.edtName);
        edtProdi = findViewById(R.id.editProdi);
        edtEmail = findViewById(R.id.edtEmail);
        txtResult = findViewById(R.id.txtResult);
        // yg dibawah ini method overriding
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // menampilkan hasil di txtresult
                String name = edtName.getText().toString();
                String prodi = edtProdi.getText().toString();
                String email = edtEmail.getText().toString();

                String fakultas = "";

                if (prodi.equalsIgnoreCase("hukum")) {
                    fakultas = "Fakultas Hukum";
                } else if (prodi.equalsIgnoreCase("sistem informasi")) {
                    fakultas = "Fakultas Teknologi Informasi";
                } else if (prodi.equalsIgnoreCase("informatika")) {
                    fakultas = "Fakultas Teknologi Informasi";
                } else if (prodi.equalsIgnoreCase("Hospitality")) {
                    fakultas = "Fakultas Bisnis Manajemen";
                } else if (prodi.equalsIgnoreCase("Akuntansi")) {
                    fakultas = "Fakultas Bisnis Manajemen";
                } else if (prodi.equalsIgnoreCase("Manajemen")) {
                    fakultas = "Fakultas Bisnis Manajemen";
                } else {
                    fakultas = "Fakultas tidak diketahui";
                }

                txtResult.setText(name + "\n" + email + "\n" + prodi + "\n" + fakultas);
            }
        });
    }
}