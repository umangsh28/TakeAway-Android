package ug.sharma.takeaway.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ug.sharma.takeaway.R
import ug.sharma.takeaway.databinding.ItemDesignBinding
import ug.sharma.takeaway.interfacee.OnItemClick
import ug.sharma.takeaway.model.ResponseDTOItem

class VAdapter (private  val result: List<ResponseDTOItem>,val listener:OnItemClick)
    : RecyclerView.Adapter<VHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val itemLayoutBinding:ItemDesignBinding = DataBindingUtil.
        inflate(layoutInflater, R.layout.item_design,parent,false)
        return VHolder(itemLayoutBinding,listener)
    }

    override fun onBindViewHolder(holder: VHolder, pos: Int) {
        val result: ResponseDTOItem = result[pos]
        holder.setData(result)
    }

    override fun getItemCount(): Int {
        return result.size
    }

}