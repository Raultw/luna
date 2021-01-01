package com.example.cine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clase7.R;

import java.util.ArrayList;

public class AdaptadorCine extends BaseAdapter {

    private Context context;
    private ArrayList<CineInfo> listaCines;

    public AdaptadorCine(Context context, ArrayList<CineInfo> listaCines) {
        this.context = context;
        this.listaCines = listaCines;

    }

    @Override
    public int getCount() {
        return listaCines.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCines.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        CineInfo cine = (CineInfo) getItem(position);

        view = LayoutInflater.from(context).inflate(R.layout.lista_cines, null);
        ImageView img = view.findViewById(R.id.imgTapa);
        TextView titulo = view.findViewById(R.id.textTitulo);
        TextView descripcion = view.findViewById(R.id.textDescripcion);

        img.setImageResource(cine.getImgId());
        titulo.setText(cine.getTitulo());
        descripcion.setText(cine.getDescripcion());

        return view;
    }
}
