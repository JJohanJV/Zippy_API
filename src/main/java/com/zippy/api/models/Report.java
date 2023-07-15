package com.zippy.api.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(fluent = false, chain = true)
public class Report {
    private EmployeeReport employeeReport;
    private String userReport;

    public Report(String userReport) {
        this.userReport = userReport;
    }

    public Report(EmployeeReport employeeReport) {
        this.employeeReport = employeeReport;
    }

}
