package org.n2aconsultings.mecef.factory;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetailsDto {
    String ifu;
    String aib;
    String type;
    List<ItemDto> items;
    ClientDto client;
    OperatorDto operator;
    List<PaymentDto> payment;
    String reference;
    String errorCode;
    String errorDesc;
    String paymentUrl;
}
