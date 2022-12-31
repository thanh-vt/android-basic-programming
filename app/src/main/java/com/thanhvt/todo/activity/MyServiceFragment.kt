package com.thanhvt.todo.activity

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thanhvt.todo.BuildConfig
import com.thanhvt.todo.databinding.FragmentMyServiceBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyServiceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentMyServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_my_service, container, false)
        binding = FragmentMyServiceBinding.inflate(inflater, container, false)
        binding.startMyServiceBtn.setOnClickListener {
            startMyService()
        }
        binding.stopMyServiceBtn.setOnClickListener {
            stopMyService()
        }
        return binding.root
    }


    private fun startMyService() {
        val intent = Intent(activity, MyService::class.java)
        activity?.startService(intent)
        updateTextStatus()
    }

    private fun stopMyService() {
        val intentStop = Intent(activity, MyService::class.java)
        intentStop.action = ACTION_STOP
        activity?.startService(intentStop)
        Handler().postDelayed({
            updateTextStatus()
        },100)
    }

    @SuppressLint("SetTextI18n")
    private fun updateTextStatus() {
        if (isMyServiceRunning(MyService::class.java)) {
            binding.myServiceStatus.text = "My Service is Running"
        } else {
            binding.myServiceStatus.text = "My Service is NOT Running"
        }
    }


    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        try {
            val manager =
                activity?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in manager.getRunningServices(
                Int.MAX_VALUE
            )) {
                if (serviceClass.name == service.service.className) {
                    return true
                }
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }

    companion object {
        const val ACTION_STOP = "${BuildConfig.APPLICATION_ID}.stop"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyServiceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyServiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}