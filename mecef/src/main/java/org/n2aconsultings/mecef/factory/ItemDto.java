package org.n2aconsultings.mecef.factory;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto{
    protected String code;
    protected String name;
    protected Integer price;
    protected Float quantity;
    protected String taxGroup;
    protected Integer taxSpecific;
    protected Integer originalPrice;
    protected String priceModification;
}
