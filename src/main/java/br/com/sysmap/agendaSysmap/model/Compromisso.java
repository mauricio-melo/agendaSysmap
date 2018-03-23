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
	private Usuario usuario;

	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date inicio;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date termino;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String local;

}
