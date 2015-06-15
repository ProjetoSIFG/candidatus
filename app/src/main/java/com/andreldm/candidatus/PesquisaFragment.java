package com.andreldm.candidatus;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.apmem.tools.layouts.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class PesquisaFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View content = (View)inflater.inflate(R.layout.pesquisa_fragment, container, false);

        FlowLayout pesquisaResult = (FlowLayout) content.findViewById(R.id.pesquisa_result);

        List<BotaoPesquisa> listBotoes = new ArrayList<>();
        listBotoes.add(new BotaoPesquisa("Economia", 200, 0xDFF11D05));
        listBotoes.add(new BotaoPesquisa("Saúde", 150, 0xFF55AADD));
        listBotoes.add(new BotaoPesquisa("Educação", 320, 0xFFD3F3C8));
        listBotoes.add(new BotaoPesquisa("Cultura", 80, 0xFF11CCEE));
        listBotoes.add(new BotaoPesquisa("Esportes", 200, 0xFF113333));
        listBotoes.add(new BotaoPesquisa("Emprego", 250, 0xFFBB4422));
        listBotoes.add(new BotaoPesquisa("LGBT", 40, 0xFF113300));
        listBotoes.add(new BotaoPesquisa("Direto da Mulher", 100, 0xFFDD44DD));
        listBotoes.add(new BotaoPesquisa("Segurança", 250, 0xFF00FFFF));
        listBotoes.add(new BotaoPesquisa("Meio Ambiente", 200, 0xFF5CA1E5));
        listBotoes.add(new BotaoPesquisa("Previdência", 150, 0xFFD11D05));
        listBotoes.add(new BotaoPesquisa("Direitos Humanos", 80, 0xFFB3F023));
        listBotoes.add(new BotaoPesquisa("Justiça", 150, 0xFFDEDEDE));
        listBotoes.add(new BotaoPesquisa("Habitação", 80, 0xFF661177));
        listBotoes.add(new BotaoPesquisa("Reforma Política", 200, 0xFF7A2D15));

        int height = convertDpToPixel(80, getActivity());
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ListaCandidatosActivity.class));
            }
        };

        for(BotaoPesquisa botao : listBotoes) {
            Button button = new Button(getActivity());
            button.setText(botao.getTitulo());
            button.setWidth(convertDpToPixel(botao.getLargura(), getActivity()));
            button.setHeight(height);
            button.setOnClickListener(clickListener);
            button.getBackground().setColorFilter(botao.getCor(), PorterDuff.Mode.MULTIPLY);
            pesquisaResult.addView(button);
        }

        return content;
    }

    public static int convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

    public static class BotaoPesquisa {
        private String titulo;
        private int largura;
        private int cor;

        public BotaoPesquisa(String titulo, int largura, int cor) {
            this.titulo = titulo;
            this.largura = largura;
            this.cor = cor;
        }

        public String getTitulo() {
            return titulo;
        }

        public int getLargura() {
            return largura;
        }

        public int getCor() {
            return cor;
        }
    }
}