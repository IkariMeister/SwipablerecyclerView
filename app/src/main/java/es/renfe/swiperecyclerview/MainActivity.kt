package es.renfe.swiperecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.checkin_estacion_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkin_estacion_layout)
        val adapter = CheckinEstacionAdapter()
        data_rv.adapter = adapter
        val touchHelper = ItemTouchHelper(SwipeController(SwipeControllerActions(onLeftClicked = {Int -> },onRightClicked = {Int -> })))
        touchHelper.attachToRecyclerView(data_rv)
        adapter.data = listOf(
                Pasos("Madrid","02225"),
                Pasos("Principe Pio","02226"),
                Pasos("Piramides","02227"),
                Pasos("Majadahonda","02228"),
                Pasos("Atocha","02229"),
                Pasos("Fuente de la Mora","02220")
                )
    }
}
