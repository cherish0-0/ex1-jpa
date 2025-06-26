package jpashop.domain;

import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * @Embeddable 어노테이션을 사용하여 값 타입 클래스를 정의함
 * 값 타입 클래스는 엔티티와 달리 식별자가 없고, 다른 엔티티에 포함되어 사용됨
 * 값 타입은 불변 객체로 설계하는 것이 좋음 (임베디드 타입은 객체 타입이므로 복사했을 때 참조값이 복사되기에 원하지 않는 변경이 발생할 수 있음)
 * 임베디드 타입을 포함한 모든 값 타입은, 그를 소유한 엔티티에 생명주기가 종속됨
 * 매핑하는 테이블은 임베디드 타입을 사용하기 전과 동일
 */
@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Address address = (Address)o;
		return Objects.equals(city, address.city) && Objects.equals(street, address.street)
			&& Objects.equals(zipcode, address.zipcode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street, zipcode);
	}
}
