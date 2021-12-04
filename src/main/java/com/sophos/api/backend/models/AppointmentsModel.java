package com.sophos.api.backend.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


	
	@ManyToOne
	@JoinColumn(name = "id_test" , foreignKey = @ForeignKey(name = "id_test"))
	private TestModel test;
	
	
	@ManyToOne
	@JoinColumn(name = "id_affiliate", foreignKey = @ForeignKey(name = "id_affiliate"))
	private AffiliateModel affiliate;

}
