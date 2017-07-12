package mbrtechnology.com.mbrt_app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.models.Incidente;

/**
 * Created by ASUS on 7/07/2017.
 */

public class IncidenteAdapter extends RecyclerView.Adapter<IncidenteAdapter.ViewHolder> {

    private List<Incidente> incidentes;

    public IncidenteAdapter(){ this.incidentes = new ArrayList<>(); }

    public void setIncidentes(List<Incidente> incidentes){this.incidentes = incidentes;}

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView cod;
        public TextView nombre;
        public TextView estado;
        public TextView tecnico;
        public TextView area;

        public ViewHolder(View itemView){
            super(itemView);
            cod = (TextView) itemView.findViewById(R.id.code_text);
            nombre = (TextView) itemView.findViewById(R.id.nombre_text);
            estado = (TextView) itemView.findViewById(R.id.estado_text);
            tecnico = (TextView) itemView.findViewById(R.id.tecnico_text);
            area = (TextView) itemView.findViewById(R.id.area_text);
        }
    }

    @Override
    public  IncidenteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incidente, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void  onBindViewHolder(IncidenteAdapter.ViewHolder viewHolder, int position) {

        Incidente incidente = this.incidentes.get(position);

        viewHolder.cod.setText(incidente.getId());

    }

    @Override
    public int getItemCount(){ return this.incidentes.size(); }

}
