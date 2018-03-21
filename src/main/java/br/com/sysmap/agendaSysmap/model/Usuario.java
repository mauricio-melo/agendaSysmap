package br.com.sysmap.agendaSysmap.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Data
@Builder
@ToString(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	@OneToMany(mappedBy = "usuario")
	private List<Compromisso> compromissos;
	
	@ManyToOne
	private Equipe equipe;
}
