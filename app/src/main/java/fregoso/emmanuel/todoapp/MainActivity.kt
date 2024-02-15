package fregoso.emmanuel.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    lateinit var etTitulo:EditText
    lateinit var etDesc:EditText
    lateinit var btnAgregar:Button
    lateinit var lvTask:ListView
    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitulo = findViewById(R.id.etTitulo)
        etDesc = findViewById(R.id.etDesc)
        btnAgregar = findViewById(R.id.btnAgregar)
        lvTask = findViewById(R.id.lvTask)

        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,tareasViewModel.tareas)
        lvTask.adapter = adaptador

        btnAgregar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val desc = etDesc.text.toString()
            Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show()
            Log.d("MainActivity", "$titulo: $desc") // Log -> Para debugear la app
            tareasViewModel.tareas.add("$titulo: $desc")
            adaptador.notifyDataSetChanged()

        }
    }
}