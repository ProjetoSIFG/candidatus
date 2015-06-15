package com.andreldm.candidatus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.andreldm.candidatus.pojo.Candidato;

public class ListaCandidatosActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_candidatos);

        final ListView listview = (ListView) findViewById(R.id.lista_candidatos);
        Candidato[] values = new Candidato[] { new Candidato("João Plenário", "Muito honesto"),
                new Candidato("Tiririca", "Sou eu abestado"), new Candidato("Romário", "E aí peixe?")};

        final CandidatoAdapter adapter = new CandidatoAdapter(this, values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Candidato c = (Candidato) parent.getItemAtPosition(position);
                Toast.makeText(ListaCandidatosActivity.this, "Candidato: " + c.getNome(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
