package com.medvantx.decoupling.model;

import dev.morphia.annotations.*;

@Entity("patient")
@Indexes({
        @Index(
                fields = @Field("first_name"),
                options = @IndexOptions(name = "patient_first_name")
        ),
        @Index(
                fields = @Field("last_name"),
                options = @IndexOptions(name = "patient_last_name")
        ),
        @Index(
                fields = @Field("date_of_birth"),
                options = @IndexOptions(name = "patient_date_of_birth")
        ),
        @Index(
                fields = @Field("zip_code"),
                options = @IndexOptions(name = "patient_zip_code")
        )

})
public class Patient extends BaseModel{
    @Id
    private String id;

    @Property("group_id")
    private int groupId;

    @Property("first_name")
    private String firstName;

    @Property("last_name")
    private String lastName;

    @Property("date_of_birth")
    private String dateOfBirth;

    @Property("zip_code")
    private String zipCode;

    @Property("patient_pointer")
    private Integer patientPointer;

    @Property("email_address")
    private String emailAddress;

    @Property("primary_phone")
    private String primaryPhone;

    @Property("alternate_phone")
    private String alternatePhone;

    @Property("gender")
    private String gender;

    public Patient() {
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

    public Integer getPatientPointer() {
        return patientPointer;
    }

    public void setPatientPointer(Integer patientPointer) {
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
        return "Patient{" +
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
