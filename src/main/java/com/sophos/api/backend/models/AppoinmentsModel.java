package com.sophos.api.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "citas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppoinmentsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Bogota")
    @NotNull
    private Date fecha;
    
    @JsonFormat(pattern = "hh:mm a", timezone = "America/Bogota")
    @NotNull
    private Date hora;
    
  
    private String idTest;
    private String idAffiliate;
}
