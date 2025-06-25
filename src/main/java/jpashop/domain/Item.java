package jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Item {

	@Id @GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;

	private String name;

	private int price;

	private int StockQuantity;

	/**
	 * @ManyToMany : 다대다 관계를 나타냄 (여러 Item이 여러 Category에 속할 수 있음)
	 * RDBMS에서는 다대다 관계를 테이블 2개로 표현할 수 없음
	 *  - 데이터가 중복해서 등장하기 때문에 하나의 셀에 여러 값이 들어가게 됨 (고유성 사라짐)
	 *  - 연관 테이블을 중간에 추가해 1:N, N:1 관계로 변환하여 해결
	 *  - 하지만 연관 테이블 때문에 예상 못한 쿼리들이 생성될 수 있음 (=> 실무에서 쓰지 않는 게 좋음)
	 */
	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return StockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		StockQuantity = stockQuantity;
	}
}
