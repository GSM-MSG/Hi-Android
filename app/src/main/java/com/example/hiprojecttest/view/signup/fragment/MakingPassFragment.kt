package com.example.hiprojecttest.view.signup.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.FragmentMakingPassBinding
import com.example.hiprojecttest.model.dto.auth.request.SignUpDTO
import com.example.hiprojecttest.model.retrofit.CommunicationWork
import com.example.hiprojecttest.setOnTextChanged
import com.example.hiprojecttest.viewmodel.SignUpViewModel


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
        val signUpViewModel by activityViewModels<SignUpViewModel>()

        binding.passInputBox.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()) {
                binding.nextStepBtn.setBackground(resources.getDrawable(R.drawable.gradient_btn))

            }
        }
        binding.nextStepBtn.setOnClickListener {
            var newPass = binding.passwordInputBox.text.toString()
            var checkingPass = binding.passInputBox.text.toString()
            if (newPass == checkingPass && !newPass.isNullOrBlank()) {
                val clientInfo = SignUpDTO(
                    signUpViewModel.emailDataRequest.value!!,
                    newPass,
                    signUpViewModel.nameDataRequest.value!!,
                    signUpViewModel.studentIdDataRequest.value!!
                )
                val retrofitWork = CommunicationWork()
                retrofitWork.signUp(clientInfo, successAction = {
                    navController.navigate(R.id.action_makingPassFragment_to_lastSinUpFragment)
                })

            }else{
                Toast.makeText(context,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show()
            }
        }


        binding.goBackButton.setOnClickListener {
            navController.popBackStack()
        }
    }
}