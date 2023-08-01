package cl.awakelab.ejercicio2m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelab.ejercicio2m6.R
import cl.awakelab.ejercicio2m6.databinding.FragmentListBinding

class ListFragment : Fragment() {
  lateinit var binding: FragmentListBinding
    val itemViewModel: ItemViewModel by activityViewModels()
    val adapter= ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initList()
        return binding.root
    }

    private fun initList() {
        itemViewModel.getAllItems().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
        binding.recyclerView.adapter = adapter
    }
}