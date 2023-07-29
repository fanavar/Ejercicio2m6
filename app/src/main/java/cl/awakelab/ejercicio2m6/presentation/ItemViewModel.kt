package cl.awakelab.ejercicio2m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.ejercicio2m6.data.Repository
import cl.awakelab.ejercicio2m6.data.local.Item
import cl.awakelab.ejercicio2m6.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDataBase.getDatabase(application).getItemDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repository.getItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repository.insertItem(item)
    }
}