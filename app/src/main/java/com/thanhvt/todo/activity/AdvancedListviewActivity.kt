package com.thanhvt.todo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thanhvt.todo.R
import com.thanhvt.todo.adapter.DishAdapter
import com.thanhvt.todo.databinding.ActivityAdvancedListviewBinding
import com.thanhvt.todo.model.Dish

private const val TAG = "AdvancedListviewActivity"

class AdvancedListviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdvancedListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvancedListviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dishes: ArrayList<Dish> = ArrayList()
        dishes.add(Dish("Bánh mỳ ốp la", R.drawable.banhmyopla))
        dishes.add(Dish("Chả giò", R.drawable.chagio))
        dishes.add(Dish("Cơm trộn Hàn Quốc", R.drawable.comtronhanquoc))
        dishes.add(Dish("Món ăn với táo đỏ", R.drawable.monanvoitaodo))
        dishes.add(Dish("Mỳ với trứng chiên", R.drawable.myvoitrungchien))
        dishes.add(Dish("Mỳ xào thập cẩm", R.drawable.myxaothapcam))

        binding.advancedListView.adapter = DishAdapter(this@AdvancedListviewActivity, dishes)
    }
}