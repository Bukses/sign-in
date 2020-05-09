import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.signup.R

class Adapter(
    internal var context: Context,
    internal var myItems: MutableList<Model>

) :RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var img_icon: ImageView
        internal var txt_desc: TextView
        private var iCardItemClickListener : ICardItemClickListener? = null



        fun setEvent(iCardItemClickListener:ICardItemClickListener)
        {
            this.iCardItemClickListener = iCardItemClickListener
        }

        init {
            img_icon = itemView.findViewById<View>(R.id.img_icon) as ImageView
            txt_desc = itemView.findViewById(R.id.txt_desc) as TextView

            itemView.setOnClickListener(this)
        }

        public override fun onClick(v: View?) {
            iCardItemClickListener?.onCartItemClick(v, adapterPosition)



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.gridlayout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_icon.setImageResource(myItems[position].icon)
        holder.txt_desc.text = myItems[position].description

        holder.setEvent(object : ICardItemClickListener {
            @SuppressLint("ShowToast")


            override fun onCartItemClick(view: View?, position: Int) {
                Toast.makeText(
                    context,
                    "Clicked: " + myItems[position].description,
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent()
                intent.action=Intent.ACTION_VIEW
                view?.context?.startActivity(Intent.createChooser(intent,"Open with"))
            }
        })
    }
}

fun getItemViewType(position: Int): Int {
    return getItemViewType(position)
}

