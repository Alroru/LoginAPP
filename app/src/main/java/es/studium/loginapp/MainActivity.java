package es.studium.loginapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText nombre,contraseña;
    Button boton;
    Switch recordar;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Nombre = "nombre";
    public static final String Contraseña = "contraseña";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.editTextNombre);
        contraseña=findViewById(R.id.editTextContrasena);

        boton=findViewById(R.id.button);

        recordar=findViewById(R.id.switch1);

       sharedpreferences=getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);

        // ¿Hay ya información en las Shared Preferences?
        String isShared = sharedpreferences.getString(Nombre,"");
        if(isShared!=null)
        {

            //Obtener las credenciales y colocarlas en sus respectivos lugares
            nombre.setText(sharedpreferences.getString(Nombre, ""));
            contraseña.setText(sharedpreferences.getString(Contraseña, ""));
            

        }

        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (nombre.getText().toString().equals("")||contraseña.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Faltan Datos", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (recordar.isChecked())
                    {

                        String n = nombre.getText().toString();
                        String c = contraseña.getText().toString();


                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString(Nombre, n);
                        editor.putString(Contraseña, c);

                        editor.commit();
                        Toast.makeText(MainActivity.this, "Datos salvados", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(MainActivity.this, Bienvenida.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Intent intent = new Intent(MainActivity.this, Bienvenida.class);
                        startActivity(intent);
                    }
                }
            }
        });


    }
}