package com.example.myemployees.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myemployees.Data.Employee
import com.example.myemployees.Data.EmployeeListRepo

class EmployeeListViewModel(application: Application): AndroidViewModel(application) {
    private val ListRepo : EmployeeListRepo = EmployeeListRepo(application)

    val employees : LiveData<List<Employee>> = ListRepo.getEmployees()
}