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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "PasswordResetToken")
@NamedQueries({
		@NamedQuery(name = "PasswordResetToken.findByToken", query = "SELECT p FROM PasswordResetToken p WHERE p.token = :token"),
		@NamedQuery(name = "PasswordResetToken.findByUserId", query = "SELECT P FROM PasswordResetToken p WHERE p.user.id = :userId"),
		@NamedQuery(name = "PasswordResetToken.findAllByExpiryDateLessThan", query = "SELECT p FROM PasswordResetToken p WHERE p.expirtDate <= :expiryDate") })
public class PasswordResetToken {

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

	public PasswordResetToken() {
		this.expiryDate = calculatedExpiryDate(expiry_date);
	}

	public PasswordResetToken(String token, User user) {
		this.token = token;
		this.user = user;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		PasswordResetToken other = (PasswordResetToken) obj;
		return Objects.equals(id, other.id);
	}

}
