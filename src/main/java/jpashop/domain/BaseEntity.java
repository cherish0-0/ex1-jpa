package jpashop.domain;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;

/**
 * JPA 엔티티의 공통 필드와 메서드를 정의하는 추상 클래스
 * @MappedSuperclass : 이 클래스가 JPA 엔티티의 상위 클래스임을 나타내며, 매핑 정보만 제공함
 * 엔티티가 아니므로 테이블로 매핑되지 않음
 * 직접 인스턴스화할 일이 없으므로 추상 클래스로 정의 (조회, 검색 등 불가)
 */
@MappedSuperclass
public abstract class BaseEntity {

	private String createdBy;
	private LocalDateTime createdDate;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
