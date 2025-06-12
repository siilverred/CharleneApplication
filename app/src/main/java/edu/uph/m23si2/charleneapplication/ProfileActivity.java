package edu.uph.m23si2.charleneapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    Spinner sprProdi;

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
        init();

        edtName.setText(getIntent().getStringExtra("nama"));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                simpan();
            }
        });
    }
    public void init(){
        btnSubmit = findViewById(R.id.btnSubmit);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        txtResult = findViewById(R.id.txtResult);
        sprProdi = findViewById(R.id.sprProdi);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.prodi_array,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        sprProdi.setAdapter(adapter);
    }

    public boolean isValidated(){
        if(edtName.getText().toString().equals("")){
            edtName.setError("Nama wajib di isi");
            return false;
        }else if(edtEmail.getText().toString().equals("")){
            edtEmail.setError("Email wajib di isi");
            return false;
        } return true;
    }


    public void simpan(){
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        if(item.getItemId()==R.id.mSimpan) {
            Simpan();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}


