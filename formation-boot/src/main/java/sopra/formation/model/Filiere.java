package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "training", uniqueConstraints = { @UniqueConstraint(columnNames = { "title", "startdate" }) })
public class Filiere {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "title")
	@JsonView(Views.ViewCommon.class)
	private String intitule;
	@Column(name = "prom")
	@JsonView(Views.ViewCommon.class)
	private String promotion;
	@Temporal(TemporalType.DATE)
	@Column(name = "startdate")
	@JsonView(Views.ViewCommon.class)
	private Date dtDebut;
	@Column(name = "duration")
	@JsonView(Views.ViewCommon.class)
	private Integer duree;
	@Enumerated(EnumType.STRING)
	@Column(name = "device")
	@JsonView(Views.ViewCommon.class)
	private Dispositif dispositif;
	@OneToMany(mappedBy = "filiere")
	private List<Module> modules = new ArrayList<Module>();
	@OneToMany(mappedBy = "filiere")
	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	@ManyToOne
	@JoinColumn(name = "referent_id")
	@JsonView(Views.ViewFiliereDetail.class)
	private Formateur referent;

	public Filiere() {
		super();
	}

	public Filiere(String intitule, Date dtDebut) {
		super();
		this.intitule = intitule;
		this.dtDebut = dtDebut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Dispositif getDispositif() {
		return dispositif;
	}

	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", intitule=" + intitule + ", promotion=" + promotion + ", dtDebut=" + dtDebut
				+ ", duree=" + duree + ", dispositif=" + dispositif + "]";
	}

}
