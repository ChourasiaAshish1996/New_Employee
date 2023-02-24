package com.example.myemployees.UI

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myemployees.Data.Employee
import com.example.myemployees.Data.ListAdapter_RV
import com.example.myemployees.R
import com.example.myemployees.databinding.FragmentEmployeeListBinding


@Suppress("DEPRECATION")
class Employee_list_fragment : Fragment() {
    private lateinit var viewModel: EmployeeListViewModel


    private var emp_list:ArrayList<Employee> = ArrayList()

    private var mContext: Context? = null
    private var _binding: FragmentEmployeeListBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    // Fxn to check if the contecxt is attached to the activtiy
    fun checkIfFragmentAttached(operation: Context.() -> Unit) {
        if (isAdded && mContext != null) {
            operation(mContext!!)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this@Employee_list_fragment)[EmployeeListViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(isAdded) {
            checkIfFragmentAttached {
                binding.employeeRV.apply {
                    //val rv= view.findViewById<RecyclerView>(R.id.employee_RV)
                    binding.employeeRV.layoutManager = LinearLayoutManager(mContext)
                    hasFixedSize()
                    binding.employeeRV.adapter = ListAdapter_RV(emp_list, requireContext() )
                }

                viewModel.employees.observe(viewLifecycleOwner , Observer { list->
                    list?.let{
                        (binding.employeeRV.adapter as ListAdapter_RV).submitList(emp_list)
                    }
                    


                })



                   binding.addBtn.setOnClickListener{
                        val bundle = Bundle()
                        bundle.putInt("newEmployeeID" , 0)
                        it.findNavController().navigate(
                            R.id.action_employee_list_to_employee_detail , bundle
                        )
                        //                addBtn.setOnClickListener{
//                    val Direction = Employee_list_fragmentDirections.actionEmployeeListToEmployeeDetail(0)
//                    findNavController().navigate(Direction)
//                }
                    }


                }








        }
        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }