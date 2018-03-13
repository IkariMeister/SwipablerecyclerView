package es.renfe.swiperecyclerview

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.widget.RecyclerView
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.checkin_estacion_view_holder_alt.view.*


/**
 * Created by jcgarcia on 01/03/2018.
 */
class CheckinEstacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun render(element: Pasos) {
        itemView.circulacion_tren_tv.text = element.tren
        itemView.destino_tv.text = element.destino
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(itemView as ConstraintLayout)
        val constraint2 = ConstraintSet()
        constraint2.clone(itemView.context, R.layout.checkin_estacion_view_holder_alt)
        itemView.setOnClickListener {
            TransitionManager.beginDelayedTransition(itemView)
            val constraint = if (set) constraint1 else constraint2
            constraint.applyTo(itemView)
            set = !set
        }
    }

}