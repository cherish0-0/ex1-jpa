package jpashop.domain;

import static jakarta.persistence.FetchType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	// 외래 키 값을 직접 사용하고 있었음 (객체 지향적이지 않음)
	// private Long orderId;

	// private Long itemId;

	/**
	 * @ManyToOne : 다대일 관계를 나타냄 (여러 OrderItem이 하나의 Order에 속할 수 있음)
	 * @JoinColumn : 외래 키 컬럼을 지정 (name 속성으로 외래 키 컬럼 이름 지정)
	 * - orderItems 테이블에서 order_id 컬럼이 orders 테이블의 id 컬럼을 참조함
	 * - 외래 키를 직접 사용하지 않고 객체 참조를 통해 관계를 설정함 (객체 지향적인 방식 유지!)
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	private int orderPrice;

	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
