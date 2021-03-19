package com.nerdygeek.mvvm.ui.registration.types

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nerdygeek.mvvm.R
import com.nerdygeek.mvvm.databinding.FragmentTypeBinding
import com.nerdygeek.mvvm.ui.AuthListener
import com.nerdygeek.mvvm.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_type.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


const val TAG = "tf"

/**
 * A simple [Fragment] subclass.
 * Use the [TypeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TypeFragment : Fragment(), AuthListener{

    lateinit var mBinding: FragmentTypeBinding
    lateinit var typeFragmentViewModel: TypeFragmentViewModel
    // TODO: Rename and change types of parameters
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeFragmentViewModel= activity?.run {
            ViewModelProvider(this).get(TypeFragmentViewModel::class.java)
        }?: throw Exception("invalid activity")

        typeFragmentViewModel.authListener = this

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_type, container, false)
        mBinding.userInfo = typeFragmentViewModel

        if(param1 == "tenant"){
            typeFragmentViewModel.type = "tenant"
            mBinding.inputLandlordEmail.visibility = View.VISIBLE

        }
        Log.d("abc", param1!!)


        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TypeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            TypeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }

    override fun onStarted() {
        Log.d(TAG, "on started")
    }

    override fun onSuccess(loginResponse: MutableLiveData<String>) {
        loginResponse.observe(this, Observer {
            Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()

            startActivity(Intent(mBinding.root.context, LoginActivity::class.java))
        })
    }

    override fun onFailure(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
    }
}