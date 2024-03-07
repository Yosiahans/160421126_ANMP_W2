package com.example.adv160421126week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421126week2.databinding.FragmentGameBinding
import com.example.adv160421126week2.databinding.FragmentResult2Binding
import com.example.adv160421126week2.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResult2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResult2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var point = ResultFragmentArgs.fromBundle(requireArguments()).point
        binding.textView2.text = "Your Score is $point"
        binding.btnBackToMainScreen.setOnClickListener{
            val action = ResultFragmentDirections.actionResultFragmentToMainFragment(point=0)
            Navigation.findNavController(it).navigate(action)
            //test
        }
    }


}