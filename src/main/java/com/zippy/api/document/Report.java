package com.zippy.api.document;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private EmployeeReport employeeReport;
    private String userReport;

    public Report(String userReport) {
        this.userReport = userReport;
    }

    public Report(EmployeeReport employeeReport) {
        this.employeeReport = employeeReport;
    }

    @Data
    @AllArgsConstructor
    public static class EmployeeReport {

        @DocumentReference
        private Employee employeeId;
        private String report;
    }
}
