package br.com.senai.ctr.dal;

import br.com.senai.ctr.model.Comando;
import com.google.firebase.database.*;

public class ComandoDAO extends DAO<Comando> {

    private DatabaseReference reference;

    public ComandoDAO(DatabaseReference reference) {
        super(reference, "comandos");
    }

    @Override
    protected ValueEventListener generateNewValueEventListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Comando obj = snapshot.getValue(Comando.class);
                obj.setId(snapshot.getKey());

                map.put(snapshot.getKey(), obj);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                error.toException().printStackTrace();
            }
        };
    }

    public Comando syncRetrieveComando(String idMarca, String idModelo, String idComando) {
        final Comando[] comando = new Comando[1];
        final boolean[] buscando = new boolean[]{true};

        Query query = reference
                .child("marcas").child(idMarca)
                .child("modelos").child(idModelo)
                .child("comandos").child(idComando);
        ValueEventListener listener = query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                comando[0] = snapshot.getValue(Comando.class);
                buscando[0] = false;
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        while (buscando[0]) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        query.removeEventListener(listener);

        return comando[0];
    }
}
