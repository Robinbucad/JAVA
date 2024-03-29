package com.example.CRUDvalidation;

import java.util.Date;

public record PersonaInputDTO(
        String username,
        String name,
        String password,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        String url_image,
        Date creation_date,
        Date termination_date
) {
}
