package jpashop.domain;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @Entity : JPA가 관리하는 엔티티 클래스 (이 어노테이션을 보고 테이블과 매핑해줌)
 * - 기본 생성자(public or protected) 필수
 *   - JPA가 해당 데이터를 매핑할 때 객체를 동적으로 생성하는 데 필요 (리플렉션)
 *   - 지연 로딩을 구현하기 위해 프록시 객체를 생성해 반환하는데, 프록시 객체를 기본 생성자를 통해 생성함
 * - final, enum, interface, inner class는 엔티티로 사용 불가
 *   - final 클래스는 JPA가 프록시 객체를 생성할 수 없기 때문 (프록시 객체는 엔티티를 상속받아야 하니까)
 *   - enum은 불변이며 인스턴스를 생성할 수 없고 각 상수는 이미 고유하기 때문
 *   - interface는 new 키워드를 사용해 인스턴스를 생성할 수 없고, 구체적인 클래스가 아니기 때문
 *   - inner class는 독립적인 클래스가 아니며, 외부 클래스의 인스턴스에 종속되기 때문
 */

@Entity
// DB에는 ORDER가 예약어이므로 ORDERS로 테이블 이름을 지정 (DB에 따라 ORDER가 될 때도 있음)
@Table(name = "ORDERS")
public class Order extends BaseEntity {

	/**
	 * @Id : 엔티티의 기본 키임을 나타냄 (엔티티 식별하는 데 사용)
	 * @GeneratedValue : 기본 키 생성 전략을 지정 (자동 생성)
	 * 	 - GenerationType.IDENTITY : 데이터베이스에 위임하여 기본 키를 생성 (주로 MySQL에서 사용)
	 * 	 - GenerationType.SEQUENCE : 시퀀스를 사용하여 기본 키를 생성 (주로 Oracle, PostgreSQL에서 사용)
	 * 	 - GenerationType.TABLE : 별도의 테이블을 사용하여 기본 키를 생성 (잘 사용하지 않음)
	 * 	 - GenerationType.AUTO : JPA 구현체가 적절한 전략을 선택 (기본값이며, 데이터베이스에 따라 다름)
	 * @Column : 엔티티 필드를 데이터베이스 컬럼에 매핑 (name 속성으로 컬럼 이름 지정 가능, 기본값: 필드 이름)
	 */
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	// @Column(name = "MEMBER_ID")
	// private Long memberId;

	/**
	 * fetch = LAZY : 지연 로딩을 사용 (실제로 member 사용하는 시점에 DB에서 조회, 그 전에는 프록시 객체로 조회)
	 * @ManyToOne, @OneToOne은 기본값이 EAGER(즉시로딩)이므로 LAZY로 설정해야 함
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	/**
	 * @OneToOne : 일대일 관계를 나타냄 (하나의 Order가 하나의 Delivery를 가질 수 있음
	 * - cascade = ALL : 영속성 전이 설정 (Order가 영속화되면 Delivery도 함께 영속화됨)
	 */
	@OneToOne(fetch = LAZY, cascade = ALL)
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery;

	/**
	 * @OneToMany : 일대다 관계를 나타냄 (하나의 Order가 여러 OrderItem을 가질 수 있음)
	 * - mappedBy 속성 : 연관 관계의 주인이 아닌 쪽에서 설정 (OrderItem 클래스의 order 필드에 의해 매핑됨)
	 * - OrderItem 클래스에서 order 필드가 외래 키 역할을 하며, Order 클래스의 orderItems 필드와 연결됨
	 * - 단방향 매핑으로만 설계하면 제일 좋지만 필요시 이처럼 양방향 매핑도 설정 가능
	 */
	@OneToMany(mappedBy = "order", cascade = ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	private LocalDateTime orderDate;

	// @Enumerated : enum 타입을 매핑할 때 사용 (EnumType.STRING 또는 EnumType.ORDINAL)
	// - EnumType.STRING : enum 상수의 이름을 DB에 저장 (가독성이 좋음)
	// - EnumType.ORDINAL : enum 상수의 순서를 DB에 저장 (가독성이 떨어짐, enum 상수가 변경되면 문제가 발생할 수 있음, 권장 X)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;


	/**
	 * OrderItem을 추가할 때 Order와의 양방향 관계를 설정하는 편의 메서드
	 * - OrderItem의 order 필드를 this로 설정
	 * - OrderItem을 orderItems 리스트에 추가
	 */
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
