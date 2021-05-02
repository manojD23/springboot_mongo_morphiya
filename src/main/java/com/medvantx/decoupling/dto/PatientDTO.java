package com.medvantx.decoupling.dto;

public class PatientDTO {

    private String id;
    private int groupId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String zipCode;
    private int patientPointer;
    private String emailAddress;
    private String primaryPhone;
    private String alternatePhone;
    private String gender;

    public PatientDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPatientPointer() {
        return patientPointer;
    }

    public void setPatientPointer(int patientPointer) {
        this.patientPointer = patientPointer;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id='" + id + '\'' +
                ", groupId=" + groupId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", patientPointer=" + patientPointer +
                ", emailAddress='" + emailAddress + '\'' +
                ", primaryPhone='" + primaryPhone + '\'' +
                ", alternatePhone='" + alternatePhone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
