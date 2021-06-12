package hn.edu.ujcv.pdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm.Clases.Alumnos
import kotlinx.android.synthetic.main.activity_registro_alumno.*

class RegistroAlumnoActivity : AppCompatActivity() {
    var valores: HashMap<Int, Alumnos> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumno)

        inicializar()
        btnGuardar.setOnClickListener{ guardar()}
        btnEnviar.setOnClickListener { enviar() }
        btnRegresar.setOnClickListener{regresar()}
    }

    private fun regresar() {
        val intentnRegistroAlumno = Intent(this, MainActivity::class.java)
        startActivity(intentnRegistroAlumno)
    }

    private fun enviar() {
        val intent = Intent(this, BuscarAlumnoActivity::class.java)
        intent.putExtra("valores", valores)
        startActivity(intent)

    }

    private fun guardar() {
        val dato : Alumnos = Alumnos()
        dato.NumeroCuenta  = txtNumCuenta.text.toString().toInt()
        dato.Nombre        = txtNombre.text.toString()
        dato.Carrera       = txtCarrera.text.toString()
        dato.FechaIngreso  = txtFecha.text.toString()
        dato.Correo        = txtCorreo.text.toString()

        valores.put(dato.NumeroCuenta, dato)
        btnEnviar.isEnabled = true
    }
    private fun inicializar() {
        btnEnviar.isEnabled = false
    }
}
