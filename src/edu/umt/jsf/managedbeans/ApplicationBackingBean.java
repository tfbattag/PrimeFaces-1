package edu.umt.jsf.managedbeans;

import edu.umt.db.Application;
import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.exceptions.ApplicationDetailsException;
import edu.umt.exceptions.ApplicationInsertException;
import org.hibernate.HibernateException;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 7/17/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationBackingBean {
    private Logger log = Logger.getLogger(ApplicationBackingBean.class);
    private List<Application> applications;
    private Application application;
    private Application applicationToView;
    private String index_charge;
    private String balance;
    private String request_amount;
    private String equipment_description;
    private String outside_funds;
    private String use_description;
    private String maintenance_responsibility;
    private String new_connections;
    private String provided_by;
    private String pilot;
    private String pilot_summary;
    private User user;
    private int userId;
    private User approvedUser;
    private int approved;
    private Double approvedAmount;
    private byte[] attachment;
    private UploadedFile file;

    public List<Application> getApplications() {
        return DatabaseManager.getApplications();
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Application getApplicationToView() {
        return applicationToView;
    }

    public void setApplicationToView(Application applicationToView) {
        this.applicationToView = applicationToView;
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

    public String getRequest_amount() {
        return request_amount;
    }

    public void setRequest_amount(String request_amount) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public void handleFileUpload(FileUploadEvent event){
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + "uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.attachment = event.getFile().getContents();
    }

    public String newApplicationAction() throws ApplicationInsertException {
        Application a = new Application();
        a.setEquipment_description(this.equipment_description);
        a.setMaintenance_responsibility(this.maintenance_responsibility);
        a.setRequest_amount(new Double(this.request_amount).doubleValue());
        a.setApprovedAmount(new Double(0).doubleValue());
        a.setNew_connections(this.new_connections);
        a.setOutside_funds(this.outside_funds);
        a.setPilot(this.pilot);
        a.setPilot_summary(this.pilot_summary);
        a.setProvided_by(this.provided_by);
        a.setUse_description(this.use_description);
        a.setUser(DatabaseManager.getUser(this.userId));
        if(attachment != null){
               a.setAttachment(this.attachment);
        }

        try{
            log.debug("Attempting to insert new Application.");
            DatabaseManager.insertApplication(a);
        }catch(HibernateException he){
            // do something different.
            log.error(he);
        }catch(Exception e){
            throw new ApplicationInsertException(a.getUse_description());
            //TODO: check Database Manger for throw versus catch.
        }
        return "new-application-created";
    }

    public String applicationDetailsAction() throws ApplicationDetailsException {
        log.debug("Navigating to application details.");

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try{
            applicationToView = DatabaseManager.getApplication(new Integer(request.getParameter("appId")));
        }catch(Exception e){
            if (applicationToView == null) throw new ApplicationDetailsException("Could not retrieve application.");
            log.error(e);
        }

        return "application-details";
    }

    /**
     * This method will use the afidavitToView object and stream its originalForm byte array
     * back to the browser as a PDF.
     */
    public void viewOriginalAction() {
        try {
            ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();

            if (applicationToView.getAttachment()!= null) {
                baosPDF.write(applicationToView.getAttachment());

                HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.setContentType("application/pdf");
                response.setHeader("Content-disposition", "attachment; filename=tempPDF.pdf");
                response.setHeader("Cache-Control", "no-cache");
                response.setContentLength(baosPDF.size());
                response.setHeader("Pragma", "public");

                ServletOutputStream sos;
                sos = response.getOutputStream();
                baosPDF.writeTo(sos);
                sos.flush();

                FacesContext.getCurrentInstance().responseComplete();
            } else {
                FacesContext.getCurrentInstance().responseComplete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAttachment() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();

        if (applicationToView.getAttachment()!= null) baosPDF.write(applicationToView.getAttachment());
        ec.responseReset();
        ec.setResponseContentType("application/pdf");
        ec.setResponseContentLength(baosPDF.size());
        ec.addResponseHeader("Content-Disposition", "inline; filename=tempPDF.pdf");

        OutputStream output = ec.getResponseOutputStream();
        baosPDF.writeTo(output);

        FacesContext.getCurrentInstance().responseComplete();
    }

}
