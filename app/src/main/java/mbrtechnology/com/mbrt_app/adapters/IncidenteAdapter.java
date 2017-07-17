package mbrtechnology.com.mbrt_app.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.activities.DetalleActivity;
import mbrtechnology.com.mbrt_app.models.Incidente;

/**
 * Created by ASUS on 7/07/2017.
 */

public class IncidenteAdapter extends RecyclerView.Adapter<IncidenteAdapter.ViewHolder> {

    private List<Incidente> incidentes;
    private Activity activity;

    public IncidenteAdapter(Activity activity){
        this.activity = activity;
        this.incidentes = new ArrayList<>();
    }

    public void setIncidentes(List<Incidente> incidentes){this.incidentes = incidentes;}

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView codeText;
        public TextView nombreText;
        public TextView estadoText;
        public TextView tecnicoText;
        public TextView areaText;

        public ViewHolder(View itemView){
            super(itemView);
            codeText = (TextView) itemView.findViewById(R.id.code_text);
            nombreText = (TextView) itemView.findViewById(R.id.nombre_text);
            estadoText = (TextView) itemView.findViewById(R.id.estado_text);
            tecnicoText = (TextView) itemView.findViewById(R.id.tecnico_text);
            areaText = (TextView) itemView.findViewById(R.id.area_text);
        }
    }

    @Override
    public  IncidenteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incidente, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void  onBindViewHolder(IncidenteAdapter.ViewHolder viewHolder, int position) {

        final Incidente incidente = this.incidentes.get(position);
        viewHolder.codeText.setText(String.valueOf(incidente.getId()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(activity, DetalleActivity.class);
                intent.putExtra("ID", incidente.getId());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount(){ return this.incidentes.size(); }

}
