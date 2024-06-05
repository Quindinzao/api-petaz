package com.quindinzao.petaz.dto;

import java.time.LocalDateTime;

public class AppointmentRequest {
    private Long userCpfId;
    private Long userCnpjId;
    private Long petId;
    private Long serviceId;
    private LocalDateTime appointmentTime;

    public AppointmentRequest() {}

    public AppointmentRequest(Long userCpfId, Long userCnpjId, Long petId, Long serviceId, LocalDateTime appointmentTime) {
        this.userCpfId = userCpfId;
        this.userCnpjId = userCnpjId;
        this.petId = petId;
        this.serviceId = serviceId;
        this.appointmentTime = appointmentTime;
    }

    public Long getUserCpfId() {
        return userCpfId;
    }

    public void setUserCpfId(Long userCpfId) {
        this.userCpfId = userCpfId;
    }

    public Long getUserCnpjId() {
        return userCnpjId;
    }

    public void setUserCnpjId(Long userCnpjId) {
        this.userCnpjId = userCnpjId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
