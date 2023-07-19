package cl.individual.miercoles190723p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.individual.miercoles190723p1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}