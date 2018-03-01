package es.renfe.swiperecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.checkin_estacion_view_holder.view.*


/**
 * Created by jcgarcia on 01/03/2018.
 */
class CheckinEstacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun render(element:Pasos){
            itemView.circulacion_tren_tv.text = element.tren
            itemView.destino_tv.text = element.destino

        }
}