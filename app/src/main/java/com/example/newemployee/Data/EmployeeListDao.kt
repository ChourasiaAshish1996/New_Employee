package com.example.myemployees.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface EmployeeListDao {

    @Query ("SELECT * FROM Employee ORDER BY name")
    fun getEmployee() : LiveData<List<Employee>>
}