package cefim.android.airbnb;

import android.support.v4.app.NavUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<MyObject> list;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<MyObject> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.logement_vue,viewGroup,false);
        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        MyObject logement = list.get(position);
        myViewHolder.bind(logement);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
