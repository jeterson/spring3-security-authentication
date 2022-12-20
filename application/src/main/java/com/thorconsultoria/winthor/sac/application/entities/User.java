package com.thorconsultoria.winthor.sac.application.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "PCEMPR")
@Entity
@Data
public class User {
    @Id
    @Column(name = "MATRICULA")
    private Integer id;
    @Column(name = "USUARIOBD")
    private String username;
    @Column(name = "SENHABD")
    private String password;
}
