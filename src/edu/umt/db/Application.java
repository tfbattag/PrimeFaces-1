package edu.umt.db;


import java.sql.Timestamp;

public class Application {
	private int application_id;
	private String index_charge;
	private String balance;
	private double request_amount;
	private String equipment_description;
	private String outside_funds;
	private String use_description;
	private String maintenance_responsibility;
	private String new_connections;
	private String provided_by;
	private String pilot;
	private String pilot_summary;
	private User user;
	private User approvedUser;
	private int approved;
	private Double approvedAmount;
	private Timestamp created;
    private byte[] attachment;
	
	
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public String getIndex_charge() {
		return index_charge;
	}
	public void setIndex_charge(String index_charge) {
		this.index_charge = index_charge;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public double getRequest_amount() {
		return request_amount;
	}
	public void setRequest_amount(double request_amount) {
		this.request_amount = request_amount;
	}
	public String getEquipment_description() {
		return equipment_description;
	}
	public void setEquipment_description(String equipment_description) {
		this.equipment_description = equipment_description;
	}
	public String getOutside_funds() {
		return outside_funds;
	}
	public void setOutside_funds(String outside_funds) {
		this.outside_funds = outside_funds;
	}
	public String getUse_description() {
		return use_description;
	}
	public void setUse_description(String use_description) {
		this.use_description = use_description;
	}
	public String getMaintenance_responsibility() {
		return maintenance_responsibility;
	}
	public void setMaintenance_responsibility(String maintenance_responsibility) {
		this.maintenance_responsibility = maintenance_responsibility;
	}
	public String getNew_connections() {
		return new_connections;
	}
	public void setNew_connections(String new_connections) {
		this.new_connections = new_connections;
	}
	public String getProvided_by() {
		return provided_by;
	}
	public void setProvided_by(String provided_by) {
		this.provided_by = provided_by;
	}
	public String getPilot() {
		return pilot;
	}
	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	public String getPilot_summary() {
		return pilot_summary;
	}
	public void setPilot_summary(String pilot_summary) {
		this.pilot_summary = pilot_summary;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getApprovedUser() {
		return approvedUser;
	}
	public void setApprovedUser(User approvedUser) {
		this.approvedUser = approvedUser;
	}
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public double getApprovedAmount() {
		return approvedAmount;
	}
	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
}

