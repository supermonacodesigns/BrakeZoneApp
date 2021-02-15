package sample;

public class BrakeInputs {
    public String reportNo;
    public String reportName;
    public String dateCreated;
    public String vehicleName;
    public String compiledBy;
    public String vehicleClass;

    public BrakeInputs(String reportNo, String reportName, String dateCreated, String vehicleClass) {
        this.reportNo = reportNo;
        this.reportName = reportName;
        this.dateCreated = dateCreated;
        this.vehicleClass = vehicleClass;
    }

    public BrakeInputs(String reportNo, String reportName, String dateCreated, String vehicleName, String compiledBy) {
        this.reportNo = reportNo;
        this.reportName = reportName;
        this.dateCreated = dateCreated;
        this.vehicleName = vehicleName;
        this.compiledBy = compiledBy;
    }

    public BrakeInputs() {

    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getCompiledBy() {
        return compiledBy;
    }

    public void setCompiledBy(String compiledBy) {
        this.compiledBy = compiledBy;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }
}

