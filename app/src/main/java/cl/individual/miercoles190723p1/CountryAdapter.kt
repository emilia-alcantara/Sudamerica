package cl.individual.miercoles190723p1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.miercoles190723p1.databinding.ItemBinding
import coil.load

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {
    var paisesListado = mutableListOf<Pais>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paisesListado.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pais:Pais = paisesListado[position]
        holder.bind(pais)
    }

    fun setData(listaPaises: List<Pais>) {
        this.paisesListado = listaPaises.toMutableList()
    }

    class MyViewHolder (val binding: ItemBinding) : RecyclerView.ViewHolder (binding.root) {
        fun bind(pais: Pais) {
            binding.txtCountry.text = pais.nombre
            binding.imgBandera.load(pais.imgUrl)

        }
    }
}


