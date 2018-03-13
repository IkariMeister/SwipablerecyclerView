package es.renfe.swiperecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.checkin_estacion_view_holder.view.*
import kotlin.properties.Delegates


/**
 * Created by jcgarcia on 01/03/2018.
 */
class CheckinEstacionAdapter : RecyclerView.Adapter<CheckinEstacionViewHolder>() {
    var data: List<Pasos> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckinEstacionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater
                .inflate(R.layout.checkin_estacion_view_holder, parent, false)
        inflater.inflate(R.layout.checkin_estacion_vh_action_buttons, v.container, true)

        return CheckinEstacionViewHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CheckinEstacionViewHolder, position: Int) {
        holder.render(data[position])
    }
}