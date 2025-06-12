package edu.uph.m23si2.charleneapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TodoListActivity extends AppCompatActivity {

    Button btnSimpan;
    EditText edtnamaKegiatan;
    RadioButton rdnLuar, rdnDalam;
    CheckBox chkOlahraga, chkMakan, chkBelajar, chkJalan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_todo_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // inisialisasi variabel
        edtnamaKegiatan = findViewById(R.id.edtNamaKegiatan);
        rdnLuar = findViewById(R.id.rdnLuar);
        rdnDalam = findViewById(R.id.rdnDalam);
        chkOlahraga = findViewById(R.id.chkOlahraga);
        chkMakan = findViewById(R.id.chkMakan);
        chkBelajar = findViewById(R.id.chkBelajar);
        chkJalan = findViewById(R.id.chkJalan);
        btnSimpan = findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidasiForm()){
                    String namaKegiatan = "";
                    String tempatKegiatan = "";
                    String jenisKegiatan = "";
                    namaKegiatan = edtnamaKegiatan.getText().toString();
                    if(rdnDalam.isChecked()) tempatKegiatan = rdnDalam.getText().toString();
                    else if (rdnLuar.isChecked()) tempatKegiatan = rdnLuar.getText().toString();

                    if(chkOlahraga.isChecked()) jenisKegiatan += chkOlahraga.getText().toString() + "\n";
                    if(chkMakan.isChecked()) jenisKegiatan += chkMakan.getText().toString() + "\n";
                    if(chkBelajar.isChecked()) jenisKegiatan += chkBelajar.getText().toString() + "\n";
                    if(chkJalan.isChecked()) jenisKegiatan += chkJalan.getText().toString() + "\n";

                    String pesan = "Berhasil di simpan! \nNama Kegiatan: " +namaKegiatan + "\n Tempat Kegiatan: " +tempatKegiatan + "\n Jenis Kegiatan: " + jenisKegiatan;
                    Toast toast = Toast.makeText(getApplicationContext(),
                            pesan, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
                    toast.show();
                }

            }
        });
    }

    boolean ValidasiForm(){
        if(edtnamaKegiatan.getText().toString().equals("")) {
            edtnamaKegiatan.setError("Nama kegiatan wajib di isi");
            return false;
        }
        else return true;
    }
}