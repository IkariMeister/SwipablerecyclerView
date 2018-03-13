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
class CheckinEstacionViewHolder(itemView: View, val buttons: View) : RecyclerView.ViewHolder(itemView) {


    fun render(element: Pasos) {
        itemView.circulacion_tren_tv.text = element.tren
        itemView.destino_tv.text = element.destino
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(itemView as ConstraintLayout)
        val constraintB1 = ConstraintSet()
        constraintB1.clone(itemView.context,R.layout.checkin_estacion_vh_action_buttons)
        val constraint2 = ConstraintSet()
        constraint2.clone(itemView.context, R.layout.checkin_estacion_view_holder_alt)
        val constraintB2 = ConstraintSet()
        constraintB2.clone(itemView.context, R.layout.checkin_estacion_vh_action_buttons_alt)
        itemView.setOnClickListener {
            TransitionManager.beginDelayedTransition(itemView)
            TransitionManager.beginDelayedTransition(itemView.container)
            val constraint = if (set) constraint1 else constraint2
            val constraintB = if (set) constraintB1 else constraintB2

            constraint.applyTo(itemView)
            constraintB.applyTo(buttons as ConstraintLayout)
            set = !set
        }
    }

}