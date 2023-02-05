package com.example.hiprojecttest.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.FragmentMakingPassBinding
import com.example.hiprojecttest.setOnTextChanged


class MakingPassFragment : Fragment() {
    lateinit var navController: NavController
    private lateinit var binding: FragmentMakingPassBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMakingPassBinding.inflate(inflater,container,false)
        return binding.root
    }
    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = requireActivity().findNavController(R.id.nav_host_fragment_email)

        var newPass = binding.passwordInputBox.toString()
        var checkingPass = binding.passInputBox.toString()

        binding.passInputBox.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()){
                binding.nextStepBtn.setBackground(resources.getDrawable(R.drawable.gradient_btn))
                binding.nextStepBtn.setOnClickListener {
                    navController.navigate(R.id.action_makingPassFragment_to_lastSinUpFragment)
                }
            }
        }

        binding.nextStepBtn.setOnClickListener {
            navController.popBackStack()
        }
    }
}