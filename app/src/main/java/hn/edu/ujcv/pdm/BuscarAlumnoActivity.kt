package hn.edu.ujcv.pdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm.Clases.Alumnos
import kotlinx.android.synthetic.main.activity_buscar_alumno.*

class BuscarAlumnoActivity : AppCompatActivity() {
    var valores2: HashMap<Int, Alumnos> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_alumno)
        inicializar()
        btnBuscar.setOnClickListener { busqueda() }
        btnRegresar2.setOnClickListener { regresar() }
    }

    private fun regresar() {
        val intentnRegistroAlumno = Intent(this, RegistroAlumnoActivity::class.java)
        startActivity(intentnRegistroAlumno)
    }

    private fun busqueda() {
        var datoBuscado : Alumnos? = valores2[txtNumeroCuenta2.text.toString().toInt()]

        if (datoBuscado == null){
            Toast.makeText(applicationContext, "El numero de cuenta no esta registrado", Toast.LENGTH_LONG).show()
        }else{
            txvNombre2.setText(datoBuscado.Nombre)
            txvCarrera2.setText(datoBuscado.Carrera)
            txvFechaIngreso2.setText(datoBuscado.FechaIngreso)
            txvCorreo2.setText(datoBuscado.Correo)
        }
    }

    private fun inicializar() {
        var intent = getIntent()
        valores2 = intent.getSerializableExtra("valores") as HashMap<Int, Alumnos>
    }

}