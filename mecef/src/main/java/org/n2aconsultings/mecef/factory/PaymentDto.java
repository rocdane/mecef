package org.n2aconsultings.mecef.factory;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    String paymentType;
    Integer amount;
}
