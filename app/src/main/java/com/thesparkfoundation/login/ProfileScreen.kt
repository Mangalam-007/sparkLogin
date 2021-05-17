package com.thesparkfoundation.login

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import com.thesparkfoundation.login.databinding.FragmentProfileScreenBinding
import java.net.URL

class ProfileScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    val binding = DataBindingUtil.inflate<FragmentProfileScreenBinding>(
        inflater, R.layout.fragment_profile_screen, container, false
    )
        if(FirebaseAuth.getInstance().currentUser?.displayName==null)
            NavHostFragment.findNavController(this).navigate(R.id.action_loginScreen_to_homeScreen)
        binding.nameProfile.text=binding.nameProfile.text.toString() + FirebaseAuth.getInstance().currentUser?.displayName.toString()
        var uri:String? = FirebaseAuth.getInstance().currentUser?.photoUrl.toString()
        binding.loggedInformation.text=binding.loggedInformation.text.toString()+FirebaseAuth.getInstance().currentUser?.email.toString()
        var image:ImageView=binding.photoProfile
        Picasso.with(context).load(uri).into(image)
        binding.logoutBtn.setOnClickListener {
            AuthUI.getInstance().signOut(requireContext())
            Toast.makeText(this.context, "Logout successfully", Toast.LENGTH_LONG).show()
            NavHostFragment.findNavController(this).navigate(R.id.action_loginScreen_to_homeScreen)
        }
        return binding.root
    }
}