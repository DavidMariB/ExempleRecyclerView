package pmdm.mviel.exemplerecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager rvLM;
    AdaptadorRecyclerViewClient aRVclient;
    List clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

// --------------------------------------------------------------
        //Creem un ArrayList amb 15 clients
        clients = new ArrayList();

        // I l'omplim amb 15 dades de clients
        for (int i=0;i<5;i++){
            clients.add(new Client("Manel","Viel","PMDM","123456789"));
            clients.add(new Client("Sr.","Cuesta","PSP","111222333"));
            clients.add(new Client("Baptista","Basset","PMDM","444555666"));

        }

        //Obtenim una instància del RecyclerView
        rv= (RecyclerView)findViewById(R.id.elMeuRecyclerView);
        //Triem el LayoutManager que volem utilitzar i l'assignem a l'objecte recyclerView
        rvLM = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLM);

        //Creem l'adaptador que interactuarà amb les dades
        aRVclient = new AdaptadorRecyclerViewClient(clients);

        //Enllacem el RecyclerView amb l'adaptador
        rv.setAdapter(aRVclient);
// ------------------------------------------------------------

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
