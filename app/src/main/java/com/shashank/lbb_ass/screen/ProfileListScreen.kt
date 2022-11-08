package com.shashank.lbb_ass.screen

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashank.lbb_ass.R
import com.shashank.lbb_ass.UserAdapter
import com.shashank.lbb_ass.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.profile_list_screen.*

class ProfileListScreen :Fragment(R.layout.profile_list_screen) {
    lateinit var viewMmodel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UserAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(activity)



        viewMmodel = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)

        viewMmodel.allUser.observe(requireActivity(), Observer {

            adapter.update(it)

        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                // navigate to settings screen
                findNavController().navigate(R.id.action_profileListScreen_to_addProfileScreen)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

