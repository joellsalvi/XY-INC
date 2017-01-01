package br.com.zup.xyinc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findByMargem",
	comment = "Query de ajuda no procedimento de filtrar por Margem, para não retornar todos os registros do Banco. "
			+ "Esta query visa trazer somente os registros com o máximo de margem possível, "
			+ "para não sobrecarregar o sistema e ser mais performático",
	query = "select * from PontoDeInteresse s where s.coordenada_x between :x1 and :x2 and s.coordenada_y between :y1 and :y2",
        resultClass = PontoDeInteresse.class
	)
})
@Entity
@Table(name = "PontoDeInteresse", uniqueConstraints = @UniqueConstraint(columnNames = "nome_poi"))
public class PontoDeInteresse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@NotNull
    @Column(name = "nome_poi", nullable = false, unique = true)
	private String nomePOI;
	
	@NotNull
    @Column(name = "coordenada_x", nullable = false, unique = false)
	private Long coordenadaX;
	
	@NotNull
    @Column(name = "coordenada_y", nullable = false, unique = false)
	private Long coordenadaY;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePOI() {
		return nomePOI;
	}

	public void setNomePOI(String nomePOI) {
		this.nomePOI = nomePOI;
	}

	public Long getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Long coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Long getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Long coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
}
