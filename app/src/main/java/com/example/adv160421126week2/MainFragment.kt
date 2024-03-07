package com.example.adv160421126week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.example.adv160421126week2.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding
    var point = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(
            inflater,
            container, false
        )
        return binding.root
        var point = GameFragmentArgs.fromBundle(requireArguments()).point

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var X = (1..10).random()
        var y = (1..10).random()
        binding.txtNum1.text = X.toString()
        binding.txtNum2.text = y.toString()
        binding.btnSetting.setOnClickListener{
            val action = MainFragmentDirections.actionOptionFragment()
            Navigation.findNavController(it).navigate(action)
        }
        binding.btnStart.setOnClickListener{
            val playerName = binding.textName.text.toString()
            val answer = (X+y).toString()
            if(answer == binding.textName.text.toString())
            {
                point += 1
                 X = (1..10).random()
                 y = (1..10).random()
                binding.txtNum1.text = X.toString()
                binding.txtNum2.text = y.toString()


            }
            else{
                val action = MainFragmentDirections.actionGameFragment(playerName,answer,point)
                Navigation.findNavController(it).navigate(action)
            }



        }
    }


}