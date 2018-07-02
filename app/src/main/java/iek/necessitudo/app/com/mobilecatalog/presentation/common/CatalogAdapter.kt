package iek.necessitudo.app.com.mobilecatalog.presentation.common

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import iek.necessitudo.app.com.mobilecatalog.R
import android.view.View
import android.view.ViewGroup
import iek.necessitudo.app.com.mobilecatalog.presentation.model.GroupDDP


class CatalogAdapter() : ListAdapter<GroupDDP, GroupDDPViewHolder>(GroupDDPDiffCallback()){

    lateinit var allGroupDDP:List<GroupDDP>

    fun addItem(allGroupDDP:List<GroupDDP>){
        this.allGroupDDP = allGroupDDP
        submitList(allGroupDDP)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupDDPViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GroupDDPViewHolder(inflater.inflate(R.layout.groupddp_list_item, parent,false))
    }

    override fun onBindViewHolder(holder: GroupDDPViewHolder, position: Int) {
        holder.bind(allGroupDDP.get(position))
    }

}

class GroupDDPDiffCallback:DiffUtil.ItemCallback<GroupDDP>() {
    override fun areItemsTheSame(oldItem: GroupDDP?, newItem: GroupDDP?): Boolean {
        return oldItem?.groupId == newItem?.groupId
    }

    override fun areContentsTheSame(oldItem: GroupDDP?, newItem: GroupDDP?): Boolean {
       return oldItem == newItem
    }
}


class GroupDDPViewHolder(val itemView:View) :RecyclerView.ViewHolder(itemView){

    fun bind(groupDDP: GroupDDP) {

        val a = 0;
        // itemView.taskTitle.text = task.title
        //itemView.setOnClickListener { clickListener(task) }
    }
}



