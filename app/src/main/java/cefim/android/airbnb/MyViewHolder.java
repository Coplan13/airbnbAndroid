package cefim.android.airbnb;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cefim.android.airbnb.data.logements.Logement;

public class MyViewHolder extends RecyclerView.ViewHolder {


    private TextView textViewView, prixView, noteView, paysView;
    private ImageView imageView;

    private ArrayList<MyObject> logement;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        Logement logement;
        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        prixView =(TextView) itemView.findViewById(R.id.prix);
        noteView = (TextView) itemView.findViewById(R.id.notes);
        paysView = (TextView) itemView.findViewById(R.id.pays);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(MyObject logement){
        textViewView.setText(logement.getText());
        prixView.setText(String.valueOf(logement.getPrix() + "€ / nuit"));
        noteView.setText(logement.getNote()+ " / 5");
        paysView.setText(logement.getPays());
        Picasso.with(imageView.getContext()).load(logement.getImageUrl()).centerCrop().fit().into(imageView);
    }
}
