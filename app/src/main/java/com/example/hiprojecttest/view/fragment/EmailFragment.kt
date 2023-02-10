package com.example.hiprojecttest.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.FragmentEMailBinding
import com.example.hiprojecttest.dto.email.request.EmailSendDTO
import com.example.hiprojecttest.retrofit.CommunicationWork
import com.example.hiprojecttest.setOnTextChanged


class EmailFragment : Fragment(){
    lateinit var navController: NavController
    private lateinit var binding: FragmentEMailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentEMailBinding.inflate(inflater,container,false)
        return binding.root
    }
    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = requireActivity().findNavController(R.id.nav_host_fragment_email)
        var setting = binding.emailInputBox.toString()
        var data = setting.substring(6 until 15)
        var emailGuide = "@gsm.hs.kr"

        binding.emailInputBox.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()){
                binding.sendEmailBtn.setOnClickListener {
                    val emailInfo = binding.emailInputBox.text.toString()
                    val userEmailData = EmailSendDTO(
                        emailInfo
                    )
                    val action = EmailFragmentDirections.actionEMailFragmentToEmailProveFragment(email = emailInfo)
                    Log.d("TAG","$userEmailData")
                    val emailSendWork = CommunicationWork()
                    emailSendWork.sendEamil(userEmailData)
                    findNavController().navigate(action)
                }
            }
        }
        binding.backBtn.setOnClickListener {
            navController.popBackStack()
        }
        
    }

}

