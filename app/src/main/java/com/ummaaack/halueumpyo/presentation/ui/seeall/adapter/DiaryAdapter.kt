package org.cardna.presentation.ui.alarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.halueumpyo.databinding.ItemSeeAllBinding

class DiaryAdapter(
    private val clickListener: (DiaryResponseData) -> Unit
) : androidx.recyclerview.widget.ListAdapter<DiaryResponseData, DiaryAdapter.DiaryViewHolder>(diffUtil) {


    inner class DiaryViewHolder(private val binding: ItemSeeAllBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: DiaryResponseData) {
            binding.apply {
                tvItemSeeAllContent.text = data.content
                tvItemSeeAllMonth.text = data.month
                tvItemSeeAllDay.text = data.day
                tvItemSeeAllMusicSinger.text = data.musicSinger
                tvSeeAllMusicName.text = " - "+data.musicName

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val binding = ItemSeeAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DiaryResponseData>() {
            override fun areContentsTheSame(oldItem: DiaryResponseData, newItem: DiaryResponseData) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: DiaryResponseData, newItem: DiaryResponseData) =
                oldItem.day == newItem.day  //TODO 친구 id로 비교
        }
    }
}