package com.sophos.api.backend.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "citas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentsModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Bogota")
    private Date fecha;
    
    
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "hh:mm", timezone = "America/Bogota")
    private Date hora;
  
    @Column(name="id_test")
    private Long test;
    
    
	@Column(name="id_affiliate")
	private  Long affiliate;
    
    
  
    
   
}
