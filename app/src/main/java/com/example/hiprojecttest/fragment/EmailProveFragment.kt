package com.example.hiprojecttest.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.FragmentEmailProveBinding
import com.example.hiprojecttest.setOnTextChanged


class EmailProveFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var binding: FragmentEmailProveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentEmailProveBinding.inflate(inflater,container,false)
        return binding.root
    }
    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = requireActivity().findNavController(R.id.nav_host_fragment_email)


        binding.emailProveInputBox.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()){
                binding.nextStepBtn.setBackground(resources.getDrawable(R.drawable.gradient_btn))
                binding.nextStepBtn.setOnClickListener {
                    navController.navigate(R.id.action_emailProveFragment_to_makingPassFragment)
                }
            }
        }
        binding.reSendEmailBtn.setOnClickListener{
            binding.emailProveInputBox.setText(null)
            binding.nextStepBtn.setBackgroundColor(resources.getColor(R.color.hint_black1))
        }
        binding.backBtn.setOnClickListener {
            navController.popBackStack()
        }

    }

}