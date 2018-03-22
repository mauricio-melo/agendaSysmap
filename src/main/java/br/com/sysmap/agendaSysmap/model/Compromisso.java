package br.com.sysmap.agendaSysmap.model;


import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder
@ToString(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compromisso")
public class Compromisso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idUsuario")
	private Usuario usuario;

	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date inicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar termino;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String local;

}
