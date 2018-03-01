package es.renfe.swiperecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlin.properties.Delegates


/**
 * Created by jcgarcia on 01/03/2018.
 */
class CheckinEstacionAdapter() : RecyclerView.Adapter<CheckinEstacionViewHolder>() {
    var data: List<Pasos> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckinEstacionViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.checkin_estacion_view_holder, parent, false)
        return CheckinEstacionViewHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CheckinEstacionViewHolder, position: Int) {
        holder.render(data[position])
//        holder.itemView.setOnClickListener {  }
//        holder.itemView.setOnLongClickListener {  }
    }
}