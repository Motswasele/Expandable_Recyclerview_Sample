package com.example.expandable_recyclerview_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class ProvinceAdapter :
    RecyclerView.Adapter<ProvinceAdapter.MyViewHolder>() {

    private var titles= arrayOf("Gauteng","Limpopo","Mpumalanga","KwaZulu Natal","Free State",
        "North West","Eastern Cape","Western Cape","Northern Cape")
    private var details= arrayOf("Province of Gold","Province of Avocados and Oranges",
        "Province of Farming","Province of the Great Kingdom of Zulu Land",
        "Province known for farming","Province of Gold and Platinum","Province of the Xhosa Nation",
        "Province of the greatest wine on earth","Province of Gold and Diamonds")
    private var sites= arrayOf("Soweto","Giyani","Kruger National Park","Durban","Bloemfontein",
        "Pilanesberg National Park","Gqeberha","Table Mountain","Kimberley")
    private var activities= arrayOf("Gold-reef City","Kruger Park","U-Shark Marine",
        "Endless Festival Jazz Parties","Sun City","Potchefstroo The City that rocks!!",
        "Rugby Fanatics","All about making wine and drinking it!","Kimberley Hole")
    private var refreshments= arrayOf("Soweto","Phala-borwa","I've never been","Max LifeStyle",
        "Bloem","Mahikeng or Rusty","Xhosa's are a vibe themselves","Anywhere but it's expensive",
        "Do people there drink??")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val v = LayoutInflater.from(parent.context)
          .inflate(R.layout.item_list_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemSites.text = sites[position]
        holder.itemActivities.text = activities[position]
        holder.itemRefreshments.text = refreshments[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    class MyViewHolder(v:View):RecyclerView.ViewHolder(v) {

        var itemTitle: TextView = itemView.findViewById(R.id.text1)
        var itemDetail: TextView = itemView.findViewById(R.id.text2)
        var itemSites: TextView = itemView.findViewById(R.id.text3)
        var itemActivities: TextView = itemView.findViewById(R.id.text4)
        var itemRefreshments: TextView = itemView.findViewById(R.id.text5)
        var itemExpandLayout: ConstraintLayout = itemView.findViewById(R.id.expandLayout)
        private var itemCardView: CardView = itemView.findViewById(R.id.card_view)
        var itemShow: ImageButton = itemView.findViewById(R.id.show)

        init {
           itemShow.setOnClickListener {
                if (itemExpandLayout.visibility == View.GONE){
                    TransitionManager.beginDelayedTransition(itemCardView, AutoTransition())
                    itemExpandLayout.visibility = View.VISIBLE
                    itemShow.setImageResource(R.drawable.ic_expand_more)
                } else{
                    TransitionManager.beginDelayedTransition(itemCardView, AutoTransition())
                    itemExpandLayout.visibility = View.GONE
                    itemShow.setImageResource(R.drawable.ic_expand_less)}

           }
        }
    }
}