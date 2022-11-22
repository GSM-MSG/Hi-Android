package com.example.hiprojecttest.fragment

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.hiprojecttest.MainActivity
import com.example.hiprojecttest.R
import com.example.hiprojecttest.SinUpActivity
import com.example.hiprojecttest.databinding.FragmentRealNameBinding
import com.example.hiprojecttest.setOnTextChanged


class RealNameFragment : Fragment() {
    lateinit var navController: NavController
    private lateinit var binding: FragmentRealNameBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentRealNameBinding.inflate(inflater,container,false)
        return binding.root

    }

    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = requireActivity().findNavController(R.id.nav_host_fragment_email)

        var setting = binding.inputTextName.toString()


        binding.inputTextName.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()){
                Log.d("TAG", "is not NULL ")
                binding.nextStageBtn.setBackground(resources.getDrawable(R.drawable.gradientbutton))
                binding.nextStageBtn.setOnClickListener {
                    Log.d("TAG", "onClick")
                    navController.navigate(R.id.action_real_nameFragment_to_e_mailFragment)
                }
            }
        }

        binding.backTrakingBtn.setOnClickListener{
            val intent = Intent(activity,MainActivity::class.java)
            startActivity(intent)
        }
    }


}


