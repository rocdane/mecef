package org.n2aconsultings.mecef.controller;


import javafx.fxml.Initializable;
import org.n2aconsultings.mecef.exception.ResourceNotFoundException;
import org.n2aconsultings.mecef.factory.*;
import org.n2aconsultings.mecef.service.IMeCEF;
import org.n2aconsultings.mecef.service.MeCEF;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MecefController implements Initializable {

    private IMeCEF mecef;

    public InfoResponseDto info() {
        try {
            return mecef.info();
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public TaxGroupDto taxes() {
        try {
            return mecef.taxes();
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public List<InvoiceTypeDto> invoices() {
        try {
            return mecef.invoices();
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public List<PaymentTypeDto> payments(){
        try {
            return mecef.payments();
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public StatusResponseDto status(){
        try {
            return mecef.status();
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public InvoiceResponseDataDto invoicing(InvoiceRequestDataDto invoice){
        try {
            return mecef.invoicing(invoice);
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public SecurityElementsDto confirmation(String uid, String action){
        try {
            return mecef.confirmation(uid,action);
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public InvoiceDetailsDto details(String uid){
        try {
            return mecef.details(uid);
        } catch (IOException | InterruptedException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mecef = new MeCEF();
    }
}
