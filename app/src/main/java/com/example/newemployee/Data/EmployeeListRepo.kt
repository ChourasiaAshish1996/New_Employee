package com.example.myemployees.Data

import android.app.Application
import androidx.lifecycle.LiveData


class EmployeeListRepo(context : Application) {
    private val employeeListDao : EmployeeListDao = EmployeeDatabase.getDatabase(context).EmployeeListDao

    fun getEmployees (): LiveData<List<Employee>> = employeeListDao.getEmployee()
}