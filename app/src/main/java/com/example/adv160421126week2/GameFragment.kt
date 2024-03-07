package com.example.adv160421126week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.adv160421126week2.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
//    var point = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val answer = GameFragmentArgs.fromBundle(requireArguments()).answer
            var point = GameFragmentArgs.fromBundle(requireArguments()).point
//            val p = point
            if (playerName == answer){
                point += 20
                binding.textView.text = "Correct!! Your Point is $point"

                binding.btnNext.setOnClickListener{
                    val action = GameFragmentDirections.actionGameFragmentToResultFragment(point)
                    Navigation.findNavController(it).navigate(action)
                }

            }else{
                binding.textView.text = "Wrong Answer"
                binding.btnNext.setOnClickListener{
                    val action = GameFragmentDirections.actionGameFragmentToResultFragment(point)
                    Navigation.findNavController(it).navigate(action)
                }
            }

        }

    }
}