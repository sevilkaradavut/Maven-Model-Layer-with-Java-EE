package maven.personnelSystem.model.user;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "VerificationToken.findByToken", query = "SELECT v FROM VerificationToken v WHERE v.token = :token"),
		@NamedQuery(name = "VerificationToken.findByUserId", query = "SELECT v FROM VerificationToken v WHERE v.user.id = :userId"),
		@NamedQuery(name = "VerificationToken.findAllByExpiryDateLessThan", query = "SELECT v FROM VerificationToken v WHERE v.expirtDate <= :expiryDate") })
public class VerificationToken {

	@Transient
	private final int expiry_date = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String token;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(foreignKeyDefinition = "user_fk"))
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	public VerificationToken() {
		this.expiryDate = calculatedExpiryDate(expiry_date);
	}

	public VerificationToken(User user, String token) {
		this.user = user;
		this.token = token;
		this.expiryDate = calculatedExpiryDate(expiry_date);
	}

	private Date calculatedExpiryDate(int expiry_date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expiry_date);
		return new Date(calendar.getTime().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getExpiry_date() {
		return expiry_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerificationToken other = (VerificationToken) obj;
		return Objects.equals(id, other.id);
	}

}
