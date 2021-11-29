package ug.sharma.takeaway.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ug.sharma.takeaway.databinding.ItemDesignBinding
import ug.sharma.takeaway.interfacee.OnItemClick
import ug.sharma.takeaway.model.ResponseDTOItem

class VHolder(private val itemDesignBinding: ItemDesignBinding,val listener:OnItemClick)

    : RecyclerView.ViewHolder(itemDesignBinding.root){

    fun setData(result: ResponseDTOItem){

        itemDesignBinding.cinema=result

        itemDesignBinding.title.text = result.name

        itemDesignBinding.card.setOnClickListener {
            listener.OnPicClick(result)
        }

        itemDesignBinding.popularity.text = result.updated.toString()
        try {

            Glide.with(itemDesignBinding.umg).load(result.image.original).into(itemDesignBinding.umg)

        }catch (e:Exception){

        }

    }


}