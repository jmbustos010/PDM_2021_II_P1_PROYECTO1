package hn.edu.ujcv.pdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm.Clases.Prestamo
import kotlinx.android.synthetic.main.activity_buscar_prestamo.*

class BuscarPrestamoActivity : AppCompatActivity() {
    var valores: HashMap<Int, Prestamo> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_prestamo)
        inicalizar()
        btnBuscar.setOnClickListener{buscar()}
        btnRegresar.setOnClickListener{regresar()}
    }

    private fun regresar() {
        val intentnRegistroPrestamo = Intent(this, RegistroPrestamoActivity::class.java)
        startActivity(intentnRegistroPrestamo)
    }

    private fun buscar(){

        var datoBuscado: Prestamo? = valores[txtIngresarNumeroCuenta.text.toString().toInt()]

        if (datoBuscado == null){
            Toast.makeText(applicationContext, "Esta nulo", Toast.LENGTH_LONG).show()
        }else{
            txvMostrarNumeroPrestamo.setText(datoBuscado.numeroPrestamo)
            txvMostrarNumeroLibro.setText(datoBuscado.numeroLibro)
            txvMostrarFechaEntrega.setText(datoBuscado.fechaEntrega)
            txvMostrarFechaDevolucion.setText(datoBuscado.fechaDevolucion)
        }
    }

    private fun inicalizar() {
        var intent = getIntent()
        valores    = intent.getSerializableExtra("valores") as HashMap<Int, Prestamo>
    }
}