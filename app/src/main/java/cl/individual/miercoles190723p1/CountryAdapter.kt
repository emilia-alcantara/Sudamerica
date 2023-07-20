package cl.individual.miercoles190723p1

import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cl.individual.miercoles190723p1.databinding.ItemBinding
import coil.load

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {
    var paisesListado = mutableListOf<Pais>()
    var callback: PaisCallback? = null

    fun setPaisCallback(c: PaisCallback) {
        this.callback = c
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paisesListado.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pais: Pais = paisesListado[position]
        holder.bind(pais)
      //  holder.itemView.setOnClickListener()

    }

    fun setData(listaPaises: List<Pais>) {
        this.paisesListado = listaPaises.toMutableList()
    }

    inner class MyViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pais: Pais) {

            binding.txtCountry.text = pais.nombre
            binding.imgBandera.load(pais.imgUrl)


            val texto = "Pais: ${pais.nombre}, Población: ${pais.poblacion}"


            binding.countryCard.setOnClickListener(View.OnClickListener {
                callback?.mostrarPoblacion(texto)
               // Toast.makeText(itemView.context, texto, Toast.LENGTH_LONG).show()
            })
        }

    }

}

interface PaisCallback {
    fun mostrarPoblacion(s: String)
}





