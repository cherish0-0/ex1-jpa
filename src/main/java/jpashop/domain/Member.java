package jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	/**
	 * @Embedded 어노테이션을 사용하여 Address 클래스를 임베디드 타입으로 매핑함
	 */
	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
