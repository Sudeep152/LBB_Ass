package com.shashank.lbb_ass.screen

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.shashank.lbb_ass.Entity.User
import com.shashank.lbb_ass.R
import com.shashank.lbb_ass.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.add_profile_screen.*


class AddProfileScreen : Fragment(R.layout.add_profile_screen) {

    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    var imageUri: Uri? = null
    lateinit var viewM: UserViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewM = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)

        imgSet.setOnClickListener {
            openGallery()
        }

        Save_button.setOnClickListener {
            val firstname = nameEdt.text.toString()
            val lastName = lastEdt.text.toString()
            val map = useImage(imageUri);

            if (firstname.isEmpty() || lastName.isEmpty() || map.toString().isEmpty()){
                Toast.makeText(context, "Please enter all field ", Toast.LENGTH_SHORT).show()
            }else{
                viewM.insertUser(User(firstname, lastName, map))
            }

        }
    }

    fun useImage(uri: Uri?): Bitmap {
        val bitmap = MediaStore.Images.Media.getBitmap(this.context?.contentResolver, uri)
        return bitmap
    }

    private fun openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == IMAGE_REQUEST_CODE) {
            imageUri = data?.data
            imgSet.setImageURI(imageUri)
        }
    }

}