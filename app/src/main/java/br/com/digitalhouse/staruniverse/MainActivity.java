package br.com.digitalhouse.staruniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton buttonFace;
    private ImageButton buttonGmail;
    private Button buttonCadastrese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login_layout);

      buttonFace = findViewById(R.id.btnFace);
      buttonGmail = findViewById(R.id.btnGmail);
        buttonCadastrese = findViewById(R.id.btnCadastrese);


        buttonFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FacebookActivity.class));
                
            }
        });

        buttonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GmailActivity.class));



            }
        });
        buttonCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,Cadastro.class));

            }
        });





    }


}
