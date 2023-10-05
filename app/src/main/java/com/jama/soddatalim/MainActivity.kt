package com.jama.soddatalim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.size
import androidx.fragment.app.FragmentManager
import com.jama.soddatalim.adapter.LessonAdapter
import com.jama.soddatalim.databinding.ActivityMainBinding
import com.jama.soddatalim.model.Lesson
import com.jama.soddatalim.model.Topic

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var manager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager = supportFragmentManager
        manager!!.beginTransaction()
            .add(R.id.fr, ListFragment(), "frag1")
            .commit()
    }
}