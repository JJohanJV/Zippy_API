package com.zippy.api.models;

import com.zippy.api.document.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
public class EmployeeReport {

    @DocumentReference
    private Employee employeeId;
    private String report;
}
