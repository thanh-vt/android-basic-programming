package com.thanhvt.todo.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.thanhvt.todo.adapter.UserAdapter
import com.thanhvt.todo.databinding.ActivityRecyclerViewBinding
import com.thanhvt.todo.model.User
import com.thanhvt.todo.util.HttpUtil
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.Executors

private const val TAG = "RecyclerViewActivity"

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    private val myExecutor = Executors.newSingleThreadExecutor()
    private val myHandler = Handler(Looper.getMainLooper())
    private lateinit var userAdapter: UserAdapter

    private val users: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        userAdapter = UserAdapter(this@RecyclerViewActivity, users)
        binding.photoRecyclerView.adapter = userAdapter
        binding.photoRecyclerView.layoutManager = LinearLayoutManager(this)

        myExecutor.execute {
            // Do something in background (back-end process)
            val content = HttpUtil.readAsString("https://reqres.in/api/users?page=0")
            val response = JSONObject(content)
            val arrays = response.get("data") as JSONArray
            for (i in 0 until arrays.length()) {
                val obj: JSONObject = arrays[i] as JSONObject
                val photo = User(
                    obj.getLong("id"),
                    obj.getString("email"),
                    obj.getString("first_name"),
                    obj.getString("last_name"),
                    obj.getString("avatar")
                )
                users.add(photo)
            }
            myHandler.post {
                // Do something in UI (front-end process)
                userAdapter.notifyDataSetChanged()
            }
        }
    }
}