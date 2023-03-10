package br.com.agenda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@Entity
// @Table(name = "Contact")
@SQLDelete(sql = "UPDATE Contact SET status = 'Inativo' WHERE id = ?")
@Where(clause = "Status = 'Ativo'")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(max = 30)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 30)
    @Column(length = 100, nullable = false)
    private String surname;

    @NotBlank
    @NotNull
    @Length(max = 20)
    @Column(length = 100, nullable = false)
    private String number;

    @NotNull
    @Length(max = 20)
    @Column(length = 100, nullable = false)
    private String birthdate;

    @NotNull
    @Length(max = 50)
    @Column(length = 100, nullable = false)
    private String email;

    @NotNull
    @Length(max = 50)
    @Column(length = 100, nullable = false)
    private String adress;

    @NotNull
    @Length(max = 200)
    @Column(length = 100, nullable = false)
    private String note;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";
}
