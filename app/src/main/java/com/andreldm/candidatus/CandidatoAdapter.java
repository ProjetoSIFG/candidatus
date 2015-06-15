package com.andreldm.candidatus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andreldm.candidatus.pojo.Candidato;

public class CandidatoAdapter extends ArrayAdapter<Candidato> {
  private final Context context;
  private final Candidato[] values;

  public CandidatoAdapter(Context context, Candidato[] values) {
    super(context, -1, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.item_candidato, parent, false);
    TextView textNome = (TextView) rowView.findViewById(R.id.nome);
    TextView textDescricao = (TextView) rowView.findViewById(R.id.descricao);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

    Candidato c = values[position];

    textNome.setText(c.getNome());
    textDescricao.setText(c.getDescricao());

    return rowView;
  }
} 

