package org.cardna.presentation.ui.alarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.databinding.ItemSeeAllBinding

class DiaryAdapter(
    private val clickListener: (ResponseGetDiary.Data) -> Unit
) : androidx.recyclerview.widget.ListAdapter<ResponseGetDiary.Data, DiaryAdapter.DiaryViewHolder>(diffUtil) {

  /*  @SerializedName("id")
    var id: Int,

    @SerializedName("content")
    var content: String,

    @SerializedName("emotionId")
    var emotionId: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("singer")
    var singer: String,

    @SerializedName("cover")
    var cover: String,

    @SerializedName("url")
    var url: String,

    @SerializedName("createdAt")
    var createdAt: String*/

    inner class DiaryViewHolder(private val binding: ItemSeeAllBinding) : RecyclerView.ViewHolder(binding.root) {
        //2022-02-02 mgm 3
        fun onBind(data: ResponseGetDiary.Data) {
            binding.apply {
                tvItemSeeAllContent.text = data.content
                tvItemSeeAllMonth.text = data.createdAt.substring(8..9)
                tvItemSeeAllDay.text = data.createdAt.substring(11..13)
                tvItemSeeAllMonth.text = data.createdAt.substring(8..9)
                tvItemSeeAllDay.text = data.createdAt.substring(11..13)
                tvItemSeeAllMusicSinger.text = data.singer
                tvSeeAllMusicName.text = " - " + data.title

                when (data.emotionId) {
                    1 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_joy)
                    2 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_sad)
                    3 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_surprise)
                    4 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_angry)
                    5 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_hate)
                    6 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_fear)
                    7 -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_note_soso)
                    else -> binding.ivItemSeeAllEightNote.setImageResource(R.drawable.ic_eight_transparent)
                }


                ctlSeeAll.setOnClickListener {
                    clickListener(data)
                }
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
        val diffUtil = object : DiffUtil.ItemCallback<ResponseGetDiary.Data>() {
            override fun areContentsTheSame(oldItem: ResponseGetDiary.Data, newItem: ResponseGetDiary.Data) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: ResponseGetDiary.Data, newItem: ResponseGetDiary.Data) =
                oldItem.id == newItem.id
        }
    }
}