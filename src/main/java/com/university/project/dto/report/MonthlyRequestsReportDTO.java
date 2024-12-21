package com.university.project.dto.report;

import java.util.List;

public class MonthlyRequestsReportDTO {

    private List<String> yearMonth;
    private int requests;

    public MonthlyRequestsReportDTO() {
    }

    public MonthlyRequestsReportDTO(List<String> yearMonth, int requests) {
        this.yearMonth = yearMonth;
        this.requests = requests;
    }

    public List<String> getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(List<String> yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }
}
