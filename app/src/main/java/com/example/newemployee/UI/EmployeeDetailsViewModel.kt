package com.example.myemployees.UI

import android.app.Application
import androidx.lifecycle.*
import com.example.myemployees.Data.Employee
import com.example.myemployees.Data.EmployeeDetailsRepo
import kotlinx.coroutines.launch

class EmployeeDetailsViewModel (application: Application) : AndroidViewModel(application) {
    private val DetailsRepo : EmployeeDetailsRepo   = EmployeeDetailsRepo(application)

    private val _employeeId = MutableLiveData<Long>(0)
    val employeeId : LiveData<Long>
    get() = _employeeId

    val employee: LiveData<Employee> = Transformations.switchMap(_employeeId){id ->
        DetailsRepo.getEmployee(id)
    }

    fun setEmployeeId(id: Long){
        if(_employeeId.value != id){
            _employeeId.value = id
        }
    }
    fun saveEmployee(employee: Employee){
        viewModelScope.launch {
        }
    }


}