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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var etTitulo:EditText
    lateinit var etDesc:EditText
    lateinit var btnAgregar:Button
    lateinit var listaTareas:RecyclerView
    lateinit var adapter: TareasAdapter
    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitulo = findViewById(R.id.etTitulo)
        etDesc = findViewById(R.id.etDesc)
        btnAgregar = findViewById(R.id.btnAgregar)
        listaTareas = findViewById(R.id.rvTareas)

        adapter = TareasAdapter(tareasViewModel.tareas)
        listaTareas.adapter = adapter
        listaTareas.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        btnAgregar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val desc = etDesc.text.toString()
            tareasViewModel.tareas.add(Tarea(titulo, desc,false))
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show()
            Log.d("MainActivity", "$titulo: $desc") // Log -> Para debugear la app


        }
    }
}