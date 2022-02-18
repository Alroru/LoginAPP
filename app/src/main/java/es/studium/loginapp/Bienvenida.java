package es.studium.loginapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {
    Button borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        borrar=findViewById(R.id.button2);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(Bienvenida.this, "Usuario Borrado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Bienvenida.this,MainActivity.class);
                startActivity(intent);
                deleteSharedPreferences("MyPrefs");
            }
        });
    }
}