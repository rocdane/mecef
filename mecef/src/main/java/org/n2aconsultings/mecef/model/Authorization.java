package org.n2aconsultings.mecef.model;

import lombok.*;
import org.hibernate.annotations.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authorization {

    private long id;
    private String code;
    private String token;
}
