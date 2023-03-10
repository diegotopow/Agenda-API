package br.com.agenda.dto;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(max = 30) String name,
        @NotNull @Length(max = 30) String surname,
        @NotBlank @NotNull @Length(max = 20) String number,
        @NotNull @Length(max =10) String birthdate,
        @NotNull @Length(max = 50) String email,
        @NotNull @Length(max = 50) String adress,
        @NotNull @Length(max = 200) String note) {
}