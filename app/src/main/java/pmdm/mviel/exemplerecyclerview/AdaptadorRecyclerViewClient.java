package pmdm.mviel.exemplerecyclerview;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mviel on 14/7/16.
 */
public class AdaptadorRecyclerViewClient extends RecyclerView.Adapter<AdaptadorRecyclerViewClient.ClientViewHolder> {

    private List<Client> llistaClients; // Llista amb els clients que volem mostrar

    //Classe interna que defineix el viewHolder.
    // El ViewHolder será un objecte que ens permetrà accedir a tots els
    // camps de l'XML que dissenya el contingut d'un item de la llista
    public static class ClientViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{

        //elements d'un ítem a mostrar
        public TextView nom_i_cognoms;
        public TextView malnom;
        public TextView telefon;

        //Constructor de ClientViewHolder
        public ClientViewHolder(View v) {
            super(v);
            nom_i_cognoms = (TextView) v.findViewById(R.id.cognoms_i_nom);
            nom_i_cognoms.setOnClickListener(this); // Li afegim el Listener al textView nom_i_cognoms
            malnom = (TextView) v.findViewById(R.id.malnom);
            telefon = (TextView) v.findViewById(R.id.telefon);
            telefon.setOnClickListener(this); //Li afegim el listener al textview telèfon
        }


        @Override
        // Definim les accions que volem realitzar cada vega que l'usuari faça un click.
        public void onClick(View view) {
            int idView = view.getId();  // Agafem l'identificador del wiew on s'ha produït l'event

            if (nom_i_cognoms.getId()==idView){  //Han fet click sobre el textview Nom_i_cognoms
                Snackbar.make(view,"Has polsat en el nom",Snackbar.LENGTH_LONG).show();
            }
            if (telefon.getId()==idView){  //Han fet click sobre el textview telefon
                TextView tv= (TextView) view;
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tv.getText().toString()));
                view.getContext().startActivity(i);
            }
        }
    }

    // El constructor de l'adaptador, rebrà la llista de clients a mostrar
    // i el context on s'executa l'activity que conté la llista
    public AdaptadorRecyclerViewClient(List<Client> llista){
        this.llistaClients=llista;
    }

    @Override
    public int getItemCount(){
        return this.llistaClients.size();
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyclerview_client, parent, false);
        return new ClientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        holder.telefon.setText(llistaClients.get(position).getTelefon());
        holder.nom_i_cognoms.setText(this.llistaClients.get(position).getCognoms() + ", " + this.llistaClients.get(position).getNom());
        holder.malnom.setText(this.llistaClients.get(position).getMalnom());

    }




}
