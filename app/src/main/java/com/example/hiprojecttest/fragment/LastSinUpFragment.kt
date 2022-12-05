package com.example.hiprojecttest.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hiprojecttest.MainActivity
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.FragmentLastSignUpBinding



class LastSinUpFragment : Fragment() {
    lateinit var navController: NavController
    private lateinit var binding: FragmentLastSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLastSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = requireActivity().findNavController(R.id.nav_host_fragment_email)

        binding.nextStepBtn.setOnClickListener {
            val intent = Intent(activity,MainActivity::class.java)
            startActivity(intent)
        }
    }

}