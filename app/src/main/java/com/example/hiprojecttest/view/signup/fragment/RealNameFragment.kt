package com.example.hiprojecttest.view.signup.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hiprojecttest.view.MainActivity
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.FragmentRealNameBinding
import com.example.hiprojecttest.setOnTextChanged
import com.example.hiprojecttest.viewmodel.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_real_name.*


class RealNameFragment : Fragment(){
    lateinit var navController: NavController
    private lateinit var binding: FragmentRealNameBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRealNameBinding.inflate(inflater,container,false)
        return binding.root

    }


    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = requireActivity().findNavController(R.id.nav_host_fragment_email)
        val signUpViewModel by activityViewModels<SignUpViewModel>()

        binding.nameInputBox.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()){
                Log.d("TAG", "is not NULL ")
                binding.nextStepBtn.setBackground(resources.getDrawable(R.drawable.gradient_btn))
            }
            else if(p0.isNullOrBlank()){
                binding.nextStepBtn.setBackgroundColor(resources.getColor(R.color.hint_black1))
            }
        }
        binding.nextStepBtn.setOnClickListener {
            Log.d("TAG", "onClick")
            val userName = binding.nameInputBox.text.toString()
            val studentId = binding.studentIdInputBox.text.toString()
            signUpViewModel.nameDataRequest(userName)
            signUpViewModel.studentIdDataRequest(studentId)
            if (!userName.isNullOrBlank() && !studentId.isNullOrBlank())
                navController.navigate(R.id.action_real_nameFragment_to_e_mailFragment)
            else{
                Toast.makeText(context,"이름 입력란과 학번 입력란이 비어있습니다",Toast.LENGTH_SHORT).show()
            }
        }

        binding.backBtn.setOnClickListener{
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

        }
    }
}


